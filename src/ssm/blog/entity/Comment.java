package ssm.blog.entity;

import org.springframework.stereotype.Component;

@Component
public class Comment {
	
	private Integer id;			//����id
	private String content;		//��������
	private String subContent;	//��������
	private String time;		//����ʱ��
	private Integer bloggerId;	//�û�id
	private String image;		//�û�ͷ��
	private String nickname;	//�û���
	private Integer blogId;		//����id
	
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
