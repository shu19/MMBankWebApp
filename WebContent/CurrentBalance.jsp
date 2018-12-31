<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Current Balance</title>
</head>
<body>

	<header> <jsp:include page="header.html"></jsp:include> </header>
	<div class="container col-md-4 col-md-offset-4">


		<form action="currentBalForm.mm">
			<div class="form-group">
				<label>Account Number :</label> <input type="text"
					class="form-control" placeholder="Account Number"
					name="txtAccountNumber">
			</div>

			<button type="submit" class="btn btn-default center-block"
				style="margin-top: 16px;">Submit</button>


		</form>

	</div>



	<footer> <jsp:include page="footer.html"></jsp:include> </footer>

</body>
</html>