package cn.fengziyang.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import cn.fengziyang.po.Post;
import cn.fengziyang.po.PostRe;

import com.alibaba.fastjson.JSON;

public class TestGetPost {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		//获取数据连接如下
		//http://i.eastmoney.com/api/ta/UserPostList?p=2&uid=3004094405875882
		
		   CloseableHttpClient httpClient = HttpClients.createDefault();   //创建HttpClient对象
		   HttpGet httpGet = new HttpGet("http://i.eastmoney.com/api/ta/UserPostList?p=20&uid=1573135402679676");
		  
		   RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();  
		   httpGet.setConfig(requestConfig);
			
			httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
			httpGet.setHeader("Accept-Encoding:","gzip, deflate");
			httpGet.setHeader("Accept-Language: ","zh-CN,zh;q=0.9");
			httpGet.setHeader("Connection:","keep-alive");
			httpGet.setHeader("Host","i.eastmoney.com");
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
			
			//...模拟浏览器请求参数
			CloseableHttpResponse response = httpClient.execute(httpGet); //执行请求
			HttpEntity entity = response.getEntity();
			String htmlContent = EntityUtils.toString(entity, "utf-8").trim();
			
			Post post = JSON.parseObject(htmlContent, Post.class);
		
		   
		    
		    //打印文章链接
		    String me = post.getData().getMe();
		    if(!"操作成功".equals(me)){
		    	System.out.println("页面太大");
		    	return;
		    }
		    
		    /*System.out.println(post.getStauts());
		    System.out.println(post.getData().getRe().get(1).getPost_guba().getStockbar_code());
		    System.out.println(post.getData().getRe().get(1).getPost_id());
		    */
		    
		    List<PostRe> postReList = post.getData().getRe();
		    for(int i=0;i<postReList.size();i++){
		    	String stockbar_code = post.getData().getRe().get(i).getPost_guba().getStockbar_code();
		    	String post_id = post.getData().getRe().get(i).getPost_id();
		    	String post_publish_time = post.getData().getRe().get(i).getPost_publish_time();
		    	String post_click_count = post.getData().getRe().get(i).getPost_click_count();
		    	System.out.println(post_click_count);
		    	System.out.println(post_publish_time);
		    	System.out.println("http://guba.eastmoney.com/news,"+stockbar_code+","+post_id+".html");
		    }
	}

}
