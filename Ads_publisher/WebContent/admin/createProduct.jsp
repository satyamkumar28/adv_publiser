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
	<H1> <u>Create Product</u> </H1>
	</CENTER>
<!-- 	<SCRIPT language="JavaScript">
  	function validate()
  	{
	  	if(document.frm.name.value==""||document.frm.price.value=="")
		{
  			alert("name or price cannot be blank!!");
			return;
  		}
  	  	document.frm.action="CreateProduct";
  		document.frm.submit();
  	}
	</SCRIPT> -->
	<form method="post" name="frm" action="../CreateProduct">
	<!-- <p align="center"><font size="5"><b></b></font></p> -->
  	<TABLE ALIGN="center" height="57">
  	<TR>
  		<TD >
        	<b>Product Name: </b>
  		</TD>
  		<TD >
    		<input type="text" name="name" size="20">
     		</TD>
   	</TR>
   	<TR>
    		<TD >
        	<b>Price: </b>
    		</TD>
    		<TD >
    		<input type="text" name="price" size="20">
    		</TD>
        </TR>
        	
        <TR><td><br></TR><TR></TR><TR></TR>
    	<TR align="center">
    		<TD>
    		<input type="submit" value=" Create " >
    		</TD>
                
    	</TR>
        
    	
  	</TABLE>
  	</form>
</body>
</html>