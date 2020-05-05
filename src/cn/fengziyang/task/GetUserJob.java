package cn.fengziyang.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import cn.fengziyang.po.User;
import cn.fengziyang.util.ConnectUtil;
import cn.fengziyang.util.SqlUtil;
import cn.fengziyang.util.UserUtil;

public class GetUserJob {
	private static Logger log = Logger.getLogger(GetUserJob.class);
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		String sql ="select user_code from [t_temp_user] where [user_flag]=0  ";
		
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
						System.out.println(user_code);
						User user = UserUtil.getUser(user_code);
						if(null != user){
							int count = UserUtil.insertUser(user);
							if(count>0){ //如果成功更新状态为1
								String sqlTempUser = "update [t_temp_user] set user_flag=1 where user_code="+user_code;
								SqlUtil.execForSql(sqlTempUser);
							}
						}
				 }
				
		} catch (Exception e) {
			log.error("在查询信息时出现异常！");
			ConnectUtil.closeAllConn(con, pst, rs);
			e.printStackTrace();
		}finally{
			 ConnectUtil.closeAllConn(con, pst, rs);
		}
		
		
		
	}

}
