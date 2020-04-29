<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forgot</title>
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
			<li><a href="Home.jsp"><strong style="color: white;">Home</strong></a></li>
			<li><a href="Login.jsp"><strong style="color: white;">Login</strong></a></li>
		</ul>
	</div>
	</nav>
	<form action="forgot.do" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="text-center">
								<h3>
									<i class="fa fa-lock fa-4x"></i>
								</h3>
								<h2 class="text-center">Forgot Password?</h2>
								<div class="panel-body">

									<form class="form">
										<fieldset>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-envelope color-blue"></i></span> <input
														id="email" name="email" placeholder="email address"
														class="form-control" type="email"
														oninvalid="setCustomValidity('Please enter a valid email address!')"
														onchange="try{setCustomValidity('')}catch(e){}"
														required="">
												</div>
											</div>
											<div class="form-group">
												<input class="btn btn-lg btn-primary btn-block"
													value="Reset Password" type="submit">
											</div>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<h3>New Password:${NewPassword}</h3>
	<h3>${validmsg}</h3>
	<h4>${forgot}</h4>
	<div class="footer">
		<a href="#">xworkz.com</a>
	</div>
</body>
</html>