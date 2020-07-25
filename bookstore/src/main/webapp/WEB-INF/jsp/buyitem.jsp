<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Scart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Products</a></li>
			</ul>
		</div>
	</nav>
	<div class="row mt-3">
		<div class="col-md-6 offset-md-3">
			<form action="paynow" method="post">
				<div class="form-group">
					<label for="mobile">Mobile</label> <input
						type="text" class="form-control" id="mobile" name="CUST_ID">
				</div>
				<div class="form-group">
					<label for="mobile">Amount</label> <input
						type="text" class="form-control" id="mobile" name="TXN_AMOUNT" readonly="readonly" value="${product.price}">
				</div>
				<div class="form-group">
					 <button
						type="submit" class="btn btn-primary"> Paynow </button>
				</div>
			</form>
		</div>
	</div>


</body>
</html>