<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="row">
		<div class='col-sm-3' style="margin-top: 15px">
			<%@ include file="menu_left.jsp"%>
		</div>
		<div class="col-sm-9 form-group" style="margin-top: 15px">
		<h3 style="text-align:center">Thêm thành viên</h3>
			<form action='user_add' method="post">
				<div class="col-md-12" style= "margin-top: 20px">
					<div class="col-md-4">Tên người dùng:</div>
					<div class="col-md-8">
						<input type="text" name="nameUser" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">password:</div>
					<div class="col-md-8">
						<input type="text" name="password" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Email:</div>
					<div class="col-md-8">
						<input type="text" name="email" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Role:</div>
					<div class="col-md-8">
						<input type="text" name="role" />
					</div>
					<br />
				</div>
				<input type="submit" value="Submit" style="text-align: center" />

			</form>
		</div>
	</div>
</body>
</html>