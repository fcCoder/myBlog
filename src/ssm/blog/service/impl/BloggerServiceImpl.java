package ssm.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.blog.dao.BlogDao;
import ssm.blog.dao.BloggerDao;
import ssm.blog.dao.CommentDao;
import ssm.blog.dao.TagDao;
import ssm.blog.dao.TypeDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Blogger;
import ssm.blog.entity.Tag;
import ssm.blog.entity.Type;
import ssm.blog.service.IBloggerService;

@Service
public class BloggerServiceImpl implements IBloggerService {

	@Resource
	private BloggerDao bloggerDao;
	@Resource
	private BlogDao blogDao;
	@Resource
	private Blogger blogger;
	@Resource
	private TypeDao typeDao;
	@Resource
	private TagDao tagDao;
	@Resource
	private CommentDao commentDao;
	
	@Override
	public int register(Blogger blogger) {
		return bloggerDao.addBlogger(blogger);
	}
	@Override
	public Blogger doRegister(String nickname) {
		return bloggerDao.doRegister(nickname);
	}
	/**
	 * 用户登录
	 */
	@Override
	public Blogger login(String username, String password) {
		blogger=bloggerDao.doLogin(username, password);
		System.out.println(blogger);
		if(blogger!=null){
			return blogger;
		}
		return null;
	}
	/**
	 * 查看博主信息
	 */
	@Override
	public Blogger getBloggerById(Integer id) {
		System.out.println("############################"+id);
		return bloggerDao.getBloggerData(id);
	}
	@Override
	public List<Blog> getBlogByBloggerId(Integer bloggerId) {
		return blogDao.selectBlogByBlogger(bloggerId);
	}
	@Override
	public int getBlogsCountByBloggerId(Integer bloggerId) {
		int count=blogDao.selectBlogByBlogger(bloggerId).size();
		System.out.println("日志数量"+count);
		return count;
	}
	@Override
	public List<Type> getTypeByBloggerId(Integer bloggerId) {
		return typeDao.getTypeByBlogger(bloggerId);
	}
	@Override
	public int getTypeCountByBloggerId(Integer bloggerId) {
		int count=typeDao.getTypeByBlogger(bloggerId).size();
		return count;
	}
	@Override
	public List<Tag> getTagByBloggerId(Integer bloggerId) {
		return tagDao.getTagByBlogger(bloggerId);
	}
	@Override
	public int getTagCountByBloggerId(Integer bloggerId) {
		int count=tagDao.getTagByBlogger(bloggerId).size();
		return count;
	}
	@Override
	public int deleteBlogById(Integer blogId) {
		return blogDao.deleteBlog(blogId);
	}
	@Override
	public int deleteCommentById(Integer commentId) {
		return commentDao.deleteComment(commentId);
	}
	@Override
	public int updateType(String typeName) {
		Type type=typeDao.getTypeByName(typeName);
		return typeDao.updateType(type);
	}

}
