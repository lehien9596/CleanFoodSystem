<%@page import="java.util.ArrayList"%>
<%@page import="model.UserModel"%>
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
<title>Danh sách người dùng</title>
</head>
<body>
<%@ include file="header.jsp"%>
		<div class="row">
			<div class='col-sm-3' style="margin-top: 15px">
				<%@ include file="menu_left.jsp"%>
			</div>
			<div class="col-sm-9" style="margin-top: 15px">
			<h3 style="text-align:center">Danh sách thành viên</h3>
				<form action="UserController" method="get">
					<table class="data-table">
						<tr class="header">
							<td>Mã người dùng</td>
							<td>Tên người dùng</td>
							<td>Mật khẩu</td>
							<td>Email</td>
							<td>Role</td>
							<td></td>
						</tr>
						<tr>
							<%
								ArrayList<UserModel> listUser = (ArrayList<UserModel>) request.getAttribute("listUser");
								if (listUser != null && !listUser.isEmpty()) {
									for (UserModel model : listUser) {
							%>
						
						<tr>
							<td><%=model.getIdUser()%></td>
							<td><%=model.getNameUser()%></td>
							<td><%=model.getPassword()%></td>
							<td><%=model.getEmail()%></td>
							<td><%=model.getRole() %></td>
							<td><a href="user?action=delete&id=<%=model.getIdUser()%>" >Xóa</a>
							<a href="user?action=update&id=<%=model.getIdUser()%>"">Sửa</a></td>
						</tr>
						<%
							}
							}
						%>
						</tr>
					</table>
					<div style="margin-top: 15px"><a href="user?action=add">Thêm một người dùng mới</a></div>
				</form>
			</div>
		</div>
</body>
</html>