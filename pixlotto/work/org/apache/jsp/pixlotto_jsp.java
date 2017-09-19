package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public final class pixlotto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta charset=\"utf-8\"> \r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("  \t<link href=\"css/datepicker.css\" rel=\"stylesheet\">\r\n");
      out.write("  \t<title>PixLotto</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("      .navbar-inner {\r\n");
      out.write("\t\t    height: 60px;  \r\n");
      out.write("\t\t    background: #336699;\r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\t.navbar .brand {\r\n");
      out.write("\t    color: #FFFFFF;\r\n");
      out.write("\t    display: block;\r\n");
      out.write("\t    float: left;\r\n");
      out.write("\t    font-size: 40px;\r\n");
      out.write("\t    font-weight: 200;\r\n");
      out.write("\t    margin-left: -20px;\r\n");
      out.write("\t    padding: 10px 20px;\r\n");
      out.write("\t    margin-top: 10px;\r\n");
      out.write("\t    text-shadow: 0 1px 0 #FFFFFF;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.navbar .nav > li > a {\r\n");
      out.write("\t    color: #FFFFFF;\r\n");
      out.write("\t    float: none;\r\n");
      out.write("\t    padding: 10px 15px;\r\n");
      out.write("\t    margin-top: 20px;\r\n");
      out.write("\t    text-decoration: none;\r\n");
      out.write("\t    text-shadow: 0 1px 0 #FFFFFF;\r\n");
      out.write("\t}\r\n");
      out.write("      .text-larger {\r\n");
      out.write("\t    font-size: 18px;\r\n");
      out.write("      }\r\n");
      out.write("      .input-mini {\r\n");
      out.write("        width: 140px;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      .input-xmini {\r\n");
      out.write("        width: 80px;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      .luckyNumbers {\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        color: #EFD10B;\r\n");
      out.write("        font-size: 25px;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      .gradient {\r\n");
      out.write("\t\t\tbackground: #87bcea; /* Old browsers */\r\n");
      out.write("\t\t\tbackground: -moz-linear-gradient(left, #87bcea 0%, #ffffff 21%, #ffffff 50%, #ffffff 79%, #87bcea 100%); /* FF3.6+ */\r\n");
      out.write("\t\t\tbackground: -webkit-gradient(linear, left top, right top, color-stop(0%,#87bcea), color-stop(21%,#ffffff), color-stop(50%,#ffffff), color-stop(79%,#ffffff), color-stop(100%,#87bcea)); /* Chrome,Safari4+ */\r\n");
      out.write("\t\t\tbackground: -webkit-linear-gradient(left, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* Chrome10+,Safari5.1+ */\r\n");
      out.write("\t\t\tbackground: -o-linear-gradient(left, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* Opera 11.10+ */\r\n");
      out.write("\t\t\tbackground: -ms-linear-gradient(left, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* IE10+ */\r\n");
      out.write("\t\t\tbackground: linear-gradient(to right, #87bcea 0%,#ffffff 21%,#ffffff 50%,#ffffff 79%,#87bcea 100%); /* W3C */\r\n");
      out.write("\t\t\tfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#87bcea', endColorstr='#87bcea',GradientType=1 ); /* IE6-9 */\r\n");
      out.write("\t   }      \r\n");
      out.write("    </style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body class=\"gradient\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    <div class=\"navbar\">\r\n");
      out.write("      <div class=\"navbar-inner\">\r\n");
      out.write("  \t\t<a class=\"brand\" href=\"/pixlotto/main?lang=");
      out.print( request.getAttribute( "lang" ) );
      out.write("\">PixLotto</a>\r\n");
      out.write("        <ul class=\"nav pull-right\">\r\n");
      out.write("          <li><a href=\"/pixlotto/main?lang=");
      out.print( request.getAttribute( "lang" ) );
      out.write("\" class=\"active\">");
      out.print( request.getAttribute( "slogan" ) );
      out.write("</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"pull-right\">\r\n");
      out.write("    \t<a href=\"main?lang=en\"><img src=\"img/us.png\" /></a>&nbsp;\r\n");
      out.write("    \t<a href=\"main?lang=de\"><img src=\"img/de.png\" /></a>&nbsp;\r\n");
      out.write("    \t<a href=\"main?lang=bg\"><img src=\"img/bg.png\" /></a>&nbsp;\r\n");
      out.write("    </div><br>\r\n");
      out.write("    <div id=\"feedback\"></div>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <div align=\"center\" class=\"text-larger\">\r\n");
      out.write("  \t  <p>");
      out.print( request.getAttribute( "top_text" ) );
      out.write("</p>\r\n");
      out.write("    </div>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("    <form action=\"main\" method=\"post\" enctype=\"multipart/form-data\" id=\"luckyform\">\r\n");
      out.write("      <!-- Example row of columns -->\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"span4\">\r\n");
      out.write("          <h4>");
      out.print( request.getAttribute( "choose_image" ) );
      out.write("</h4>\r\n");
      out.write("          <input type=\"file\" name=\"file\" id=\"image-upload\">\r\n");
      out.write("          <div class=\"upload-preview\">\r\n");
      out.write("            <img />\r\n");
      out.write("          </div><br>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span4\">\r\n");
      out.write("          <h4>");
      out.print( request.getAttribute( "choose_date" ) );
      out.write("</h4>\r\n");
      out.write("          <div id=\"dp3\" class=\"input-append date\" data-date=\"12-02-2012\" data-date-format=\"dd-mm-yyyy\">\r\n");
      out.write("            <input id=\"date\" class=\"span3\" type=\"text\" readonly=\"\" value=\"12-02-2012\" name=\"date\">\r\n");
      out.write("            <span class=\"add-on\"><i class=\"icon-calendar\"></i></span>\r\n");
      out.write("          </div>\r\n");
      out.write("          <button onclick=\"submitForm()\" class=\"btn btn-large btn-success\" data-loading-text=\"Calculating...\">");
      out.print( request.getAttribute( "main_button" ) );
      out.write("</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span4\">\r\n");
      out.write("          <h4>");
      out.print( request.getAttribute( "choose_lotto" ) );
      out.write("</h4>\r\n");
      out.write("          <select id=\"lottoland\" name=\"lottoland\" class=\"input-small input-xmini\">\r\n");
      out.write("            ");
      out.print( request.getAttribute( "lottoLandOptions" ) );
      out.write("\r\n");
      out.write("          </select>\r\n");
      out.write("          <select id=\"lottotype\" name=\"lottotype\" class=\"input-small input-mini\">\r\n");
      out.write("            ");
      out.print( request.getAttribute( "lottoTypeOptions" ) );
      out.write("\r\n");
      out.write("          </select>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <div align=\"center\">\r\n");
      out.write("      <p>\r\n");
      out.write("        <a href=\"main?show=menu1&lang=");
      out.print( request.getAttribute( "lang" ) );
      out.write("\"><button class=\"btn btn-lg btn-primary\">");
      out.print( request.getAttribute( "menu1" ) );
      out.write("</button></a>\r\n");
      out.write("        <a href=\"main?show=menu2&lang=");
      out.print( request.getAttribute( "lang" ) );
      out.write("\"><button class=\"btn btn-lg btn-primary\">");
      out.print( request.getAttribute( "menu2" ) );
      out.write("</button></a>\r\n");
      out.write("        <a href=\"main?show=menu3&lang=");
      out.print( request.getAttribute( "lang" ) );
      out.write("\"><button class=\"btn btn-lg btn-primary\">");
      out.print( request.getAttribute( "menu3" ) );
      out.write("</button></a>\r\n");
      out.write("        <!--a href=\"main?show=menu4&lang=");
      out.print( request.getAttribute( "lang" ) );
      out.write("\"><button class=\"btn btn-lg btn-primary\">");
      out.print( request.getAttribute( "menu4" ) );
      out.write("</button></a-->\r\n");
      out.write("      </p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"myModal\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">x</button>\r\n");
      out.write("        <h3 id=\"myModalLabel\">");
      out.print( request.getAttribute( "congrats" ) );
      out.write("</h3>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("        <div class=\"container span5\">\r\n");
      out.write("\t      \t<div class=\"row\">\r\n");
      out.write("\t          <div class=\"luckyNumbers span4 offset1\"></div><br>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t      \t<div class=\"row\">\r\n");
      out.write("\t      \t\t<br>\r\n");
      out.write("\t      \t\t<div class=\"span4 offset1\">\r\n");
      out.write("\t\t          \t<h4>");
      out.print( request.getAttribute( "go_get_lucky" ) );
      out.write("</h4>\r\n");
      out.write("\t\t          \t");
      out.print( request.getAttribute( "affilliates" ) );
      out.write("\r\n");
      out.write("\t\t          \t<button class=\"btn btn-large btn-success\">");
      out.print( request.getAttribute( "play_now" ) );
      out.write("</button>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t     </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap.js\"> </script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap-datepicker.js\"> </script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.chained.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.form.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("  \t<script type=\"text/javascript\">\r\n");
      out.write("  \t\t//$( document ).ready(function() {\r\n");
      out.write("\t\t\ttoday = new Date();\r\n");
      out.write("\t\t\tvar dd = today.getDate();\r\n");
      out.write("\t\t\tvar mm = today.getMonth()+1; //January is 0!\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar yyyy = today.getFullYear();\r\n");
      out.write("\t\t\tif( dd<10 ){ dd='0'+dd } if( mm<10 ){ mm='0'+mm } today = dd + '-' + mm + '-' + yyyy;\r\n");
      out.write("\t\r\n");
      out.write("\t      \t$('#date').val( today );\r\n");
      out.write("\t      \t$('#dp3').attr( 'data-date', today );\r\n");
      out.write("\t      \t$('#dp3').datepicker();\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t$(\"#lottotype\").chained(\"#lottoland\");\r\n");
      out.write("\t\r\n");
      out.write("\t      var preview = $(\".upload-preview img\");\r\n");
      out.write("\t\r\n");
      out.write("\t      $(\"#image-upload\").change(function(event){\r\n");
      out.write("\t\t     $(\".luckyNumbers\").html( \"\" );\r\n");
      out.write("\t      \t var input = $(event.currentTarget);\r\n");
      out.write("\t         var file = input[0].files[0];\r\n");
      out.write("\t         var reader = new FileReader();\r\n");
      out.write("\t         reader.onload = function(e){\r\n");
      out.write("\t             image_base64 = e.target.result;\r\n");
      out.write("\t             preview.attr(\"src\", image_base64);\r\n");
      out.write("\t         };\r\n");
      out.write("\t         reader.readAsDataURL(file);\r\n");
      out.write("\t      });\r\n");
      out.write("\t\t//});\r\n");
      out.write("\t    \r\n");
      out.write("\t    function submitForm() {\r\n");
      out.write("\t    \t$('#luckyform')\r\n");
      out.write("\t\t\t    .ajaxForm({\r\n");
      out.write("\t\t        url : 'main',\r\n");
      out.write("        \t\tdataType : 'json',\r\n");
      out.write("\t\t        success : function (response) {\r\n");
      out.write("\t\t        \tif ( response.status == \"success\" ) {\r\n");
      out.write("\t\t        \t\tvar numbers = response.luckyNumbers;\r\n");
      out.write("\t\t        \t\t\r\n");
      out.write("\t\t        \t\tif ( response.super != \"\" ) numbers += '<br>Super: ' + response.super;\r\n");
      out.write("\t\t\t\t\t\t    \r\n");
      out.write("                $('#myModal').modal();\r\n");
      out.write("\t\t        \t\t$(\".luckyNumbers\").html( numbers );\r\n");
      out.write("\t\t      \t\t\t//$(\".upload-preview img\").attr(\"src\", \"\");\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        \t\r\n");
      out.write("\t\t        \telse if ( response.status == \"error\" ) {\r\n");
      out.write("\t\t        \t\t$(\"#luckyNumbers\").attr( 'class', 'alert alert-error' );\r\n");
      out.write("\t\t        \t\t$(\"#luckyNumbers\").val( response.error );\r\n");
      out.write("\t\t        \t}\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
