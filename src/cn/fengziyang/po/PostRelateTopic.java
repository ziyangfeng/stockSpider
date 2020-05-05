package cn.fengziyang.po;

public class PostRelateTopic {
	private String id;
	private String name;
	private String h5_url;
	private String guide;
	
	public PostRelateTopic(String id, String name, String h5_url, String guide) {
		super();
		this.id = id;
		this.name = name;
		this.h5_url = h5_url;
		this.guide = guide;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getH5_url() {
		return h5_url;
	}
	public void setH5_url(String h5_url) {
		this.h5_url = h5_url;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	
	
}
