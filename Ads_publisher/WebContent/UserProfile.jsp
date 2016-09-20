<%@page import="com.database.DBuser"%>
<%@page import="com.database.DBmanager"%>
<%@page import="java.sql.*" %>
<%@page import="com.model.*" %>
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

        <SCRIPT language="JavaScript">
function validate()
{
	
  	
    if(document.frm.name.value=="")
	{
		alert("Name  cannot be blank!!");
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
  	

  	  	document.frm.action="UpdateClient";
  		document.frm.submit();
}
</SCRIPT>

      

<%

Connection con=null;
ResultSet rs=null;
System.out.println("Data Retrieving ....");

String name="";
String password="";
String address="";
long phone=0;
String question="";
String answer="";
int ewallet=0;

int rows;
try{
con=DBmanager.getconnection();
rs=DBuser.getresultset(id);
while(rs.next())
    {
	name=rs.getString(1);
	password=rs.getString(3);
	address=rs.getString(4);
 	phone=rs.getLong(5);
	question=rs.getString(6);
    answer=rs.getString(7);
	ewallet=rs.getInt(8);    
    }
}
catch(Exception e)
{
	out.println("Error in retrieving  "+e.getMessage());
}
%>
<style>

blink{
     animation-duration:3000ms;
     animation-name:blink;
     animation-iteration-count: infinite;
     animation-direction:alternate;
    }
    @keyframes blink{
     0%{opacity: 1;color: red;}
     25%{opacity: 1;color: green;}
     50%{opacity: 1;color: blue;}
     75%{opacity: 1;color: yellow;}
    }
</style>
>> Personal Details<br>
<blink><marquee direction="left" scrollamount="4">* Note :Please enter same values in case of no modification *</marquee></blink>

        <center>
        <form name="frm" method="post">
        <h1>Personal Details</h1>
        <table>
            <tr><td>Name</td>
                <td><input type="text" size=45 name="name" value="<%=name%>"></td>
            </tr>
            <tr><td>User id</td>
                <td><input type="text" size=45 name="userid" value="<%=id%>" disabled></td>
            </tr>
                    
            <tr><td>Address</td>
                <td><input type="text" size=45 name="address" value="<%=address%>"></td>
            </tr>
			<tr><td>Contact number</td>
                <td><input type="text" size=45 name="phno" value="<%=phone%>"></td>
            </tr>
            <tr><td>Security Question :</td>
                <td>
    				<input type="text" size=45 name="question" value="<%=question%>" disabled>
				</td>
            </tr>
            <tr><td>Security Answer :</td>
                <td><input type="text" size=45 name="answer" value="<%=answer%>" disabled></td>
            </tr>
            
<tr><td>   <br><br>     
                        <input type="button" name="b1" value="Submit" onclick="validate();"></td>
               
                 <td>
                   		<br><br>
                     <a href="ClientPage.jsp">
                      <input type="button" value="Cancel">
                     </a>
                   
                 </td>
            </tr>
            </form> 
        </table>
        </center>
</body>
</html>