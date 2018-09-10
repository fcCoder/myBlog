package ssm.blog.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class Blog {
	
	private Integer id;			//博客id
	private String title;		//博客题目
	private String releaseDate;	//发布日期
	private Integer zanCount;	//点赞数
	private Integer readCount;	//阅读次数
	private Integer clickHit;	//评论数
	private String content;		//内容
	private Integer bloggerId;	//用户id
	private Integer typeId;		//类型id
	//private List<Tag> tags;
	//private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Integer getId() {
		return id;
	}
	/*public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}*/
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;		
	}
	public Integer getZanCount() {
		return zanCount;
	}
	public void setZanCount(Integer zanCount) {
		this.zanCount = zanCount;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	public Integer getClickHit() {
		return clickHit;
	}
	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getBloggerId() {
		return bloggerId;
	}
	public void setBloggerId(Integer bloggerId) {
		this.bloggerId = bloggerId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", zanCount=" + zanCount
				+ ", readCount=" + readCount + ", clickHit=" + clickHit + ", content=" + content + ", bloggerId="
				+ bloggerId + ", typeId=" + typeId + "]";
	}
	
	
}
