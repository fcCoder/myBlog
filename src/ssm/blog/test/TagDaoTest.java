package ssm.blog.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.TagDao;
import ssm.blog.entity.Tag;

@RunWith(SpringJUnit4ClassRunner.class) //ʹ��spring����
@ContextConfiguration(locations = "classpath:spring-beans.xml") //����spring�����ļ�·��
public class TagDaoTest {

	@Resource   //ע��BloggerDao����
    private TagDao tagDao;
	
	@Test
	public void testGetAllTag() {
		System.out.println(tagDao.getTagByBlogger(3).size());
	}
	
	@Test
	public void testAddTag() {
		Tag tag=new Tag();
		tag.setTagName("������");
		System.out.println(tagDao.addTag(tag.getTagName()));
	}
	
	@Test
	public void testDeleteTag() {
		System.out.println(tagDao.deleteTag(3));
	}

	@Test
	public void testUpdateTag() {
		Tag tag=new Tag();
		tag.setTagName("������");
		tag.setId(2);
		System.out.println(tagDao.updateTag(tag));
	}
}
