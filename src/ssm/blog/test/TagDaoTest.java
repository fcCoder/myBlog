package ssm.blog.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.TagDao;
import ssm.blog.entity.Tag;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class TagDaoTest {

	@Resource   //注入BloggerDao对象
    private TagDao tagDao;
	
	@Test
	public void testGetAllTag() {
		System.out.println(tagDao.getTagByBlogger(3).size());
	}
	
	@Test
	public void testAddTag() {
		Tag tag=new Tag();
		tag.setTagName("区块链");
		System.out.println(tagDao.addTag(tag.getTagName()));
	}
	
	@Test
	public void testDeleteTag() {
		System.out.println(tagDao.deleteTag(3));
	}

	@Test
	public void testUpdateTag() {
		Tag tag=new Tag();
		tag.setTagName("区块链");
		tag.setId(2);
		System.out.println(tagDao.updateTag(tag));
	}
}
