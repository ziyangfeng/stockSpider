package cn.fengziyang.po;

public class PostRe {
	private String post_content;
	private String post_abstract;
	private String post_publish_time;
	private String post_display_time;
	private String post_ip;
	private String post_state;
	private String post_checkState;
	private String post_forward_count;
	private String post_comment_authority;
	private String post_like_count;
	private String post_is_like;
	private String post_is_collected;
	private String post_type;
	private String post_source_id;
	private String post_top_status;
	private String post_status;
	private String post_from;
	private String post_from_num;
	private String post_pdf_url;
	private String post_has_pic;
	private String has_pic_not_include_content;
	private String post_pic_url;
	private String source_post_id;
	private String source_post_state;
	private String source_post_user_id;
	private String source_post_user_nickname;
	private String source_post_user_type;
	private String source_post_user_is_majia;
	private String source_post_pic_url;
	private String source_post_title;
	private String source_post_content;
	private String source_post_ip;
	private String source_post_type;
	private SourcePostGuba source_post_guba;
	private String post_video_url;
	private String source_post_video_url;
	private String source_post_from;
	private String source_post_like_count;
	private String code_name;
	private String product_type;
	private String v_user_code;
	private String source_click_count;
	private String source_comment_count;
	private String source_forward_count;
	private String source_publish_time;
	private String source_user_is_majia;
	private String ask_chairman_state;
	private String selected_post_code;
	private String selected_post_name;
	private String selected_relate_guba;
	private String ask_question;
	private String ask_answer;
	private String qa;
	private String extend;
	private String source_extend;
	private String source_post_source_id;
	private String post_pic_url2;
	private String source_post_pic_url2;
	private PostRelateTopic relate_topic;
	private String zwpage_flag;
	private String source_post_comment_count;
	private String post_atuser;
	private String reply_list;
	private String content_type;
	private PostDiscussion post_discussion;
	private String media_type;
	private String repost_state;
	private String post_id;
	private PostUser post_user;
	private PostGuba post_guba;
	private String post_title;
	private String post_last_time;
	private String post_click_count;
	private String post_comment_count;
	private String post_address;
	
	public PostRe(String post_content, String post_abstract,
			String post_publish_time, String post_display_time, String post_ip,
			String post_state, String post_checkState,
			String post_forward_count, String post_comment_authority,
			String post_like_count, String post_is_like,
			String post_is_collected, String post_type, String post_source_id,
			String post_top_status, String post_status, String post_from,
			String post_from_num, String post_pdf_url, String post_has_pic,
			String has_pic_not_include_content, String post_pic_url,
			String source_post_id, String source_post_state,
			String source_post_user_id, String source_post_user_nickname,
			String source_post_user_type, String source_post_user_is_majia,
			String source_post_pic_url, String source_post_title,
			String source_post_content, String source_post_ip,
			String source_post_type, SourcePostGuba source_post_guba,
			String post_video_url, String source_post_video_url,
			String source_post_from, String source_post_like_count,
			String code_name, String product_type, String v_user_code,
			String source_click_count, String source_comment_count,
			String source_forward_count, String source_publish_time,
			String source_user_is_majia, String ask_chairman_state,
			String selected_post_code, String selected_post_name,
			String selected_relate_guba, String ask_question,
			String ask_answer, String qa, String extend, String source_extend,
			String source_post_source_id, String post_pic_url2,
			String source_post_pic_url2, PostRelateTopic relate_topic,
			String zwpage_flag, String source_post_comment_count,
			String post_atuser, String reply_list, String content_type,
			PostDiscussion post_discussion, String media_type,
			String repost_state, String post_id, PostUser post_user,
			PostGuba post_guba, String post_title, String post_last_time,
			String post_click_count, String post_comment_count,
			String post_address) {
		super();
		this.post_content = post_content;
		this.post_abstract = post_abstract;
		this.post_publish_time = post_publish_time;
		this.post_display_time = post_display_time;
		this.post_ip = post_ip;
		this.post_state = post_state;
		this.post_checkState = post_checkState;
		this.post_forward_count = post_forward_count;
		this.post_comment_authority = post_comment_authority;
		this.post_like_count = post_like_count;
		this.post_is_like = post_is_like;
		this.post_is_collected = post_is_collected;
		this.post_type = post_type;
		this.post_source_id = post_source_id;
		this.post_top_status = post_top_status;
		this.post_status = post_status;
		this.post_from = post_from;
		this.post_from_num = post_from_num;
		this.post_pdf_url = post_pdf_url;
		this.post_has_pic = post_has_pic;
		this.has_pic_not_include_content = has_pic_not_include_content;
		this.post_pic_url = post_pic_url;
		this.source_post_id = source_post_id;
		this.source_post_state = source_post_state;
		this.source_post_user_id = source_post_user_id;
		this.source_post_user_nickname = source_post_user_nickname;
		this.source_post_user_type = source_post_user_type;
		this.source_post_user_is_majia = source_post_user_is_majia;
		this.source_post_pic_url = source_post_pic_url;
		this.source_post_title = source_post_title;
		this.source_post_content = source_post_content;
		this.source_post_ip = source_post_ip;
		this.source_post_type = source_post_type;
		this.source_post_guba = source_post_guba;
		this.post_video_url = post_video_url;
		this.source_post_video_url = source_post_video_url;
		this.source_post_from = source_post_from;
		this.source_post_like_count = source_post_like_count;
		this.code_name = code_name;
		this.product_type = product_type;
		this.v_user_code = v_user_code;
		this.source_click_count = source_click_count;
		this.source_comment_count = source_comment_count;
		this.source_forward_count = source_forward_count;
		this.source_publish_time = source_publish_time;
		this.source_user_is_majia = source_user_is_majia;
		this.ask_chairman_state = ask_chairman_state;
		this.selected_post_code = selected_post_code;
		this.selected_post_name = selected_post_name;
		this.selected_relate_guba = selected_relate_guba;
		this.ask_question = ask_question;
		this.ask_answer = ask_answer;
		this.qa = qa;
		this.extend = extend;
		this.source_extend = source_extend;
		this.source_post_source_id = source_post_source_id;
		this.post_pic_url2 = post_pic_url2;
		this.source_post_pic_url2 = source_post_pic_url2;
		this.relate_topic = relate_topic;
		this.zwpage_flag = zwpage_flag;
		this.source_post_comment_count = source_post_comment_count;
		this.post_atuser = post_atuser;
		this.reply_list = reply_list;
		this.content_type = content_type;
		this.post_discussion = post_discussion;
		this.media_type = media_type;
		this.repost_state = repost_state;
		this.post_id = post_id;
		this.post_user = post_user;
		this.post_guba = post_guba;
		this.post_title = post_title;
		this.post_last_time = post_last_time;
		this.post_click_count = post_click_count;
		this.post_comment_count = post_comment_count;
		this.post_address = post_address;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_abstract() {
		return post_abstract;
	}

	public void setPost_abstract(String post_abstract) {
		this.post_abstract = post_abstract;
	}

	public String getPost_publish_time() {
		return post_publish_time;
	}

	public void setPost_publish_time(String post_publish_time) {
		this.post_publish_time = post_publish_time;
	}

	public String getPost_display_time() {
		return post_display_time;
	}

	public void setPost_display_time(String post_display_time) {
		this.post_display_time = post_display_time;
	}

	public String getPost_ip() {
		return post_ip;
	}

	public void setPost_ip(String post_ip) {
		this.post_ip = post_ip;
	}

	public String getPost_state() {
		return post_state;
	}

	public void setPost_state(String post_state) {
		this.post_state = post_state;
	}

	public String getPost_checkState() {
		return post_checkState;
	}

	public void setPost_checkState(String post_checkState) {
		this.post_checkState = post_checkState;
	}

	public String getPost_forward_count() {
		return post_forward_count;
	}

	public void setPost_forward_count(String post_forward_count) {
		this.post_forward_count = post_forward_count;
	}

	public String getPost_comment_authority() {
		return post_comment_authority;
	}

	public void setPost_comment_authority(String post_comment_authority) {
		this.post_comment_authority = post_comment_authority;
	}

	public String getPost_like_count() {
		return post_like_count;
	}

	public void setPost_like_count(String post_like_count) {
		this.post_like_count = post_like_count;
	}

	public String getPost_is_like() {
		return post_is_like;
	}

	public void setPost_is_like(String post_is_like) {
		this.post_is_like = post_is_like;
	}

	public String getPost_is_collected() {
		return post_is_collected;
	}

	public void setPost_is_collected(String post_is_collected) {
		this.post_is_collected = post_is_collected;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public String getPost_source_id() {
		return post_source_id;
	}

	public void setPost_source_id(String post_source_id) {
		this.post_source_id = post_source_id;
	}

	public String getPost_top_status() {
		return post_top_status;
	}

	public void setPost_top_status(String post_top_status) {
		this.post_top_status = post_top_status;
	}

	public String getPost_status() {
		return post_status;
	}

	public void setPost_status(String post_status) {
		this.post_status = post_status;
	}

	public String getPost_from() {
		return post_from;
	}

	public void setPost_from(String post_from) {
		this.post_from = post_from;
	}

	public String getPost_from_num() {
		return post_from_num;
	}

	public void setPost_from_num(String post_from_num) {
		this.post_from_num = post_from_num;
	}

	public String getPost_pdf_url() {
		return post_pdf_url;
	}

	public void setPost_pdf_url(String post_pdf_url) {
		this.post_pdf_url = post_pdf_url;
	}

	public String getPost_has_pic() {
		return post_has_pic;
	}

	public void setPost_has_pic(String post_has_pic) {
		this.post_has_pic = post_has_pic;
	}

	public String getHas_pic_not_include_content() {
		return has_pic_not_include_content;
	}

	public void setHas_pic_not_include_content(String has_pic_not_include_content) {
		this.has_pic_not_include_content = has_pic_not_include_content;
	}

	public String getPost_pic_url() {
		return post_pic_url;
	}

	public void setPost_pic_url(String post_pic_url) {
		this.post_pic_url = post_pic_url;
	}

	public String getSource_post_id() {
		return source_post_id;
	}

	public void setSource_post_id(String source_post_id) {
		this.source_post_id = source_post_id;
	}

	public String getSource_post_state() {
		return source_post_state;
	}

	public void setSource_post_state(String source_post_state) {
		this.source_post_state = source_post_state;
	}

	public String getSource_post_user_id() {
		return source_post_user_id;
	}

	public void setSource_post_user_id(String source_post_user_id) {
		this.source_post_user_id = source_post_user_id;
	}

	public String getSource_post_user_nickname() {
		return source_post_user_nickname;
	}

	public void setSource_post_user_nickname(String source_post_user_nickname) {
		this.source_post_user_nickname = source_post_user_nickname;
	}

	public String getSource_post_user_type() {
		return source_post_user_type;
	}

	public void setSource_post_user_type(String source_post_user_type) {
		this.source_post_user_type = source_post_user_type;
	}

	public String getSource_post_user_is_majia() {
		return source_post_user_is_majia;
	}

	public void setSource_post_user_is_majia(String source_post_user_is_majia) {
		this.source_post_user_is_majia = source_post_user_is_majia;
	}

	public String getSource_post_pic_url() {
		return source_post_pic_url;
	}

	public void setSource_post_pic_url(String source_post_pic_url) {
		this.source_post_pic_url = source_post_pic_url;
	}

	public String getSource_post_title() {
		return source_post_title;
	}

	public void setSource_post_title(String source_post_title) {
		this.source_post_title = source_post_title;
	}

	public String getSource_post_content() {
		return source_post_content;
	}

	public void setSource_post_content(String source_post_content) {
		this.source_post_content = source_post_content;
	}

	public String getSource_post_ip() {
		return source_post_ip;
	}

	public void setSource_post_ip(String source_post_ip) {
		this.source_post_ip = source_post_ip;
	}

	public String getSource_post_type() {
		return source_post_type;
	}

	public void setSource_post_type(String source_post_type) {
		this.source_post_type = source_post_type;
	}

	public SourcePostGuba getSource_post_guba() {
		return source_post_guba;
	}

	public void setSource_post_guba(SourcePostGuba source_post_guba) {
		this.source_post_guba = source_post_guba;
	}

	public String getPost_video_url() {
		return post_video_url;
	}

	public void setPost_video_url(String post_video_url) {
		this.post_video_url = post_video_url;
	}

	public String getSource_post_video_url() {
		return source_post_video_url;
	}

	public void setSource_post_video_url(String source_post_video_url) {
		this.source_post_video_url = source_post_video_url;
	}

	public String getSource_post_from() {
		return source_post_from;
	}

	public void setSource_post_from(String source_post_from) {
		this.source_post_from = source_post_from;
	}

	public String getSource_post_like_count() {
		return source_post_like_count;
	}

	public void setSource_post_like_count(String source_post_like_count) {
		this.source_post_like_count = source_post_like_count;
	}

	public String getCode_name() {
		return code_name;
	}

	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getV_user_code() {
		return v_user_code;
	}

	public void setV_user_code(String v_user_code) {
		this.v_user_code = v_user_code;
	}

	public String getSource_click_count() {
		return source_click_count;
	}

	public void setSource_click_count(String source_click_count) {
		this.source_click_count = source_click_count;
	}

	public String getSource_comment_count() {
		return source_comment_count;
	}

	public void setSource_comment_count(String source_comment_count) {
		this.source_comment_count = source_comment_count;
	}

	public String getSource_forward_count() {
		return source_forward_count;
	}

	public void setSource_forward_count(String source_forward_count) {
		this.source_forward_count = source_forward_count;
	}

	public String getSource_publish_time() {
		return source_publish_time;
	}

	public void setSource_publish_time(String source_publish_time) {
		this.source_publish_time = source_publish_time;
	}

	public String getSource_user_is_majia() {
		return source_user_is_majia;
	}

	public void setSource_user_is_majia(String source_user_is_majia) {
		this.source_user_is_majia = source_user_is_majia;
	}

	public String getAsk_chairman_state() {
		return ask_chairman_state;
	}

	public void setAsk_chairman_state(String ask_chairman_state) {
		this.ask_chairman_state = ask_chairman_state;
	}

	public String getSelected_post_code() {
		return selected_post_code;
	}

	public void setSelected_post_code(String selected_post_code) {
		this.selected_post_code = selected_post_code;
	}

	public String getSelected_post_name() {
		return selected_post_name;
	}

	public void setSelected_post_name(String selected_post_name) {
		this.selected_post_name = selected_post_name;
	}

	public String getSelected_relate_guba() {
		return selected_relate_guba;
	}

	public void setSelected_relate_guba(String selected_relate_guba) {
		this.selected_relate_guba = selected_relate_guba;
	}

	public String getAsk_question() {
		return ask_question;
	}

	public void setAsk_question(String ask_question) {
		this.ask_question = ask_question;
	}

	public String getAsk_answer() {
		return ask_answer;
	}

	public void setAsk_answer(String ask_answer) {
		this.ask_answer = ask_answer;
	}

	public String getQa() {
		return qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getSource_extend() {
		return source_extend;
	}

	public void setSource_extend(String source_extend) {
		this.source_extend = source_extend;
	}

	public String getSource_post_source_id() {
		return source_post_source_id;
	}

	public void setSource_post_source_id(String source_post_source_id) {
		this.source_post_source_id = source_post_source_id;
	}

	public String getPost_pic_url2() {
		return post_pic_url2;
	}

	public void setPost_pic_url2(String post_pic_url2) {
		this.post_pic_url2 = post_pic_url2;
	}

	public String getSource_post_pic_url2() {
		return source_post_pic_url2;
	}

	public void setSource_post_pic_url2(String source_post_pic_url2) {
		this.source_post_pic_url2 = source_post_pic_url2;
	}

	public PostRelateTopic getRelate_topic() {
		return relate_topic;
	}

	public void setRelate_topic(PostRelateTopic relate_topic) {
		this.relate_topic = relate_topic;
	}

	public String getZwpage_flag() {
		return zwpage_flag;
	}

	public void setZwpage_flag(String zwpage_flag) {
		this.zwpage_flag = zwpage_flag;
	}

	public String getSource_post_comment_count() {
		return source_post_comment_count;
	}

	public void setSource_post_comment_count(String source_post_comment_count) {
		this.source_post_comment_count = source_post_comment_count;
	}

	public String getPost_atuser() {
		return post_atuser;
	}

	public void setPost_atuser(String post_atuser) {
		this.post_atuser = post_atuser;
	}

	public String getReply_list() {
		return reply_list;
	}

	public void setReply_list(String reply_list) {
		this.reply_list = reply_list;
	}

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public PostDiscussion getPost_discussion() {
		return post_discussion;
	}

	public void setPost_discussion(PostDiscussion post_discussion) {
		this.post_discussion = post_discussion;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getRepost_state() {
		return repost_state;
	}

	public void setRepost_state(String repost_state) {
		this.repost_state = repost_state;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public PostUser getPost_user() {
		return post_user;
	}

	public void setPost_user(PostUser post_user) {
		this.post_user = post_user;
	}

	public PostGuba getPost_guba() {
		return post_guba;
	}

	public void setPost_guba(PostGuba post_guba) {
		this.post_guba = post_guba;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_last_time() {
		return post_last_time;
	}

	public void setPost_last_time(String post_last_time) {
		this.post_last_time = post_last_time;
	}

	public String getPost_click_count() {
		return post_click_count;
	}

	public void setPost_click_count(String post_click_count) {
		this.post_click_count = post_click_count;
	}

	public String getPost_comment_count() {
		return post_comment_count;
	}

	public void setPost_comment_count(String post_comment_count) {
		this.post_comment_count = post_comment_count;
	}

	public String getPost_address() {
		return post_address;
	}

	public void setPost_address(String post_address) {
		this.post_address = post_address;
	}
	
	
	
}
