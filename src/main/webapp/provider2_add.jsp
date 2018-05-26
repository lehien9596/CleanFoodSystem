<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhà cung cấp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/jquery.prettify.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="row">
		<div class='col-sm-3' style="margin-top: 15px">
			<%@ include file="menu_left_provider.jsp"%>
		</div>
		<div class="col-sm-9" style="margin-top: 15px">
		<h3 style="text-align:center">Thêm nhà cung cấp mới</h3>
			<form method="post" action="provider2_add">
				<div class="col-md-12">
					<div class="col-md-4" name="nameProvider">Tên nhà cung cấp
						thực phẩm :</div>
					<div class="col-md-8">
						<input type="text" name="nameProvider" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4" name="address">Địa chỉ:</div>
					<div class="col-md-8">
						<input type="text" name="address"  id="diachi"/>
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4" name="phone">Số điện thoại:</div>
					<div class="col-md-8">
						<input type="text" name="phone" />
					</div>
					<br />
				</div>
				<input type="submit" value="Submit" style="text-align: center" />
				<!-- <input type="button" value="Submit" style="text-align: center" id="abcd" /> -->
			</form>
		</div>
	</div>
</body>
</html>
<!-- <script>
	$('#abcd').click(function(){
		var diachi = $('#diachi').val();
		alert(diachi);
	});
</script> -->