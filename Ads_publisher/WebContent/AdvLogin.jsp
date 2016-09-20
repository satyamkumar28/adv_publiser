<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.database.DbManger"%>
<%@page import="com.model.RegUserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%
	String cuserId = request.getParameter("name");
	String Password = request.getParameter("password");

	if (cuserId != null && Password != null) {
		String sql = "select * from advertiserdetails where advertiserid ='" +cuserId+ "'and Password='" + Password + "'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		boolean status = false;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","system");
			st = con.createStatement();
			rs = st.executeQuery(sql);
			status = rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if (st != null) {
					st.close();
					st = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		if (status) {
			%>
			<jsp:forward page="Createadvpage.jsp"/>
			<%
	} else {
		%>
		<jsp:forward page="AdvLogin.jsp"/>
		<%
			
		}
	} else {
		cuserId = "";
	}
%>
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
	  	if(document.frm.name.value==""||document.frm.password.value=="")
		{
  			alert("UserName or Password cannot be blank!!");
			return;
  		}
  	  	
  		document.frm.submit();
  	}
  	</script>
<div class="loginForm">
<h1 class="formheading">Advertiser Panel</h1>
<form name="frm" action="" method="post" >
<table >

<tr  ><td>UserID:</td><td><input type="text" name="name" placeholder="EMAILID" size="30" value="<%=cuserId %>"></td></tr>
<tr><td>Password:</td><td><input type="text" name="password" placeholder="PASSWORD" size="30"></td></tr>
<tr><td colspan="2" style="text-align:center"><input class="sub" type="button" value="LOGIN" onclick="validate();"></td></tr>
</table>
<a href="advertiserRegistration.jsp">New User</a><br>
<a href="ForgetPassword.jsp">Forget Password</a>
</form>
</div>

</body>

</html>