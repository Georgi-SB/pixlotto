import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import pixLotto.Configurator;
import pixLotto.LottoConfig;
import pixLotto.pix2draw;
import tools.DB;




/**
 * This class is designed to evaluate the parameters the user submited and to
 * execute WebAnnie with the correct configuration.
 */
public final class PixLotto extends HttpServlet {

	// declare needed parameters
	private static String date, language, lottotype, lottoland, lottoOptions, lottoLands;
	private static Connection conn;
	private static boolean deleteFile;
	private static Calendar luckyDate;
	
	// initialize constants
	private static final long serialVersionUID = 1L;
	private final int MAX_FILE_SIZE            = 50000 * 1024;
	private final int MAX_MEM_SIZE             = 50000 * 1024;
	private final boolean DEBUG_MODE           = false;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// initialize parameters
		ServletContext context    = getServletContext();
		String configPath         = context.getInitParameter( "lottoConfig" );
		String[] dbConfig         = context.getInitParameter( "dbConfig" ).split( ":" );
		language                  = request.getParameter( "lang" ) != null ? request.getParameter( "lang" ) : "en";
		String showPage           = request.getParameter( "show" );
		Configurator configurator;
		
		// make sure the language is supported, and initialize with "en" otherwise
		if ( !language.equals( "de" ) && !language.equals( "en" ) && !language.equals( "bg" ) ) language = "en";
		request.setAttribute( "lang", language );

		try {
			conn                           = DB.openMySQLConnection( dbConfig[0], dbConfig[1], dbConfig[2] );
			HashMap<String,String> pageMap = DB.selectHashMap( conn, "SELECT name, content FROM i18n WHERE language = '" + language + "'", "name", "content" );
			
			// select page text fragments and set them in the request
			for ( Map.Entry<String, String> entry : pageMap.entrySet() ) request.setAttribute( entry.getKey(), entry.getValue() );

			if ( showPage != null ) {
				getServletConfig().getServletContext().getRequestDispatcher( "/" + showPage + ".jsp" ).forward( request, response );		
			}		
			else {
				// create a configurator
				configurator = this.getConfigurator( context, configPath );
				// initialize the select options which will be shown on the page
				this.initializeSelectOptions( context, configurator );	
				// Verify the content type
				String contentType = request.getContentType();
				request.setAttribute( "lottoTypeOptions", lottoOptions );
				request.setAttribute( "lottoLandOptions", lottoLands );
		
				luckyDate = GregorianCalendar.getInstance();
				
				// check if the form was submitted, or if it is just a page request
				if ( contentType == null ) {
					getServletConfig().getServletContext().getRequestDispatcher("/pixlotto.jsp").forward( request, response );			
				}
				else if ( contentType.indexOf( "multipart/form-data" ) >= 0 ) {	
					// if the form was submitted get the file, and do pixelMagic with it
					try {
						// do the magic and get the json response string
						File image          = this.getImage( context, request );
						String responseJson = this.pixelMagic( image, configurator, request, luckyDate, deleteFile );
						
						if ( deleteFile ) image.delete();
						
						response.setContentType( "application/json" );
						response.setCharacterEncoding("UTF-8");
				        response.getWriter().println( responseJson );	
					}
					catch( Exception ex) {
						ex.printStackTrace();
						response.setContentType( "application/json" );
						response.setCharacterEncoding( "UTF-8" );
						response.getWriter().println( "{ \"status\": \"error\", \"error\": \"Ooops, something went wrong. Please try again\" }"  );	
					}
					finally {
						// close the database connection
						try {
							if ( !conn.isClosed() ) conn.close();
						} catch (SQLException e) {
							System.out.println( "Could not close the connection. Reason: " + e.getMessage() );
						}					
					}
				}
				else {
					request.setAttribute( "status", "error" );
					getServletConfig().getServletContext().getRequestDispatcher("/pixlotto.jsp").forward( request, response );			
				}
			}
		}
		catch( Exception ex) {
			ex.printStackTrace();
			response.setContentType( "application/json" );
			response.setCharacterEncoding( "UTF-8" );
			response.getWriter().println( "{ \"status\": \"error\", \"error\": \"Ooops, something went wrong. Please try again\" }"  );	
		}
		finally {
			// close the database connection
			try {
				if ( !conn.isClosed() ) conn.close();
			} catch (SQLException e) {
				System.out.println( "Could not close the connection. Reason: " + e.getMessage() );
			}					
		}
	}

	
	@SuppressWarnings("rawtypes")
	private File getImage( ServletContext context, HttpServletRequest request ) throws Exception {
		deleteFile                  = true;
		File file                   = null;
		String filePath             = context.getInitParameter( "file-upload" );
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum memory size to be used for uploads.
		factory.setSizeThreshold( MAX_MEM_SIZE );
		// set the temporary path for the upload
		factory.setRepository( new File( context.getInitParameter( "tempPath" ) ) );
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload( factory );
		// maximum file size to be uploaded.
		upload.setSizeMax( MAX_FILE_SIZE );

		// Parse the request to get file items.
		List fileItems = upload.parseRequest( request );
		// Process the uploaded file items
		Iterator i = fileItems.iterator();

		while ( i.hasNext() ) {
			FileItem fi = (FileItem)i.next();
			if ( fi.isFormField() ) {
			    if ( fi.getFieldName().equals( "lottotype" ) ) lottotype = fi.getString();
			    if ( fi.getFieldName().equals( "lottoland" ) ) lottoland = fi.getString();
			    if ( fi.getFieldName().equals( "lang" ) ) language = fi.getString();
			    if ( fi.getFieldName().equals( "date" ) ) date = fi.getString();
				
				if ( DEBUG_MODE ) {
					System.out.println( "language: " + language );
					System.out.println( "lottoland: " + lottoland );
					System.out.println( "lottotype: " + lottotype );
					System.out.println( "date: " + date );
					System.out.println( "luckyDate: " + luckyDate.toString() );
				}
			}
			else {
				// Get the uploaded file parameters
				String fileName = fi.getName();
				// Write the file
				if( fileName.lastIndexOf("\\") >= 0 ) {
					file = new File( filePath + fileName.substring( fileName.lastIndexOf( "\\" ) ) );
				}
				else {
					file = new File( filePath + fileName.substring( fileName.lastIndexOf( "\\" )+1 ) );
				}
				fi.write( file ) ;							
			}
		}
		
		if ( file == null ) {
			file = new File( context.getInitParameter( "defaultImage" ) );
			deleteFile = false;
		}
		if ( date == null ) 
			luckyDate.set( 2013, 5, 17 );
		else {
			String[] split = date.split( "-" );
			luckyDate.set( Integer.parseInt( split[2] ), Integer.parseInt( split[1] ), Integer.parseInt( split[0] ) );
		}
		
		if ( lottotype == null ) {
			lottoland = "DE";
			lottotype = "Lotto";
		}
		
		if ( DEBUG_MODE ) {
			System.out.println( "language: " + language );
			System.out.println( "lottoland: " + lottoland );
			System.out.println( "lottotype: " + lottotype );
			System.out.println( "date: " + date );
			System.out.println( "luckyDate: " + luckyDate.toString() );
		}
		
		return file;
	}


	private void initializeSelectOptions( ServletContext context, Configurator configurator ) {
		if ( context.getAttribute( "lottoOptions" ) == null ) {
			Collection<String> lottotypes = configurator.map.keySet();
			HashSet<String> lands         = new HashSet<String>();
			
			for ( String ltype : lottotypes ) {
				String[] split = ltype.split( "_" );
				
				if ( split.length == 2 ) {
					lands.add( split[0] );
					lottoOptions += "<option value=\"" + split[1] + "\" class=\"" + split[0] + "\">" + split[1] + "</option>\n";
				}
			}
			
			for ( String land : lands ) {
				lottoLands += "<option value=\"" + land + "\">" + land + "</option>\n";
			}
			context.setAttribute( "lottoOptions", lottoOptions );
			context.setAttribute( "lottoLands", lottoLands );
		}
		else {
			lottoOptions = (String) context.getAttribute( "lottoOptions" );
			lottoLands   = (String) context.getAttribute( "lottoLands" );
		}
	}


	private Configurator getConfigurator( ServletContext context, String configPath ) {
		Configurator configurator;
		
		if ( context.getAttribute( "configurator" ) == null ) {
			configurator = new Configurator( new File( configPath ) );
			context.setAttribute( "configurator", configurator );
		}
		else {
			configurator = (Configurator) context.getAttribute( "configurator" );
		}

		return configurator;
	}


	private String pixelMagic( File file, Configurator configurator, HttpServletRequest request, Calendar luckyDate, boolean deleteFile ) throws IOException, SQLException {
		LottoConfig config        = configurator.map.get( lottoland + "_" + lottotype );
		pix2draw getLucky         = new pix2draw( luckyDate, file, config );
		int[] draw                = getLucky.getDraw();
		int[] nums                = new int[draw.length - config.mNumberSuper];
		
		System.arraycopy( draw, 0, nums, 0, draw.length - config.mNumberSuper );
		Arrays.sort( nums );
		
		String superNumber = "";
		if ( config.mNumberSuper == 1 ) superNumber += draw[draw.length - 1];
		else if ( config.mNumberSuper == 2 ) superNumber += draw[draw.length - 1] + ", " + draw[draw.length - 2];
		
		request.setAttribute( "luckyNumbers", Arrays.toString( nums ) );
		request.setAttribute( "date", date );
		request.setAttribute( "lottoland", lottoland );
		request.setAttribute( "lottotype", lottotype );
		
		if ( deleteFile )  file.delete();

		// get affiliates
		String affjson    = this.getAffiliatesJson( conn );

		// generate and return output json
		String json = "{ \"status\": \"success\", \"luckyNumbers\": \"" 
				+  Arrays.toString( nums ) + "\", \"super\": \"" + superNumber + "\"" + affjson + "}";

		return json;
	}


	private String getAffiliatesJson( Connection conn ) throws SQLException {
		
		String query    = "SELECT content FROM i18n WHERE language = '" + language + "' AND name='affilliates_" + lottoland + "'";
		String content  = DB.selectString( conn, query, "content" );
		String affjson  = "";
		
		if ( content.contains( ";;;" ) ) {
			String[] affs   = DB.selectString( conn, query, "content" ).split( ";;;" );
			String comma    = ", ";
			HashMap<String,String> map = new HashMap<String, String>();
			
			
			for ( String aff : affs ) {
				String[] p = aff.trim().split( ":::::" );
				if ( p.length == 2 )
					map.put( p[0], p[1] );
				//affjson   += comma + " \"" + p[0] + "\": \"" + p[1] + "\"";
			}
			
			boolean aff1 = false;
			boolean aff2 = false;
			boolean aff3 = false;
			
			if ( map.get( "a1_title" ) != null && !map.get( "a1_title" ).trim().equals("") && map.get( "a1_text" ) != null 
					&& !map.get( "a1_text" ).trim().equals("") && map.get( "a1_url" ) != null && !map.get( "a1_url" ).trim().equals("") ) {
				aff1 = true;
			}
			
			if ( map.get( "a2_title" ) != null && !map.get( "a2_title" ).trim().equals("") && map.get( "a2_text" ) != null 
					&& !map.get( "a2_text" ).trim().equals("") && map.get( "a2_url" ) != null && !map.get( "a2_url" ).trim().equals("") ) {
				aff2 = true;
			}
			
			if ( map.get( "a3_title" ) != null && !map.get( "a3_title" ).trim().equals("") && map.get( "a3_text" ) != null 
					&& !map.get( "a3_text" ).trim().equals("") && map.get( "a3_url" ) != null && !map.get( "a3_url" ).trim().equals("") ) {
				aff3 = true;
			}
			
			if ( aff1 && aff2 && aff3 ) {
				affjson = ", \"partners\": \"3\", \"a1_title\": \"" + map.get( "a1_title" ) + "\", \"a1_text\": \"" + map.get( "a1_text" ) + "\", " +
									"\"a1_url\": \"" + map.get( "a1_url" ) + "\", \"a2_title\": \"" + map.get( "a2_title" ) + "\", \"a2_text\": \"" 
									+ map.get( "a2_text" ) + "\", \"a2_url\": \"" + map.get( "a2_url" ) + "\", \"a3_title\": \"" + map.get( "a3_title" ) 
									+ "\", \"a3_text\": \"" + map.get( "a3_text" ) + "\", \"a3_url\": \"" + map.get( "a3_url" ) + "\"";
			}
			else if ( aff1 && aff2 ) {
				affjson = ", \"partners\": \"2\", \"a1_title\": \"" + map.get( "a1_title" ) + "\", \"a1_text\": \"" + map.get( "a1_text" ) + "\", " +
								"\"a1_url\": \"" + map.get( "a1_url" ) + "\", \"a2_title\": \"" + map.get( "a2_title" ) + "\", \"a2_text\": \"" 
								+ map.get( "a2_text" ) + "\", \"a2_url\": \"" + map.get( "a2_url" ) + "\"";
				
			}
			else if ( aff1 && aff3 ) {
				affjson = ", \"partners\": \"2\", \"a1_title\": \"" + map.get( "a1_title" ) + "\", \"a1_text\": \"" + map.get( "a1_text" ) + "\", " +
								"\"a1_url\": \"" + map.get( "a1_url" ) + "\", \"a2_title\": \"" + map.get( "a3_title" ) + "\", \"a2_text\": \"" 
								+ map.get( "a3_text" ) + "\", \"a2_url\": \"" + map.get( "a3_url" ) + "\"";
				
			}
			else if ( aff2 && aff3 ) {
				affjson = ", \"partners\": \"2\", \"a1_title\": \"" + map.get( "a2_title" ) + "\", \"a1_text\": \"" + map.get( "a2_text" ) + "\", " +
								"\"a1_url\": \"" + map.get( "a2_url" ) + "\", \"a2_title\": \"" + map.get( "a3_title" ) + "\", \"a2_text\": \"" 
								+ map.get( "a3_text" ) + "\", \"a2_url\": \"" + map.get( "a3_url" ) + "\"";
				
			}
			else if ( aff1 ) {
				affjson = ", \"partners\": \"1\", \"a1_title\": \"" + map.get( "a1_title" ) + "\", \"a1_text\": \"" + map.get( "a1_text" ) + "\", " +
								"\"a1_url\": \"" + map.get( "a1_url" ) + "\"";
			}
			else if ( aff2 ) {
				affjson = ", \"partners\": \"1\", \"a1_title\": \"" + map.get( "a2_title" ) + "\", \"a1_text\": \"" + map.get( "a2_text" ) + "\", " +
								"\"a1_url\": \"" + map.get( "a2_url" ) + "\"";
			}
			else if ( aff3 ) {
				affjson = ", \"partners\": \"1\", \"a1_title\": \"" + map.get( "a3_title" ) + "\", \"a1_text\": \"" + map.get( "a3_text" ) + "\", " +
								"\"a1_url\": \"" + map.get( "a3_url" ) + "\"";
			}
			else {
				affjson = ", \"partners\": \"0\"";
			}			
		}
		else {
			affjson = ", \"partners\": \"0\"";
		}			

		return affjson;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
} 