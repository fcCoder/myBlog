package ssm.blog.test;

import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import ssm.blog.dao.BloggerDao;
import ssm.blog.entity.Blogger;
import ssm.blog.service.IBloggerService;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class BloggerDaoTest {

	@Resource   //注入BloggerDao对象
    private BloggerDao bloggerDao;
	@Resource
	private IBloggerService service;
	
	@Test
	public void testDoLogin() {
        System.out.println(service.login("何鹏", "123"));
	}
	
	@Test
	public void testGetBloggerData() {
		Blogger blogger = bloggerDao.getBloggerData(1);
        System.out.println(blogger);
	}

	@Test
	public void testUpdateBlogger() {
		Blogger blogger = new Blogger();
		blogger.setId(2);
		blogger.setUserName("hepeng");
		blogger.setPassword("123456");
		blogger.setAge(21);
		blogger.setSex("男");
		blogger.setNickName("hp");
		blogger.setSign("cool");
		blogger.setImageName("default.jpg");
        System.out.println(bloggerDao.updateBlogger(blogger));
	}
	
	@Test
	public void testAddBlogger() {
		Blogger blogger = new Blogger();
		blogger.setUserName("hepeng");
		blogger.setPassword("123");
		blogger.setAge(18);
        System.out.println(bloggerDao.addBlogger(blogger));
	}
	
	@Test
	public void testDeleteBlogger() {
		Blogger blogger = new Blogger();
		blogger.setId(4);
        System.out.println(bloggerDao.deleteBlogger(blogger.getId()));
	}
}
