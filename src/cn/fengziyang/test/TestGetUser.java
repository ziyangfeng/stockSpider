package cn.fengziyang.test;

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

public class TestGetUser {
	public static void main(String[] args) throws Exception {
		  CloseableHttpClient httpClient = HttpClients.createDefault();   //创建HttpClient对象
		  //HttpGet httpGet = new HttpGet("http://i.eastmoney.com/3004094405875882");
		  HttpGet httpGet = new HttpGet("http://i.eastmoney.com/3004094405875882");
		  /*HttpHost proxy=new HttpHost("111.231.92.21",8888);
			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			httpGet.setConfig(config);*/
		  
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
			
			//经测试jsoup1.11.1版本不支持jdk1.6，降低jsoup版本至1.9
			Document doc = Jsoup.parse(htmlContent);
			Elements elements =  doc.getElementsByTag("title");  //获取网站表弃
			Element element = elements.get(0);
			String str = element.text();
			System.out.println(str);
			
			if(str.indexOf("的个人主页")==-1){
				System.out.println("----的个人主页");
				//return null;
			}
			
			//用户名
			Elements userNameElements = doc.getElementsByClass("others_username");
			Element userNameElement = userNameElements.get(0);
			String userName = userNameElement.text();
			System.out.println("--"+userName);
			
			if("".equals(userName.trim())){
				System.out.println("----用户名为空");
			}
			
			
			
			
			//吧龄（如：4.2年）
			Elements levelElements = doc.getElementsByClass("others_level");
			Element userAgeElement = levelElements.get(0).getElementsByTag("p").get(1).getElementsByTag("span").get(0);
			String userAge = userAgeElement.text();
			System.out.println(userAge);
			
			//粉丝数量
			Element fansElement = doc.getElementById("tafansa");
			Elements fansElementsSpan =  fansElement.getElementsByTag("span");
			String fans = fansElementsSpan.get(0).text();
			System.out.println(fans);
			
			//总访问量
			Elements infoElements = doc.getElementsByClass("others_info");
			Element pvElement =  infoElements.get(0).getElementsByClass("orange").get(0);
			String pv = pvElement.text();
			System.out.println(pv);
			
			
			/*Elements menuElements = doc.getElementsByClass("PMenu"); //获取所有菜单
	        System.out.println("=======菜单==============");
	        for(int i=0;i<menuElements.size();i++){
	        	Element e = menuElements.get(i);
	        	
	        	System.out.println(e.text());
	        	
	        }
			
			System.out.println(htmlContent);*/
			httpClient.close();  //关闭
			response.close();
			
	}
}
