<%@page import="com.model.AdvertiserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%
     AdvertiserInfo info=null;
     String id="";
     String name="";
     String address="";
     String phonenumber="";
    // String photo="";
     
    info = (AdvertiserInfo)request.getAttribute("display");
    id=info.getAdvertiserId();
    name=info.getName();
    phonenumber=info.getPhoneNumber();
    address=info.getAddress();
    
   // photo=info.getPhoto();
    
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="color: blue;"> ID:<%=id %></p>
<p style="color: blue;">Name :<%=name %></p>
<p style="color: blue;">Address :<%=address %></p>
<p style="color: blue;">Phone Number :<%=phonenumber %></p>
</body>
</html>