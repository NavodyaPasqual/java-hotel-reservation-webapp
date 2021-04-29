<%@page import="com.model.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/Staff.css" />
<link rel="stylesheet" type="text/css" href="styles/main.css" />
<meta charset="ISO-8859-1">
<title>White Line Hotels</title>
</head>
<body>
	<nav>
		<div class="logo">
			<a href="#"><img src="images/mainLogo.png" width="133px"
				height="65px"></a>
		</div>
		<a class="search-btn" href="#"> <img class="searchImg"
			src="images/Search.png">
		</a>
		<ul class="nav-links">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="#">Customer login</a></li>
			<li><a href="#">Admin login</a></li>
			<li><a href="#">Contact Us</a></li>
		</ul>
		<div class="burger">
			<div class="line1"></div>
			<div class="line2"></div>
			<div class="line3"></div>
		</div>
	</nav>
	<br>
	<br>
	<div class="box">
		<h1>Get Staff Page</h1>
		<br>
		<hr>
		<br>
		<%
			Staff staff = (Staff) request.getAttribute("staff");
		%>
		<form method="POST" action="UpdateStaffServlet">
			<h3>Staff ID</h3>
			<br> <input type="text" name="staffID" disabled="disabled"
				value="<%=staff.getStaffID()%>" />
			<h3>Staff Name</h3>
			<br> <input type="text" name="staffName"
				value="<%=staff.getName()%>" />
			<h3>Address</h3>
			<br> <input type="text" name="address"
				value="<%=staff.getAddress()%>" />
			<h3>Occupation</h3>
			<br> <input type="text" name="occupation"
				value="<%=staff.getOccupation()%>" />
			<h3>Email</h3>
			<br> <input type="text" name="email"
				value="<%=staff.getEmail()%>" />
			<h3>Phone</h3>
			<br> <input type="text" name="phone"
				value="<%=staff.getPhone()%>" />
			<h3>User Name</h3>
			<br> <input type="text" name="userName"
				value="<%=staff.getUserName()%>" />
			<h3>Gender</h3>
			<br> <input type="radio" name="gender" value="male"
				 checked="checked" tabindex="1" />
				 <label>Male</label><br> 
				 <input type="radio" name="gender" value="female"  
				 tabindex="2" />
				 <label>Female</label><br> 
				 <input type="hidden" name="staffID" value="<%=staff.getStaffID()%>" />
				 <input type="submit" value="Update" class="update-button" />
		</form>

		<form method="POST" action="DeleteStaffServlet">
			<input type="hidden" name="staffID" value="<%=staff.getStaffID()%>" />
			<input type="submit" value="Delete" class="delete-button" />
		</form>
		<br>
	</div>
	<div class="footerMain">
		<div class="footerSMicon">
			<ul>
				<li><a href="https://www.facebook.com" target="_blank"><img
						src="images/facebookLogo.png" title="Facebook"></a></li>
				<li><a href="https://twitter.com" target="_blank"><img
						src="images/twitterLogo.png" title="Twitter"></a></li>
				<li><a href="https://www.instagram.com" target="_blank"><img
						src="images/instagramLogo.png" title="Instagram"></a></li>
				<li><a href="https://aboutme.google.com/u/0/?referer=gplus"
					target="_blank"><img src="images/googlePlusLogo.png"
						title="Google+"></a></li>
				<li><a href="https://www.youtube.com" target="_blank"><img
						src="images/youtubeLogo.png" title="YouTube"></a></li>
			</ul>
		</div>
		<div class="footerPages">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="login.jsp">Customer login</a></li>
				<li><a href="#">Admin login</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
		</div>
	</div>
	<script src="js/Main.js"></script>
</body>
</html>