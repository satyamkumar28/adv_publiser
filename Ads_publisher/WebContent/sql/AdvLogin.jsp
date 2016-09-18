
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%
    String userName="";
    String password="";
    UserInfo info =null;
    if(request.getMethod().equals("POST"))
    {
         userName = request.getParameter("username");
         password = request.getParameter("password");
    	info=DBManager.loginUser(userName,password);
    
    	
    	
    	out.println(info);
    	
    	
    	
    	
    	 if(!(info.equals(null))){
    		request.setAttribute("Uinfo",info);
    		RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
    		rd.forward(request,response);
    	} 
    }
    %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="styleSheet" type="text/css" href="css\Style1.css">
</head>
<body>
<SCRIPT language="JavaScript">
  	function validate()
  	{
	  	if(document.frm.userid.value==""||document.frm.password.value=="")
		{
  			alert("UserName or Password cannot be blank!!");
			return;
  		}
  	  	document.frm.action="ValidateClient";
  		document.frm.submit();
  	}
<div class="loginForm">
<h1 class="formheading">Advertiser Panel</h1>
<form action="">
<table >

<tr  ><td>UserID:</td><td><input type="text" name="name" placeholder="EMAILID" size="30"></td></tr>
<tr><td>Password:</td><td><input type="text" name="password" placeholder="PASSWORD" size="30"></td></tr>
<tr><td colspan="2" style="text-align:center"><input class="sub" type="button" value="LOGIN" onclick="validate();"></td></tr>
</table>
<a href="Registration.html">New User</a><br>
<a href="Forgetpassword.html">Forget Password</a>
</form>
</div>

</body>
</html>