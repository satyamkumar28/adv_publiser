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
%>
   <CENTER>
	<H1> <u>Client Help Center!</u> </H1>
	</CENTER>
	<SCRIPT language="JavaScript">
  	function validate()
  	{
  		if(document.frm.newpassword.value==""||document.frm.newpassword.value.length>=11||document.frm.newpassword.value.length<=5)
  		{
  			alert("INVALID Password!!");
  			return;
  		}
  		if(document.frm.confirmnewpassword.value=="")
		{
  			alert("Confirm password can't be empty!!");
			return;
  		}
	  	if(document.frm.newpassword.value!=document.frm.confirmnewpassword.value)
		{
  			alert("Confirm password didn't match with password!!");
			return;
  		}
  	  	document.frm.action="PasswordReset";
  		document.frm.submit();
  	}
	</SCRIPT>
	<form method="post" name="frm">
	<p align="center"><font size="5"><b>Forgot Password Form</b></font></p>
  	<TABLE ALIGN="center" height="57" cellpadding="12">
  	<TR>
  		<TD >
        	<b>New Password:</b>
  		</TD>
  		<TD >
    		<input type="text" name="newpassword" size="20">(6-11 characters)
     		</TD>
   	</TR>
   		<TR>
    		<TD >
        	<b>Confirm Password:</b>
    		</TD>
    		<TD >
    		<input type="text" name="confirmnewpassword" size="20">
    		</TD>
        </TR>
        <TR><td><br></TR>
    	<TR align="center">
    		<TD>
    		<input type="button" value="  Reset Password  " onclick="validate();">
    		</TD>
                <TD>
                    <a href="ClientLogin.jsp">
    		       <input type="button" value="  Cancel  ">
    		    </a>
                </TD>
    	</TR>
        
    	
  	</TABLE>
  	</form>

</body>
</html>