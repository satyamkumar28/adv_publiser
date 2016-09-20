<%@page import="com.database.DBmanager"%>
<%@page import="com.model.AdInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

            <a style="position: absolute; top: 0; right: 0; width: 100px;margin-right: 50px; text-align:right;" href="AdvLogin.jsp">
                Advertiser</a><br>
            <a style="position: absolute; top: 1; right: 0; width: 100px;margin-right: 50px; text-align:right;" href="ClientLogin.jsp">
                User</a><br><br><br><br>
          
 <div>
 
  <CENTER>

  <TABLE cellSpacing=0 cellPadding=0 border=0>
<SCRIPT language="JavaScript">
  	function validate()
  	{
	  	if(document.frm.search.value=="")
		{
  			alert(" Search input cannot be blank!!");
			return;
  		}
  	  	document.frm.action="test";
  		document.frm.submit();
  	}
  	</SCRIPT>
<TBODY>

<TR>

<TD><IMG height=110 alt=Google src="images/google.gif" 

  width=276></TD></TR></TBODY></TABLE><BR>
  
  <div>
  <form name="frm">
  <input type="text" name="search" value="">
  <input type="button" value="GO" name="button1" onclick="validate();">
  </form>
</div>
</CENTER>
</div>
 

<div >
     <h2>Categories</h2>
<ul >
<%
ArrayList<AdInfo> info = DBmanager.getCategories();
for(int i=0;i<info.size();i++){
	String cat=info.get(i).getCategory().toString();
	%>	
	<li><a href="test?param1=<%=cat %>"><%=cat %></a></li>	
	<%
		ArrayList<AdInfo> info1 = DBmanager.getSubCategories(cat);
	    for(int j=0;j<info1.size();j++){
		String subcat=info1.get(j).getSubcategory().toString();
	%>

		<ul >
        <li><a href="test?param2=<%=subcat %>"><%=subcat %></a></li>
       </ul>
<% 		
	}%><br>
	<% 
}
%>
</ul>
</div>
<br><br>
<center>
<div style="position: absolute; bottom: 0;">
	<p>Copyright &copy; Untitled. Designed by <a href="http://templated.co" rel="nofollow">TEMPLATED</a> 
	&nbsp &nbsp &nbsp &nbsp <a href="adminlogin.html">Admin</a>
	</p>
</div></center>
</body>
</html>