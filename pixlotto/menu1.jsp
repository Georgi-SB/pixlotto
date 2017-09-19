<%@page pageEncoding="UTF-8" language="java" import="java.sql.*"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta charset="utf-8"> 
	    <link href="scripts/bootstrap/css/bootstrap.css" rel="stylesheet">
	    <link href="scripts/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	    <script src="scripts/jquery-1.7.min.js" type="text/javascript"></script>
	    <link href="http://fonts.googleapis.com/css?family=Cuprum" rel="stylesheet" type="text/css">
	    <link href="scripts/fonts/foundation-icons-general/stylesheets/foundation-icons-general.css" rel="stylesheet" type="text/css" />
	    <link href="scripts/fonts/foundation-icons-social/stylesheets/foundation-icons-social.css" rel="stylesheet" type="text/css" />  
	    <script src="scripts/default.js" type="text/javascript"></script>
	    <link href="styles/custom.css" rel="stylesheet" type="text/css" />
	  	<title>PixLotto</title>
	    <style type="text/css">
	      .input-mini {
	        width: 140px;
	      }
	      
	      .input-xmini {
	        width: 80px;
	      }
	    </style>
	</head>
	<body id="pageBody">
		<div id="divBoxed" class="container">
		    <div class="transparent-bg" style="position: absolute;top: 0;left: 0;width: 100%;height: 90%;z-index: -1;zoom: 1;"></div>
		    <div class="headerArea">
		        <div class="divPanel notop nobottom">
		            <div class="row-fluid">
		                <div class="span6">
		                    <div id="divLogo">
		                        <a href="index.html" id="divSiteTitle">PixLotto</a><br />
		                        <a href="index.html" id="divTagLine"><%= request.getAttribute( "slogan" ) %></a>
		                    </div>
		                </div>
		                <div class="span6">
		                    <div class="pull-right">
				            <ul class="nav nav-pills ddmenu">
					            <li class="dropdown"><a href="main?lang=<%= request.getAttribute( "lang" ) %>">Home</a></li>
					            <li class="dropdown active"><a href="main?show=menu1&lang=<%= request.getAttribute( "lang" ) %>"><%= request.getAttribute( "menu1" ) %></a></li>
					            <li class="dropdown">
						            <a href="#" class="dropdown-toggle"><%= request.getAttribute( "menu2" ) %> <b class="caret"></b></a>
						            <ul class="dropdown-menu">
							            <li><a href="main?show=menu2&lang=<%= request.getAttribute( "lang" ) %>" class="dropdown-toggle">Australia</a></li>
							            <!--li><a href="#">Dropdown Item</a></li>
							            <li><a href="#">Dropdown Item</a></li-->
						            </ul>
					            </li>
					            <!--li class="dropdown"><a href="grid.html">Tell us your story</a></li-->
				            </ul>
				            <script type="text/javascript">
					            $(document).ready(function () {
						            jQuery('ul.nav li.dropdown').hover(function () {
							            jQuery(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn();
						            }, function () {
							            jQuery(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut();
						            });
					            });
				            </script> 
		                    </div>
		                </div>
		            </div>
				    <div class="pull-right">
				    	Switch language: 
				    	<a href="main?show=menu1&lang=en"><img src="img/us.png" /></a>&nbsp;
				    	<a href="main?show=menu1&lang=de"><img src="img/de.png" /></a>&nbsp;
				    	<a href="main?show=menu1&lang=bg"><img src="img/bg.png" /></a>&nbsp;
				    </div>
	            </div>
	        </div>
		    <div class="contentArea">
			    <div class="contentArea">
			        <div class="divPanel notop page-content" id="divMain">
			    	  <h1><%= request.getAttribute( "menu1_title" ) %></h1>
			    	  <p><%= request.getAttribute( "menu1_text" ) %></p>
			    	</div>
			    </div>
		    </div>
		    <div id="footerOuterSeparator"></div>
		    <div id="divFooter" class="footerArea">
		        <div class="divPanel">
		            <div class="row-fluid">
		            <div class="row-fluid">
		                <div class="span9">
		                    <p id="copyright">&copy; 2014 PixLotto. All Rights Reserved.</p>
		                    <p id="bookmarks">
		                        <a href="#"><span class="glyph social">e</span> Twitter</a>
		                        <a href="#"><span class="glyph social">d</span> Facebook</a>
		                    </p>
		                </div>
		                <div class="span3">
		                    <p>Your feedback is welcome:</p>
		                    <ul id="contact-info">
		                    <li>
		                        <span class="glyph general icon">h</span>
		                        <span class="field">Email:</span>
		                        <br />
		                        <a href="mailto:info@pixlotto.de" title="Email">feedback@pixlotto.de</a>
		                    </li>
		                    </ul>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</body>
</html>