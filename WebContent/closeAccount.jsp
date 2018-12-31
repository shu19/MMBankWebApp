<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Close Account</title>
</head>
<body>
	<header>
		<jsp:include page="header.html"></jsp:include>

	</header>

	<div class="container col-md-4 col-md-offset-4">

		<form action="closeAccount.mm">
			<div class="form-group">
			<label>Account No :</label>
				<input type="text" name="accountNumber" />
				 
				<input type="submit">
			</div>
		</form>
	</div>

	<footer>
		<jsp:include page="footer.html"></jsp:include>

	</footer>
</body>
</html>