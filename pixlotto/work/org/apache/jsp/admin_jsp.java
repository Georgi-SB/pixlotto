package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t    <div class=\"navbar\">\r\n");
      out.write("\t      <div class=\"navbar-inner\">\r\n");
      out.write("\t  \t\t<a class=\"brand\" href=\"/\">PixLotto</a>\r\n");
      out.write("\t        <ul class=\"nav pull-right\">\r\n");
      out.write("\t          <li><a href=\"/\" class=\"active\">Admin</a></li>\r\n");
      out.write("\t        </ul>\r\n");
      out.write("\t      </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div align=\"center\" style=\"color: red;\">");
      out.print( ( request.getAttribute( "error" ) != null ) ? request.getAttribute( "error" ) : "" );
      out.write("</div>\r\n");
      out.write("\t    <hr>\r\n");
      out.write("\t    <div align=\"center\" class=\"text-larger\">\r\n");
      out.write("\t        <form method=\"post\" action=\"admin\">\r\n");
      out.write("\t        \t<input type=\"hidden\" name=\"op\" value=\"login\">\r\n");
      out.write("\t            <center>\r\n");
      out.write("\t            <table width=\"40%\" cellpadding=\"3\">\r\n");
      out.write("\t                <tbody>\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                        <td>User Name</td>\r\n");
      out.write("\t                        <td><input type=\"text\" name=\"username\" autofocus></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                        <td>Password</td>\r\n");
      out.write("\t                        <td><input type=\"password\" name=\"password\"></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                    <tr>\r\n");
      out.write("\t                        <td></td>\r\n");
      out.write("\t                        <td><input type=\"submit\" value=\"Login\" class=\"btn btn-primary btn-success\" ></td>\r\n");
      out.write("\t                    </tr>\r\n");
      out.write("\t                </tbody>\r\n");
      out.write("\t            </table>\r\n");
      out.write("\t            </center>\r\n");
      out.write("\t        </form>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap.js\"> </script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap-datepicker.js\"> </script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.chained.min.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.form.min.js\" charset=\"utf-8\"></script>\r\n");
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
