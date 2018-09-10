<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客 | MyBlog</title>
<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="page/signin.html" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<!-- 引入本页面的特殊样式 -->
<link type="text/css" rel="stylesheet" href="css/article.css">
<link type="text/css" rel="stylesheet" href="css/comment.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<script src="js/article.js"></script>

</head>
<body style="background:#eee;">
	<div class="head_line"></div>
	<div class="container" id="main">

		<div class="head">
			<div id="title">
				<h2>
					<a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}&currPage=1">MyBlog首页</a>
				</h2>
			</div>
		</div>

		<div id="article">

			<div id="a_head ">
				<h3>${blog.title}</h3>
				<br>
				<div>
					<h5>
						<span>${blog.releaseDate}</span> <a href="${pageContext.request.contextPath}/blogsByType?typeName=${type.typeName}">${type.typeName}</a>
					${blogger2.nickName}
					</h5>
				</div>
				<div class="r_div">
					<h5>
						<span class="glyphicon glyphicon-eye-open">&nbsp;${blog.readCount}&nbsp;</span>						
						 <span class="glyphicon glyphicon-heart" id="love">&nbsp;${blog.zanCount}&nbsp;</span>
						 <input type="hidden" id="articleId" value="${blog.id}">
						<span class="glyphicon glyphicon-comment">&nbsp;${blog.clickHit}&nbsp;</span>
					</h5>
				</div>
				<div id="tag">
					<c:choose>
						<c:when test="${empty tags}">
							<a href="#">无标签&nbsp;</a>
						</c:when>
						<c:otherwise>
							<c:forEach items="${tags}" var="tag">
								<a href="${pageContext.request.contextPath}/blogsByTag?tagName=${tag.tagName}">${tag.tagName}&nbsp;</a>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
			<div class="line"></div>



			<div id="a_content">
			<!-- 引入 show.jsp 显示文章内容 测试测试-->
			



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Md2Html</title>
<!-- 这个文件用来转换 Markdown 到Html 显示 -->
<!-- 参数: 测试测试 -->


<!-- preview的css -->
<link rel="stylesheet" href="editormd/css/style.css">
 <link rel="stylesheet" href="editormd/css/editormd.css">

<!-- 引入editormd相关 -->
<script src="editormd/js/zepto.js"></script>
<script src="editormd/js/editormd.js"></script>

 <div id="mdView" style="background:#eee;" class="markdown-body editormd-html-preview">  	
     
 <p>${blog.content}</p>
</div>  
<br>
<script type="text/javascript">
	$(function mdToHtml() {		
		//获取要显示的内容
		//var content = $("#article_content").text();			
		editormd.markdownToHTML("mdView", {
			htmlDecode : "style,script,iframe", 
			emoji : true,
			taskList : true,
			tex : true, // 默认不解析
			flowChart : true, // 默认不解析
			sequenceDiagram : true, // 默认不解析			
		});
	});	
</script>


			
			</div>


			<div>
				<!-- <div class="f_div">
					<span class="glyphicon glyphicon-chevron-left"></span>
					
					
					
						
							<a href="http://localhost:5224/Blog/ArticleServlet?id=11">&nbsp;上一篇:测试文件</a>
											
											
					
					
				</div>				
				<div class="r_div">
				
						
											
						
							&nbsp;没有更多的文章了
											
					
						
					<span class="glyphicon glyphicon-chevron-right"></span>
				</div> -->
				
				<div>			
				<span class="btn btn-default" style="color:#d9534f;" onclick="love_article()" id="click">点赞</span>
				</div>						
				<br>
			</div>
			
			<div class="line"></div>
			
			<!-- 评论 -->					
			<div class="comment"> 
			
			<div class="r_div">
			<a href="#comment"><span class="glyphicon glyphicon-pencil">&nbsp;写评论....</span></a>
			</div>
					
			<!-- 加载文章评论 -->	
			
			<c:forEach items="${comments}" var="comment">
			
			<div class="row">
			<div class="f_div">		
			<img src="${pageContext.request.contextPath}/img/${comment.image}" class="img-circle" width="15" height="15">
			&nbsp;&nbsp;			
			<span style="color: #428bca"> 热心网友&nbsp;${comment.nickname}&nbsp;</span>					
			<span>&nbsp;&nbsp;${comment.time}</span>
			</div>			
			<div id="c_content" class="c_left">						
			<p>${comment.content}</p>			
			</div>				
			<div class="line"></div>
			</div>	
			
			</c:forEach>	
			
			
			
			
			</div>
			<!-- 这里可以扩展子评论 -->		
			
				
			<!-- 写评论 -->
			<div id="comment">
			
			<form action="${pageContext.request.contextPath}/addComment?blogId=${blog.id}&bloggerId=${blogger.id}" method="post">
			<input style="width:30%" class="form-control" name="w_nickname" value="热心网友" type="text">
			<br>							
			<textarea style="resize:none; width:100%; height:180px;" name="content"></textarea>
			<br>
			<br>			
			<input class="btn btn-default" value="评论" onclick="onclick" type="submit">	
			<br>						
			</form>			
			</div>
			<!--  -->    			
			<div class="line"></div>
			 	
	</div>
	<div id="footer">	
	<a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}&currPage=1">MyBlog首页&nbsp;&nbsp;</a>|
	<a href="#">&nbsp;&nbsp;返回顶部</a>
	</div>
	<!-- footer -->

</body></html>