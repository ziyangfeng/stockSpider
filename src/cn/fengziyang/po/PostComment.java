package cn.fengziyang.po;

/**
 * 评论
 * @author feng
 *
 */
public class PostComment {
	
	private String postId;  
	private String userCode;   //用户编码
	private String pubUserCode; //评论用户编码
	private String pubUserName; //评论用户名
	private String content;     //评论内容
	private String pubtime;     //评论时间
	private String operDate;    //操作时间
	
	
	
	public PostComment() {
		super();
	}



	public PostComment(String postId, String userCode, String pubUserCode,
			String pubUserName, String content, String pubtime, String operDate) {
		super();
		this.postId = postId;
		this.userCode = userCode;
		this.pubUserCode = pubUserCode;
		this.pubUserName = pubUserName;
		this.content = content;
		this.pubtime = pubtime;
		this.operDate = operDate;
	}



	public String getPostId() {
		return postId;
	}



	public void setPostId(String postId) {
		this.postId = postId;
	}



	public String getUserCode() {
		return userCode;
	}



	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}



	public String getPubUserCode() {
		return pubUserCode;
	}



	public void setPubUserCode(String pubUserCode) {
		this.pubUserCode = pubUserCode;
	}



	public String getPubUserName() {
		return pubUserName;
	}



	public void setPubUserName(String pubUserName) {
		this.pubUserName = pubUserName;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getPubtime() {
		return pubtime;
	}



	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}



	public String getOperDate() {
		return operDate;
	}



	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}
	
	


	

	
	
	
	
	
}
