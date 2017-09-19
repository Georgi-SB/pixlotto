package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/datepicker.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<title>PixLotto</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("      .input-mini {\r\n");
      out.write("        width: 140px;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      .input-xmini {\r\n");
      out.write("        width: 80px;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    <div class=\"navbar navbar-inverse\">\r\n");
      out.write("      <div class=\"navbar-inner\">\r\n");
      out.write("  \t\t\t<a class=\"brand\" href=\"/\">PixLotto</a>\r\n");
      out.write("        <ul class=\"nav pull-right\">\r\n");
      out.write("          <li><a href=\"/\" class=\"active\">We are all up to get lucky</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <div align=\"center\">\r\n");
      out.write("\t\t  <p>You know how there are special people or things in your life that just make you feel fortunate? Or you have a dream you aspire towards? Yet defining luck with words is tricky, let alone pick lucky numbers.  We humans do tend to think, hope, dream and envision in pictures.  Let us translate  your  pictures in lotto numbers. </p>\r\n");
      out.write("    </div>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("    <form action=\"main\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("      <!-- Example row of columns -->\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"span4\">\r\n");
      out.write("          <h4>Choose your image</h4>\r\n");
      out.write("          <input type=\"file\" name=\"file\" id=\"image-upload\">\r\n");
      out.write("          <div class=\"upload-preview\">\r\n");
      out.write("            <img />\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span4\">\r\n");
      out.write("          <h4>Choose your date</h4>\r\n");
      out.write("          <div id=\"dp3\" class=\"input-append date\" data-date=\"12-02-2012\" data-date-format=\"dd-mm-yyyy\">\r\n");
      out.write("            <input id=\"date\" class=\"span3\" type=\"text\" readonly=\"\" value=\"12-02-2012\" name=\"date\">\r\n");
      out.write("            <span class=\"add-on\"><i class=\"icon-calendar\"></i></span>\r\n");
      out.write("          </div>\r\n");
      out.write("          <input type=\"submit\" class=\"btn btn-large btn-success\" value=\"Generate lucky numbers\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"span4\">\r\n");
      out.write("          <h4>Choose your lotto type</h4>\r\n");
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
      out.write("    <div class=\"pull-right\"><button class=\"btn btn-lg btn-primary\">Play online</button></div><br><br>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <div align=\"center\">\r\n");
      out.write("      <p>\r\n");
      out.write("        <button class=\"btn btn-lg btn-primary\">What is it good for!</button>\r\n");
      out.write("        <button class=\"btn btn-lg btn-primary\">Jackpot hunter</button>\r\n");
      out.write("        <button class=\"btn btn-lg btn-primary\">Tell us your story</button>\r\n");
      out.write("        <button class=\"btn btn-lg btn-primary\">Lotto news RSS</button>\r\n");
      out.write("      </p>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap.js\"> </script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap-datepicker.js\"> </script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.chained.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tvar today = new Date();\r\n");
      out.write("\t\t\tvar dd = today.getDate();\r\n");
      out.write("\t\t\tvar mm = today.getMonth()+1; //January is 0!\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar yyyy = today.getFullYear();\r\n");
      out.write("\t\t\tif( dd<10 ){ dd='0'+dd } if( mm<10 ){ mm='0'+mm } today = dd + '-' + mm + '-' + yyyy;\r\n");
      out.write("\t\t  \r\n");
      out.write("      $('#date').val( today );\r\n");
      out.write("      $('#dp3').attr('data-date', today);\r\n");
      out.write("      $('#dp3').datepicker();\r\n");
      out.write("\r\n");
      out.write("      $(\"#lottotype\").chained(\"#lottoland\");\r\n");
      out.write("\r\n");
      out.write("      var preview = $(\".upload-preview img\");\r\n");
      out.write("\r\n");
      out.write("      $(\"#image-upload\").change(function(event){\r\n");
      out.write("         var input = $(event.currentTarget);\r\n");
      out.write("         var file = input[0].files[0];\r\n");
      out.write("         var reader = new FileReader();\r\n");
      out.write("         reader.onload = function(e){\r\n");
      out.write("             image_base64 = e.target.result;\r\n");
      out.write("             preview.attr(\"src\", image_base64);\r\n");
      out.write("         };\r\n");
      out.write("         reader.readAsDataURL(file);\r\n");
      out.write("      });\r\n");
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
