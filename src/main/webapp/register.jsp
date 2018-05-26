<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <link rel="stylesheet" href="css/style_register.css">
<title>Register
</title>
</head>
<body>
<div class="login-page">
  <div class="form">
    <form method="post" action = "register">
      <input type="text" name = "nameUser" placeholder="name"/>
      <input type="password" name = "password" placeholder="password"/>
      <input type="text" name = "email" placeholder="email address"/>
      <input type="text" name = "role" placeholder="role"/>
      <div>(Nếu là nhà cung cấp chọn role = 1, Nhà quản lí chọn role = 2)</div>
      <button>create</button>
      <p class="message">Already Login? <a href="login.jsp">Sign In</a></p>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>

</body>
</html>