<%-- 
    Document   : createSubCategory.jsp
    Created on : 8 Sep, 2016, 12:09:06 PM
    Author     : PC
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.model.AdInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.database.DBmanager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
if(session.getAttribute("admin")==null){
	response.sendRedirect("../adminlogin.html");
}
%>
<html>
 <script src="jquery-2.2.1.js"></script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="style.css">
       
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>Create SubCategory</h1></center><br><br><br>
    
    <form style="width:600px"  action="../CreateSubCategories" method="post" >
	
	
	<fieldset>
	<table border="0" cellpadding="10">
	
	<tbody>
	
	<tr>
	<td>Sub-Category : </td>
	<td ><input type="text" name="subcat" value="" >
	</td>
	</tr>
		<%
		ArrayList<AdInfo> info = new ArrayList<AdInfo>();
	 info =DBmanager.getCategories();%>
<tr>
	<td>Select Category : </td>
	<td ><select name="category">
	<% for(int i=0; i<info.size();i++){
	String cat=info.get(i).getCategory().toString();
	%>		 
<option value="<%=cat%>"><%=cat%> </option>
<%} %>
</select>
</td>
</tr>
	<tr>
    <td colspan="2" align="right">
    <input type="submit" value="Register" />
    </td>
    </tr></tbody>
	
		</table>
	</fieldset>
		
	</form>

    </body>
</html>
