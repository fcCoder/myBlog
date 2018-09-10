<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>

<!-- CSS -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
<script type="text/javascript">
function doRegister(this){
	$.ajax();
}
</script>
</head>

<body>

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Bootstrap Multi Step Registration Form Template</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="top-navbar-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<span class="li-text">
						Put some text or
					</span> 
					<a href="#"><strong>links</strong></a> 
					<span class="li-text">
						here, or some icons: 
					</span> 
					<span class="li-social">
						<a href="#"><i class="fa fa-facebook"></i></a> 
						<a href="#"><i class="fa fa-twitter"></i></a> 
						<a href="#"><i class="fa fa-envelope"></i></a> 
						<a href="#"><i class="fa fa-skype"></i></a>
					</span>
				</li>
			</ul>
		</div>
	</div>
</nav>

<!-- Top content -->
<div class="top-content">
	
	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<h1><strong>Bootstrap</strong> Multi Step Registration Form</h1>
					<div class="description">
						<p>
							This is a free responsive multi-step registration form made with Bootstrap. 
							Download it on <a href="#"><strong>AZMIND</strong></a>, customize and use it as you like!
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3 form-box">
					
					<form role="form" action="${pageContext.request.contextPath}/register" method="post" class="registration-form">
						
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>Step 1 / 3</h3>
									<p>Tell us who you are:</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-user"></i>
								</div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="sr-only" for="form-first-name">username</label>
									<input type="text" name="username" placeholder="username..." class="form-first-name form-control" id="form-first-name">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-last-name">nickname</label>
									<input type="text" name="nickname" placeholder="nickname..." class="form-last-name form-control" id="form-last-name" onmouseout="doRegister(this)">
								</div>
								
								<button type="button" class="btn btn-next">Next</button>
							</div>
						</fieldset>
						
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>Step 2 / 3</h3>
									<p>Set up your account:</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">
								
								<div class="form-group">
									<label class="sr-only" for="form-password">password</label>
									<input type="password" name="password" placeholder="password..." class="form-password form-control" id="form-password">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-repeat-password">repeat</label>
									<input type="password" name="repeat" placeholder="repeat password..." 
												class="form-repeat-password form-control" id="form-repeat-password">
								</div>
								<button type="button" class="btn btn-previous">Previous</button>
								<button type="button" class="btn btn-next">Next</button>
							</div>
						</fieldset>
						
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>Step 3 / 3</h3>
									<p>Social media profiles:</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-twitter"></i>
								</div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="sr-only" for="form-facebook">sex</label>
									<input type="text" name="sex" placeholder="sex..." class="form-facebook form-control" id="form-facebook">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-twitter">age</label>
									<input type="text" name="age" placeholder="age..." class="form-twitter form-control" id="form-twitter">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-about-yourself">sign</label>
									<textarea name="sign" placeholder="About yourself..." 
												class="form-about-yourself form-control" id="form-about-yourself"></textarea>
								</div>
								<button type="button" class="btn btn-previous">Previous</button>
								<button type="submit" class="btn">Sign me up!</button>
							</div>
						</fieldset>
					
					</form>
					
				</div>
			</div>
		</div>
	</div>
	
</div>
Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/retina-1.1.0.min.js"></script>
<script src="assets/js/scripts.js"></script>

<!--[if lt IE 10]>
	<script src="assets/js/placeholder.js"></script>
<![endif]-->

</body>

</html>