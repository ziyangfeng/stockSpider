package cn.fengziyang.po;

import java.util.ArrayList;
import java.util.List;

public class PostData {
	private List<PostRe> re = new ArrayList<PostRe>();
	
	//ret  对象列表
	//ret_ad  对象列表
	//ret_ad_type  对象列表
	//hot_articles  对象列表
	
	private String count;
	private String bar_name;
	private String bar_code;
	private String bar_quot_code;
	private String apis;
	private String bar_rank;
	private String stockbar_fans_count;
	private String stockbar_desc;
	private String intelligent_reply;
	private String classic_reply;
	private String rc;
	private String me;   //页码超过最大限制后显示【没有更多内容了】，正常为【操作成功】
	private String time;
	
	public PostData(List<PostRe> re, String count, String bar_name,
			String bar_code, String bar_quot_code, String apis,
			String bar_rank, String stockbar_fans_count, String stockbar_desc,
			String intelligent_reply, String classic_reply, String rc,
			String me, String time) {
		super();
		this.re = re;
		this.count = count;
		this.bar_name = bar_name;
		this.bar_code = bar_code;
		this.bar_quot_code = bar_quot_code;
		this.apis = apis;
		this.bar_rank = bar_rank;
		this.stockbar_fans_count = stockbar_fans_count;
		this.stockbar_desc = stockbar_desc;
		this.intelligent_reply = intelligent_reply;
		this.classic_reply = classic_reply;
		this.rc = rc;
		this.me = me;
		this.time = time;
	}

	public List<PostRe> getRe() {
		return re;
	}

	public void setRe(List<PostRe> re) {
		this.re = re;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getBar_name() {
		return bar_name;
	}

	public void setBar_name(String bar_name) {
		this.bar_name = bar_name;
	}

	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	public String getBar_quot_code() {
		return bar_quot_code;
	}

	public void setBar_quot_code(String bar_quot_code) {
		this.bar_quot_code = bar_quot_code;
	}

	public String getApis() {
		return apis;
	}

	public void setApis(String apis) {
		this.apis = apis;
	}

	public String getBar_rank() {
		return bar_rank;
	}

	public void setBar_rank(String bar_rank) {
		this.bar_rank = bar_rank;
	}

	public String getStockbar_fans_count() {
		return stockbar_fans_count;
	}

	public void setStockbar_fans_count(String stockbar_fans_count) {
		this.stockbar_fans_count = stockbar_fans_count;
	}

	public String getStockbar_desc() {
		return stockbar_desc;
	}

	public void setStockbar_desc(String stockbar_desc) {
		this.stockbar_desc = stockbar_desc;
	}

	public String getIntelligent_reply() {
		return intelligent_reply;
	}

	public void setIntelligent_reply(String intelligent_reply) {
		this.intelligent_reply = intelligent_reply;
	}

	public String getClassic_reply() {
		return classic_reply;
	}

	public void setClassic_reply(String classic_reply) {
		this.classic_reply = classic_reply;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getMe() {
		return me;
	}

	public void setMe(String me) {
		this.me = me;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
