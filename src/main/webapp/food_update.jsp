<%@page import="dao.FoodDAO"%>
<%@page import="model.FoodModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa thông tin</title>
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
		<div class='col-sm-4' style="margin-top: 15px">
			<%@ include file="menu_left.jsp"%>
		</div>
		<div class="col-sm-8" style="margin-top: 15px">
		<h3 style="text-align:center">Chỉnh sửa thông tin loại thực phẩm</h3>
			<form method="post" action="food_update" style= "margin-top: 20px">
				<%
					int id = Integer.valueOf(request.getAttribute("idFood").toString());
					FoodModel food = new FoodDAO().getFoodById(id);
				%>
				<div class="col-md-12" hidden>
					<div class="col-md-4">Mã thực phẩm:</div>
					<div class="col-md-8">
						<input  type="text" name="idFood"
							value="<%=food.getIdFood()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Tên thực phẩm:</div>
					<div class="col-md-8">
						<input type="text" name="nameFood"
							value="<%=food.getNameFoot()%>" />
					</div>
					<br />
				</div>
				<div class="col-md-12">
					<div class="col-md-4">Ghi chú:</div>
					<div class="col-md-8">
						<input type="text" name="note" value="<%=food.getNote()%>" />
					</div>
					<br />
				</div>
				<input type="submit" value="Submit" style="text-align: center" />

			</form>
		</div>
	</div>

</body>
</html>