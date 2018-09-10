package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Blog;
import ssm.blog.entity.Blogger;
import ssm.blog.entity.Tag;
import ssm.blog.entity.Type;

public interface IBloggerService {
	int register(Blogger blogger);
	
	Blogger doRegister(String nickname);
	
	Blogger login(String username,String password);
	
	Blogger getBloggerById(Integer id);
	
	List<Blog> getBlogByBloggerId(Integer bloggerId);
	
	int getBlogsCountByBloggerId(Integer bloggerId);
	
	List<Type> getTypeByBloggerId(Integer bloggerId);
	
	int getTypeCountByBloggerId(Integer bloggerId);
	
	List<Tag> getTagByBloggerId(Integer bloggerId);
	
	int getTagCountByBloggerId(Integer bloggerId);
	
	int deleteBlogById(Integer blogId);
	
	int deleteCommentById(Integer commentId);
	
	int updateType(String typeName);
}
