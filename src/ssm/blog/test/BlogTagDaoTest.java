package ssm.blog.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.BlogTagDao;
import ssm.blog.entity.BlogTag;

@RunWith(SpringJUnit4ClassRunner.class) //ʹ��spring����
@ContextConfiguration(locations = "classpath:spring-beans.xml") //����spring�����ļ�·��
public class BlogTagDaoTest {

	@Resource
	private BlogTagDao blogTagDao;
	@Test
	public void testAdd() {
		BlogTag blogTag=new BlogTag();
		blogTag.setBlogId(2);
		blogTag.setTagId(3);
		System.out.println(blogTagDao.addTag(blogTag));
	}

	@Test
	public void testDeleteTag() {
		System.out.println(blogTagDao.deleteTag(2,2));
	}
	
	@Test
	public void testDeleteTagByBlogId() {
		System.out.println(blogTagDao.deleteTagByBlogId(2));
	}
	
	@Test
	public void testDeleteTagByTagId() {
		System.out.println(blogTagDao.deleteTagByTagId(3));
	}
}
