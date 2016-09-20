<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="styleSheet" type="text/css" href="css\Style1.css">
<title>Insert title here</title>
</head>
<body>
<SCRIPT language="JavaScript">
function validate()
{
  	
        if(document.frm.userid.value=="")
	{
		alert("email id!!");
		return;
 	}
  	if(document.frm.title.value=="")
	{
		alert("invalid title!!");
		return;
 	}
	
	
	if(document.frm.category.value=="")
	{
		alert("INVALID category !!");
		return;
 	}
  	if(document.frm.subcategory.value=="");
		alert("INVALID subcategory. !!");
		return;
 	}
  	if(document.frm.select.value=="Select any")
	{
		alert("Select  any one !!");
		return;
 	}
  	

  	  	
  		document.frm.submit();
}
</SCRIPT>

<div class="adv">
<h1>Advertise</h1>
<form action="CreateAds" enctype="multipart/form-data" method="post" name="frm">

		<table>
				
				<tr>
					<td>Title:</td>
					<td><input type="text" name="title" placeholder="Advertiser Name" size="30"></td>
				</tr>
				<tr>
					<td>ThemeImage:</td>
					<td><input type="file" name="image"  size="15"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><textarea rows="5" cols="25" name="description" placeholder="Description.........." ></textarea></td>
				</tr>
				<tr>
					<td>Image:</td>
					<td><input type="file" name="image1" size="15"><br><br>
					<input type="file" name="image2" size="15"><br><br>
					<input type="file" name="image3" size="15"></td>
				</tr>
				<tr>
					<td>Video:</td>
					<td><input type="file" name="video" size="15"></td>
				</tr>
				
					<%
		ArrayList<AdInfo> info = new ArrayList<AdInfo>();
	 info =DBmanager.getCategories();%>
<tr>
	<td>Category:</td>
	<td ><select name="category" >
	<% for(int i=0; i<info.size();i++){
	String cat=info.get(i).getCategory().toString();
	%>		 
<option size="30" value="<%=cat%>"><%=cat%> </option>
<%} %>
</select>
</td>
</tr>
					<%
		ArrayList<AdInfo> info1 = new ArrayList<AdInfo>();
	 info1 =DBmanager.getSubCategories();%>
<tr>
	<td>SubCategory:</td>
	<td ><select name="subcategory" >
	<% for(int i=0; i<info1.size();i++){
	String subcat=info1.get(i).getSubcategory().toString();
	%>		 
<option value="<%=subcat%>"><%=subcat%> </option>
<%} %>
</select>
</td>
</tr>
		
				<tr>
					<td>Type Add</td>
					<td>

						<select name="priority" >
								<option value="5">Free Add</option>
								<option value="4">Sponsored Add</option>
								<option value="3">Bucket Add</option> 
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="SUBMIT"></td>
					<td><input type="reset" value="RESET"></td>
				</tr>
				
		</table>
		
	</div>
</form>

</body>
</html>