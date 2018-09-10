<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>发表博客 | MyBlog</title>

		<!-- Bootstrap core CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/add.css" />

<link rel="stylesheet" href="editormd/css/style.css" />
<link rel="stylesheet" href="editormd/css/editormd.css" />
 
<script src="editormd/js/zepto.min.js"></script>
<script src="editormd/js/editormd.js"></script>  

<script src="js/add.js"></script>
	</head>

	<body>
		<div class="head_line"></div>
		<div class="container" id="main">
			<div id="title">
				<h2><a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}&currPage=1">MyBlog首页</a></h2>
			</div>

			<form action="${pageContext.request.contextPath}/addBlog" method="post">

				<div class="info">
					<!-- error -->
					<span class="help">${msg}</span>
					<!-- title -->
					<span class="help">标题</span>
					<input class="form-control" name="title" type="text">
					<!-- time -->
					<!-- <span class="help">时间</span>
					<input class="form-control" name="time" value="" type="text">
					author
					<span class="help">作者</span>
					<input class="form-control" name="author" type="text"> -->
					<!-- sort -->
					<span class="help">分类</span><br>

					<input class="btn btn-default" value="Java" onclick="sort_click(this)" type="button"> &nbsp;

					<input class="btn btn-default" value="区块链" onclick="sort_click(this)" type="button"> &nbsp;

					<input class="form-control" id="sort" name="typeName" type="text">

					<!-- tag -->
					<span class="help">标签</span><br>

					<input class="btn btn-default" value="多线程" onclick="tags_click(this)" type="button">&nbsp;
					<input class="btn btn-default" value="区块链" onclick="tags_click(this)" type="button">&nbsp;
					<input class="btn btn-default" value="测试" onclick="tags_click(this)" type="button">&nbsp;
					<input class="btn btn-default" value="blog" onclick="tags_click(this)" type="button">&nbsp;
					<input class="btn btn-default" value="分页" onclick="tags_click(this)" type="button">&nbsp;
					<input class="form-control" id="tags" name="tagNames" type="text">
				</div>

				<div class="foot_line"></div>
				<!-- content -->
				<div class="editormd editormd-vertical" id="mdView" style="width: 90%; height: 720px;" data-old-width="1204" data-old-height="720">
					<textarea name="content" class="editormd-markdown-textarea" placeholder="Enjoy Markdown! coding now..." style="display: none;"></textarea>
					<div class="CodeMirror cm-s-default CodeMirror-wrap CodeMirror-empty CodeMirror-focused" style="font-size: 13px; margin-top: 79px; height: 642px; width: 602px;">
						<div style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 4px; left: 61px;">
							<textarea style="position: absolute; padding: 0px; width: 1px; height: 1em; outline: currentcolor none medium;" autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0" wrap="off">
								
							</textarea>
						</div>
						<div class="CodeMirror-vscrollbar" cm-not-content="true">
							<div style="min-width: 1px; height: 0px;"></div>
						</div>
						<div class="CodeMirror-hscrollbar" cm-not-content="true">
							<div style="height: 100%; min-height: 1px; width: 0px;"></div>
						</div>
						<div class="CodeMirror-scrollbar-filler" cm-not-content="true"></div>
						<div class="CodeMirror-gutter-filler" cm-not-content="true"></div>
						<div class="CodeMirror-scroll" tabindex="-1" draggable="true">
							<div class="CodeMirror-sizer" style="margin-left: 49px; margin-bottom: -17px; border-right-width: 13px; min-height: 30px; padding-right: 0px; padding-bottom: 0px;">
								<div style="position: relative; top: 0px;">
									<div class="CodeMirror-lines">
										<div style="position: relative; outline: currentcolor none medium;"><pre style="height: 0px; overflow: visible;" class="CodeMirror-placeholder">Enjoy Markdown! coding now...</pre>
											<div class="CodeMirror-measure"><span><span>​</span>x</span>
											</div>
											<div class="CodeMirror-measure"></div>
											<div style="position: relative; z-index: 1;"></div>
											<div class="CodeMirror-cursors" style="visibility: hidden;">
												<div class="CodeMirror-cursor" style="left: 12px; top: 0px; height: 22.4px;">&nbsp;</div>
											</div>
											<div class="CodeMirror-code">
												<div style="position: relative;" class="CodeMirror-activeline">
													<div class="CodeMirror-activeline-background CodeMirror-linebackground"></div>
													<div class="CodeMirror-gutter-wrapper" style="left: -49px; width: 48px;">
														<div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 20px;">1</div>
													</div><pre class=""><span><span cm-text="">​</span></span></pre></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div style="position: absolute; height: 13px; width: 1px; top: 30px;"></div>
							<div class="CodeMirror-gutters" style="height: 655px;">
								<div class="CodeMirror-gutter CodeMirror-linenumbers" style="width: 28px;"></div>
								<div class="CodeMirror-gutter CodeMirror-foldgutter"></div>
							</div>
						</div>
					</div>
					<a href="javascript:;" class="fa fa-close editormd-preview-close-btn"></a>
					<textarea class="editormd-html-textarea" name="mdView-html-code"></textarea>
					<div class="editormd-preview" style="display: block; width: 602px; top: 79px; height: 642px;">
						<div class="markdown-body editormd-preview-container" previewcontainer="true" style="padding: 20px;"></div>
					</div>
					<div class="editormd-container-mask" style="display: none;"></div>
					<div class="editormd-mask"></div>
					<div class="editormd-toolbar" style="display: block;">
						<div class="editormd-toolbar-container">
							<ul class="editormd-menu">
								<li>
									<a href="javascript:;" title="撤销（Ctrl+Z）" unselectable="on"><i class="fa fa-undo" name="undo" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="重做（Ctrl+Y）" unselectable="on"><i class="fa fa-repeat" name="redo" unselectable="on"></i></a>
								</li>
								<li class="divider" unselectable="on">|</li>
								<li>
									<a href="javascript:;" title="粗体" unselectable="on"><i class="fa fa-bold" name="bold" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="删除线" unselectable="on"><i class="fa fa-strikethrough" name="del" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="斜体" unselectable="on"><i class="fa fa-italic" name="italic" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="引用" unselectable="on"><i class="fa fa-quote-left" name="quote" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="将每个单词首字母转成大写" unselectable="on"><i class="fa" name="ucwords" style="font-size:20px;margin-top: -3px;">Aa</i></a>
								</li>
								<li>
									<a href="javascript:;" title="将所选转换成大写" unselectable="on"><i class="fa fa-font" name="uppercase" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="将所选转换成小写" unselectable="on"><i class="fa" name="lowercase" style="font-size:24px;margin-top: -10px;">a</i></a>
								</li>
								<li class="divider" unselectable="on">|</li>
								<li>
									<a href="javascript:;" title="标题1" unselectable="on"><i class="fa editormd-bold" name="h1" unselectable="on">H1</i></a>
								</li>
								<li>
									<a href="javascript:;" title="标题2" unselectable="on"><i class="fa editormd-bold" name="h2" unselectable="on">H2</i></a>
								</li>
								<li>
									<a href="javascript:;" title="标题3" unselectable="on"><i class="fa editormd-bold" name="h3" unselectable="on">H3</i></a>
								</li>
								<li>
									<a href="javascript:;" title="标题4" unselectable="on"><i class="fa editormd-bold" name="h4" unselectable="on">H4</i></a>
								</li>
								<li>
									<a href="javascript:;" title="标题5" unselectable="on"><i class="fa editormd-bold" name="h5" unselectable="on">H5</i></a>
								</li>
								<li>
									<a href="javascript:;" title="标题6" unselectable="on"><i class="fa editormd-bold" name="h6" unselectable="on">H6</i></a>
								</li>
								<li class="divider" unselectable="on">|</li>
								<li>
									<a href="javascript:;" title="无序列表" unselectable="on"><i class="fa fa-list-ul" name="list-ul" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="有序列表" unselectable="on"><i class="fa fa-list-ol" name="list-ol" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="横线" unselectable="on"><i class="fa fa-minus" name="hr" unselectable="on"></i></a>
								</li>
								<li class="divider" unselectable="on">|</li>
								<li>
									<a href="javascript:;" title="链接" unselectable="on"><i class="fa fa-link" name="link" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="引用链接" unselectable="on"><i class="fa fa-anchor" name="reference-link" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="添加图片" unselectable="on"><i class="fa fa-picture-o" name="image" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="行内代码" unselectable="on"><i class="fa fa-code" name="code" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="预格式文本 / 代码块（缩进风格）" unselectable="on"><i class="fa fa-file-code-o" name="preformatted-text" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="代码块（多语言风格）" unselectable="on"><i class="fa fa-file-code-o" name="code-block" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="添加表格" unselectable="on"><i class="fa fa-table" name="table" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="日期时间" unselectable="on"><i class="fa fa-clock-o" name="datetime" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="Emoji表情" unselectable="on"><i class="fa fa-smile-o" name="emoji" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="HTML实体字符" unselectable="on"><i class="fa fa-copyright" name="html-entities" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="插入分页符" unselectable="on"><i class="fa fa-newspaper-o" name="pagebreak" unselectable="on"></i></a>
								</li>
								<li class="divider" unselectable="on">|</li>
								<li>
									<a href="javascript:;" title="跳转到行" unselectable="on"><i class="fa fa-terminal" name="goto-line" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="关闭实时预览" unselectable="on"><i class="fa fa-eye-slash" name="watch" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="全窗口预览HTML（按 Shift + ESC还原）" unselectable="on"><i class="fa fa-desktop" name="preview" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="全屏（按ESC还原）" unselectable="on"><i class="fa fa-arrows-alt" name="fullscreen" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="清空" unselectable="on"><i class="fa fa-eraser" name="clear" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="搜索" unselectable="on"><i class="fa fa-search" name="search" unselectable="on"></i></a>
								</li>
								<li class="divider" unselectable="on">|</li>
								<li>
									<a href="javascript:;" title="使用帮助" unselectable="on"><i class="fa fa-question-circle" name="help" unselectable="on"></i></a>
								</li>
								<li>
									<a href="javascript:;" title="关于Editor.md" unselectable="on"><i class="fa fa-info-circle" name="info" unselectable="on"></i></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<br>
				<input class="btn btn-default" value="提交" type="submit">
			</form>

			<div class="foot_line"></div>
			<!-- container -->
		</div>
		<!-- container -->

		<div id="footer">
			<a href="${pageContext.request.contextPath}/home?bloggerId=${blogger.id}&currPage=1">&nbsp;&nbsp;MyBlog首页</a>

		</div>
		<!-- footer -->

		<script type="text/javascript">
			var testEditor;
			var jQuery = Zepto;
			$(function() {
				testEditor = editormd("mdView", {
					width: "90%",
					height: 720,
					path: './editormd/lib/',
					codeFold: true,
					searchReplace: true,
					saveHTMLToTextarea: true, // 保存 HTML 到 Textarea                   
					htmlDecode: "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启
					emoji: true,
					taskList: true,
					tocm: true,
					tex: true,
					flowChart: true,
					sequenceDiagram: true,
					imageUpload: true,
					imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
					imageUploadURL: "/Blog/UploadPic",
					//后台只需要返回一个 JSON 数据				      
					onload: function() {
						//console.log("onload =>", this, this.id, this.settings);
					}
				});
				editor.setToolbarAutoFixed(false); //工具栏自动固定定位的开启与禁用               
			});
		</script>

	</body>

</html>