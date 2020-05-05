package cn.fengziyang.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.fengziyang.po.User;


public class UserUtil {
	
	public static User getUser(String userCode) throws IOException{
		    CloseableHttpClient httpClient = HttpClients.createDefault();   //创建HttpClient对象
		    HttpGet httpGet = new HttpGet("http://i.eastmoney.com/"+userCode);
		  
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();  
			httpGet.setConfig(requestConfig);
			
			httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
			httpGet.setHeader("Accept-Encoding:","gzip, deflate");
			httpGet.setHeader("Accept-Language: ","zh-CN,zh;q=0.9");
			httpGet.setHeader("Connection:","keep-alive");
			httpGet.setHeader("Host","i.eastmoney.com");
			//httpGet.setHeader("Referer","http://new.flycua.com/aoc/");
			httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36");
			//httpGet.setHeader("X-Requested-With","XMLHttpRequest");
			
			//...模拟浏览器请求参数
			CloseableHttpResponse response = httpClient.execute(httpGet); //执行请求
			HttpEntity entity = response.getEntity();
			String htmlContent = EntityUtils.toString(entity, "utf-8").trim();
			
			
			User user = new User();
			user.setUserCode(userCode);
			
			//经测试jsoup1.11.1版本不支持jdk1.6，降低jsoup版本至1.9
			Document doc = Jsoup.parse(htmlContent);
			Elements elements =  doc.getElementsByTag("title");  //获取网站表弃
			Element element = elements.get(0);
			String str = element.text();
			if(str.indexOf("的个人主页")==-1){
				return null;
			}
			
			//用户名
			Elements userNameElements = doc.getElementsByClass("others_username");
			Element userNameElement = userNameElements.get(0);
			String userName = userNameElement.text();
			if("".equals(userName.trim())){
				return null;
			}
			user.setUserName(userName);
			
			
			//吧龄（如：4.2年）
			Elements levelElements = doc.getElementsByClass("others_level");
			Element userAgeElement = levelElements.get(0).getElementsByTag("p").get(1).getElementsByTag("span").get(0);
			String userAge = userAgeElement.text();
			user.setUser_age(userAge);
			
			//粉丝数量
			Element fansElement = doc.getElementById("tafansa");
			Elements fansElementsSpan =  fansElement.getElementsByTag("span");
			String fans = fansElementsSpan.get(0).text();
			user.setFans(Integer.parseInt(fans));
			
			//总访问量
			Elements infoElements = doc.getElementsByClass("others_info");
			Element pvElement =  infoElements.get(0).getElementsByClass("orange").get(0);
			String pv = pvElement.text();
			user.setPv(Integer.parseInt(pv));
			
			
			httpClient.close();  //关闭
			response.close();
		
		    return user;
	}
	
	
	//通过int类型，转换为8为的字符类型，如99变为00000099
	public static String get8Code(int num){
		int youNumber = 999;  
	    // 0 代表前面补充0   
	    // 10代表长度为10   
	    // d 代表参数为正数型   
	    String str = String.format("%08d", num);  
		return str;
	    
	}
	
	
	//根据用户插入到数据库
	public static int insertUser(User user){
		String userCode = user.getUserCode();
		String userName = user.getUserName();
		String userAge = user.getUser_age();
		int fans = user.getFans();
		int pv = user.getPv();
        
		String sql="insert into [t_user] ([user_code],[user_name],[user_age],[fans],[pv],[oper_date]) " +
				"values('"+userCode+"','"+userName+"','"+userAge+"',"+fans+"," +pv+ ",getdate())";
		
		int i = SqlUtil.execForSql(sql);
		return i;
	    
	}
	
	
	/**
	 * 
	* @Title: updateUserFlag  
	* @Description: TODO 
	* @param @param userCode 用户编码
	* @param @param flag  更新的状态
	* @param @return   
	* @return int 
	* @throws
	 */
	public static int updateUserFlag(String userCode,String flag){
		String sql="update [t_user] set user_flag='"+flag+"' where user_code="+userCode;;
		int i = SqlUtil.execForSql(sql);
		return i;
	}
	
	
	
}
