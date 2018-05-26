<%@page import="model.FoodDetailModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<
<meta charset="UTF-8">
<title>Thực phẩm</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="food_detail_provider" method="get">
		<%@ include file="header.jsp"%>
			<div class="row">
				<div class='col-sm-3' style="margin-top: 15px">
					<%@ include file="menu_left_provider.jsp"%>
				</div>
				<div class="col-sm-9" style="margin-top: 15px">
					<table class="data-table">
						<tr class="header">
							<td>Mã thực phẩm</td>
							<td>Tên thực phẩm</td>
							<td>Ghi chú</td>
							<td>Số lượng (gói/kg)
							<td hidden = "true">Mã QR Tem</td>
							<td>Hình ảnh</td>
							<td hidden>Sinh tem</td>
							<td></td>
						</tr>
						<tr>
							<%
								List<FoodDetailModel> listDetailModel = (List<FoodDetailModel>) request.getAttribute("listFoodDetail");
								if (listDetailModel != null && !listDetailModel.isEmpty())
									for (FoodDetailModel detailModel : listDetailModel) {
										Integer idFootDetail = detailModel.getIdFootDetail();
										String nameFootDetail = detailModel.getNameFoodDetail();
										String note = detailModel.getNote();
										Integer number = detailModel.getNumber();
										String codeQR = detailModel.getCodeQR();
										Integer idProvider = detailModel.getIdProvider();
										Integer idManage = detailModel.getIdManage();
										Integer idMarket = detailModel.getIdMarket();
										Integer idFood = detailModel.getIdFood();
										String image = detailModel.getImage();
										
							%>
						
						<tr>
							<td><%=idFootDetail%></td>
							<td><%=nameFootDetail%></td>
							<td><%=note%></td>
							<td><%=number%></td>
							<td  hidden = "true"><%=codeQR%></td>
							<td><img src="<%=image%>" style="width: 150px; height: 150px"></td>
							<td hidden><a href="food_detail_provider?action=showTem&id=<%=idFood %>&idFoodDetail=<%=idFootDetail%>">Hiển thị tem</a></td>
							<td><a href="food_detail_provider?action=delete&id=<%=idFood %>&idFoodDetail=<%=idFootDetail%>" >Xóa</a>
							<a href="food_detail_provider?action=update&id=<%=idFood %>&idFoodDetail=<%=idFootDetail%>">Sửa</a></td>
						</tr>
						
						<%
							}
						%>
						</tr>
					</table>
					<div style="margin-top: 15px"><a href="foodDetail?action=add">Thêm một thực phẩm mới</a></div>
				</div>
			</div>
	</form>
</body>
</html>