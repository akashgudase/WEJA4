<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navigation Page</title>
<style type="text/css">
#box {
	height: 50px;
	background-color: gray;
	border: 3px solid;
}

a {
	height: 30px;
	width: 60px;
	background-color: black;
	color: gray;
	margin-left: 30px;
	border-radius: 5px;
	padding: 10px;
	font-size: 20px;
	text-decoration: none;
}

nav {
	width: 750px;
	margin-top: 15px;
	margin-left: 700px;
	margin-top: 15px;
}
</style>
</head>
<body>
	<div id="box" align="center">
		<nav>
			<a href="add_page">ADD</a> <a href="cars">All CARS</a> <a
				href="my_cars">MY CARS</a> <a href="sign_out">SIGN OUT</a> <a
				href="delete_user">DELETE ACCOUNT</a>
		</nav>
	</div>
</body>
</html>