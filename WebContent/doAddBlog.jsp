<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发表博客验证 | MyBlog</title>
</head>
<body>
<h2 style="text-align: center;color: red">${msg}</h2><br>
<div style="text-align: center;">
<a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}&currPage=1">返回首页</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/addBlog.jsp">继续发表</a>
</div>
</body>
</html>