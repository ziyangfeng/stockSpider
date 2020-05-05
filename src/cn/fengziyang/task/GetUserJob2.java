package cn.fengziyang.task;

import java.io.IOException;

import org.apache.log4j.Logger;

import cn.fengziyang.po.User;
import cn.fengziyang.util.SqlUtil;
import cn.fengziyang.util.UserUtil;

public class GetUserJob2 {
	private static Logger log = Logger.getLogger(GetUserJob2.class);
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=20000000;i<99999999;i++){
			String iStr = String.valueOf(i);
			for(int j=0;j<99999999;j++){
				String jStr = UserUtil.get8Code(j);
				String userCode = iStr+jStr;
				try {
					User user = UserUtil.getUser(userCode);
					if(null != user){
						int count = UserUtil.insertUser(user);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("userCOde2:"+userCode);
				log.info(userCode);
			}
		}
		
		
		

	}

}
