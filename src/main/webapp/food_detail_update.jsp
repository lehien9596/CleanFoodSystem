<%@page import="dao.FoodDetailDAO"%>
<%@page import="model.FoodDetailModel"%>
<%@page import="java.util.List"%>
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
	<form action='foodDetailUpdate' method="post">
		<%
			int id = Integer.valueOf(request.getAttribute("idFootDetail").toString());
			FoodDetailModel foodDetailModel = new FoodDetailDAO().getFoodDetailById(id);
		%>
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class='col-sm-3' style="margin-top: 15px">
				<%@ include file="menu_left.jsp"%>
			</div>
			<div class="col-sm-9" style="margin-top: 15px">
				<h3 style="text-align:center">Chỉnh sửa thông tin thực phẩm</h3>
				<div class="col-md-12" style="margin-top: 20px">
					<div class="col-md-4">Mã thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" name="idFoodDetail"
							value="<%=foodDetailModel.getIdFootDetail()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Tên thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" name="nameFoodDetail"
							value="<%=foodDetailModel.getNameFoodDetail()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Ghi chú chi tiết:</div>
					<div class="col-md-8">
					<input type="text"  rows="4" cols="50" name= "note" value="<%=foodDetailModel.getNote()%>">
						
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Số lượng:</div>
					<div class="col-md-8">
						<input type="text" name="number"
							value="<%=foodDetailModel.getNumber()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12" hidden>
					<div class="col-md-4">Mã QR Code:</div>
					<div class="col-md-8">
						<input type="text" name="codeQR"
							value="<%=foodDetailModel.getCodeQR()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã QR Code:</div>
					<div class="col-md-8">
						<input disabled type="text" name="codeQR"
							value="<%=foodDetailModel.getCodeQR()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã nhà cung cấp thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" name="idProvider"
							value="<%=foodDetailModel.getIdProvider()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã nhà quản lí thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" name="idManage"
							value="<%=foodDetailModel.getIdManage()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã siêu thị:</div>
					<div class="col-md-8">
						<input type="text" name="idMarket"
							value="<%=foodDetailModel.getIdMarket()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Mã loại thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" name="idFood"
							value="<%=foodDetailModel.getIdFood()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12" >
					<div class="col-md-4">Hình ảnh:</div>
					<div class="col-md-8">
						<input type="text" name="image" value="<%=foodDetailModel.getImage()%>"/>
					</div>
				</div>
				<input type="submit" value="Submit" style="text-align: center" />
			</div>

		</div>





	</form>
</body>
</html>