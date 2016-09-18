<%@page import="com.database.DbManger"%>
<%@page import="com.model.RegUserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String userName="";
    String password="";
    RegUserInfo info =null;
    if(request.getMethod().equals("POST"))
    {
         userName = request.getParameter("name");
         password = request.getParameter("password");
    	info=DbManger.loginUser(userName, password);
    
    	
    	
    	out.println(info);
    	
    	
    	
    	
    	 if(!(info.equals(null))){
    		request.setAttribute("Uinfo",info);
    		RequestDispatcher rd=request.getRequestDispatcher("Craeteadvpage.jsp");
    		rd.forward(request,response);
    	} 
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="styleSheet" type="text/css" href="css\Style1.css">
</head>
<body>
<SCRIPT language="JavaScript">
  	function validate()
  	{
	  	if(document.frm.name.value==""||document.frm.password.value=="")
		{
  			alert("UserName or Password cannot be blank!!");
			return;
  		}
  	  	document.frm.action="Validateadvertiser";
  		document.frm.submit();
  	}
  	</script>
<div class="loginForm">
<h1 class="formheading">Advertiser Panel</h1>
<form name="frm" action="" method="post" >
<table >

<tr  ><td>UserID:</td><td><input type="text" name="name" placeholder="EMAILID" size="30"></td></tr>
<tr><td>Password:</td><td><input type="text" name="password" placeholder="PASSWORD" size="30"></td></tr>
<tr><td colspan="2" style="text-align:center"><input class="sub" type="button" value="LOGIN" onclick="validate();"></td></tr>
</table>
<a href="Registration.html">New User</a><br>
<a href="ForgetPassword.html">Forget Password</a>
</form>
</div>

</body>

</html>