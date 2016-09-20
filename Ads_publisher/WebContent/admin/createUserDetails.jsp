<%-- 
    Document   : createUserDetails.jsp
    Created on : 8 Sep, 2016, 12:10:04 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <CENTER>
        <h1>User Details</h1>
    </CENTER>
    <p> Search by UserId</p><br>
    <script type="text/javascript">
   function validate(){
    	if(document.frm.id.value==""){
    		alert("ID cannot be blank!!");
			return;
    	}
    	document.frm.action="../UserInformation";
  		document.frm.submit();
    }
    </script>
    <form name="frm">
    <input type="text" name="id" >
    <input type="button" value ="submit" onclick="validate()">
    </form>
    </body>
</html>
