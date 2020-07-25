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
    <div class="row">
        <div class="jumbotorn">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <strong>Transaction Status: ${result}</strong>
                    <br>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em>Receipt #: ${orderid}</em>
                    </p>
                </div>
            </div>
            <div class="row">
            	<div class="col-md-6 offset-md-3">
                <div class="text-center">
                    <h3>Receipt</h3>
                </div>
               
                <table class="table table-hover">
                 
                    <tbody>

                   		 <#list parameters?keys as key>
                    		<tr>
   								<td> ${key} </td>
   								<td> ${parameters[key]}</td>
   							</tr>
						</#list>
                    </tbody>
                </table>
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