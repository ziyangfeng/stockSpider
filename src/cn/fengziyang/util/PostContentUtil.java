package cn.fengziyang.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.fengziyang.po.Post;
import cn.fengziyang.po.PostComment;
import cn.fengziyang.po.PostContent;
import cn.fengziyang.po.PostRe;
import cn.fengziyang.po.User;
import cn.fengziyang.task.GetPostContentJob;


public class PostContentUtil {
	
	private static Logger logger = Logger.getLogger(PostContentUtil.class);
	
	/**
	 * 获取文章内容和评论
	 */
	public static List<PostContent> getPostContent(int pageNum,String userCode) throws IOException{
		Post post=null;
		try{
		   post = PostUtil.getPost(pageNum, userCode);
		}catch(Exception e){
			logger.error("解析失败，页码："+pageNum+" 用户编码："+userCode);
			logger.error(e);
			e.printStackTrace();
			return null;
		}
		//无内容返回空值
		String me = post.getData().getMe();
		if(!"操作成功".equals(me)){
		    System.out.println("页面太大");
		    return null;
		}
		
		List<PostContent> postContentList = new ArrayList<PostContent>();
		
		List<PostRe> postReList = post.getData().getRe();
	    for(int i=0;i<postReList.size();i++){
	    	String stockbar_code = post.getData().getRe().get(i).getPost_guba().getStockbar_code();  //股票吧代码
	    	String post_id = post.getData().getRe().get(i).getPost_id();							 //文章id
	    	String post_publish_time = post.getData().getRe().get(i).getPost_publish_time();         //发表时间
	    	String post_click_count = post.getData().getRe().get(i).getPost_click_count();           //访问量
	    	String postUrl = "http://guba.eastmoney.com/news,"+stockbar_code+","+post_id+".html";
	    	PostContent postContent = PostContentUtil.getPostContent(postUrl, userCode, post_publish_time, post_click_count, stockbar_code+"|"+post_id);
	    	if (null!=postContent){
	    		postContentList.add(postContent);
	    	}
	    	
	    }
	    
		return postContentList;
	}
	
	
	
	
	
	/**
	 * 
	* @Title: getPost  
	* @Description: 获取文章内容
	* @param  postUrl
	* @param 
	* @param @return
	* @param @throws IOException  
	* @return Post
	* @throws
	 */
	public static PostContent getPostContent(String postUrl,String postUserCode,String postPubtime,String postPv,String postId) throws IOException{
		//System.out.println(postUrl);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();   //创建HttpClient对象
	    HttpGet httpGet = new HttpGet(postUrl);
	   
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();  
		httpGet.setConfig(requestConfig);
		
		httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
		httpGet.setHeader("Accept-Encoding","gzip, deflate");
		httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.9");
		httpGet.setHeader("Cache-Control","max-age=0");
		httpGet.setHeader("Connection","keep-alive");
		httpGet.setHeader("Host","guba.eastmoney.com");
		httpGet.setHeader("Upgrade-Insecure-Requests","1");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
		
		
		//...模拟浏览器请求参数
		CloseableHttpResponse response = httpClient.execute(httpGet); //执行请求
		HttpEntity entity = response.getEntity();
		String htmlContent = EntityUtils.toString(entity, "utf-8").trim();
		
		//经测试jsoup1.11.1版本不支持jdk1.6，降低jsoup版本至1.9
		Document doc = Jsoup.parse(htmlContent);
		//文章标题
		Element postTitleElement = doc.getElementById("zwconttbt"); 
		//文章内容
		Element postContentElement = doc.getElementById("zwconbody"); 
		
		//特殊情况处理，如：http://guba.eastmoney.com/news,600178,836626093.html
		if(null==postTitleElement){ 
			logger.error("不符合解析规则的文章："+postUrl);
			return null;
		}
		
		//设置对象
		PostContent postContent = new PostContent();
		postContent.setPostId(postId);
		postContent.setUserCode(postUserCode);
		postContent.setTitle(postTitleElement.text());
		postContent.setContent(postContentElement.text());
		postContent.setPubtime(postPubtime);
		postContent.setPv(postPv);
		
		//获取评论
		List<PostComment> postCommentList = new ArrayList<PostComment>();
		Elements  zwlist = doc.getElementById("zwlist").getElementsByClass("zwli");
		for(int i=0;i<zwlist.size();i++){
			//用户编码
			String userCode= zwlist.get(i).getElementsByClass("zwlianame").get(0).getElementsByClass("zwnick").get(0).getElementsByTag("a").attr("data-popper");   
			//用户名
			String userName = zwlist.get(i).getElementsByClass("zwlianame").get(0).getElementsByTag("font").text();
			//发表时间 
			String pubtime = zwlist.get(i).getElementsByClass("zwlitx").get(0).getElementsByClass("zwlitime").get(0).text();
			pubtime=pubtime.replaceAll("发表于", "").trim(); //去除多余的字符，并去除空字符
			//发表内容
			String content = zwlist.get(i).getElementsByClass("zwlitxt").get(0).getElementsByClass("zwlitext").get(0).getElementsByClass("short_text").get(0).text();
			
			PostComment postComment = new PostComment();
			postComment.setPostId(postId);
			postComment.setUserCode(postUserCode);
			postComment.setPubUserCode(userCode);
			postComment.setPubUserName(userName);
			postComment.setContent(content);
			postComment.setPubtime(pubtime);
			postCommentList.add(postComment);
		}
		postContent.setPostCommentList(postCommentList);
		
		return postContent;
			
	}
	
	
	
	/**
	 * 根据发表内容和评论插入到数据库
	 */
	public static int insertPostContent(PostContent postContent){
		String postId = postContent.getPostId();
		String userCode = postContent.getUserCode();
		String title = postContent.getTitle();
		String content = postContent.getContent();
		String pubtime = postContent.getPubtime();
		String pv = postContent.getPv();
		
		content=content.replaceAll("'", "''");
		
		String sqlPostContent="insert into [t_post] ([post_id],[user_code],[title],[content],[pubtime],[pv],[oper_date]) " +
				"values('"+postId+"','"+userCode+"','"+title+"','"+content+"','" +pubtime+"','" +pv+ "',getdate())";
		//System.out.println(sqlPostContent);
		int i = SqlUtil.execForSql(sqlPostContent);
		
		
		//插入评论
		List<PostComment> postCommentList = postContent.getPostCommentList();
		for(PostComment postComment:postCommentList){
			insertPostComment(postComment);
		}
		
		return i;
	}
	
	
	
	
	/**
	 * 
	* @Title: insertPostComment  
	* @Description: TODO 插入评论内容
	* @param @param postComment
	* @param @return   
	* @return int 
	* @throws
	 */
	public static int insertPostComment(PostComment postComment){
		String postId = postComment.getPostId();
		String userCode = postComment.getUserCode();
		String pubUserCode= postComment.getPubUserCode();
		String pubUserName = postComment.getPubUserName();
		String content = postComment.getContent();
		String pubtime = postComment.getPubtime();
		
		content=content.replaceAll("'", "''");
		
		String sql="insert into [t_post_comment] ([post_id],[user_code],[pub_user_code],[pub_user_name],[content],[pubtime],[oper_date]) " +
		"values('"+postId+"','"+userCode+"','"+pubUserCode+"','"+pubUserName+"','" +content+"','" +pubtime+ "',getdate())";
		
		int i = SqlUtil.execForSql(sql);
		return i;
	}
	
	
	
	
	
}
