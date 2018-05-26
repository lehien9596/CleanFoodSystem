<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<link rel="stylesheet" href="css/style_login.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="login" method="post">
				<input type="text" placeholder="username" name="username"/> 
				<input type="password" placeholder="password" name="password"/> 
				<input type="submit" value="Login">
				<p class="message">
					Not registered? <a href="register.jsp">Create an account</a>
				</p>
			</form>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>
</body>
</html>