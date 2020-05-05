package cn.fengziyang.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import cn.fengziyang.po.PostContent;
import cn.fengziyang.po.User;
import cn.fengziyang.util.ConnectUtil;
import cn.fengziyang.util.PostContentUtil;
import cn.fengziyang.util.SqlUtil;
import cn.fengziyang.util.UserUtil;

public class GetPostContentJob {
	private static Logger log = Logger.getLogger(GetPostContentJob.class);
	
	/**  
	 * @Title: main  
	 * @Description: TODO 
	 * @param @param args   
	 * @return void 
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) {
		
		String sql="select user_code from [t_user] where user_flag=0";
		
		PreparedStatement pst = null;
		 ResultSet rs = null;
		 Connection con = null;
		 try {
				 con = ConnectUtil.getHerpConnection();
			     if (con == null) System.exit(1);
				 pst = con.prepareStatement(sql);
				 rs = pst.executeQuery();
				 while(rs.next()){
						String user_code = rs.getString("user_code");
						System.out.println(user_code + " 开始获取内容 "+new Date());
						exePostToDataBase(user_code);
						System.out.println(user_code + " 结束获取内容 "+new Date());
				 }
				
		} catch (Exception e) {
			log.error(e);
			ConnectUtil.closeAllConn(con, pst, rs);
			e.printStackTrace();
		}finally{
			 ConnectUtil.closeAllConn(con, pst, rs);
		}
		
		
		
	}
	
	
	public static void exePostToDataBase(String userCode){
		for(int i=1;i<20;i++){
			System.out.println("第"+i+"页内容---->>>"+userCode);
			try {
				List<PostContent> list = PostContentUtil.getPostContent(i,userCode);
			
			//如果内容为空退出循环
			if(null==list){
				System.out.println("第"+i+"页，无内容退出！");
				break;
			}
			
			//循环数据插入到内容表和评论表中
			for(PostContent postContent:list){
				PostContentUtil.insertPostContent(postContent);
			}
			
			} catch (Exception e) {
				log.error(e);
				UserUtil.updateUserFlag(userCode, "2");
				e.printStackTrace();
			}
			
		}
		//更新用户表flag为1，表示已经取过数据
		UserUtil.updateUserFlag(userCode, "1");
		
	}
	

	
	
	
}
