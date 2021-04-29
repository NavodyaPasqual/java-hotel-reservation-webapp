<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/home.css" />
<link rel="stylesheet" type="text/css" href="styles/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>White Line Hotels</title>
</head>
<body>
	<nav>
		<div class="logo">
			<a href="index.jsp"><img src="images/mainLogo.png" width="183px" height="65px"></a>
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

	<div class="container">
		<input type="radio" id="i1" name="images" checked /> <input
			type="radio" id="i2" name="images" /> <input type="radio" id="i3"
			name="images" /> <input type="radio" id="i4" name="images" /> <input
			type="radio" id="i5" name="images" />

		<div class="slide_img" id="one">
			<img src="images/1.jpg"> <label class="prev" for="i5"><span>&#x2039;</span></label>
			<label class="next" for="i2"><span>&#x203a;</span></label>
		</div>

		<div class="slide_img" id="two">
			<img src="images/2.jpg"> <label class="prev" for="i1"><span>&#x2039;</span></label>
			<label class="next" for="i3"><span>&#x203a;</span></label>
		</div>

		<div class="slide_img" id="three">
			<img src="images/3.jpg"> <label class="prev" for="i2"><span>&#x2039;</span></label>
			<label class="next" for="i4"><span>&#x203a;</span></label>
		</div>
		<div class="slide_img" id="four">
			<img src="images/4.jpg"> <label class="prev" for="i3"><span>&#x2039;</span></label>
			<label class="next" for="i5"><span>&#x203a;</span></label>
		</div>
		<div class="slide_img" id="five">
			<img src="images/5.jpeg"> <label class="prev" for="i4"><span>&#x2039;</span></label>
			<label class="next" for="i1"><span>&#x203a;</span></label>
		</div>

		<div id="nav_slide">
			<label for="i1" class="dots" id="dot1"></label> <label for="i2"
				class="dots" id="dot2"></label> <label for="i3" class="dots"
				id="dot3"></label> <label for="i4" class="dots" id="dot4"></label> <label
				for="i5" class="dots" id="dot5"></label>
		</div>

	</div>
	<div class="about">
		<h1>About White Line Hotel</h1>
	</div>
	<div class="aboutp">
		<center>
			<p>
				A personal tropical sanctuary that is perfect for escaping the
				city,White Line Hotel,<br> Colombo overlooks the Indian Ocean
				in the heart of the business district and<br> the capital's
				buzzing social scene, with direct access to the most extensive
				international<br> shopping mall in Sri Lanka, White Line's own
				One Galle Face Mall.<br> The hotel offers the finest
				accommodation in Colombo, with 500 luxurious<br> guest rooms
				and suites, and 41 serviced apartments. It brings an exciting new
				dining<br> and social scene to the city, featuring outstanding
				restaurants and bars, an exclusive<br> Horizon Club Lounge and
				the largest and extensive hotel conference and event<br>
				facilities in the region, which can cater to up to 2,000 guests.
			</p>
		</center>
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