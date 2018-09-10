package ssm.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netscape.javascript.JSObject;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Blogger;
import ssm.blog.entity.Page;
import ssm.blog.service.IBlogService;
import ssm.blog.service.IBloggerService;
import ssm.blog.service.IPageService;

@Controller  //注册为控制器bean
//@RequestMapping(value = "/blogger")    //请求路径
public class BloggerController {
	
	@Autowired
	private IBloggerService bloggerService;
	@Autowired
	private IBlogService blogService;
	@Autowired
	private IPageService pageService;
	@Autowired
	private Blogger blogger;
	
	@RequestMapping("/register")
	public String register(String username,String nickname,String password,String sex,Integer age,String sign,HttpServletResponse response){
		String imagename="default.jpg";
		blogger=new Blogger();
		blogger.setUserName(username);
		blogger.setNickName(nickname);
		blogger.setPassword(password);
		blogger.setSex(sex);
		blogger.setAge(age);
		blogger.setSign(sign);
		blogger.setImageName(imagename);
		bloggerService.register(blogger);
		response.setHeader("refresh", "2;login.jsp");
		return "doRegister";
	}
   /**
    * 登录操作，成功后在主页分页显示所有博客
    * @param username
    * @param password
    * @param request
    * @return
    */
    @RequestMapping(value="/login")
    public String login(String username,String password,HttpServletRequest request){
    	blogger=bloggerService.login(username, password);
    	if(blogger!=null){
    		System.out.println("成功");
    		HttpSession session=request.getSession();
    		session.setAttribute("blogger", blogger);
    		//session.setMaxInactiveInterval(3*24*60);
    		return "redirect:/home?bloggerId="+blogger.getId()+"&currPage=1";
    	}
    	System.out.println("失败");
    	request.setAttribute("msg", "<font color='red'>用户名或密码错误</font>");
    	return "login";
    }
    @RequestMapping("/home")
    public String getIndex(Integer bloggerId,Integer currPage,HttpServletRequest request){
    	Page page=pageService.getBlogByPage(currPage);
		System.out.println(page);
		request.setAttribute("page", page);
		List<Blog> blogs=blogService.getBlogByReadCount();
		request.setAttribute("blogs", blogs);
		int blogsCount=bloggerService.getBlogsCountByBloggerId(bloggerId);
		request.setAttribute("blogCount", blogsCount);
		int typeCount=bloggerService.getTypeCountByBloggerId(bloggerId);
		request.setAttribute("typeCount", typeCount);
		int tagCount=bloggerService.getTagCountByBloggerId(bloggerId);
		request.setAttribute("tagCount", tagCount);
    	return "index";
    }
    @RequestMapping("/getMyBlog")
    public String getMyBlog(Integer bloggerId,HttpServletRequest request){
    	List<Blog> myBlogs=blogService.getBlogsByBloggerId(bloggerId);
    	request.setAttribute("myBlogs", myBlogs);
		List<Blog> blogs=blogService.getBlogByReadCount();
		request.setAttribute("blogs", blogs);
		int blogsCount=bloggerService.getBlogsCountByBloggerId(bloggerId);
		request.setAttribute("blogsCount", blogsCount);
		int typeCount=bloggerService.getTypeCountByBloggerId(bloggerId);
		request.setAttribute("typeCount", typeCount);
		int tagCount=bloggerService.getTagCountByBloggerId(bloggerId);
		request.setAttribute("tagCount", tagCount);
    	return "myBlogs";
    }
    @RequestMapping("/readOrder")
    @ResponseBody
    public List<Blog> readOrder(HttpServletRequest request){
    	System.out.println("*********进入readOrder************");
    	List<Blog> blogList=blogService.getBlogByReadCount();
    	return blogList;
    }


}

