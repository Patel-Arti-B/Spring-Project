<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.container-fluid {
	padding: 10px 16px;
	background: #555;
}

.footer {
	position: fixed;
	padding: 10px 16px;
	left: 10px;
	bottom: 10px;
	width: 100%;
	background-color: #555;
	color: #f1f1f1;
	text-align: center;
}

.footer a {
	color: #f1f1f1;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><strong style="color: white;">X-WORKZ
					COMMON MODULE</strong></a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Login.jsp"><strong style="color: white;">Login</strong></a></li>
			<li><a href="index.jsp"><strong style="color: white;">Home</strong></a></li>
		</ul>
	</div>
	</nav>
	<!-- Register form  -->
	<form action="register.do" method="post" modelAttribute="Register">
		<div class="form-group row">
			<label for="validationServer" class="col-sm-2 col-form-label">User
				ID:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="userId"
					placeholder="UserID" required>
				<div class="invalid-feedback">Please provide a valid UserId
					length should be 3 to 10.</div>
			</div>

		</div>
		<div class="form-group row">
			<label for="inputEmail" class="col-sm-2 col-form-label">Email:</label>
			<div class="col-sm-4">
				<input type="email" class="form-control" name="email"
					placeholder="email" required>
				<!-- <div class="invalid-feedback">Please provide a valid Email.</div> -->
			</div>
		</div>
		<div class="form-group row">
			<label for="inputPhoneNo" class="col-sm-2 col-form-label">Phone
				No:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="phone"
					placeholder="phone No" pattern="^\d{10}$" required>
				<!-- <div class="invalid-feedback">Please provide a valid PhoneNo.</div> -->
			</div>
		</div>
		<div class="form-group row">
			<label for="inputCourseInterested" class="col-sm-2 col-form-label">Course
				Interested:</label>
			<div class="col-sm-4">
				<select class="custom-select mr-sm-2" name="course">
					<option selected>Select...</option>
					<option value="1">Developer</option>
					<option value="2">Database administration</option>
					<option value="3">Software Quality Testing Automation</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label for="inputAgree" class="col-sm-2 col-form-label">Agree:</label>
			<div class="col-sm-4">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="agree"
						id="agree" value="disagree">Agree <input
						class="form-check-input" type="radio" name="agree" id="agree"
						value="disagree">Dis-Agree
				</div>
			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Register</button>
			</div>
		</div>
	</form>
	<h4>${disAgree}</h4>
	<h3>${useUserID}</h3>
	<h3>${useEmail}</h3>
	<h3>Password:${password}</h3>
	<h4>UserID:${Register.userId}</h4>
	<h4>Email:${Register.email}</h4>
	<%-- <p>Password:${Register.password }</p> --%>
	<div class="footer">
		<a href="#">xworkz.com</a>
	</div>
</body>
</html>