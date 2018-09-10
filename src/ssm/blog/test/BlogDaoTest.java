package ssm.blog.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.BlogDao;
import ssm.blog.entity.Blog;
import ssm.blog.service.IBlogService;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class BlogDaoTest {

	@Resource
	private BlogDao blogDao;
	@Resource
	private IBlogService service;
	@Test
	public void testSelectBlog() {
		System.out.println(service.dianzan(1, 14));
	}
	
	@Test
	public void testSelectLastBlogId() {
		Blog blog=new Blog();
		blog.setBloggerId(1);
		blog.setContent("something");
		blog.setReadCount(0);
		blog.setClickHit(0);
		blog.setTitle("test2");
		blog.setTypeId(1);
		blogDao.addBlog(blog);
		System.out.println(blogDao.selectLastBlogId());
	}

	@Test
	public void testAddTagByName() {
		System.out.println(service.addTagByName("测试", 1));
	}
	
	@Test
	public void testGetTagByBlogId() {
		System.out.println(service.getTagByBlogId(1));
	}
	
	@Test
	public void testAddBlog() {
		Blog blog=new Blog();
		blog.setBloggerId(1);
		blog.setTitle("无名");
		blog.setClickHit(0);
		blog.setReadCount(0);
		blog.setTypeId(1);
		System.out.println(blogDao.addBlog(blog));
	}
	
	@Test
	public void testUpdateBlog() {
		Blog blog=new Blog();
		blog.setId(3);
		blog.setTitle("名");
		blog.setContent("dddd");
		blog.setTypeId(2);
		System.out.println(blogDao.updateBlog(blog));
	}
	
	@Test
	public void testDeleteBlog() {
		System.out.println(blogDao.deleteBlog(3));
	}
	
}
