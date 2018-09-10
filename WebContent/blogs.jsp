<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类下的博客 | MyBlog</title>
<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="page/signin.html" rel="stylesheet">


<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/sort.css">
</head>
<body>
<div class="head_line"></div>

	<div class="container" id="main">

		<div id="header"></div>

		<div class="row c_center">
			<div class="col-md-3" id="left_content">

				<div id="title">
					<h2>
						<a href="#">MyBlog</a>
					</h2>
					<h5 class="text-muted">${blogger.userName}</h5>
				</div>

				<div class="c_center" id="person_info">
					<img src="${pageContext.request.contextPath}/img/${blogger.imageName}" alt="what?" class="img-circle" width="130" height="130">
					<h5 class="text-muted">${blogger.nickName}</h5>
				</div>


				<div id="list">
					<table class="table table-hover c_center">
						<tbody><tr>
							<td><a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}&currPage=1"><span class="glyphicon glyphicon-home"></span>
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
			</div>
			<div class="col-md-2" id="center_content"></div>
			<div class="col-md-7 " id="right_Content">
				<br> <br>
				<div class="list-group">
					<a href="#" class="list-group-item active">博客</a>
					<!-- 这里初始化列表 -->					
					
						<div class="sort_name">
						<!-- 分类名字 -->
						<span class="glyphicon glyphicon-triangle-bottom"></span>	&nbsp;	&nbsp;${name}					
						</div>
						<div>
						<!-- 分类信息 -->
						<ul class="list-group">
						<c:forEach items="${blogs}" var="blog">	
							<li class="list-group-item">
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
							</li>
						</c:forEach>					
						</ul>
					</div>								
										
					<!-- 初始化列表完成 -->

				</div>
			</div>
		</div>

		<div class="foot_line"></div>
	</div>
</body>
</html>