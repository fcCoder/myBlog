package ssm.blog.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Tag {
	
	private Integer id;			//��ǩid
	private String tagName;		//��ǩ����
	//private List<Blog> blogs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + "]";
	}
	
}
