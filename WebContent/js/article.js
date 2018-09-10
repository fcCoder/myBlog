
/* 
* 获取ajax处理对象		
 * @returns {xmlhttp}
 */
function getXHR(){	
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;	
}
/**
 * 点赞这个ariticle
 * @param article_id
 */
function love_article(){	
	var love=parseInt($("#love").text().trim())+1;
	var blogId=parseInt($("#articleId").val());
	console.log(love);
	console.log(blogId);
	data= {"zanCount" : love,"blogId" : blogId};
	//data=JSON.stringify(data);
	console.log(data);
	$.ajax({ 
	  	type: "get", 
	  	url : "dianzan",
	  	dataType:"text",
	  	contentType: "application/json ;charset=utf-8",
	  	data:data, 
	  	success: function(data){
	  		document.getElementById("love").innerHTML="&nbsp;"+love+"&nbsp;";
	  		document.getElementById("click").innerHTML="已点赞";
	  		$("#click").removeAttr("onclick");
	  	}
	  	
	  	});	
}


/*
 *删除评论
 */
function deletecm(component,comm_id){
	var container = component.parentNode.parentNode;
	var url = "/Blog/CMDeleServlet?id="+comm_id ;		
	// 获取ajax
	var xmlhttp = getXHR();	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// 处理服务器收到的请求响应
			var res = xmlhttp.responseText;			
			// 解析json对象
			var res = eval('(' + res + ')');			
			//alert( res.msg );
			if(res.msg == "success"){
				//删除评论的视图
				var p = container.parentNode;
				p.removeChild(container);
			}			
		}	
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();	
}

/**
 * 点击了star
 */
function star(component , comm_id) {
	
	var url = "/Blog/CMStarServlet?id="+comm_id ;		
	// 获取ajax
	var xmlhttp = getXHR();	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// 处理服务器收到的请求响应
			var res = xmlhttp.responseText;			
			// 解析json对象
			var res = eval('(' + res + ')');			
			if (res.msg == "success") {
				//返回 ”success“
				component.innerHTML = res.new_star;				
			}else{
				alert("不要狂点呀...");
			}
		}
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();	
}

/**
 * 点击了diss
 */
function diss(component , comm_id) {
	
	var url = "/Blog/CMDissServlet?id="+comm_id;		
	// 获取ajax
	var xmlhttp = getXHR();	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// 处理服务器收到的请求响应
			var res = xmlhttp.responseText;			
			// 解析json对象
			var res = eval('(' + res + ')');			
			if (res.msg == "success") {
				//返回 ”success“
				component.innerHTML = res.new_diss;				
			}else{
				alert("不要狂点呀...");
			}
		}
	}
	xmlhttp.open("POST", url, true);
	xmlhttp.send();	
}
