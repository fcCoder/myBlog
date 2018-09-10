package ssm.blog.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ssm.blog.entity.Blog;
import ssm.blog.entity.Comment;
import ssm.blog.entity.Page;
import ssm.blog.entity.Tag;
import ssm.blog.entity.Type;

public interface IBlogService {
	
	Type getTypeById(Integer typeId);
	
	Type getTypeByName(String typeName);
	
	int addTagByName(String tagName,Integer blogId);
	
	List<Tag> getTagByBlogId(Integer blogId);
	
	int addBlog(Blog blog,String tagNames);
	
	List<Type> getAllTypes();
	
	List<Blog> getBlogByType(String typeName);
	
	Blog getBlogById(Integer id);
	
	List<Tag> getAllTags();
	
	List<Blog> getBlogByTag(String tagName);
	
	Map<String,List> getBlogByBlogger(Integer bloggerId);
	
	List<Blog> getBlogByReadCount();
	
	List<Comment> getCommentByBlog(Integer blogId);
	
	int addComment(Integer blogId,Integer bloggerId,String content);
	
	int addReadCount(Integer readCount,Integer blogId);
	
	int dianzan(Integer zanCount,Integer blogId);
	
	List<Blog> getBlogsByBloggerId(Integer bloggerId);
}
