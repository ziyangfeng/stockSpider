package cn.fengziyang.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectUtil {
	  private static Logger log = Logger.getLogger(ConnectUtil.class);
	  private static Properties pro = new Properties();
	  private static String webserviceProFile = "/webserviceSet.properties";
	  private static String driver;
	  private static String address;
	  private static String port;
	  private static String dbName;
	  private static String username;
	  private static String password;
	  private static String url;

	  static
	  {
	    try
	    {
	      InputStream is = PathConfig.class.getResourceAsStream(webserviceProFile);
	      pro.load(is);
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new ExceptionInInitializerError(e);
	    }

	    driver = getConfiguration().getProperty("JDBCDriver");
	    address = getConfiguration().getProperty("address");
	    port = getConfiguration().getProperty("port");
	    dbName = getConfiguration().getProperty("dbName");
	    username = getConfiguration().getProperty("username");
	    password = getConfiguration().getProperty("password");
	    //url = "jdbc:sqlserver://" + address + ":" + port + "/" + dbName;
	    url = "jdbc:sqlserver://" + address + ":" + port + ";DatabaseName=" + dbName;
	  }

	  public static Properties getConfiguration()
	  {
	    return pro;
	  }
	  
	  /**
	   * 获取连接
	   * @return
	   */
	  public static Connection getHerpConnection()
	  {
	    Connection connHerp = null;
	    try {
			Class.forName(driver);
			connHerp = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			log.error("在连接HEPR数据库异常，请检查连接设置");
			e.printStackTrace();
		}
	    return connHerp;
	  }
	  
	  
	  /**
	   * 关闭连接
	   * @param conn
	   * @param pstm
	   * @param rs
	   */
	  public static void closeAllConn(Connection conn, PreparedStatement pstm, ResultSet rs) {
	    try {
	      if (rs != null) { rs.close(); rs = null; }
	      if (pstm != null) { pstm.close(); pstm = null; }
	      if (conn != null) {
	        conn.close();
	        conn = null;
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	  public static void main(String[] args) throws Exception {
	    getHerpConnection();
	  }
}
