package ssm.blog.service;

import ssm.blog.entity.Page;

/**
 * ·ÖÒ³¹¦ÄÜ
 * @author Administrator
 *
 */
public interface IPageService {
	
	Page getBlogByPage(Integer currPage);
	
	Page getMyBlogByPage(Integer currPage,Integer bloggerId);
	
	Page getAllCommentByPage(Integer currPage);
}
