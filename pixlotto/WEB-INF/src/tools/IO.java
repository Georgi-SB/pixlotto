package tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;


/**
 * The Class MySQLConnector.
 */
public final class IO {

	public static List<String> readLines( File source ) throws IOException {
		return FileUtils.readLines( source, "UTF-8" );
	}

	public static HashSet<String> readHashSet( File source ) throws IOException {
		HashSet<String> result = new HashSet<String>();
		Iterator<String> lines = FileUtils.readLines( source, "UTF-8" ).iterator();
		
		while ( lines.hasNext() )  result.add( lines.next().trim() );
		
		return result;
	}

	public static HashSet<String> readHashSet( List<File> files ) throws IOException {
		HashSet<String> result = new HashSet<String>();
		
		for( File file : files ) {
			Iterator<String> lines = FileUtils.readLines( file, "UTF-8" ).iterator();
		
			while ( lines.hasNext() )  result.add( lines.next().trim() );
		}
		
		return result;
	}

	public static HashMap<String, String> readHashMapFromFile( File source, String separator ) throws IOException {
		return readHashMapFromFile( source, separator, false );
	}

	
	public static HashMap<String,String> readHashMapFromFile( File source, String separator, boolean reversed ) throws IOException {
		HashMap<String,String> result   = new HashMap<String, String>();
		Iterator<String> lines          = readLines( source ).iterator();
		int errors                      = 0;
		
		while ( lines.hasNext() ) {
			String line        = lines.next();
			String[] lineParts = line.split( separator );
			if ( lineParts.length != 2 ) {
//				System.out.println("Disgarding line because it doesn't have two arguments: " + line );
				errors++;
			}
			else {	 
				if ( reversed ) {
					if ( result.get( lineParts[1] ) == null ) {
						result.put( lineParts[1], lineParts[0] );
					}
					else {
						if ( result.get( lineParts[1] ) != lineParts[0] ) {
							errors++;
//							System.out.println( "Disambiguation collision: " + lineParts[1] + "(" + lineParts[0] + ") vs. " +
//									lineParts[1] + "(" + result.get( lineParts[1] ) + ")" );
						}
					}					
				}
				else {
					if ( result.get( lineParts[0] ) == null ) {
						result.put( lineParts[0], lineParts[1] );
					}
					else {
						if ( result.get( lineParts[0] ) != lineParts[1] ) {
							errors++;
//							System.out.println( "Disambiguation collision: " + lineParts[0] + "(" + lineParts[1] + ") vs. " +
//								lineParts[0] + "(" + result.get( lineParts[0] ) + ")" );
						}
					}					
				}
			}
		}
		
		if ( errors > 0 ) System.err.println( "[Warning] " + errors + " loading errors (disambiguation issue)." );
		
		return result;
	}

	public static boolean writeMap( File output, HashMap<String, String>  map, String separator ) throws IOException {
		return writeMap( output, map, separator, false );
	}
		
	
	public static boolean writeMap( File output, HashMap<String, String>  map, String separator, boolean reversed ) throws IOException {
		Iterator<String> it = map.keySet().iterator();
		List<String> lines  = new ArrayList<String>();	
		
		while ( it.hasNext() ) {
			String key = it.next();
			if ( reversed ) {
				lines.add( map.get( key ) + separator + key );				
			}
			else {
				lines.add( key + separator + map.get( key ) );
			}
		}
		
		FileUtils.writeLines( output, lines );
		return true;
	}


	public static boolean writeList( File output, HashSet<String> terms ) throws IOException {
		Iterator<String> it = terms.iterator();
		List<String> lines  = new ArrayList<String>();	
		
		while ( it.hasNext() ) {
			lines.add( it.next() );
		}
		
		FileUtils.writeLines( output, "UTF-8", lines );
		return true;
	}

	/**
	 * @param file
	 * @param primary
	 * @throws IOException 
	 */
	public static void writeLines( File ouput, List<String> lines ) throws IOException {
		FileUtils.writeLines( ouput, "utf-8", lines );
	}

	/**
	 * @param file
	 * @param primary
	 * @throws IOException 
	 */
	public static void writeString( File ouput, String text ) throws IOException {
		FileUtils.write( ouput, text, "utf-8" );
	}
}
