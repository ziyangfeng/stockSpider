package cn.fengziyang.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章内容
 * @author feng
 *
 */
public class PostContent {
	private String postId;    //文章唯一id，由股票吧代码和post_id组成
	private String userCode;  //
	private String title;     //
	private String content;   //
	private String pubtime;   //
	private String pv;        //
	private String operDate;  //
	
	private List<PostComment> postCommentList = new ArrayList<PostComment>();
	
	
	public PostContent() {
		super();
	}


	public PostContent(String postId, String userCode, String title,
			String content, String pubtime, String pv, String operDate,
			List<PostComment> postCommentList) {
		super();
		this.postId = postId;
		this.userCode = userCode;
		this.title = title;
		this.content = content;
		this.pubtime = pubtime;
		this.pv = pv;
		this.operDate = operDate;
		this.postCommentList = postCommentList;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public String getPv() {
		return pv;
	}


	public void setPv(String pv) {
		this.pv = pv;
	}


	public String getOperDate() {
		return operDate;
	}


	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}


	public List<PostComment> getPostCommentList() {
		return postCommentList;
	}


	public void setPostCommentList(List<PostComment> postCommentList) {
		this.postCommentList = postCommentList;
	}

	
	
	
	
	
	
	
	
}
