<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
if(session.getAttribute("admin")==null){
	response.sendRedirect("../adminlogin.html");
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>Create Category</h1></center><br><br>
    <form action="../CreateCategories" method="post">
     CreateCategory<input type="text" name="category"><br>
     <input type="submit"   value="submit"/>
     
        </form>
        <br>
        <a href="admin/createSubCategory.jsp">Create SubCategory</a>
    </body>
</html>
