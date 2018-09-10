<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页 | MyBlog</title>
<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="page/signin.html" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript">

</script>
</head>
<body>
	<div class="head_line"></div>

	<div class="container" id="main">
	
		<div id="header"></div>

		<div class="row c_center">
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2><a href="#">MyBlog</a></h2>
					<h5 class="text-muted">欢迎<span style="color: red;">${blogger.userName}</span>光临本站&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/login.jsp">切换用户</a></h5>
				</div>

				<div class="c_center" id="person_info">
					<img src="${pageContext.request.contextPath}/img/${blogger.imageName}" alt="丢失了我的头像?" class="img-circle" width="130" height="130">
					<h4 class="text-muted">${blogger.nickName}</h4>
					<h5 class="text-muted">${blogger.sign}</h5>
				</div>

				<div class="c_center">
					<!-- 这里初始化侧边栏的4个标签 -->
					<div class="inline ">
						<a href="${pageContext.request.contextPath}/getMyBlog?bloggerId=${blogger.id}" id="myBlogs">${blogCount}<br>博客</a>
						<input type="hidden" value="${blogger.id}" id="bloggerId"/>
					</div>
					<div class="inline ">
						<a href="${pageContext.request.contextPath}/myType?bloggerId=${blogger.id}"><span>${typeCount}</span><br>分类</a>
					</div>
					<div class="inline ">
						<a href="${pageContext.request.contextPath}/myTag?bloggerId=${blogger.id}"><span>${tagCount}</span><br>标签</a>
					</div>
					
				</div>
			

				<div id="list">
					<table class="table table-hover c_center">
						<tbody><tr class="active">
							<td><a href="#"><span class="glyphicon glyphicon-home"></span>
								&nbsp;&nbsp;首页</a></td>
						</tr>
						<tr>	
							<td><a href="${pageContext.request.contextPath}/type"><span class="glyphicon glyphicon-list"></span>
								&nbsp;&nbsp;所有分类</a></td>
						</tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/tag"><span class="glyphicon glyphicon-tags"></span>
								&nbsp;&nbsp;所有标签</a></td>
						</tr>						
						<tr>
							<td><a href="${pageContext.request.contextPath}/time?bloggerId=${blogger.id}"><span class="glyphicon glyphicon-book"></span>
								&nbsp;&nbsp;时间轴</a></td>
						</tr>
						<tr>
							<td><a href="#"><span class="glyphicon glyphicon-user"></span>
								&nbsp;&nbsp;关于</a></td>
						</tr>
					</tbody></table>
				</div>
				<!-- list -->
					<br>
					
				
				
				<div class="visit">
					<div class="list-group" id="readOrder">
						<!-- <span class="list-group-item active">阅读排行</span>	 -->					
						<!-- 这里初始化阅读排行 -->
						<%-- <c:forEach items="${blogs}" var="blog">
							<a href="${pageContext.request.contextPath}/blog?id=${blog.id}" class="list-group-item">${blog.title}&nbsp;&nbsp; <span class="c_right">(${blog.readCount})</span></a>						
						</c:forEach> --%>									
						<!-- 初始化结束 -->						
					</div>
				</div><!-- visit-->
	

				
				
			<!-- admin here -->
			
			<a href="${pageContext.request.contextPath}/addBlog.jsp">
			<span class="glyphicon glyphicon-plus">&nbsp;&nbsp;写新文章&nbsp;&nbsp;</span>
			</a>
			<a href="${pageContext.request.contextPath}/manageAll">
			<span class="glyphicon glyphicon glyphicon-user">&nbsp;&nbsp;管理更多&nbsp;&nbsp;</span>
			</a>
			
			<!--  -->
			
			</div>
			<div class="col-md-2" id="center_content">		
			</div>
					
			
			<div class="col-md-7 " id="right_Content">
				<br>
				<br>
				<div class="list-group">							
					<a href="#" class="list-group-item active">博客</a>
					<%-- <a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}" class="list-group-item active">刷新</a> --%>
					<span style="text-align: center;">${msg}</span>
					<!-- 这里初始化博客列表 -->
					<c:forEach items="${page.list}" var="blog">
					<div class="list-group-item">									
					<h4 style="float: left;"><a href="${pageContext.request.contextPath}/blog?id=${blog.id}" target="_blank">${blog.title}</a></h4>
					<h5 style="float: right">
						<span>${blog.releaseDate} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span class="glyphicon glyphicon-eye-open">&nbsp;${blog.readCount}&nbsp;</span>						
						<span class="glyphicon glyphicon-heart" id="love">&nbsp;${blog.zanCount}&nbsp;</span> 
						<span class="glyphicon glyphicon-comment">&nbsp;${blog.clickHit}&nbsp; </span>
					</h5>					
					<br><br>
					<a href="${pageContext.request.contextPath}/blog?id=${blog.id}" target="_blank">阅读全文</a>
					<br>			
					</div>
					</c:forEach>
					<!-- 初始化博客列表完成 -->			
				</div>
				<table>
					<tr>
						<td>
							共有${page.currPage}/${page.totalPage}页
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/page?totalPage=${page.totalPage}&bloggerId=${blogger.id}" method="post">
								<Input type=hidden name="currPage" value="1"/>
			          			<Input type=submit name="g" value="首页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/page?totalPage=${page.totalPage}&bloggerId=${blogger.id}" method="post">
								<Input type=hidden name="currPage" value="${page.currPage-1}"/>
			          			<Input type=submit name="g" value="上一页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/page?totalPage=${page.totalPage}&bloggerId=${blogger.id}" method="post">
								<Input type=hidden name="currPage" value="${page.currPage+1}"/>
			          		 	<Input type=submit name="g" value="下一页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/page?totalPage=${page.totalPage}&bloggerId=${blogger.id}" method="post">
								<Input type=hidden name="currPage" value="${page.totalPage}"/>
			          			<Input type=submit name="g" value="尾页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/page?totalPage=${page.totalPage}&bloggerId=${blogger.id}" method="post">
			          			<p>输入页码:<input type="text" name="currPage"/> <Input type=submit name="g" value="提交"/></p>
							</form>
						</td>	
					</tr>
				</table>
			</div>
		</div>				
		<div class="foot_line"></div>
			</div><!-- container -->
	<div id="footer">
		<div">
			<a href="https://github.com/fcCoder/myBlog"><img src="${pageContext.request.contextPath}/img/github.png" class="img-circle" width="20px" height="20px">&nbsp;&nbsp;GitHub</a>
			&nbsp;|
			<a href="#">&nbsp;&nbsp;MyBlog</a>
			<br>
			copyright © 2017
		</div>		
		
		<div class="r_div">
		<a href="#"><input class="btn btn-default" value="返回顶部" style="width:50%;"></a>
		</div>
		
	</div><!-- footer -->

</body></html>