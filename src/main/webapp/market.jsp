<%@page import="java.util.ArrayList"%>
<%@page import="model.MarketModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/jquery.prettify.js"></script>
<title>Siêu thị</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="row">
		<div class='col-sm-3' style="margin-top: 15px">
			<%@ include file="menu_left.jsp"%>
		</div>
		<div class="col-sm-9" style="margin-top: 15px">
		<h3 style="text-align:center">Danh sách siêu thị</h3>
			<form action="marketController" method="get">
				<table class="data-table">
					<tr class="header">
						<td>Mã siêu thị</td>
						<td>Tên siêu thị</td>
						<td>Địa chỉ</td>
						<td>Số điện thoại</td>
						<td></td>
					</tr>
					<tr>
						<%
							ArrayList<MarketModel> listMarket = (ArrayList<MarketModel>) request.getAttribute("listMarket");
							if (listMarket != null && !listMarket.isEmpty()) {
								for (MarketModel model : listMarket) {
						%>
					
					<tr>
						<td><%=model.getIdMarket()%></td>
						<td><%=model.getNameMarket()%></td>
						<td><%=model.getAddress()%></td>
						<td><%=model.getPhone()%></td>
						<td><a
							href="market?action=delete&id=<%=model.getIdMarket()%>">Xóa</a> <a
							href="market?action=update&id=<%=model.getIdMarket()%>">Sửa</a></td>
					</tr>
					<%
						}
						}
					%></tr>
				</table>
				<div style="margin-top: 10px">
				<a href="market?action=add">Thêm siêu thị mới</a>
			</div>
			</form>
		</div>
	</div>
</body>
</html>