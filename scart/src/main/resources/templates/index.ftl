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
    <table class="table">
  	<thead>
    <tr>
      <th scope="col">PID</th>
      <th scope="col">PNAME</th>
      <th scope="col">PRICE</th>
      <th scope="col">Buy</th>
    </tr>
  </thead>
  <tbody>
    
    <#list model["products"] as product>
    <tr>
    
      <td>${product.pid}</td>
      <td>${product.name}</td>
      <td>${product.price}</td>
      <td><a href="/order?pid=${product.pid}">Buy</a></td>
    </tr>
   </#list>
  </tbody>
</table>
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