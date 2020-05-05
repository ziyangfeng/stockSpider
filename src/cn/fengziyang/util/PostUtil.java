package cn.fengziyang.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

import cn.fengziyang.po.Post;
import cn.fengziyang.po.User;


public class PostUtil {
	
	
	public static Post getPost(int pageNum,String userCode) throws IOException{
		   CloseableHttpClient httpClient = HttpClients.createDefault();   //创建HttpClient对象
		   HttpGet httpGet = new HttpGet("http://i.eastmoney.com/api/ta/UserPostList?p="+pageNum+"&uid="+userCode);
		  
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
			
			return post;
	}
}
