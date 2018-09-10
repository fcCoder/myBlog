package ssm.blog.entity;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 对应数据库中blog表与tag表多对多的映射表
 * @author Administrator
 *
 */
@Component
public class BlogTag {
	
	private Integer id;
	private Integer blogId;
	private Integer tagId;
	//private Blog blog;
	//private Tag tag;
	//private List<Blog> blogs;
	//private List<Tag> tags;
	
	/*public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	public List<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	@Override
	public String toString() {
		return "BlogTag [id=" + id + ", blogId=" + blogId + ", tagId=" + tagId + "]";
	}
	
}
