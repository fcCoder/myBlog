package ssm.blog.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.TypeDao;
import ssm.blog.entity.Type;

@RunWith(SpringJUnit4ClassRunner.class) //ʹ��spring����
@ContextConfiguration(locations = "classpath:spring-beans.xml") //����spring�����ļ�·��
public class TypeDaoTest {

	@Resource   //ע��BloggerDao����
    private TypeDao typeDao;
	
	@Test
	public void testGetAllType() {
		System.out.println(typeDao.getTypeByBlogger(2));
	}
	
	@Test
	public void testAddType() {
		Type type=new Type();
		type.setTypeName("������");
		System.out.println(typeDao.addType(type));
	}
	
	@Test
	public void testDeleteType() {
		System.out.println(typeDao.deleteType(3));
	}

	@Test
	public void testUpdateType() {
		Type type=new Type();
		type.setTypeName("������");
		type.setId(2);
		System.out.println(typeDao.updateType(type));
	}
}
