package ssm.blog.entity;

import org.springframework.stereotype.Component;

@Component
public class Comment {
	
	private Integer id;			//评论id
	private String content;		//评论内容
	private String subContent;	//部分内容
	private String time;		//评论时间
	private Integer bloggerId;	//用户id
	private String image;		//用户头像
	private String nickname;	//用户名
	private Integer blogId;		//博客id
	
	public String getSubContent() {
		return subContent;
	}
	public void setSubContent() {
		this.subContent = this.content.substring(0, 3);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getBloggerId() {
		return bloggerId;
	}
	public void setBloggerId(Integer bloggerId) {
		this.bloggerId = bloggerId;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", time=" + time + ", bloggerId=" + bloggerId + ", nickname=" + nickname + ", blogId=" + blogId + "]";
	}
	
}
