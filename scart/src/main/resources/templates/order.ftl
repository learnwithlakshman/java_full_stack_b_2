<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>Shopping Cart</title>
  </head>
  <body>

    <#include "header.ftl">
    
    <div class="container">
    <div class="row mt-3">
    <div class="col-md-6 offset-md-3">
    <div class="row mt-2">

			<div class="col-md-6 offset-md-3">

				<form action="/paynow" method="post">
					<div class="form-group">
						<label for="CUST_ID">Mobile Number</label> <input
							type="text" class="form-control" id="custId" name="CUST_ID"
							> <small class="form-text text-muted">Customer Mobile number</small>
					</div>
					<div class="form-group">
						<label for="TXN_AMOUNT">Transaction Amount</label> <input
							type="text" class="form-control" id="TXN_AMOUNT" name="TXN_AMOUNT" readonly value = ${model["product"].price}
 							> <small class="form-text text-muted">Transaction Amount</small>
					</div>
					<button type="submit" class="btn btn-primary">Paynow</button>
				</form>

			</div>

		</div>
   	
	</div>
	</div>
</div>    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jjquery-3.5.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>