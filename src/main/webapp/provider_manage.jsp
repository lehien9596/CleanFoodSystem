<%@page import="java.util.ArrayList"%>
<%@page import="model.ProviderModel"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhà cung cấp thực phẩm</title>
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
		<h3 style="text-align:center">Danh sách nhà cung cấp thực phẩm</h3>
			<table class="data-table">
				<tr class="header">
					<td>Mã nhà cung cấp</td>
					<td>Tên nhà cung cấp</td>
					<td>Địa chỉ</td>
					<td>Số điện thoại</td>
					<td></td>
				</tr>
				<tr>
					<%
								ArrayList<ProviderModel> listProvider = (ArrayList<ProviderModel>) request
										.getAttribute("listProvider");
								if (listProvider != null && !listProvider.isEmpty()) {
									for (ProviderModel model : listProvider) {
							%>
				
				<tr>
					<td><%=model.getIdProvider()%></td>
					<td><%=model.getNameProvider()%></td>
					<td><%=model.getAddress()%></td>
					<td><%=model.getPhone()%></td>
					<td><a
						href="provider_manage?action=delete&id=<%=model.getIdProvider()%>">Xóa</a>
						<a href="provider_manage?action=update&id=<%=model.getIdProvider()%>">Sửa</a>
					</td>
				</tr>
				<%
							}
							}
						%></tr>

			</table>
			<div style="margin-top: 10px">
				<a href="provider_manage?action=add">Thêm nhà cung cấp thực phẩm mới</a>
			
			</div>
			
		</div>
	</div>

</body>
</html>
