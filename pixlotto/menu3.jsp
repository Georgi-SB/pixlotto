<%@page pageEncoding="UTF-8" language="java" import="java.sql.*"%>
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
	  		<a class="brand" href="/pixlotto/main?lang=<%= request.getAttribute( "lang" ) %>">PixLotto</a>
	        <ul class="nav pull-right">
	          <li><a href="/pixlotto/main?lang=<%= request.getAttribute( "lang" ) %>" class="active"><%= request.getAttribute( "slogan" ) %></a></li>
	        </ul>
	      </div>
	    </div>
	    <div align="justify" class="span8 offset2">
	    	  <h3 align="center"><%= request.getAttribute( "menu3_title" ) %></h3>
	    	  <p><%= request.getAttribute( "menu3_text" ) %></p>
	    </div>
  	  <div align="center" class="span8 offset2"> 
	    <br>
	    <input type="text" class="input-xxlarge" name="email" value="Enter your email here"><br>
	    <textarea class="input-xxlarge" name="text" rows="7">Enter your message here</textarea><br>
  	  	<button class="btn btn-lg btn-primary"><%= request.getAttribute( "send_button" ) %></button><br><br>
  	  </div>
		<hr>
	    <div align="center">
		  <!--p>
	 	  	<a href="main?lang=<%= request.getAttribute( "lang" ) %>">
	 	  		<button onclick="location.href='/main'" class="btn btn-large btn-success"><%= request.getAttribute( "main_button" ) %></button>
	 	  	</a-->
	 	  </p>
	      <p>
	 	  	<a href="main?lang=<%= request.getAttribute( "lang" ) %>"><button class="btn btn-lg btn-success"><%= request.getAttribute( "main_button" ) %></button></a>
	        <a href="main?show=menu1&lang=<%= request.getAttribute( "lang" ) %>"><button class="btn btn-lg btn-primary"><%= request.getAttribute( "menu1" ) %></button></a>
	        <a href="main?show=menu2&lang=<%= request.getAttribute( "lang" ) %>"><button class="btn btn-lg btn-primary"><%= request.getAttribute( "menu2" ) %></button></a>
	        <a href="main?show=menu3&lang=<%= request.getAttribute( "lang" ) %>"><button class="btn btn-lg btn-warning"><%= request.getAttribute( "menu3" ) %></button></a>
	        <!--a href="main?show=menu4&lang=<%= request.getAttribute( "lang" ) %>"><button class="btn btn-lg btn-primary"><%= request.getAttribute( "menu4" ) %></button></a-->
	      </p>
	    </div>
	</body>
</html>