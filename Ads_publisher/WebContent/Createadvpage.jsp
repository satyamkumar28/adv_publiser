<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="">
	<h1>Advertise</h1>
	<form action="Advertiser" method="post" enctype="multipart/form-data">
	
	<div class="adv">
		<table>
				<tr>
					<td>User Id</td>
					<td><input type="text" name="userid" placeholder="Email ID*" size="30"></td>
				</tr>
				<tr>
					<td>Title:</td>
					<td><input type="text" name="title" placeholder="Advertiser Name" size="30"></td>
				</tr>
				<tr>
					<td>ThemeImage:</td>
					<td><input type="file" name="image"  size="30"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><textarea rows="10" cols="30" name="description" placeholder="Description.........."></textarea></td>
				</tr>
				<tr>
					<td>Image:</td>
					<td><input type="file" name="image1"><br>
					<input type="file" name="image2"><br>
					<input type="file" name="image3"></td>
				</tr>
				<tr>
					<td>Video:</td>
					<td><input type="file" name="video"></td>
				</tr>
				<tr>
					<td>Category:</td>
					<td><input type="text" name="category" size="30"></td>
				</tr>
				<tr>
					<td>SubCategory:</td>
					<td><input type="text" name="subcategory" size="30"></td>
				</tr>
				<tr>
					<td>Type Add</td>
					<td>
						<select>
								<option name="select">--select Advertiser--</option>
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