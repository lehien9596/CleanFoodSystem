<%@page import="model.FoodModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="food_provider" method="get">
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class='col-sm-3' style="margin-top: 15px">
				<%@ include file="menu_left_manage.jsp"%>
			</div>
			<div class='col-sm-9' style="margin-top: 15px">
				<h3 style="text-align: center">Danh sách loại thực phẩm</h3>
				<table class="data-table">
					<tr class="header">
						<td>Mã thực phẩm</td>
						<td>Tên thực phẩm</td>
						<td>Ghi chú</td>
						<td>Chi tiết</td>
						<td></td>
					</tr>

					<%
						List<FoodModel> listFoodModel = (List<FoodModel>) request.getAttribute("listFood");
						if (listFoodModel != null && !listFoodModel.isEmpty()) {
							for (FoodModel model : listFoodModel) {
								int roleValue = Integer.valueOf(request.getAttribute("role_value").toString());
								int foodId = model.getIdFood();
								String hrefController = "";
								if (roleValue == 0)
									hrefController = "./foodDetail?&id=";
								else if (roleValue == 1)
									hrefController = "./food_detail_provider?&id=";
								else
									hrefController = "./food_detail_manage?&id=";
					%>
					<tr>
						<td><%=model.getIdFood()%></td>
						<td><%=model.getNameFoot()%></td>
						<td><%=model.getNote()%></td>
						<td><a href=<%=hrefController + foodId%>>Xem chi tiết </a></td>
						<td><a href="food?action=delete&id=<%=model.getIdFood()%>">Xóa</a>
							<a href="food?action=update&id=<%=model.getIdFood()%>">Sửa</a></td>
					</tr>


					<%
						}
						}
					%>


				</table>
				<div style="margin-top: 10px">
					<a href="food?action=add">Thêm một loại thực phẩm</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>