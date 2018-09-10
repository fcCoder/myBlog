<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理 | MyBlog</title>


<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="page/signin.html" rel="stylesheet">

<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/admin.css">

<script src="js/admin.js"></script>
<script type="text/javascript">
	/* $.function(){
		$("#dialog").dialog();
	} */
</script>

</head>
<body>
	<div class="head_line"></div>
	<div class="container" id="main">
				
		<div id="header">
			<div>
				<h3><a href="#">MyBlog-管理</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}&currPage=1">前台</a></h3>
				<h5 class="text-muted">有点粗糙 但能用就行</h5>
				</div>		
		</div>
				 
				 <div class="admin_div">
				<h4 class="btn btn-default">管理评论</h4>
				<span>${commentMsg}</span>
				<c:forEach items="${commentPage.commentList}" var="comment">	
				<div class="list-group-item">						
						<span>${comment.content}</span>
						 <div class="r_div">	
						 <span>${comment.time} </span>
						
						 <a href="${pageContext.request.contextPath}/deleteComment?commentId=${comment.id}">
						 <button class="btn btn-default">&nbsp;
						 <span class="glyphicon glyphicon-trash" style="color:#d9534f" onclick="delete_article(this,'12')"> 删除</span>&nbsp;</button>
						 </a>
						 </div>										 
				</div> 
				</c:forEach>
				<br>			
				<table>
					<tr>
						<td>
							共有${commentPage.currPage}/${commentPage.totalPage}页
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/commentPage?totalPage=${commentPage.totalPage}" method="post">
								<Input type=hidden name="currPage" value="1"/>
			          			<Input type=submit name="g" value="首页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/commentPage?totalPage=${commentPage.totalPage}" method="post">
								<Input type=hidden name="currPage" value="${commentPage.currPage-1}"/>
			          			<Input type=submit name="g" value="上一页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/commentPage?totalPage=${commentPage.totalPage}" method="post">
								<Input type=hidden name="currPage" value="${commentPage.currPage+1}"/>
			          		 	<Input type=submit name="g" value="下一页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/commentPage?totalPage=${commentPage.totalPage}" method="post">
								<Input type=hidden name="currPage" value="${commentPage.totalPage}"/>
			          			<Input type=submit name="g" value="尾页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/commentPage?totalPage=${commentPage.totalPage}" method="post">
			          			<p>输入页码:<input type="text" name="currPage"/> <Input type=submit name="g" value="提交"/></p>
							</form>
						</td>	
					</tr>
				</table>   
				
				</div>
				<div class="admin_div">
				<h4 class="btn btn-default">管理博客</h4>
				<span>${msg}</span>
				<c:forEach items="${page.list}" var="blog">			
					<div class="list-group-item">
											
						<span>${blog.title}</span>
						 <div class="r_div">	
						 <span>${blog.releaseDate} </span>
						 
						 <a href="${pageContext.request.contextPath}/blog?id=${blog.id}" target="_blank">
						 <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil" style="color:#5bc0de">查看</span>&nbsp;</button>
						 </a>
						 
						 <a href="${pageContext.request.contextPath}/deleteBlog?blogId=${blog.id}">
						 <button class="btn btn-default">&nbsp;
						 <span class="glyphicon glyphicon-trash" style="color:#d9534f" onclick="delete_article()"> 删除</span>&nbsp;</button>
						 </a>
						 </div>
															 
					</div>							
				</c:forEach>
				<br>			
				<table>
					<tr>
						<td>
							共有${page.currPage}/${page.totalPage}页
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/blogPage?totalPage=${page.totalPage}" method="post">
								<Input type=hidden name="currPage" value="1"/>
			          			<Input type=submit name="g" value="首页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/blogPage?totalPage=${page.totalPage}" method="post">
								<Input type=hidden name="currPage" value="${page.currPage-1}"/>
			          			<Input type=submit name="g" value="上一页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/blogPage?totalPage=${page.totalPage}" method="post">
								<Input type=hidden name="currPage" value="${page.currPage+1}"/>
			          		 	<Input type=submit name="g" value="下一页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/blogPage?totalPage=${page.totalPage}" method="post">
								<Input type=hidden name="currPage" value="${page.totalPage}"/>
			          			<Input type=submit name="g" value="尾页"/>
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/blogPage?totalPage=${page.totalPage}" method="post">
			          			<p>输入页码:<input type="text" name="currPage"/> <Input type=submit name="g" value="提交"/></p>
							</form>
						</td>	
					</tr>
				</table>							
									
				</div>
				
				<div class="admin_div">
				<h4 class="btn btn-default">管理分类</h4><h5 style="color:#d9534f">删除分类会删除所有的文章</h5>
				<c:forEach items="${types}" var="type">		
				<div class="list-group-item">						
						<input class="sort" value="${type.typeName}" disabled="disabled" style="border:0px;" type="text">
						 <div class="r_div">							
						 <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil" style="color:#5bc0de" onclick="edit_sort(this,'${type.typeName}')" id="dialog">编辑</span>&nbsp;</button>
						 <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-trash" style="color:#d9534f" onclick="delet_sort(this,'${type.typeName}')">删除</span>&nbsp;</button>
						 </div>										 
				</div>							
				</c:forEach>					
				
				</div>
				
				<div class="admin_div">
				<h4 class="btn btn-default">管理标签</h4>
				<c:forEach items="${tags}" var="tag">		
				<div class="list-group-item">						
						<input class="tags" value="${tag.tagName}" disabled="disabled" style="border:0px" type="text">
						 <div class="r_div">	
						 <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-pencil" style="color:#5bc0de" onclick="edit_tag(this,'${tag.tagName}')">编辑</span>&nbsp;</button>
						 <button class="btn btn-default">&nbsp;<span class="glyphicon glyphicon-trash" style="color:#d9534f" onclick="delet_tag(this,'${tag.tagName}')">删除</span>&nbsp;</button>
						 </div>										 
				</div>							
				</c:forEach>												
				
				</div>
			
				

		<div class="foot_line"></div>		
		</div><!-- container -->			
	

</body></html>