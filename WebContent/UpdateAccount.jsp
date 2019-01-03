<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>
<body>
	<header> <jsp:include page="header.html"></jsp:include> </header>

	<div class="container col-md-4 col-md-offset-4">


		<form action="updateSavingAccount.mm">
			<div class="form-group">
				<label>Account No :</label> <input type="text" class="form-control"
					placeholder="Name" maxlength="25" name="txtAccNo"
					value="${requestScope.account.bankAccount.accountNumber}">
			</div>


			<div class="form-group">
				<label>Name :</label> <input type="text" class="form-control"
					placeholder="Name" maxlength="25" name="txtAccHN"
					value="${requestScope.account.bankAccount.accountHolderName}">
			</div>

			<div class="form-group">
				<label>Account Balance :</label> <input type="text" class="form-control"
					placeholder="Name" maxlength="25" name="txtAccBal"
					value="${requestScope.account.bankAccount.accountBalance}">
			</div>

			<div class="form-group">

				<label>Salary Account:</label>
				<jstl:if test="${requestScope.account.salary == true}">
					<input type="radio" name="rgSalary" value="Yes" checked> Yes				
				<input type="radio" name="rgSalary" value="No"> No
				</jstl:if>
				<jstl:if test="${requestScope.account.salary == false}">
					<input type="radio" name="rgSalary" value="Yes"> Yes				
				<input type="radio" name="rgSalary" value="No" checked> No
				</jstl:if>

			</div>

			<div>
				<button type="submit" class="btn btn-default "
					style="margin-top: 16px;">Submit</button>
				<button type="reset" class="btn btn-danger "
					style="margin-top: 16px; float: right;">Reset</button>
			</div>

		</form>


	</div>
	<footer> <jsp:include page="footer.html"></jsp:include> </footer>
</body>
</html>