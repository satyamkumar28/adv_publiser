<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  	
        if(document.frm.Name.value=="")
	{
		alert("Name  cannot be blank!!");
		return;
 	}
  	if(document.frm.Id.value=="")
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
	if(document.frm.Address.value=="")
	{
		alert("INVALID Address !!");
		return;
 	}
  	if(document.frm.Phone.value==""||document.frm.Phone.value.length>=11||document.frm.Phone.value.length<=9)
	{
		alert("INVALID Contact No. !!");
		return;
 	}
  	if(document.frm.Question.value=="Select any")
	{
		alert("Security any Security question !!");
		return;
 	}
  	if(document.frm.Answer.value=="")
	{
		alert("Security answer  cannot be blank!!");
		return;
 	}

  	  	
  		document.frm.submit();
}
</SCRIPT>
<div class="reg">
<h1>REGISTRATION PAGE</h1>
<form action="register" method="post" name="frm">
<table>
<tr><td>NAME:</td><td><input type="text" name="Name" placeholder="Advertiser Name" size="30"></td></tr>
<tr><td>ADVERSITER ID:</td><td><input type="text" name="Id" placeholder="EMAIL ID" size="30"></td></tr>
<tr><td>PASSWORD:</td><td><input type="password" name="password" placeholder="*********" size="30"></td></tr>
<tr><td>Confirm Password</td>
                <td><input type="password" name="confirmpassword" placeholder="CONFIRMPASSWORD" name="confirmpassword" size="30"></td>
            </tr>
<tr><td>ADDRESS:</td><td><input type="text" name="Address" placeholder="ADDRESS" size="30"></td></tr>
<tr><td>CONTACT:</td><td><input type="text" name="Phone" placeholder="+91 OR 0 NOT USED" size="30"></td></tr>
<tr><td>QUESTION:</td><td><select class="" name="Question" style="width: 250px" >
<option value="">---Select your security Question---</option>
<option value="What is your pet name">What is your pet name?</option>
<option value="What was the name of your first school">What was the name of your first school?</option>
<option value="Who was your childhood hero">Who was your childhood hero?</option>
<option value="What is favorite past_time">What is favorite past_time?</option>
</select></td></tr>
<tr><td>Answer:</td><td><input type="text" name="Answer" placeholder="ANSWER" size="30"></td></tr>
<tr><td><input type="submit" value="SUBMIT" onclick="validate();"></td><td><input type="reset" value="RESET" ></td></tr>
</table>
</form>
</div>
</body>
</html>