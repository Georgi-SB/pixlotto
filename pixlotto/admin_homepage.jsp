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
	  		<a class="brand" href="/pixlotto/admin?nav=home&lang=<%= request.getAttribute( "lang" ) %>">PixLotto</a>
	        <ul class="nav pull-right">
	          <li><br><nobr>Logged in as <b><%= username %></b>. <a href="/pixlotto/admin?op=logout" class="active">Log out</a></nobr></li>
	        </ul>
	      </div>
	    </div>
	    <div class="container span3">
		    <ul class="nav nav-list">
			    <li class="nav-header">Choose template to edit</li>
			    <li class="active"><a href="/pixlotto/admin?nav=home&lang=<%= request.getAttribute( "lang" ) %>">Homepage</a></li>
			    <li><a href="/pixlotto/admin?nav=menu1&lang=<%= request.getAttribute( "lang" ) %>">What is it good for</a></li>
			    <li><a href="/pixlotto/admin?nav=menu2&lang=<%= request.getAttribute( "lang" ) %>">Jackpot hunter</a></li>
			    <!--li><a href="/pixlotto/admin?nav=menu3&lang=<%= request.getAttribute( "lang" ) %>">Tell us your story</a></li-->
			    <li><a href="/pixlotto/admin?nav=cp&lang=<%= request.getAttribute( "lang" ) %>">Change password</a></li>
		    </ul>
		</div>
	    <div class="container span9">
			<div class="container-fluid">
				<form method="post" action="/pixlotto/admin">
       				<input type="hidden" id="lang" name="lang" value="<%= request.getAttribute( "lang" ) %>">
       				<input type="hidden" name="op" value="homepage">
       				<% if ( request.getAttribute( "color" ) != null && request.getAttribute( "message" ) != null ) { %>
				    <div id="feedback"><font color="<%= request.getAttribute( "color" ) %>"><%= request.getAttribute( "message" ) %></font></div>
       				<% } %>
       				<div class="row-fluid">
						<div class="span12">
							<h4>Main page&nbsp;&nbsp;&nbsp;
							<a href="/pixlotto/admin?nav=home&lang=en"><img src="img/us.png" /></a>&nbsp;
	    		    		<a href="/pixlotto/admin?nav=home&lang=de"><img src="img/de.png" /></a>&nbsp;
	    		    		<a href="/pixlotto/admin?nav=home&lang=bg"><img src="img/bg.png" /></a>&nbsp;
	    		    		</h4><br>
	    		    	</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<b>Slogan</b><br>
							<input type="text" class="input-xxlarge" name="slogan" value="<%= request.getAttribute( "slogan" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Explanation title</b><br>
							<input type="text" class="input-xxlarge" name="top_title" value="<%= request.getAttribute( "top_title" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Explanation text</b><br>
							<textarea class="input-xxlarge" name="top_text" rows="7"><%= request.getAttribute( "top_text" ) %></textarea>
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Choose image</b><br>
							<input type="text" class="input-xxlarge" name="choose_image" value="<%= request.getAttribute( "choose_image" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Choose date</b><br>
							<input type="text" class="input-xxlarge" name="choose_date" value="<%= request.getAttribute( "choose_date" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Choose lotto</b><br>
							<input type="text" class="input-xxlarge" name="choose_lotto" value="<%= request.getAttribute( "choose_lotto" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Main button</b><br>
							<input type="text" class="input-xxlarge" name="main_button" value="<%= request.getAttribute( "main_button" ) %>">
						</div>
					</div>
					<br><br>
      				<div class="row-fluid">
						<div class="span12"><h4>Menu buttons</h4>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Menu 1</b><br>
							<input type="text" class="input-xxlarge" name="menu1" value="<%= request.getAttribute( "menu1" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Menu 2</b><br>
							<input type="text" class="input-xxlarge" name="menu2" value="<%= request.getAttribute( "menu2" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Menu 3</b><br>
							<input type="text" class="input-xxlarge" name="menu3" value="<%= request.getAttribute( "menu3" ) %>">
						</div>
					</div>
					<br><br>
      				<div class="row-fluid">
						<div class="span12"><h4>Affilliates</h4>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Lotto country</b>&nbsp;&nbsp;&nbsp;
							<select id="lottoland" name="lottoland" class="input-small input-xmini">
					            <%= request.getAttribute( "lottoLandOptions" ) %>
					        </select><br>
						</div>
					</div>
					<br>
      				<div class="row-fluid">
						<div class="span12"><h5>Partner ad 1</h5>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>title</b><br>
							<input type="text" id="a1_title" name="a1_title" class="input-xxlarge" value="<%= ( request.getAttribute( "a1_title" ) == null ? "" : ( ((String) request.getAttribute( "a1_title" )).trim().equals( "" ) ? "" : request.getAttribute( "a1_title" ) ) ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>text</b><br>
							<textarea id="a1_text" name="a1_text" class="input-xxlarge"><%= ( request.getAttribute( "a1_text" ) == null ? "" : ( ((String) request.getAttribute( "a1_text" )).trim().equals( "" ) ? "" : request.getAttribute( "a1_text" ) ) ) %></textarea>
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>url</b><br>
							<input type="text" id="a1_url" name="a1_url" class="input-xxlarge" value="<%= ( request.getAttribute( "a1_url" ) == null ? "" : ( ((String) request.getAttribute( "a1_url" )).trim().equals( "" ) ? "" : request.getAttribute( "a1_url" ) ) ) %>">
						</div>
					</div>
					<br>
      				<div class="row-fluid">
						<div class="span12"><h5>Partner ad 2</h5>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>title</b><br>
							<input type="text" id="a2_title" name="a2_title" class="input-xxlarge" value="<%= ( request.getAttribute( "a2_title" ) == null ? "" : ( ((String) request.getAttribute( "a2_title" )).trim().equals( "" ) ? "" : request.getAttribute( "a2_title" ) ) ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>text</b><br>
							<textarea id="a2_text" name="a2_text" class="input-xxlarge"><%= ( request.getAttribute( "a2_text" ) == null ? "" : ( ((String) request.getAttribute( "a2_text" )).trim().equals( "" ) ? "" : request.getAttribute( "a2_text" ) ) ) %></textarea>
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>url</b><br>
							<input type="text" id="a2_url" name="a2_url" class="input-xxlarge" value="<%= ( request.getAttribute( "a2_url" ) == null ? "" : ( ((String) request.getAttribute( "a2_url" )).trim().equals( "" ) ? "" : request.getAttribute( "a2_url" ) ) ) %>">
						</div>
					</div>
					<br>
      				<div class="row-fluid">
						<div class="span12"><h5>Partner ad 3</h5>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>title</b><br>
							<input type="text" id="a3_title" name="a3_title" class="input-xxlarge" value="<%= ( request.getAttribute( "a3_title" ) == null ? "" : ( ((String) request.getAttribute( "a3_title" )).trim().equals( "" ) ? "" : request.getAttribute( "a3_title" ) ) ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>text</b><br>
							<textarea id="a3_text" name="a3_text" class="input-xxlarge"><%= ( request.getAttribute( "a3_text" ) == null ? "" : ( ((String) request.getAttribute( "a3_text" )).trim().equals( "" ) ? "" : request.getAttribute( "a3_text" ) ) ) %></textarea>
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>url</b><br>
							<input type="text" id="a3_url" name="a3_url" class="input-xxlarge" value="<%= ( request.getAttribute( "a3_url" ) == null ? "" : ( ((String) request.getAttribute( "a3_url" )).trim().equals( "" ) ? "" : request.getAttribute( "a3_url" ) ) ) %>">
						</div>
					</div>
					<hr>
        			<div class="row-fluid">
						<div class="span12">
							<b>Partner link text</b><br>
							<input type="text" class="input-xxlarge" name="play_now" value="<%= request.getAttribute( "play_now" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>footer copyright text</b><br>
							<input type="text" class="input-xxlarge" name="footer_copyright_notice" value="<%= request.getAttribute( "footer_copyright_notice" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>footer email text</b><br>
							<input type="text" class="input-xxlarge" name="footer_email_notice" value="<%= request.getAttribute( "footer_email_notice" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>footer email title</b><br>
							<input type="text" class="input-xxlarge" name="footer_email_title" value="<%= request.getAttribute( "footer_email_title" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>footer email adress</b><br>
							<input type="text" class="input-xxlarge" name="footer_email_adress" value="<%= request.getAttribute( "footer_email_adress" ) %>">
						</div>
					</div>
        			<div class="row-fluid">
						<div class="span12">
							<b>Main button</b><br>
							<input type="text" class="input-xxlarge" name="main_button" value="<%= request.getAttribute( "main_button" ) %>">
						</div>
					</div>
        			<div class="row-fluid offset2">
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
    <script type="text/javascript">
		$( "#lottoland" ).change( function() {
			$.ajax({
				dataType: "JSON",
				type: "POST",
				url: "adminJSON",
				data: { lang: $( "#lang" ).val(), land: $( "#lottoland" ).val() }
			})
			.done( function( data ) {
				for ( var i = 1; i <= 3; i++ ) {
					$( "#a" + i + "_title" ).val( "" );
					$( "#a" + i + "_text" ).val( "" );
					$( "#a" + i + "_url" ).val( "" );
				}
				$.each( data, function( key, val ) {
					//console.log( val.htmlid + ":" + val.value );
					if ( val.value != "null" )
						$( "#" + val.htmlid ).val( val.value.replace( "null", "" ) );
					else
						$( "#" + val.htmlid ).val( "" );
				});
			});
			/*
				$( "#affilliates" ).text( data );
			});
			*/
		});
    </script>
	</body>
</html>