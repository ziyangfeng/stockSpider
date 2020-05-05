package cn.fengziyang.test;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cn.fengziyang.test.TestThreadPool.MyIgnorePolicy;
import cn.fengziyang.test.TestThreadPool.MyTask;
import cn.fengziyang.test.TestThreadPool.NameTreadFactory;


public class Test {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		   for(int i=0;i<9999;i++){
			   System.out.println(i);
			   Thread.sleep(1000); 
		   }
		   
		   int corePoolSize = 10;
		    int maximumPoolSize = 20;
		    long keepAliveTime = 10;
		    TimeUnit unit = TimeUnit.SECONDS;
		    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
		    ThreadFactory threadFactory = new NameTreadFactory();
		    RejectedExecutionHandler handler = new MyIgnorePolicy();
		    
		    ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
		            workQueue, threadFactory, handler);
		    executor.prestartAllCoreThreads(); // 预启动所有核心线程
		    
		    for (int i = 1; i <= 10; i++) {
		        MyTask task = new MyTask(String.valueOf(i));
		        executor.execute(task);
		    }
		    
		   // executor.shutdown(); // 设置线程池的状态为SHUTDOWN，然后中断所有没有正在执行任务的线程
		    //executor.shutdownNow(); // 设置线程池的状态为 STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表
		    
		    System.in.read(); //阻塞主线程
		
		
	  }
	
	
	  
		
	
	}


