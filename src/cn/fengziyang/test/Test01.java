package cn.fengziyang.test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import cn.fengziyang.po.User;
import cn.fengziyang.util.UserUtil;


public class Test01 {
private static Integer pages=1; // 网页数
	
	private static boolean exeFlag=true; // 执行标识
	
	public static void main(String[] args)  {
		ExecutorService executorService=Executors.newFixedThreadPool(10); // 创建ExecutorService 连接池默认连接10个
		
		while(exeFlag){
			if(pages<=1000){
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						//System.out.println("爬取了第"+pages+"网页...");
						try {
							User user = UserUtil.getUser(Integer.toString(pages));
							if(null!=user){
								System.out.println(user.getUserCode());
					            System.out.println(user.getUserName());
					            System.out.println(user.getUser_age());
					            System.out.println(user.getPv());
							}else{
								System.out.println("无数据："+pages);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						
						pages++;
					}
				});
			}else{
				if(((ThreadPoolExecutor)executorService).getActiveCount()==0){ // 活动线程个数是0
					executorService.shutdown(); // 结束所有线程
					exeFlag=false;
					System.out.println("爬虫任务已经完成");
				}
			}
			
			try {
				Thread.sleep(100); // 线程休息0.1秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
}
