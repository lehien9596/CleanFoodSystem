<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm loại thực phẩm mới</title>
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
		<div class="col-sm-9" style="margin-top: 15px">
		<h3 style="text-align:center">Thêm một thực phẩm mới</h3>
			<form method="post" action="food_add">
				<div class="col-md-12">
					<div class="col-md-4">Tên thực phẩm</div>
					<div class="col-md-8">
						<input type="text" name="nameFood" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Ghi chú</div>
					<div class="col-md-8">
						<input type="text" name="note" />
					</div>
					<br />
				</div>
				<input type="submit" value="Submit" style="text-align: center" />

			</form>
		</div>
	</div>
</body>
</html>