package cn.fengziyang.po;

public class User {
	/**
	 * 用户编码
	 */
	private String userCode; 
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 吧龄
	 */
	private String user_age;
	
	/**
	 * 粉丝数量
	 */
	private int fans;
	
	/**
	 * 访问量
	 */
	private int pv;
	
	public User(String userCode, String userName, String user_age, int fans,
			int pv) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.user_age = user_age;
		this.fans = fans;
		this.pv = pv;
	}
	
	
	
	public User() {
		super();
	}



	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	
}
