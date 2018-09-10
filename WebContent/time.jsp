<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时间轴 | MyBlog</title>

<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="page/signin.html" rel="stylesheet">

<!-- 引入页面公共样式 -->
<link type="text/css" rel="stylesheet" href="css/public.css">
<!-- 引入本页面的特殊样式 -->
<link type="text/css" rel="stylesheet" href="css/axis.css">

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
							<td class="active"><a href="#"><span class="glyphicon glyphicon-book"></span>
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
			
			<div class="col-md-7 " id="axis_div">
				<!-- 这里初始化时间轴 -->		
				
					<c:forEach items="${times}" var="entry">
						
						<div class="longline_div">
							<div> ${entry.key}</div>
						</div>
						<c:forEach items="${entry.value}" var="time">
							<div class="line_div">
								<div>
									<a href="${pageContext.request.contextPath}/blog?id=${time.id}" target="_blank">&nbsp;&nbsp;${time.day}
									&nbsp;&nbsp;&nbsp;&nbsp;${time.title}
									</a>
								</div>
							</div>
						</c:forEach>
					</c:forEach>	
					
				<!-- 初始化结束 -->
			</div>
			
		</div>
		
		<div class="foot_line"></div>
	</div>	
	<!-- container -->
	<div id="footer">
		<!-- <a href="#">&nbsp;&nbsp;MyBlog</a> -->
	</div>
	<!-- footer -->

</body></html>