<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <SCRIPT language="JavaScript">
function validate()
{
  	
        if(document.frm.name.value=="")
	{
		alert("Name  cannot be blank!!");
		return;
 	}
  	if(document.frm.userid.value=="")
	{
		alert("Email  cannot be blank!!");
		return;
 	}
	if(document.frm.password.value==""||document.frm.password.value.length>=11||document.frm.password.value.length<=5)
	{
		alert("INVALID Password!!");
		return;
	}
	if( document.frm.password.value!=document.frm.confirmpassword.value)
	{
		  alert("The confirm password do not match");
		  return;
	}
	if(document.frm.address.value=="")
	{
		alert("INVALID Address !!");
		return;
 	}
  	if(document.frm.phno.value==""||document.frm.phno.value.length>=11||document.frm.phno.value.length<=9)
	{
		alert("INVALID Contact No. !!");
		return;
 	}
  	if(document.frm.question.value=="Select any")
	{
		alert("Security any Security question !!");
		return;
 	}
  	if(document.frm.answer.value=="")
	{
		alert("Security answer  cannot be blank!!");
		return;
 	}

  	  	document.frm.action="ClientRegister";
  		document.frm.submit();
}
</SCRIPT>
        <center>
        <form name="frm" method="post">
        <h1>Personal Details</h1>
        <table>
            <tr><td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr><td>User id</td>
                <td><input type="text" name="userid" value=" "></td>
            </tr>
            <tr><td>Password</td>
                <td><input type="password" value="" name="password" value=" "></td><td>(6-10 characters)</td>
            </tr>
            <tr><td>Confirm Password</td>
                <td><input type="password" name="confirmpassword"></td>
            </tr>
            <tr><td>Address</td>
                <td><input type="text" name="address"></td>
                
            </tr>
			<tr><td>Contact number</td>
                <td><input type="text" name="phno"></td>
            </tr>
            
            <tr><td>Security Question :</td>
                <td>
    				<select name="question">
    				 <option>Select any</option>
	    			 <option>What is yours maiden name ?</option>
    				 <option>What is yours first school's name ?</option>
    				 <option>What is yours pet name ?</option>
    				 <option>What is yours nick name ?</option>
    				</select>
				</td>
            </tr>
            <tr><td>Security Answer :</td>
                <td><input type="text" name="answer"></td>
            </tr>
            
            
            
            
           
            
            
            <tr><td>   <br><br>     
                        <input type="button" name="b1" value="Submit" onclick="validate();"></td>
               
                 <td>
                   		<br><br>
                     <a href="ClientLogin.jsp">
                      <input type="button" value="Cancel">
                     </a>
                   
                 </td>
            </tr>
            </form> 
        </table>
        </center>
</body>
</html>