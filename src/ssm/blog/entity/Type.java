package ssm.blog.entity;

import org.springframework.stereotype.Component;

@Component
public class Type {
	
	private Integer id;			//类型id
	private String typeName;	//类型名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", typeName=" + typeName + "]";
	}
	
}
