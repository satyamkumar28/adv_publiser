<%@page import="com.database.DBproduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.model.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">

<SCRIPT language="JavaScript">
  	function validate()
  	{
	  	if(document.frm.purchaseproduct.value=="Select any Product")
		{
  			alert("Initially Select any product to purchase !!");
			return;
  		}
  	  	document.frm.action="ValidateProduct";
  		document.frm.submit();
  	}
</SCRIPT>

</head>
<body>
<%
String id=(String)session.getAttribute("userid");

if(id==null)
{

RequestDispatcher rd=request.getRequestDispatcher("ClientLogin.jsp");
	rd.forward(request,response);
 }
HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
hm=CustInfo.getusersearchads(id);
int listtotal=hm.size();
session.setAttribute("hm",hm);


CustInfo info=(CustInfo)session.getAttribute("info");
info.setListtotal(listtotal);
String name=info.getName();
String address=info.getAddress();
long phone=info.getPhone();
int ewallet=info.getEwallet();
String category=info.getCategory();
String subcategory=info.getSubcategory();
int start=info.getStart();
int previous=info.getPrevious();
int next=info.getNext();

if(listtotal<=3)
{
	next=listtotal;	
}



%>

<div id="greeting">

      <nav class="navigation">
          <ul class="mainmenu">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hello 
          <li>&nbsp;&nbsp;&nbsp;<font color="blueviolet"><%=name %></font>
            <ul class="submenu">
               <li><a href="UserProfile.jsp">Profile</a></li>
                <li><a href="ClientLogout.jsp">Logout</a></li>
            </ul>
          </li>
		</ul>
		</nav>

	
</div>
<br>
<div id="images">
	<div id="image">
		<br>
		<form action="Previous" method="post">	
		<%if(previous==1){ %> <input type="submit" value="Previous  " style="width: 80px;height: 50px" disabled>   <%} else{%>	
			<input type="submit" value="Previous  " style="width: 80px;height: 50px"><%} %>
			
	  	</form>
	</div>
	<div id="image">
		<jsp:include page="Image1.jsp"/>
	</div>
	<div id="image">
		<jsp:include page="Image2.jsp"/>
	</div>
	<div id="image">
		<jsp:include page="Image3.jsp"/>
	</div>
	
	
	<div id="image">
	<br>
	  <form action="Next" method="post">
	  <%if(next==listtotal){ %>		<input type="submit" value="Next" style="width: 80px;height: 50px" disabled>				<%} else{%>
		<input type="submit" value="Next" style="width: 80px;height: 50px">		<%} %>
	  </form>	
	</div>
</div>
<br>


<div id="ewallet">
	<div id="ewallet1">
		<font size="12">e-wallet</font>	
	</div>
	<div id="ewallet2">
		<font size="12">
			<%=ewallet %>
		</font>
	</div>
</div>





<br>
<div id="product">
 <div id="product1">
   
	<font size=10>Products Store</font>
 </div>	
	<div id="product2">
	   <form method="post" name="frm">
		<font size="12">
		 <select name="purchaseproduct" style="width: 250px;height: 50px">
				<option>Select any Product</option>
			
		 		<%	HashMap<Integer,String> hm1=DBproduct.getproducts();				
	
					for(Map.Entry m:hm1.entrySet())
					{
		  		%>
				<option> <%out.println(m.getValue()); %><sub><%out.println("("+m.getKey()+" coins)"); %></sub>   </option>
			
				<%} %>
			</select>
			
		</font>	
	</div>
	<div id="product3">
			<br>
			<input type="button" value="   Purchase   " onclick="validate();" style="width=150px;height: 50px;">
	</div>
   </form>	
</div>
<br>


<div id="profile">
Name :<%=name %><br>
Email :<%=id %><br>
Address :<%=address %><br>
Phone :<%=phone %><br>

</div>


</body>
</html>