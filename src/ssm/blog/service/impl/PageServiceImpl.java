package ssm.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.dao.BlogDao;
import ssm.blog.dao.CommentDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Comment;
import ssm.blog.entity.Page;
import ssm.blog.service.IPageService;

@Service
public class PageServiceImpl implements IPageService {
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CommentDao commentDao;
	/**
	 * ��ҳ��ʾ���в���
	 */
	@Override
	public Page getBlogByPage(Integer currPage) {
		//��ǰҳ  currPage
		//ָ��ÿҳ��ʾ��������������
		int pageSize = 10;
		//���ݿ��ѯ�ܼ�¼��  
		int count = blogDao.selectBlogCount();
		//��ҳ��
		double totalCount = count;
		//��ҳ��
		int totalPage = (int) Math.ceil(totalCount / pageSize);
				
		int startRow = (currPage - 1) * pageSize;
		List<Blog> list = blogDao.selectBlogByPage(startRow, pageSize);
				
		Page pg = new Page();
		pg.setCurrPage(currPage);
		pg.setPageSize(pageSize);
		pg.setCount(count);
		pg.setTotalPage(totalPage);
		pg.setList(list);
		return pg;
	}
	@Override
	public Page getMyBlogByPage(Integer currPage,Integer bloggerId) {
		//��ǰҳ  currPage
		//ָ��ÿҳ��ʾ��������������
		int pageSize = 10;	
		int startRow = (currPage - 1) * pageSize;
		List<Blog> list = blogDao.selectMyBlogByPage(startRow, pageSize,bloggerId);
		//���ݿ��ѯ�ܼ�¼��  
		int count = list.size();
		//��ҳ��
		double totalCount = count;
		//��ҳ��
		int totalPage = (int) Math.ceil(totalCount / pageSize);
						
		Page pg = new Page();
		pg.setCurrPage(currPage);
		pg.setPageSize(pageSize);
		pg.setCount(count);
		pg.setTotalPage(totalPage);
		pg.setList(list);
		return pg;
	}
	@Override
	public Page getAllCommentByPage(Integer currPage) {
		//��ǰҳ  currPage
		//ָ��ÿҳ��ʾ��������������
		int pageSize = 10;	
		//���ݿ��ѯ�ܼ�¼��  
		int count = commentDao.getAllCommentCount();
		//��ҳ��
		double totalCount = count;
		//��ҳ��
		int totalPage = (int) Math.ceil(totalCount / pageSize);
		int startRow = (currPage - 1) * pageSize;
		List<Comment> list = commentDao.getAllComment(startRow, pageSize);
		//System.out.println(list);
		
		Page pg = new Page();
		pg.setCurrPage(currPage);
		pg.setPageSize(pageSize);
		pg.setCount(count);
		pg.setTotalPage(totalPage);
		pg.setCommentList(list);
		System.out.println(pg);
		return pg;
	}
}
