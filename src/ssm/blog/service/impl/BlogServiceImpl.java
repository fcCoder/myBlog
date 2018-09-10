package ssm.blog.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ssm.blog.dao.BlogDao;
import ssm.blog.dao.BlogTagDao;
import ssm.blog.dao.BloggerDao;
import ssm.blog.dao.CommentDao;
import ssm.blog.dao.TagDao;
import ssm.blog.dao.TypeDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.BlogTag;
import ssm.blog.entity.Comment;
import ssm.blog.entity.Page;
import ssm.blog.entity.Tag;
import ssm.blog.entity.Time;
import ssm.blog.entity.Type;
import ssm.blog.service.IBlogService;

@Service
public class BlogServiceImpl implements IBlogService {
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private Type type;
	@Autowired
	private BlogTag blogTag;
	@Autowired
	private BlogTagDao blogTagDao;
	@Autowired
	private TagDao tagDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private BloggerDao bloggerDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private Time time;
	/**
	 * ͨ�����ͱ��е�typeid��ò������
	 */
	@Override
	public Type getTypeById(Integer typeId) {
		type=typeDao.getTypeById(typeId);
		return type;
	}
	/**
	 * д����ʱ��ͨ�������������
	 */
	@Override
	public Type getTypeByName(String typeName) {
		type=typeDao.getTypeByName(typeName);
		return type;
	}
	/**
	 * ͨ����ǩ���ڹ�������Ϊ������ӱ�ǩ
	 */
	@Override
	@Deprecated
	public int addTagByName(String tagName,Integer blogId) {
		int tagId=blogTagDao.getTagId(tagName);
		blogTag=new BlogTag();
		blogTag.setBlogId(blogId);
		blogTag.setTagId(tagId);
		
		return blogTagDao.addTag(blogTag);	
	}
	/**
	 * ͨ������id�ӹ������л�ñ�ǩ
	 */
	@Override
	public List<Tag> getTagByBlogId(Integer blogId) {
		return tagDao.getTagByBlog(blogId);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int addBlog(Blog blog,String tagNames) {
		//��blog������ӵ����ݿ�
		int result=blogDao.addBlog(blog);
		//��ȡ�ոշ���Ĳ���id
		int blogId=blogDao.selectLastBlogId();
		//��һ���ǩ�Կո�ֿ�
		String[] tagName=tagNames.split(" ");
		Tag tag;
		//������ǩ����
		for(int i=0;i<tagName.length;i++){
			tag=tagDao.getTagByName(tagName[i]);
			//��ǩ��Ϊ��������������ѭ��
			if(tagName[i].equals("")){
				continue;
			}else if(tag==null){
				tagDao.addTag(tagName[i]);
			}
			int tagId=blogTagDao.getTagId(tagName[i]);
			blogTag=new BlogTag();
			blogTag.setBlogId(blogId);
			blogTag.setTagId(tagId);
			result=blogTagDao.addTag(blogTag);
		}
		return result;
	}
	/**
	 * �鿴��ȡȫ������
	 */
	@Override
	public List<Type> getAllTypes() {
		return typeDao.getAllType();
	}
	/**
	 * ͨ����������ȡ�����͵Ĳ���
	 */
	@Override
	public List<Blog> getBlogByType(String typeName) {
		type=typeDao.getTypeByName(typeName);
		int typeId=type.getId();
		return blogDao.selectBlogByType(typeId);
	}
	/**
	 * �鿴������Ϣ
	 */
	@Override
	public Blog getBlogById(Integer id) {
		return blogDao.selectBlogById(id);
	}
	/**
	 * ��ȡȫ����ǩ
	 */
	@Override
	public List<Tag> getAllTags() {
		return tagDao.getAllTag();
	}
	/**
	 * ͨ����ǩ����ȡ�ñ�ǩ�µĲ���
	 */
	@Override
	public List<Blog> getBlogByTag(String tagName) {
		int tagId=blogTagDao.getTagId(tagName);
		return blogDao.selectBlogByTag(tagId);
	}
	/**
	 * ��ȡʱ����
	 */
	@Override
	public Map<String, List> getBlogByBlogger(Integer bloggerId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	    Date today = new Date();
	    String years=sdf.format(today);
	   // System.out.println(thisYear);
	    Map<String,List> map=new HashMap();
		List<Blog> blogs=blogDao.selectBlogByBlogger(bloggerId);
		List<Time> times=new ArrayList();
		for (Blog b : blogs) {
			String[] date=b.getReleaseDate().split("\\-",2);
			//System.out.println(date[0]);
			if(!years.equals(date[0])){
				
				//System.out.println("********����if�ж�*********8");
				map.put(years, times);
				years=date[0];
				/*for (Map.Entry<String, List> entry : map.entrySet()) {
				      System.out.println(entry.getKey() + ":" + entry.getValue());
				    }
				System.out.println("***************"+date[0]);*/
				times=new ArrayList<>();
			}
			Time blogTime=new Time();
			blogTime.setYear(date[0]);
			blogTime.setDay(date[1]);
			blogTime.setTitle(b.getTitle());
			blogTime.setId(b.getId());
			times.add(blogTime);
			//System.out.println(map);
		}
		//System.out.println(map);
		map.put(years, times);
		/*for (Map.Entry<String, List> entry : map.entrySet()) {
		      System.out.println(entry.getKey() + ":" + entry.getValue());
		    }*/
		return map;
	}
	
	/**
	 * ��ҳ�Ķ�����
	 */
	@Override
	public List<Blog> getBlogByReadCount() {
		return blogDao.selectBlogByReadCount();
	}
	/**
	 * ��������
	 */
	@Override
	public List<Comment> getCommentByBlog(Integer blogId) {
		List<Comment> comments=commentDao.getCommentByBlogId(blogId);
		List<Comment> comments2=new ArrayList();
		for (Comment comment : comments) {
			comment.setNickname(bloggerDao.getBloggerData(comment.getBloggerId()).getNickName());
			comment.setImage(bloggerDao.getBloggerData(comment.getBloggerId()).getImageName());
			comments2.add(comment);
		}
		return comments2;
	}
	/**
	 * ��������
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int addComment(Integer blogId,Integer bloggerId,String content) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(new Date());
		Comment comment=new Comment();
		comment.setTime(time);
		comment.setBlogId(blogId);
		comment.setContent(content);
		comment.setBloggerId(bloggerId);
		int result=commentDao.addComment(comment);
		Blog blog=blogDao.selectBlogById(blogId);
		Integer clickHit=blog.getClickHit();
		result=blogDao.updateClickHit(clickHit+1, blogId);
		return result;
	}
	/**
	 * �Ķ�����+1
	 */
	@Override
	public int addReadCount(Integer readCount,Integer blogId) {
		return blogDao.updateReadCount(readCount, blogId);
	}
	/**
	 * ����
	 */
	@Override
	public int dianzan(Integer zanCount, Integer blogId) {
		return blogDao.updateZanCount(zanCount, blogId);
	}
	@Override
	public List<Blog> getBlogsByBloggerId(Integer bloggerId) {
		return blogDao.selectBlogByBlogger(bloggerId);
	}

}
