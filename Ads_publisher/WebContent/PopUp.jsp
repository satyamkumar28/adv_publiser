<%@page import="com.database.DBad"%>
<%@page import="com.database.DBmanager"%>
<%@page import="com.model.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Insert title here</title>


<script>
$("proceed").delay(10000).show();

</script>
</head>
<body>
<html><head>
<script>
<!--
<%
String clock = request.getParameter( "clock" );
if( clock == null ) clock = "10";
%>
var timeout = <%=clock%>;
function closewin()
{
	mywindow.close();	
}
function timer()
{
if( --timeout > 0)
{
document.forma.clock.value = timeout;
window.setTimeout( "timer()", 1000 );
}
else
{

document.forma.clock.value = "Time over";
document.forma.action="ClaimBonus";
document.forma.submit();
///disable submit-button etc
}
}
//-->
</script>
<body>
<form action="<%=request.getRequestURL()%>" name="forma">
Time remaining to claim Bonus&nbsp;&nbsp;&nbsp;
<font size="8"><input type="text" name="clock" value="<%=clock%>" style="border:0px solid white">
...</font>
</form>
<script>
<!--
timer();
//-->
</script>
<br>submit</br>
</body></html>





	<%	
	String id=(String)session.getAttribute("userid");

	if(id==null)
	{

	RequestDispatcher rd=request.getRequestDispatcher("ClientLogin.jsp");
		rd.forward(request,response);
	 }
		
		CustInfo info=(CustInfo)session.getAttribute("info");
    	int popupimgid=Integer.parseInt(request.getParameter("popid"));
    	info.setPopupimgid(popupimgid);
    	session.setAttribute("info",info);
    	
 
    	
    	
    	String ADVERTISERUSER=""; 
    	int ADID=0; 
    	String TITLE=""; 
    	String THEMEIMAGE=""; 
    	String DESCRIPTION=""; 
    	String IMAGE1=""; 
    	String IMAGE2=""; 
    	String IMAGE3=""; 
    	String VIDEO=""; 
    	String CATEGORY=""; 
    	String SUBCATEGORY=""; 
    	int PRIORTY=0; 
    	String APPROVE="";

    	
   	
    	Connection con=DBmanager.getconnection();
    	ResultSet rs=DBad.getadsresultset(popupimgid);
    	while(rs.next())
    	{
    		ADVERTISERUSER=rs.getString("ADVERTISERUSER");
    		ADID=rs.getInt("ADID");
    		TITLE=rs.getString("TITLE");
    		THEMEIMAGE=rs.getString("THEMEIMAGE");
    		DESCRIPTION=rs.getString("DESCRIPTION");
    		IMAGE1=rs.getString("IMAGE1");
    		IMAGE2=rs.getString("IMAGE2");
    		IMAGE3=rs.getString("IMAGE3");
    		VIDEO=rs.getString("VIDEO");
    		CATEGORY=rs.getString("CATEGORY");
    		SUBCATEGORY=rs.getString("SUBCATEGORY");
    		
    	}
    	
    	
	%>
	
	
	
	
	
	<center>
	<font size="5px">Advertiser :<%=ADVERTISERUSER%>
	</center>
	<br><br>
<div id="popup1">
	<center>	
	<img src="<%=THEMEIMAGE%>" height='150' width='150'><br>
	<%=TITLE%>
	</center>
</div>	
	</font>
	<br><br><br><br>
<div id="popup">	
	<div id="popupl">
	<br>
	Category :<%=CATEGORY %><br><br>
	Sub-Category :<%=SUBCATEGORY %><br><br>	
	</div>
	
	<div id="popupr">
	More Images<br>
	<img src="<%=IMAGE1%>" height="90px" width="150px" alt="First View">&nbsp;&nbsp;&nbsp;
	<img src="<%=IMAGE2%>" height="90px" width="150px" alt="Second View">&nbsp;&nbsp;&nbsp;
	<img src="<%=IMAGE3%>" height="90px" width="150px" alt="Third View">&nbsp;&nbsp;&nbsp;
	
	</div>
	
</div><br>
<center>
<div id="popupl">
 <video width="320" height="240" controls>
  <source src="<%=VIDEO%>" type="video/mp4">
 Your Browser doesn't support this video
 
 
 </video>
 </div>
 </center>
 <br><br><br>

</center>	
</body>
</html>

