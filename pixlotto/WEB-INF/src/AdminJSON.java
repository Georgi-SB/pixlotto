import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.DB;




/**
 * This class is designed to evaluate the parameters the user submited and to
 * execute WebAnnie with the correct configuration.
 */
public final class AdminJSON extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		ServletContext context    = getServletContext();
		String[] dbConfig         = context.getInitParameter( "dbConfig" ).split( ":" );
		String language           = request.getParameter( "lang" ) != null ? request.getParameter( "lang" ) : "en";
		String land               = request.getParameter( "land" );

		if ( !language.equals( "de" ) && !language.equals( "en" ) && !language.equals( "bg" ) ) 
			language = "en";
		
		Connection conn;

		try {
			conn           = DB.openMySQLConnection( dbConfig[0], dbConfig[1], dbConfig[2] );
			String query   = "SELECT content FROM i18n WHERE language = '" + language + "' AND name='affilliates_" + land + "'";
//			System.out.println( query );
			String content = DB.selectString( conn, query, "content" );
			String json    = "[";
			if ( !content.trim().equals( "" ) ) {
				String[] split = content.split( ";;;" );
				String comma   = "";
				
				for ( String param : split ) {
					String[] p = param.trim().split( ":::::" );
					
					if ( p.length == 2 )
						json      += comma + " { \"htmlid\": \"" + p[0] + "\", \"value\": \"" + p[1] + "\" }";
					comma      = ",";
				}
			}

			response.setContentType( "application/json" );
			response.setCharacterEncoding( "UTF-8" );
//			response.getWriter().println( "{ \"data\": \"" + content.replace( "\"", "\\\"" ) + "\" }"  );	
			response.getWriter().println( json + "]" );	
		} catch ( Exception e ) {
			e.printStackTrace();
			response.setContentType( "application/json" );
			response.setCharacterEncoding( "UTF-8" );
			response.getWriter().println( "Error: \"Ooops, something went wrong. Please try again\" }"  );	
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
} 