<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Fund Transfer</title>

</head>
<body>

	<header>
	<jsp:include page="header.html"></jsp:include>
	
	</header>
	<div class="container col-md-4 col-md-offset-4">


		<form action="fundTransferForm.mm">
			<div class="form-group">
				<label>Sender Account No :</label> <input type="text"
					class="form-control" placeholder="Account No" name="txtSenderAccNo">
			</div>
			<div class="form-group">
				<label>Receiver Account No</label> <input type="text" class="form-control"
					placeholder="Account No" name="txtReceiverAccNo">
			</div>
			<div class="form-group">
				<label>Amount To Transfer :</label> <input type="number"
					class="form-control" placeholder="Amount" name="txtAmount">
			</div>

			<div class="form-group">
				<label>Remarks :</label> <input type="text" class="form-control"
					placeholder="Remarks">
			</div>


			<button type="submit" class="btn btn-default center-block"
				style="margin-top: 16px;">Tranfer</button>


		</form>

	</div>

	<footer>
	<jsp:include page="footer.html"></jsp:include>
	
	</footer>

</body>
</html>