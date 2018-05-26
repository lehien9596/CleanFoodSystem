<%@page import="java.util.ArrayList"%>
<%@page import="model.ManageModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhà quản lí thực phẩm</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="row">
		<div class='col-sm-3' style="margin-top: 15px">
			<%@ include file="menu_left_manage.jsp"%>
		</div>
		<div class="col-sm-9" style="margin-top: 15px">
		<h3 style="text-align:center">Danh sách nhà quản lí thực phẩm</h3>
			<form action="ManageController" method="Get">
				<table class="data-table">
					<tr class="header">
						<td>Mã nhà quản lí</td>
						<td>Tên nhà quản lí</td>
						<td>Địa chỉ</td>
						<td>Số điện thoại</td>
						<td></td>
					</tr>
					<tr>
						<%
							ArrayList<ManageModel> listManage = (ArrayList<ManageModel>) request.getAttribute("listManage");
							if (listManage != null && !listManage.isEmpty()) {
								for (ManageModel model : listManage) {
						%>
					
					<tr>
						<td><%=model.getIdManage()%></td>
						<td><%=model.getNameManage()%></td>
						<td><%=model.getAddress()%></td>
						<td><%=model.getPhone()%></td>
						<td><a
							href="manage?action=delete&id=<%=model.getIdManage()%>">Xóa</a> <a
							href="manage?action=update&id=<%=model.getIdManage()%>">Sửa</a></td>
					</tr>
					<%
						}
						}
					%></tr>
				</table>
				<div style="margin-top: 10px">
					<a href="manage?action=add">Thêm nhà quản lí mới</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>