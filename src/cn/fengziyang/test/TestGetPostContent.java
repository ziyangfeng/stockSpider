package cn.fengziyang.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
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

public class TestGetPostContent {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		   CloseableHttpClient httpClient = HttpClients.createDefault();   //创建HttpClient对象
		   //HttpGet httpGet = new HttpGet("http://guba.eastmoney.com/news,002230,882060963.html");
		   //HttpGet httpGet = new HttpGet("http://guba.eastmoney.com/news,002230,874063304.html");
		   //HttpGet httpGet = new HttpGet("http://guba.eastmoney.com/news,000066,887874585.html");
		   HttpGet httpGet = new HttpGet("http://guba.eastmoney.com/news,002797,836657829.html");
		   
		  
		   
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
			//System.out.println(htmlContent);
			
			//经测试jsoup1.11.1版本不支持jdk1.6，降低jsoup版本至1.9
			Document doc = Jsoup.parse(htmlContent);
			
			
			//文章标题
			Element postTitle = doc.getElementById("zwconttbt"); 
			System.out.println(postTitle.text());
			
			//文章内容
			Element postContent = doc.getElementById("zwconbody"); 
			System.out.println(postContent.text());
			
			//获取评论
			Elements  zwlist = doc.getElementById("zwlist").getElementsByClass("zwli");
			for(int i=0;i<zwlist.size();i++){
				//System.out.println(zwlist.get(i).text());
				//用户编码
				String userCode= zwlist.get(i).getElementsByClass("zwlianame").get(0).getElementsByClass("zwnick").get(0).getElementsByTag("a").attr("data-popper");   
				//System.out.println(userCode); 
				
				//用户名
				String userName = zwlist.get(i).getElementsByClass("zwlianame").get(0).getElementsByTag("font").text();
				//System.out.println(userName);
				
				//发表时间 
				String pubtime = zwlist.get(i).getElementsByClass("zwlitx").get(0).getElementsByClass("zwlitime").get(0).text();
				pubtime=pubtime.replaceAll("发表于", "").trim(); //去除多余的字符，并去除空字符
				//System.out.println(pubtime);
				
				//发表内容
				String text = zwlist.get(i).getElementsByClass("zwlitxt").get(0).getElementsByClass("zwlitext").get(0).getElementsByClass("short_text").get(0).text();
				System.out.println(text);
				
			}
			
			
			
			
			
			
			
			
			
			
			
	}
}
