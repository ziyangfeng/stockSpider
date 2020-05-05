package cn.fengziyang.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * load the webService config
 * @author feng
 *
 */
public class PathConfig {
	  private static Properties pro = new Properties();

	  static {
	    try { InputStream is = PathConfig.class.getResourceAsStream("/webserviceSet.properties");
	      pro.load(is);
	    } catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new ExceptionInInitializerError(e);
	    }
	  }
	  

	  public static Properties getConfiguration() {
	    return pro;
	  }
}
