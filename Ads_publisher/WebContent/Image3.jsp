<%@page import="com.database.DBad"%>
<%@page import="com.database.DBmanager"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String id=(String)session.getAttribute("userid");

if(id==null)
{

RequestDispatcher rd=request.getRequestDispatcher("ClientLogin.jsp");
	rd.forward(request,response);
 }


String path="",title="";

CustInfo info=(CustInfo)session.getAttribute("info");
int listtotal=info.getListtotal();
int start=info.getStart();
if((start+2)>listtotal)
{
	%>
		<font size=8>No more adds</font>
<% }
else
{

String userid=(String)session.getAttribute("userid");
HashMap<Integer,Integer> hm=(HashMap<Integer,Integer>)session.getAttribute("hm");

//HashMap<Integer,Integer> hm=CustInfo.getusersearchads(userid);
int key=start+2;
int imgid3=hm.get(key);

info.setPopupimgid(imgid3);
info.setImgid3(imgid3);
session.setAttribute("info", info);


Connection con=DBmanager.getconnection();
ResultSet rs=DBad.getadsresultset(imgid3);
while(rs.next())
{
	title=rs.getString("TITLE");
	path=rs.getString("THEMEIMAGE");
}

%>

	<img src='<%=path%>' height='180' width='180' onclick="MyWindow=window.open('http://localhost:8070/Ads_publisher/PopUp.jsp?popid=<%=imgid3%>','MyWindow');return false;">
<font size=3>
<br><center>Add :&nbsp;&nbsp;<%=title%></center>
	</font>
<%} %>
</body>
</html>