package cn.fengziyang.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 执行sql语句
 * @author feng
 *
 */
public class SqlUtil {
	private static Logger log = Logger.getLogger(SqlUtil.class);
	
	/**
	 * 查询
	 * @param sql
	 * @return ResultSet
	 */
	public static ResultSet queryForSql(String sql){
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 Connection con = null;
		 
		 try {
				 con = ConnectUtil.getHerpConnection();
			     if (con == null) System.exit(1);
				 pst = con.prepareStatement(sql);
				 rs = pst.executeQuery();
				 return rs;
		} catch (SQLException e) {
			log.error("在查询信息时出现异常！");
			ConnectUtil.closeAllConn(con, pst, rs);
			e.printStackTrace();
		}finally{
			 ConnectUtil.closeAllConn(con, pst, rs);
			 return rs;
		}
	}
	
	
	
	
	/**
	 * 查询数据条数，数据别名必须为count
	 * @param sql
	 * @return count，数据条数
	 */
	public static int queryForCount(String sql){
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 Connection con = null;
		 int count = 0;
		 
		 try {
				 con = ConnectUtil.getHerpConnection();
			     if (con == null) System.exit(1);
				 pst = con.prepareStatement(sql);
				 rs = pst.executeQuery();
				 while (rs.next()) {
					 count = rs.getInt("count");
				 }
		} catch (SQLException e) {
			log.error("在查询信息时出现异常！");
			ConnectUtil.closeAllConn(con, pst, rs);
			e.printStackTrace();
		}finally{
			 ConnectUtil.closeAllConn(con, pst, rs);
		}
		
		return count;
	}
	
	
	

	
	/**
	 * 执行update,insert语句
	 * @param sql
	 * @return 影响的行数
	 */
	public static int execForSql(String sql){
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 Connection con = null;
		 int resultCount =0;
		 
		 try {
				 con = ConnectUtil.getHerpConnection();
			     if (con == null) System.exit(1);
				 pst = con.prepareStatement(sql);
				 resultCount = pst.executeUpdate();
				 //con.commit();
		} catch (SQLException e) {
			/*try {
				con.rollback();
			} catch (SQLException e1) {
				log.error("在查询信息时出现异常,事务回滚异常！");
				e1.printStackTrace();
			}*/
			log.error("在查询信息时出现异常！");
			ConnectUtil.closeAllConn(con, pst, rs);
			e.printStackTrace();
		}finally{
			 ConnectUtil.closeAllConn(con, pst, rs);
		}
		return resultCount;
	}
	
	
	/**
	 * 更新最新更新时间
	 * @param serviceCode
	 * @return 
	 */
	public static  void updateWebServiceDate(String serviceCode,Date date) {
		/*String sql = "update webservice_date set send_date = GETDATE(),oper_date=GETDATE() " +
				     " where service_code='"+serviceCode+"'"; 
		int count = execForSql(sql);
		if(count==0){
			log.error("更新webservice_date失败！");
		}*/
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String dateString = formatter.format(date);
		 
		String sql = "update webservice_date set send_date ='"+ dateString  + "',oper_date=GETDATE() " +
	     " where service_code='"+serviceCode+"'"; 
		System.out.println(sql);
		log.info("更新时间---->>"+sql);
		int count = execForSql(sql);
		if(count==0){
		log.error("更新webservice_date失败！");
		}
		
		
	 }
	
	
	
}
