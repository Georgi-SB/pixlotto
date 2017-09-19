<%@page pageEncoding="UTF-8" language="java" import="java.sql.*"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<%
	Cookie cookie    = null;
	Cookie[] cookies = null;
	cookies          = request.getCookies();
	String username  = "none";
	
	if( cookies != null ) {
		for ( int i = 0; i < cookies.length; i++ ) {
	        cookie = cookies[i];
	        
	        if( ( cookie.getName() ).equals( "loggedIn" ) ){
	        	username = cookie.getValue();
	        }
		}
	}
	else response.sendRedirect( "admin.jsp" );
	
	if ( username.equals( "none" ) ) response.sendRedirect( "admin.jsp" );
%>
<html>
	<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
	  		<a class="brand" href="/pixlotto/admin_homepage.jsp?lang=<%= request.getAttribute( "lang" ) %>">PixLotto</a>
	        <ul class="nav pull-right">
	          <li><br><nobr>Logged in as <b><%= username %></b>. <a href="/pixlotto/admin?op=logout" class="active">Log out</a></nobr></li>
	        </ul>
	      </div>
	    </div>
	    <div class="container span3">
		    <ul class="nav nav-list">
			    <li class="nav-header">Choose template to edit</li>
			    <li><a href="/pixlotto/admin?nav=home&lang=<%= request.getAttribute( "lang" ) %>">Homepage</a></li>
			    <li><a href="/pixlotto/admin?nav=menu1&lang=<%= request.getAttribute( "lang" ) %>">What is it good for</a></li>
			    <li class="active"><a href="/pixlotto/admin?nav=menu2&lang=<%= request.getAttribute( "lang" ) %>">Jackpot hunter</a></li>
			    <!--li><a href="/pixlotto/admin?nav=menu3&lang=<%= request.getAttribute( "lang" ) %>">Tell us your story</a></li-->
			    <li><a href="/pixlotto/admin?nav=cp&lang=<%= request.getAttribute( "lang" ) %>">Change password</a></li>
		    </ul>
		</div>
	    <div class="container span9">
			<div class="container-fluid">
				<form method="post" action="/pixlotto/admin">
       				<input type="hidden" name="lang" value="<%= request.getAttribute( "lang" ) %>">
       				<input type="hidden" name="op" value="menu2">
       				<% if ( request.getAttribute( "color" ) != null && request.getAttribute( "message" ) != null ) { %>
				    <div id="feedback"><font color="<%= request.getAttribute( "color" ) %>"><%= request.getAttribute( "message" ) %></font></div>
       				<% } %>
       				<div class="row-fluid">
						<div class="span12">
							<h4>Jackpot hunter&nbsp;&nbsp;&nbsp;
							<a href="/pixlotto/admin?nav=menu2&lang=en"><img src="img/us.png" /></a>&nbsp;
	    					<a href="/pixlotto/admin?nav=menu2&lang=de"><img src="img/de.png" /></a>&nbsp;
	    					<a href="/pixlotto/admin?nav=menu2&lang=bg"><img src="img/bg.png" /></a>&nbsp;
							</h4><br>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<b>Title</b><br>
							<input type="text" class="input-xxlarge" name="menu2_title" value="<%= request.getAttribute( "menu2_title" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Text</b><br>
							<textarea class="input-xxlarge" name="menu2_text" rows="20"><%= request.getAttribute( "menu2_text" ) %></textarea>
						</div>
					</div>
        			<div class="row-fluid">
						<br><input type="submit" value="Update texts" class="btn btn-primary btn-success">
					</div>
				</div>
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