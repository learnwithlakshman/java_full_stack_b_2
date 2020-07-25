<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paytm Payment Integration</title>
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
		<div class="mr-0">
		Hello: ${user}
		&nbsp; <a href="/logout">Logout</a>
		</div>
	</nav>

	<div class="row mt-3">
		<div class="col-md-6 offset-md-3">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">PID</th>
						<th scope="col">PNAME</th>
						<th scope="col">PRICE</th>
						<th scope="col">BUY</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<th>${product.pid}</th>
							<td>${product.pname}</td>
							<td>${product.price}</td>
							<td><a href='buyitem?pid=${product.pid}'>Buy</a></td>

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>


</body>
</html>