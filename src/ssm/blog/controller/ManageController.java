package ssm.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.blog.entity.Page;
import ssm.blog.entity.Tag;
import ssm.blog.entity.Type;
import ssm.blog.service.*;

@Controller
public class ManageController {
	@Autowired
	private IPageService pageService;
	@Autowired
	private IBloggerService bloggerService;
	@Autowired
	private IBlogService blogService;
	
	@RequestMapping("/manageAll")
	public String manage(HttpServletRequest request){
		Page page=pageService.getBlogByPage(1);
		request.setAttribute("page", page);
		Page commentPage=pageService.getAllCommentByPage(1);
		request.setAttribute("commentPage", commentPage);
		List<Type> types=blogService.getAllTypes();
		request.setAttribute("types", types);
		List<Tag> tags=blogService.getAllTags();
		request.setAttribute("tags", tags);
		return "manage";
	}
	/**
	 * 管理员删除博客
	 * @param blogId
	 * @return
	 */
	@RequestMapping("/deleteBlog")
	public String deleteBlog(Integer blogId){
		bloggerService.deleteBlogById(blogId);
		return "redirect:/manageAll";
	}
	/**
	 * 管理员分页浏览博客
	 * @param currPage
	 * @param totalPage
	 * @param request
	 * @return
	 */
	@RequestMapping("/blogPage")
	public String getBlogByPage(Integer currPage,Integer totalPage,HttpServletRequest request){
		//ModelAndView mav=new ModelAndView();
		System.out.println(currPage);
		if(currPage<=0){
			currPage=1;
			request.setAttribute("msg", "<font color='red'>已经是第一页啦！</font>");
		}
		if(currPage>totalPage){
			currPage=totalPage;
			request.setAttribute("msg", "<font color='red'>当前页已经是最后一页啦！</font>");
		}
		
		Page page=pageService.getBlogByPage(currPage);
		request.setAttribute("page", page);
		Page commentPage=pageService.getAllCommentByPage(1);
		request.setAttribute("commentPage", commentPage);
		
		//mav.addObject("page", page);
		//model.addAttribute("page", page);
		return "manage";
	}
	/**
	 * 管理员删除评论
	 * @param blogId
	 * @return
	 */
	@RequestMapping("/deleteComment")
	public String deleteComment(Integer commentId){
		bloggerService.deleteCommentById(commentId);
		return "redirect:/manageAll";
	}
	/**
	 * 管理员分页浏览评论
	 * @param currPage
	 * @param totalPage
	 * @param request
	 * @return
	 */
	@RequestMapping("/commentPage")
	public String getAllCommentByPage(Integer currPage,Integer totalPage,HttpServletRequest request){
		//ModelAndView mav=new ModelAndView();
		System.out.println(currPage);
		if(currPage<=0){
			currPage=1;
			request.setAttribute("commentMsg", "<font color='red'>已经是第一页啦！</font>");
		}
		if(currPage>totalPage){
			currPage=totalPage;
			request.setAttribute("commentMsg", "<font color='red'>当前页已经是最后一页啦！</font>");
		}
		
		Page commentPage=pageService.getAllCommentByPage(currPage);
		request.setAttribute("commentPage", commentPage);
		Page page=pageService.getBlogByPage(1);
		request.setAttribute("page", page);
		
		//mav.addObject("page", page);
		//model.addAttribute("page", page);
		return "manage";
	}
	
	@RequestMapping("/updateType")
	public void updateType(String typeName){
		
		bloggerService.updateType(typeName);
	}
}
