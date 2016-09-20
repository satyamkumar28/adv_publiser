<%@page import="com.model.CustInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <%
     CustInfo info=null;
     int ewallet=0;
     String name="";
     String address="";
     long phonenumber=0;
    // String photo="";
     
    info = (CustInfo)request.getAttribute("display");
    ewallet=info.getEwallet();
    name=info.getName();
    phonenumber=info.getPhone();
    address=info.getAddress();
    
   // photo=info.getPhoto();
    
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p style="color: blue;">Name :<%=name %></p>
<p style="color: blue;">Address :<%=address %></p>
<p style="color: blue;">Phone Number :<%=phonenumber %></p>
<p style="color: blue;"> ewallet:<%=ewallet %></p>
</body>
</html>>