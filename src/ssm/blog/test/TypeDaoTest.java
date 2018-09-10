package ssm.blog.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.TypeDao;
import ssm.blog.entity.Type;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class TypeDaoTest {

	@Resource   //注入BloggerDao对象
    private TypeDao typeDao;
	
	@Test
	public void testGetAllType() {
		System.out.println(typeDao.getTypeByBlogger(2));
	}
	
	@Test
	public void testAddType() {
		Type type=new Type();
		type.setTypeName("区块链");
		System.out.println(typeDao.addType(type));
	}
	
	@Test
	public void testDeleteType() {
		System.out.println(typeDao.deleteType(3));
	}

	@Test
	public void testUpdateType() {
		Type type=new Type();
		type.setTypeName("区块链");
		type.setId(2);
		System.out.println(typeDao.updateType(type));
	}
}
