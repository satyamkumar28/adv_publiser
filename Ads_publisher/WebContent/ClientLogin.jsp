<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<CENTER>
	<H1> <u>Client Login</u> </H1>
	</CENTER>
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
	</SCRIPT>
	<form method="post" name="frm">
	<p align="center"><font size="5"><b>Login Form</b></font></p>
  	<TABLE ALIGN="center" height="57">
  	<TR>
  		<TD >
        	<b>UserName:</b>
  		</TD>
  		<TD >
    		<input type="text" name="userid" size="20">
     		</TD>
   	</TR>
   	<TR>
    		<TD >
        	<b>Password:</b>
    		</TD>
    		<TD >
    		<input type="password" name="password" size="20">
    		</TD>
        </TR>
        
        <TR>
    		<TD >
        	<b>&nbsp;</b>
    		</TD>
    		<TD >
    		<a href="ForgotPassword.jsp">Forgot Password</a>
    		</TD>
        </TR>
        <TR><td><br></TR>
    	<TR align="center">
    		<TD>
    		<input type="button" value="  Login  " onclick="validate();">
    		</TD>
                <TD>
                    <a href="ClientLogin.jsp">
    		       <input type="button" value="  Cancel  ">
    		    </a>
                </TD>
    	</TR>
        
    	<TR>
  		<TD ><font size="4">New User?</font></TD>
  		<TD><a href="ClientRegistration.jsp"><font size="4">Register</font></a></TD>
  	</TR>
  	</TABLE>
  	</form>
</body>
</html>