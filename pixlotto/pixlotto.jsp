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
	  	<link href="css/datepicker.css" rel="stylesheet">
	    <link href="scripts/fonts/foundation-icons-general/stylesheets/foundation-icons-general.css" rel="stylesheet" type="text/css" />
	    <link href="scripts/fonts/foundation-icons-social/stylesheets/foundation-icons-social.css" rel="stylesheet" type="text/css" />  
	    <link href="scripts/camera/css/camera.css" rel="stylesheet" type="text/css" />
	    <link href="http://fonts.googleapis.com/css?family=Cuprum" rel="stylesheet" type="text/css">
	    <link href="styles/custom.css" rel="stylesheet" type="text/css" />
	    <script src="scripts/jquery-1.7.min.js" type="text/javascript"></script>
	    <script src="scripts/default.js" type="text/javascript"></script>
	    <script src="scripts/camera/scripts/camera.min.js" type="text/javascript"></script>
	    <script src="scripts/easing/jquery.easing.1.3.js" type="text/javascript"></script>
	    <script src="scripts/camera/scripts/jquery.mobile.customized.min.js" type="text/javascript"></script>
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
				            <li class="dropdown active"><a href="main?lang=<%= request.getAttribute( "lang" ) %>">Home</a></li>
				            <li class="dropdown"><a href="main?show=menu1&lang=<%= request.getAttribute( "lang" ) %>"><%= request.getAttribute( "menu1" ) %></a></li>
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
			    	<a href="main?lang=en"><img src="img/us.png" /></a>&nbsp;
			    	<a href="main?lang=de"><img src="img/de.png" /></a>&nbsp;
			    	<a href="main?lang=bg"><img src="img/bg.png" /></a>&nbsp;
			    </div>
			    <form action="main" method="post" enctype="multipart/form-data" id="luckyform">
			    <input type="hidden" name="lang" value="<%= request.getAttribute( "lang" ) %>">
	            <div class="row-fluid">
	                <div class="span12">
	                    <div id="headerSeparator"></div>
	                    <div class="row-fluid">
	                        <div class="span6">
	                            <div id="divHeaderText" class="page-content">
	                                <div id="divHeaderLine2"><%= request.getAttribute( "choose_image" ) %></div>
	                                <input type="file" name="file" id="image-upload">
	                                <!--div id="divHeaderLine3"><a class="btn btn-large btn-secondary" href="#">Secondary Button</a>    <a class="btn btn-large btn-primary" href="#">Primary Button</a></div-->
	                                <br><br>
	                                <div id="divHeaderLine2"><%= request.getAttribute( "choose_lotto" ) %></div>
							        <select id="lottoland" name="lottoland" class="input-small input-xmini">
							            <%= request.getAttribute( "lottoLandOptions" ) %>
							        </select>
							        <select id="lottotype" name="lottotype" class="input-small input-mini">
							            <%= request.getAttribute( "lottoTypeOptions" ) %>
							        </select>
	                                <!--div id="divHeaderLine2"><a class="btn btn-large btn-secondary" href="#">Secondary Button</a>    </div-->
	                            </div><br>
	                            <!--a class="btn btn-large btn-primary" onclick="submitForm()" href="#"><b><%= request.getAttribute( "main_button" ) %></b></a-->
						        <button id="fat-btn" class="btn btn-large btn-primary" data-loading-text="Calculating..."><%= request.getAttribute( "main_button" ) %></button>
	                        </div>
	                        <div class="span6">
	                            <div id="camera_wrap" class="upload-preview">
	                            	<img src="styles/jumping.jpg" style="max-width: 100%; max-height: 100%">
	                                <!--div data-src="styles/jumping.jpg" ><div class="camera_caption fadeFromBottom">Caption 1 here..</div></div>
	                                <div data-src="styles/camera.jpg" ><div class="camera_caption fadeFromBottom">Caption 2 here..</div></div>
	                                <div data-src="styles/smile.jpg" ><div class="camera_caption fadeFromBottom">Caption 3 here..</div></div>
	                                <div data-src="styles/children.jpg" ><div class="camera_caption fadeFromBottom">Caption 4 here..</div></div-->
	                            </div>
	                            <!--script type="text/javascript">
	                                function startCamera() {
	                                    $('#camera_wrap').camera({ fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, height: '65%', pagination: true });
	                                    /*fx: 'random','simpleFade', 'curtainTopLeft', 'curtainTopRight', 'curtainBottomLeft', 'curtainBottomRight', 'curtainSliceLeft', 'curtainSliceRight', 'blindCurtainTopLeft', 'blindCurtainTopRight', 'blindCurtainBottomLeft', 'blindCurtainBottomRight', 'blindCurtainSliceBottom', 'blindCurtainSliceTop', 'stampede', 'mosaic', 'mosaicReverse', 'mosaicRandom', 'mosaicSpiral', 'mosaicSpiralReverse', 'topLeftBottomRight', 'bottomRightTopLeft', 'bottomLeftTopRight', 'bottomLeftTopRight', 'scrollLeft', 'scrollRight', 'scrollHorz', 'scrollBottom', 'scrollTop'*/
	                                }
	                                $(function () {
	                                    startCamera();
	                                });
	                            </script-->
	                        </div>
	                    </div>
	                    <div id="headerSeparator2"></div>
	                </div>
	            </div>
	            </form>
	        </div>
	    </div>
	    <div class="contentArea">
	        <div class="divPanel notop page-content">
	            <div class="row-fluid">
	                <div class="span12" id="divMain">
	                    <div id="divHeaderLine1" align="center" style="display: none;">lucky numbers: <b style="color: rgb(137, 0, 0);" id="luckyNumbers">1, 3, 9, 23, 24, 41</b></div>
	                    <div id="lottoPartner" class="row-fluid" style="display: none;">
	                        <div class="span4" id="a1_panel">
	                            <div class="page-content"> 
	                                <h2 id="a1_title">Lotto Partner Option 1</h2>
	                                <p>
		                                <div id="a1_text">At this lotto partner you multiply your winning chances by 1000.</div>
		                                <a id="a1_url" href="#"><b><%= request.getAttribute( "play_now" ) %> &raquo;</b></a>
		                            </p>
	                            </div>
	                        </div>
	                        <div class="span4" id="a2_panel">
	                            <div class="page-content"> 
	                                <h2 id="a2_title">Lotto Partner Option 2</h2>
	                                <p>
		                                <div id="a2_text">At this lotto partner you multiply your winning chances by 1000.</div>
		                                <a id="a2_url" href="#"><b><%= request.getAttribute( "play_now" ) %> &raquo;</b></a>
		                            </p>
	                            </div>
	                        </div>
	                        <div class="span4" id="a3_panel">
	                            <div class="page-content"> 
	                                <h2 id="a3_title">Lotto Partner Option 3</h2>
	                                <p>
		                                <div id="a3_text">At this lotto partner you multiply your winning chances by 1000.</div>
		                                <a id="a3_url" href="#"><b><%= request.getAttribute( "play_now" ) %> &raquo;</b></a>
		                            </p>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div id="info">
	                    <h1><%= request.getAttribute( "top_title" ) %></h1>
	                    <%= request.getAttribute( "top_text" ) %> 
                    </div>
	            </div>
	            <div id="footerInnerSeparator"></div>
	        </div>
	    </div>
	    <div id="footerOuterSeparator"></div>
	    <div id="divFooter" class="footerArea">
	        <div class="divPanel">
	            <div class="row-fluid">
	            <div class="row-fluid">
	                <div class="span9">
	                    <p id="copyright">&copy; <%= request.getAttribute( "footer_copyright_notice" ) %></p>
	                    <p id="bookmarks">
	                        <a href="#"><span class="glyph social">e</span> Twitter</a>
	                        <a href="#"><span class="glyph social">d</span> Facebook</a>
	                    </p>
	                </div>
	                <div class="span3">
	                    <p><%= request.getAttribute( "footer_email_notice" ) %></p>
	                    <ul id="contact-info">
	                    <li>
	                        <span class="glyph general icon">h</span>
	                        <span class="field"><%= request.getAttribute( "footer_email_title" ) %></span>
	                        <br />
	                        <a href="mailto:<%= request.getAttribute( "footer_email_adress" ) %>" title="Email"><%= request.getAttribute( "footer_email_adress" ) %></a>
	                    </li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<br /><br /><br />
    <script type="text/javascript" src="js/bootstrap.js"> </script>
    <script type="text/javascript" src="js/bootstrap-datepicker.js"> </script>
    <script type="text/javascript" src="js/jquery.chained.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery.form.min.js" charset="utf-8"></script>
  	<script type="text/javascript">
		$("#lottotype").chained("#lottoland");
	
	    var preview = $(".upload-preview img");
	
		$("#image-upload").change(function(event){
		     $(".luckyNumbers").html( "" );
		  	 var input = $(event.currentTarget);
		     var file = input[0].files[0];
		     var reader = new FileReader();
		     reader.onload = function(e){
		         image_base64 = e.target.result;
		         preview.attr("src", image_base64);
		     };
		     reader.readAsDataURL(file);
		});

		$('#fat-btn').click(function () {
	        var btn = $(this);
	        btn.button('loading');
	    	
	    	$('#luckyform')
			    .ajaxForm({
		        url : 'main',
        		dataType : 'json',
		        success : function (response) {
		        	if ( response.status == "success" ) {
		        		var numbers = response.luckyNumbers;
		        		
						$("#info").hide(500);
						$("#divHeaderLine1").hide(500);
						$("#lottoPartner").hide(500);

		        		if ( response.super != "" ) numbers += ' Super: ' + response.super;
						$("#luckyNumbers").html( numbers );
						//$("#lottoPartner").html( response.lottoPartner.replace( /\/g,"") );
						
						if ( response.partners == "0" ) {
							$( "#a1_panel" ).attr( "style","display: none;" ); 
							$( "#a2_panel" ).attr( "style","display: none;" ); 
							$( "#a3_panel" ).attr( "style","display: none;" ); 
						}
						else if ( response.partners == "1" ) {
							$( "#a1_panel" ).attr( "style","visibility: inline;" ).attr( "class","span12" ); 
							$( "#a2_panel" ).attr( "style","display: none;" ); 
							$( "#a3_panel" ).attr( "style","display: none;" ); 
							
							$( "#a1_title" ).html( response.a1_title );
							$( "#a1_text" ).html( response.a1_text );
							$( "#a1_url" ).attr( "href", response.a1_url );
						}
						else if ( response.partners == "2" ) {
							$( "#a1_panel" ).attr( "style","visibility: inline;" ).attr( "class","span6" ); 
							$( "#a2_panel" ).attr( "style","visibility: inline;" ).attr( "class","span6" ); 
							$( "#a3_panel" ).attr( "style","display: none;" ); 
							
							$( "#a1_title" ).html( response.a1_title );
							$( "#a1_text" ).html( response.a1_text );
							$( "#a1_url" ).attr( "href", response.a1_url );
							$( "#a2_title" ).html( response.a2_title );
							$( "#a2_text" ).html( response.a2_text );
							$( "#a2_url" ).attr( "href", response.a2_url );
						}
						else if ( response.partners == "3" ) {
							$( "#a1_panel" ).attr( "style","visibility: inline;" ).attr( "class","span4" ); 
							$( "#a2_panel" ).attr( "style","visibility: inline;" ).attr( "class","span4" ); 
							$( "#a3_panel" ).attr( "style","visibility: inline;" ).attr( "class","span4" ); 
							
							$( "#a1_title" ).html( response.a1_title );
							$( "#a1_text" ).html( response.a1_text );
							$( "#a1_url" ).attr( "href", response.a1_url );
							$( "#a2_title" ).html( response.a2_title );
							$( "#a2_text" ).html( response.a2_text );
							$( "#a2_url" ).attr( "href", response.a2_url );
							$( "#a3_title" ).html( response.a3_title );
							$( "#a3_text" ).html( response.a3_text );
							$( "#a3_url" ).attr( "href", response.a3_url );
						}
						
						$("#divHeaderLine1").show(500);
						$("#lottoPartner").show(1000);
		        	}
		        	
		        	else if ( response.status == "error" ) {
		        		$("#luckyNumbers").attr( 'class', 'alert alert-error' );
		        		$("#luckyNumbers").html( response.error );
		        	}
		        	
		        	btn.button('reset');
		        }
		    });
	    });		
		</script>
	</body>
</html>