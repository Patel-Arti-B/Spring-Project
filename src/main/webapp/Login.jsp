<html>
<head>
<title>Login</title>
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
				<li><a href="Register.jsp"><strong style="color: white;">Register</strong></a></li>
				<li><a href="index.jsp"><strong style="color: white;">Home</strong></a></li>
			</ul>
		</div>
	</nav>
	<div>
		<form action="login.do" method="post">
			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="email"
						placeholder="email" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Password:</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password"
						placeholder="password" required>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
	<h4>${validmsg}</h4>
	<div class="footer">
		<a href="#">xworkz.com</a>
	</div>
</body>
</html>