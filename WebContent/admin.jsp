<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>管理员登录 | MyBlog</title>
 	<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">  
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/login" method="post">

			<h1>
				<a href="#">MyBlog</a>
			</h1>
			<span>${msg}</span>
			<label for="input" class="sr-only">用户名</label> 
			
			<input id="input" class="form-control" placeholder="用户名" name="username" required="" type="text">
			
			<label for="inputPassword" class="sr-only">密码</label>
			
			<input id="inputPassword" class="form-control" placeholder="密码" name="password" required="" type="password">

			<button class="btn btn-lg btn-primary btn-block" type="submit" id="submit">登录</button>

			<a class="visitor" href="http://localhost:8080/myBlog/login.jsp">用户登录</a>
			<a class="visitor" href="http://localhost:8080/myBlog/register/register.jsp">用户注册</a>
		</form>
	</div>


	<div id="footer">
		<a target="_blank" href="https://github.com/fcCoder/myBlog">
		<img src="${pageContext.request.contextPath}/img/github.png" class="img-circle" width="22px" height="22px">GitHub</a>
		by lemonreds.		
	</div>
	<!-- footer -->

</body></html>