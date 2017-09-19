<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
	<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"> 
    <link href="css/bootstrap.css" rel="stylesheet">
  	<link href="css/datepicker.css" rel="stylesheet">
  	<title>PixLotto</title>
    <style type="text/css">
      .navbar-inner {
		    height: 60px;  
		    background: #336699;
	  }

	.navbar .brand {
	    color: #FFFFFF;
	    display: block;
	    float: left;
	    font-size: 40px;
	    font-weight: 200;
	    margin-left: -20px;
	    padding: 10px 20px;
	    margin-top: 10px;
	    text-shadow: 0 1px 0 #FFFFFF;
	}

	.navbar .nav > li > a {
	    color: #FFFFFF;
	    float: none;
	    padding: 10px 15px;
	    margin-top: 20px;
	    text-decoration: none;
	    text-shadow: 0 1px 0 #FFFFFF;
	}
      .text-larger {
	    font-size: 18px;
      }
      .input-mini {
        width: 140px;
      }
      
      .input-xmini {
        width: 80px;
      }
      
      .luckyNumbers {
        font-weight: bold;
        color: #EFD10B;
        font-size: 25px;
      }
      
      .gradient {
			background: #87bcea; /* Old browsers */
			background: -moz-linear-gradient(left, #87bcea 0%, #ffffff 21%, #ffffff 50%, #ffffff 79%, #87bcea 100%); /* FF3.6+ */
			background: -webkit-gradient(linear, left top, right top, color-stop(0%,#87bcea), color-stop(21%,#ffffff), color-stop(50%,#ffffff), color-stop(79%,#ffffff), color-stop(100%,#87bcea)); /* Chrome,Safari4+ */
			background: -webkit-linear-gradient(left, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* Chrome10+,Safari5.1+ */
			background: -o-linear-gradient(left, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* Opera 11.10+ */
			background: -ms-linear-gradient(left, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* IE10+ */
			background: linear-gradient(to right, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* W3C */
			filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#87bcea', endColorstr='#87bcea',GradientType=1 ); /* IE6-9 */
	   }      
    </style>
	</head>
	<body class="gradient">
    <div class="container">
	    <div class="navbar">
	      <div class="navbar-inner">
	  		<a class="brand" href="/">PixLotto</a>
	        <ul class="nav pull-right">
	          <li><a href="/" class="active">Admin</a></li>
	        </ul>
	      </div>
	    </div>
	    <div align="center" style="color: red;"><%= ( request.getAttribute( "error" ) != null ) ? request.getAttribute( "error" ) : "" %></div>
	    <hr>
	    <div align="center" class="text-larger">
	        <form method="post" action="admin">
	        	<input type="hidden" name="op" value="login">
	            <center>
	            <table width="40%" cellpadding="3">
	                <tbody>
	                    <tr>
	                        <td>User Name</td>
	                        <td><input type="text" name="username" autofocus></td>
	                    </tr>
	                    <tr>
	                        <td>Password</td>
	                        <td><input type="password" name="password"></td>
	                    </tr>
	                    <tr>
	                        <td></td>
	                        <td><input type="submit" value="Login" class="btn btn-primary btn-success" ></td>
	                    </tr>
	                </tbody>
	            </table>
	            </center>
	        </form>
	    </div>
		<hr>
	</div>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"> </script>
    <script type="text/javascript" src="js/bootstrap-datepicker.js"> </script>
    <script type="text/javascript" src="js/jquery.chained.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery.form.min.js" charset="utf-8"></script>
	</body>
</html>