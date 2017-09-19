/**
 * Utils.java, created on 18.07.2013 at 13:17:41
 * @author Iavor Jelev
 * @author <a href="mailto:iavor.jelev@babelmonkeys.com">iavor.jelev@babelmonkeys.com</a>
 */
package tools;

import java.text.DecimalFormat;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;


/**
 * The Utils class does ...
 */
public final class Converter {
	
	/**
	 * converts the <code>String</code> to <code>int</code>.
	 * @param convertee - the string
	 * @return the <code>int</code> representation of the <code>String</code> 
	 */
	public static int stringToInt( String convertee ) {
		return Integer.parseInt( convertee );
	}
	
	
	/**
	 * converts the <code>int</code> to <code>String</code>.
	 * @param convertee - the int
	 * @return the <code>String</code> representation of the <code>int</code> 
	 */
	public static String intToString( int convertee ) {
		return String.valueOf( convertee );
	}

	/**
	 * converts the <code>String</code> to <code>double</code>.
	 * @param convertee - the string
	 * @return the <code>double</code> representation of the <code>String</code> 
	 */
	public static double stringToDouble( String convertee ) {
		return Double.parseDouble( convertee );
	}

	/**
	 * converts the <code>double</code> to <code>String</code> with the given formater.
	 * @param convertee - the double
	 * @param format - format of result (example: "#.##" for 2 decimal values )
	 * @return the <code>String</code> representation of the <code>double</code> 
	 */
	public static String doubleToString( double convertee, String format ) {
		return new DecimalFormat( format ).format( convertee );
	}

	/**
	 * converts the <code>double</code> to <code>String</code> assuming "#.##" formater.
	 * @param convertee - the double
	 * @return the <code>String</code> representation of the <code>double</code> 
	 */
	public static String doubleToString( double convertee ) {
		return doubleToString( convertee, "#.##" );
	}

	/**
	 * converts the <code>String</code> to <code>DateTime</code> with the given formater.
	 * @param convertee - the date (example: "2012-01-10 23:13:26")
	 * @param format - format of the date (example: "yyyy-MM-dd HH:mm:ss")
	 * @return a <code>DateTime</code> object initialized with the date <code>String</code>
	 */
	public static DateTime stringToDateTime( String convertee, String format ) {
		return DateTimeFormat.forPattern( format ).parseDateTime( convertee );	
	}


	/**
	 * converts the <code>String</code> to <code>DateTime</code> assuming "yyyy-MM-dd HH:mm:ss" as formater.
	 * @param convertee - the date (example: "2012-01-10 23:13:26")
	 * @return a <code>DateTime</code> object initialized with the date <code>String</code>
	 */
	public static DateTime stringToDateTime( String convertee ) {
		return DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss" ).parseDateTime( convertee );	
	}


	/**
	 * converts the <code>String</code> to <code>int[]</code> with the given separator.
	 * @param convertee - the string
	 * @param separator - separator of the elements (example: ",")
	 * @return an array with the converted elements
	 */
	public static int[] stringToIntArray( String convertee, String separator ) {
		if ( convertee == null || convertee.equals( "" ) ) return new int[0];
		String[] split = convertee.split( separator );
		int[] result   = new int[ split.length ];
		
		for (int i = 0; i < split.length; i++) {
			result[i] = stringToInt( split[i].trim() );
		}
		
		return result;
	}
}
