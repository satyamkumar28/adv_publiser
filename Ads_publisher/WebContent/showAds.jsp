<%@page import="com.model.AdInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Advetisements</h1></center>
<% 
ArrayList<AdInfo> alist = (ArrayList<AdInfo>)request.getAttribute("display");
for(int i=0; i<alist.size();i++){
	 %>
<div style="width:50%">
<fieldset>
<% String title=alist.get(i).getTitle().toString(); %>
 <p>Title : <%=title %></p><br>
 <%String path = alist.get(i).getThemeimage().toString(); %>
 <a href="ClientLogin.jsp"><img width="100" height="70" src="<%=path%>" alt=""></a>

 </fieldset>
 <br>
 </div>
  <%} %>
</body>
</html>