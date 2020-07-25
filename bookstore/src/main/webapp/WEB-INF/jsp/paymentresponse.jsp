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

	<div class="container">
	
		<div class="row">
			<a href="/">Home</a>
			<div class="col-md-6 offset-md-3">
				<strong>Transaction Status: ${result}</strong>
				<p>
					<em>Receipt #: ${orderid}</em>
				</p>
				<div class="text-center">
					<h3>Receipt</h3>
				</div>

				<table class="table table-hover">

					<tbody>
						<c:forEach var="entry" items="${parameters}" varStatus="status">
							<tr>
								<td>${entry.key}</td>
								<td>${entry.value}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	
</body>
</html>