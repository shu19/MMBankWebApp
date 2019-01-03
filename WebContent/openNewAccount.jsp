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
<title>HDFC Bank</title>


</head>
<body>
	<header>
		<jsp:include page="header.html"></jsp:include>
	</header>
	<div class="container col-md-4 col-md-offset-4">


		<form action="addNewAccount.mm">
			<div class="form-group">
				<label>Name :</label> <input type="text" class="form-control"
					placeholder="Name" pattern="[A-Za-z]+"
					title="Digits and Special Characters are not allowed"
					maxlength="25" name="txtAccHN">
			</div>


			<div class="form-group">
				<label>Initial Balance :</label> <input type="text"
					class="form-control" placeholder="Enter initial number"
					name="txtBal">
			</div>

			<div class="form-group">
				<label>Salary Account:</label> <input type="radio" name="rgSalary"
					value="Yes"> Yes <input type="radio" name="rgSalary"
					value="No"> No
			</div>


			<!-- 			<div class="form-group">
				<label>Email Id:</label> <input type="email" class="form-control"
					id="email" placeholder="Enter email">
			</div>
			<div class="form-group">
				<label>DOB :</label> <input type="date" class="form-control"
					placeholder="DOB">
			</div>

			<div class="form-group">
				<label>Phone number :</label> <input type="text"
					class="form-control" placeholder="Enter Phone number"
					pattern="[1-9]{1}[0-9]{9}" title="Enter 10 Digit Mobile Number"
					maxlength="10">
			</div>
 -->

			<!-- 			<label>Account Type :</label> <select class="btn btn-default">
				<option value="Saving">Saving</option>
				<option value="Current">Current</option>
			</select> <br />
 -->
			<div>
				<button type="submit" class="btn btn-default "
					style="margin-top: 16px;">Submit</button>
				<button type="reset" class="btn btn-danger "
					style="margin-top: 16px; float: right;">Reset</button>
			</div>

		</form>

	</div>

	<footer>
		<jsp:include page="footer.html"></jsp:include>
	</footer>
</body>
</html>