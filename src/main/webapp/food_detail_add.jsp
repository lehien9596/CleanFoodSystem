<%@page import="utils.RandomString"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm thực phẩm mới</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action='foodDetailAdd' method="post"  enctype="multipart/form-data" >
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class='col-sm-3' style="margin-top: 15px">
				<%@ include file="menu_left.jsp"%>
			</div>
			<div class="col-sm-9" style="margin-top: 15px">
				<h3 style="text-align:center">Thêm một thực phẩm mới</h3>
				<div class="col-md-12">
					<div class="col-md-4">Tên thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" required placeholder = "Tên thực phẩm" name="nameFoodDetail" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Ghi chú chi tiết:</div>
					<div class="col-md-8">
					<textarea required rows="4" cols="50" name= "note" placeholder="Thông tin sản xuất và đóng gói của thực phẩm..."></textarea>
					
					</div>
					<br />
				</div>
				<div class="col-md-12" style= "margin-top: 20px">
					<div class="col-md-4">Số lượng:</div>
					<div class="col-md-8">
						<input type="text" required placeholder = "Số lượng(sản phẩm/kg)" name="number" />
					</div>
					<br />
				</div>
				<div class="col-md-12" hidden>
					<div class="col-md-4">Mã QR Code:</div>
					<div class="col-md-8">
						<input type="text" name="codeQR"
							value="<%=RandomString.create6CharRandom() %>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã QR Code:</div>
					<div class="col-md-8">
						<input type="text" name="codeQR" disabled
							value="<%=RandomString.create6CharRandom() %>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã nhà cung cấp thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" required placeholder = "Mã nhà cung cấp" name="idProvider" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã nhà quản lí thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" required placeholder = "Mã nhà quản lí" name="idManage" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã siêu thị:</div>
					<div class="col-md-8">
						<input type="text" required placeholder = "Mã siêu thị" name="idMarket" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã loại thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" required placeholder = "Mã loại thực phẩm" name="idFood" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Hình ảnh:</div>
					<div class="col-md-8">
						<input type="file" name="fileImage"/>
					</div>
				</div>
				<input type="submit" value="Submit" style="text-align: center" />
			</div>

		</div>

	</form>
</body>
</html>