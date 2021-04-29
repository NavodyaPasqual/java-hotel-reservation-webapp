<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/Staff.css" />
<link rel="stylesheet" type="text/css" href="styles/main.css" />
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>White Line Hotels</title>
</head>

<body>
	<nav>
		<div class="logo">
			<a href="index.jsp"><img src="images/mainLogo.png" width="183px"
				height="65px"></a>
		</div>
		<a class="search-btn" href="#"> <img class="searchImg"
			src="images/Search.png">
		</a>
		<ul class="nav-links">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="#">Customer login</a></li>
			<li><a href="adminlogin.jsp">Admin login</a></li>
			<li><a href="#">Contact Us</a></li>
		</ul>
		<div class="burger">
			<div class="line1"></div>
			<div class="line2"></div>
			<div class="line3"></div>
		</div>
	</nav>
	<div class="box">
		<br>
		<h1>Staff Management</h1>
		<br>
		<hr>
		<br>
		<form method="POST" action="AddStaffServlet">
			<h3>Staff Name</h3>
			<br> <input type="text" name="staffName" />
			<h3>Address</h3>
			<br> <input type="text" name="address" />
			<h3>Occupation</h3>
			<br> <input type="text" name="occupation" />
			<h3>Email</h3>
			<br> <input type="text" name="email"
				pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
			<h3>Phone</h3>
			<br> <input type="text" name="phone" />
			<h3>User name</h3>
			<br> <input type="text" name="userName" />
			<h3>Gender</h3>
			<br> <input type="radio" name="gender" value="male" tabindex="1" />
			<label>Male</label><br> <input type="radio" name="gender"
				value="female" tabindex="2" /> <label>Female</label><br> <input
				type="submit" value="Add" class="add-button" /><br>
		</form>

		<form method="POST" action="ListStaffServlet">
			<input type="submit" value="List of the Staff" class="list-button" />
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
				<li><a href="#">Customer login</a></li>
				<li><a href="adminlogin.jsp">Admin login</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
		</div>
	</div>
	<script src="js/Main.js"></script>

</body>
</html>