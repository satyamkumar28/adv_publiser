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
	<H1> <u>Client Help Center!</u> </H1>
	</CENTER>
	<SCRIPT language="JavaScript">
  	function validate()
  	{
	  	if(document.frm.userid.value=="")
		{
  			alert("User name can't be null!!");
			return;
  		}
		if(document.frm.question.value=="Select any")
		{
  			alert("Select any question!!");
			return;
  		}
		if(document.frm.answer.value=="")
		{
  			alert("Answer can't be empty!!");
			return;
  		}
  	  	document.frm.action="ValidateQuestion";
  		document.frm.submit();
  	}
	</SCRIPT>
	<form method="post" name="frm">
	<p align="center"><font size="5"><b>Forgot Password Form</b></font></p>
  	<TABLE ALIGN="center" height="57" cellpadding="12">
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
        	<b>Security Question:</b>
    		</TD>
    		<TD >
    			<select name="question">
    			 <option>Select any</option>
    			 <option>What is yours maiden name ?</option>
    			 <option>What is yours first school's name ?</option>
    			 <option>What is yours pet name ?</option>
    			 <option>What is yours nick name ?</option>
    			</select>
    		</TD>
        </TR>
    	
    	<TR>
    		<TD >
        	<b>Security Answer:</b>
    		</TD>
    		<TD >
    		<input type="text" name="answer" size="20">
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
        
    	
  	</TABLE>
  	</form>
</body>
</html>