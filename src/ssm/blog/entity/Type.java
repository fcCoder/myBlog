package ssm.blog.entity;

import org.springframework.stereotype.Component;

@Component
public class Type {
	
	private Integer id;			//����id
	private String typeName;	//��������
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