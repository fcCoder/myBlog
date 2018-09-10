
$(document).ready(function(){
	$.ajax({
		url:"readOrder",
		type:"get",
		dataType:"json",
		success: function(data){
			var str="<span class='list-group-item active'>阅读排行</span>";
			$.each(data,function(key,blog){
				str+="<a href='/myBlog/blog?id="+blog.id+ "' class='list-group-item'>"+blog.title+"&nbsp;&nbsp; <span class='c_right'>("+blog.readCount+")</span></a>";
			});
			$("#readOrder").html(str);
		},
	});
	var bloggerId=$("#bloggerId").val();
	console.log(bloggerId);
	/*$.ajax({
		url:"myBlogsCount?bloggerId="+bloggerId,
		type:"get",
		dataType:"json",
		success:function(data){
			var str="";
			console.log(data);
			str+=data+"<br>日志";
			$("#myBlogs").html(str);
		},
	});*/
});