<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
	Logout Successfully
	
</h1>
<br><br><br><br>
<%session.invalidate(); %>
<a href="ClientLogin.jsp">
	<input type="button" value="   Continue   " style="height: 100px; width: 150px;">
</a>
</center>
</body>
</html>