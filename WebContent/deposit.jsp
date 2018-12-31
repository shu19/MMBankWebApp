<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Deposit</title>

</head>

<body>
	<header>
		<jsp:include page="header.html"></jsp:include>
	</header>
	<div class="container col-md-4 col-md-offset-4">

		<form action="depositForm.mm">
			<div class="form-group">
				<label>Account No :</label> <input type="text" class="form-control"
					placeholder="Account No" name="txtAccNo">
			</div>

			<div class="form-group">
				<label>Amount to Deposit :</label> <input type="number"
					class="form-control" placeholder="Amount" name="txtAmount">
			</div>


			<button type="submit" class="btn btn-default center-block"
				style="margin-top: 16px;">Deposit</button>

		</form>

	</div>

	<footer>
		<jsp:include page="footer.html"></jsp:include>
	</footer>
</body>
</html>