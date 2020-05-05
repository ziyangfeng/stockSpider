package cn.fengziyang.po;

public class Post {
	private String stauts;
	
	private PostData data;  //data 对象

	public Post(String stauts, PostData data) {
		super();
		this.stauts = stauts;
		this.data = data;
	}

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public PostData getData() {
		return data;
	}

	public void setData(PostData data) {
		this.data = data;
	}
	
	
	
}
