<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% System.out.println("JSP: "+request.getAttribute("imgBase64String")); %>
<div style="width: 256px; height: 256px;border: 1px solid; margin: auto; margin-top: 100px" >
<img alt="" src="<%=request.getAttribute("imgBase64String") %>">
<button style="margin-top: 15px; margin-right: auto" onclick="myFunction()">Print tem</button>
</div>


<script>
function myFunction() {
    window.print();
}
</script>

</body>
</html>