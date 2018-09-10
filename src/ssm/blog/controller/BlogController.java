package ssm.blog.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.dao.TypeDao;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Blogger;
import ssm.blog.entity.Comment;
import ssm.blog.entity.Page;
import ssm.blog.entity.Tag;
import ssm.blog.entity.Time;
import ssm.blog.entity.Type;
import ssm.blog.service.IBlogService;
import ssm.blog.service.IBloggerService;
import ssm.blog.service.IPageService;
import ssm.blog.service.impl.BloggerServiceImpl;

@Controller
public class BlogController {
	@Autowired
	private Blog blog;
	@Autowired
	private Type type;
	@Autowired
	private Tag tag;
	@Autowired
	private Blogger blogger;
	@Autowired
	private IBlogService service;
	@Autowired
	private IBloggerService service2;
	@Autowired
	private IPageService service3;
	/**
	 * ������
	 * @param title
	 * @param typeName
	 * @param tagNames
	 * @param content
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addBlog")
	public String addBlog(String title,String typeName,String tagNames,String content,HttpServletRequest request,HttpServletResponse response){
		blog=new Blog();
		if(title!=""&&title!=null){
			blog.setTitle(title);
			if(content!=""&&content!=null){
				blog.setContent(content);
				if(typeName!=""&&typeName!=null){
					type=service.getTypeByName(typeName);
					blog.setTypeId(type.getId());	
					blogger=(Blogger) request.getSession().getAttribute("blogger");
					blog.setBloggerId(blogger.getId());
					blog.setZanCount(0);
					blog.setClickHit(0);
					blog.setReadCount(0);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
					blog.setReleaseDate(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
					service.addBlog(blog, tagNames);
					request.setAttribute("msg", "����ɹ�");
					//response.setHeader("refresh", "2;index.jsp");
					return "doAddBlog";
				}else{
					request.setAttribute("msg", "<font color='red'>�����Ϊ��</font>");
					return "addBlog";
				}
			}else{
				request.setAttribute("msg", "<font color='red'>���ݲ���Ϊ��</font>");
				return "addBlog";
			}
		}else{
			request.setAttribute("msg", "<font color='red'>���ⲻ��Ϊ��</font>");
			return "addBlog";
		}
	}
	
	/**
	 * ��ҳ��������ȡȫ������
	 * @return
	 */
	@RequestMapping("/type")
	public String getTypes(HttpServletRequest request){
		List<Type> types=service.getAllTypes();
		request.setAttribute("types", types);
		return "type";
	}
	/**
	 * ��ҳ����鿴�ҵķ���
	 * @return
	 */
	@RequestMapping("/myType")
	public String getMyTypes(Integer bloggerId,HttpServletRequest request){
		List<Type> types=service2.getTypeByBloggerId(bloggerId);
		request.setAttribute("types", types);
		return "type";
	}
	/**
	 * �������鿴�÷����µĲ���
	 * @param typeName
	 * @param request
	 * @return
	 */
	@RequestMapping("/blogsByType")
	public String blogsByType(String typeName,HttpServletRequest request){
		List<Blog> blogs=service.getBlogByType(typeName);
		request.setAttribute("name", typeName);
		request.setAttribute("blogs", blogs);
		return "blogs";
	}
	/**
	 * �鿴���岩����Ϣ
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/blog")
	public String readBlog(Integer id,HttpServletRequest request){
		blog=service.getBlogById(id);
		service.addReadCount(blog.getReadCount()+1, id);
		Blog blog2=service.getBlogById(id);
		request.setAttribute("blog", blog2);
		Integer bloggerId=blog.getBloggerId();
		Integer typeId=blog.getTypeId();
		Blogger blogger2=service2.getBloggerById(bloggerId);
		request.setAttribute("blogger2", blogger2);
		type=service.getTypeById(typeId);
		request.setAttribute("type", type);
		List<Tag> tags=service.getTagByBlogId(id);
		request.setAttribute("tags", tags);
		List<Comment> comments=service.getCommentByBlog(id);
		request.setAttribute("comments", comments);
		return "blog";
	}
	/**
	 * ��ҳ�����ǩ�鿴���б�ǩ
	 * @param request
	 * @return
	 */
	@RequestMapping("/tag")	
	public String getTags(HttpServletRequest request){
		List<Tag> tags=service.getAllTags();
		request.setAttribute("tags", tags);
		return "tag";
	}
	/**
	 * ��ҳ����鿴�ҵı�ǩ
	 * @param request
	 * @return
	 */
	@RequestMapping("/myTag")	
	public String getTags(Integer bloggerId,HttpServletRequest request){
		List<Tag> tags=service2.getTagByBloggerId(bloggerId);
		request.setAttribute("tags", tags);
		return "tag";
	}
	/**
	 * �����ǩ�鿴�ñ�ǩ�µĲ���
	 * @param tagName
	 * @param request
	 * @return
	 */
	@RequestMapping("/blogsByTag")
	public String blogsByTag(String tagName,HttpServletRequest request){
		List<Blog> blogs=service.getBlogByTag(tagName);
		request.setAttribute("name", tagName);
		request.setAttribute("blogs", blogs);
		return "blogs";
	}
	/**
	 * ʱ����
	 * @param bloggerId
	 * @param request
	 * @return
	 */
	@RequestMapping("/time")
	public String blogsByTime(Integer bloggerId,HttpServletRequest request){
		Map<String,List> map=service.getBlogByBlogger(bloggerId);
		request.setAttribute("times", map);
		return "time";
	}
	/**
	 * ��ҳ��ҳ�������
	 * @param currPage
	 * @param totalPage
	 * @param request
	 * @return
	 */
	@RequestMapping("/page")
	public String getBlogByPage(Integer currPage,Integer totalPage,Integer bloggerId,HttpServletRequest request){
		//ModelAndView mav=new ModelAndView();
		System.out.println(currPage);
		if(currPage<=0){
			currPage=1;
			request.setAttribute("msg", "<font color='red'>�Ѿ��ǵ�һҳ����</font>");
			return "forward:/home?bloggerId="+bloggerId+"&currPage="+currPage;
		}
		if(currPage>totalPage){
			currPage=totalPage;
			request.setAttribute("msg", "<font color='red'>��ǰҳ�Ѿ������һҳ����</font>");
			return "forward:/home?bloggerId="+bloggerId+"&currPage="+currPage;
		}
		
		Page page=service3.getBlogByPage(currPage);
		request.setAttribute("page", page);
	
		
		//mav.addObject("page", page);
		//model.addAttribute("page", page);
		return "redirect:/home?bloggerId="+bloggerId+"&currPage="+currPage;
	}
	/**
	 * ��������
	 * @param blogId
	 * @param bloggerId
	 * @param content
	 * @param request
	 * @return
	 */
	@RequestMapping("/addComment")
	public String addComment(Integer blogId,Integer bloggerId,String content,HttpServletRequest request){
		service.addComment(blogId, bloggerId, content);
		blog=service.getBlogById(blogId);
		request.setAttribute("blog", blog);
		Integer bloggerid=blog.getBloggerId();
		Integer typeId=blog.getTypeId();
		blogger=service2.getBloggerById(bloggerid);
		request.setAttribute("blogger", blogger);
		type=service.getTypeById(typeId);
		request.setAttribute("type", type);
		List<Tag> tags=service.getTagByBlogId(blogId);
		request.setAttribute("tags", tags);
		List<Comment> comments=service.getCommentByBlog(blogId);
		request.setAttribute("comments", comments);
		return "blog";
	}
	/**
	 * ����
	 * @param zanCount
	 * @param blogId
	 * @return
	 */
	@RequestMapping("/dianzan")
	@ResponseBody
	public String dianzan(Integer zanCount,Integer blogId){
		System.out.println("*****************���뷽��******************");
		System.out.println(zanCount);
		service.dianzan(zanCount, blogId);
		return "success";
	}
}
