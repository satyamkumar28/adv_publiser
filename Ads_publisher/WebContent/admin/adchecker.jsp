<%@page import="java.io.OutputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.AdInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
if(session.getAttribute("admin")==null){
	response.sendRedirect("../adminlogin.html");
}else{
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Check Advertisements</h1></center>
<% 
ArrayList<AdInfo> alist = (ArrayList<AdInfo>)request.getAttribute("display");
for(int i=0; i<alist.size();i++){
	 %>
<div style="width:70%">
<fieldset>
<% String title=alist.get(i).getTitle().toString(); %>
 <p>Title : <%=title %></p>
 <% String decription=alist.get(i).getDescription().toString(); %>
 <p>Description : <%=decription %></p>
 <p>Theme Image : </p>
  <%String path = alist.get(i).getThemeimage().toString(); %>
  <img width="100" height="70" src="<%= path%>" alt="">
  
   <p>Images : </p>
    <%String path1 = alist.get(i).getThemeimage().toString(); %>
  <img width="100" height="70" src="<%= path1%>" alt=""> &nbsp
  
   <%String path2 = alist.get(i).getThemeimage().toString(); %>
  <img width="100" height="70" src="<%= path2%>" alt=""> &nbsp
  
   <%String path3 = alist.get(i).getThemeimage().toString(); %>
  <img width="100" height="70" src="<%= path3%>" alt=""> 
  
 <%--    <p>Video : </p>
  <% byte[] arr5=alist.get(i).getArr5(); 
  OutputStream os5=null;
  os5.write(arr5);
  os5.flush();
  os5.close();
  %>
   --%>
   <form action="Approval">
   <input type="hidden" name="adid" value="<%=alist.get(i).getAdid()%>">
   <input  type="submit" name="bt1" value="Approve"> &nbsp &nbsp &nbsp
    <input  type="submit" name="bt2" value="Delete">
   </form>
   </fieldset>
</div>
<br>
<%} %>
</body>
</html>
<%} %>>