<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Withdraw</title>


<style>

</style>


</head>
<body>
	<header>
	<jsp:include page="header.html"></jsp:include>
	 </header>
	<div class="container col-md-4 col-md-offset-4">


		<form class="form-horizontal" action="withdrawForm.mm">
			<div class="form-group">
				<label class="control-label col-sm-5">Account No :</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" placeholder="Account No"
						name="txtAccNo">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-5">Amount to Withdraw :</label>
				<div class="col-sm-7">
					<input type="number" class="form-control" placeholder="Amount"
						name="txtAmount">
				</div>

			</div>


			<button type="submit" class="btn btn-default center-block"
				style="margin-top: 16px;">Withdraw</button>


		</form>

	</div>

	<footer>
	<jsp:include page="footer.html"></jsp:include> </footer>
</body>
</html>