package ssm.blog.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.blog.dao.CommentDao;
import ssm.blog.entity.Comment;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试
@ContextConfiguration(locations = "classpath:spring-beans.xml") //设置spring配置文件路径
public class CommentDaoTest {

	@Resource
	private CommentDao commentDao;
	@Test
	public void testSelect() {
		System.out.println(commentDao.getCommentByBlogId(1));
	}
	
	@Test
	public void testAdd() {
		Comment comment=new Comment();
		comment.setContent("一般般吧");
		comment.setBloggerId(2);
		comment.setBlogId(2);
		System.out.println(commentDao.addComment(comment));
	}

	@Test
	public void testDelete() {
		System.out.println(commentDao.deleteComment(3));
	}
}
