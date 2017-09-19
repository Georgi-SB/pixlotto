package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;


/**
 * The Class MySQLConnector.
 */
public final class DB {

	/**
	 * The method opens a localhost database connection.
	 *
	 * @return boolean - <code>true</code> if the connection could be established, <code>false</code> otherwise
	 * @throws SQLException the sQL exception
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Connection openMySQLConnection( String user, String pass, String db ) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName( "com.mysql.jdbc.Driver" ).newInstance ();
		return DriverManager.getConnection( "jdbc:mysql://127.0.0.1/" + db + "?user=" + user + "&password=" + pass + "&useEncoding=true&characterEncoding=UTF-8" );
	}
	
	public static Connection openSQLiteConnection( String db ) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC" ).newInstance ();
		return DriverManager.getConnection ( "jdbc:sqlite:" + db );
	}
	
	/**
	 * The method closes an open localhost database connection.
	 *
	 * @return  boolean - <code>true</code> if the connection could be closed, <code>false</code> otherwise
	 * @throws SQLException the sQL exception
	 */
	public void closeConnection( Connection conn ) throws SQLException { if (conn != null) conn.close(); }
	
	
	/**
	 * The method selects and returns a <code>ResultSet</code> given a SQL query.
	 *
	 * @param query the query
	 * @return ResultSet - the result of the query
	 * @throws SQLException the sQL exception
	 */
	public static ResultSet select( Connection conn, String query ) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet res  = stmt.executeQuery( query );
		return res;
	}
	
	
	/**
	 * The method selects the Int selected by a given SQL query and the result field name.
	 *
	 * @param query the query
	 * @param field the field
	 * @return int - the integer value of the result field name
	 * @throws SQLException the sQL exception
	 */
	public static int selectInt( Connection conn, String query, String field ) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet res  = stmt.executeQuery( query );
		res.next();
		return res.getInt( field );
	}

	/**
	 * The method selects the Double selected by a given SQL query and the result field name.
	 *
	 * @param query the query
	 * @param field the field
	 * @return the double
	 * @throws SQLException the sQL exception
	 */
	public double selectDouble( Connection conn, String query, String field ) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet res  = stmt.executeQuery( query );
		res.next();
		return res.getDouble( field );
	}	
	
	/**
	 * The method selects the String selected by a given SQL query and the result field name.
	 *
	 * @param query the query
	 * @param field the field
	 * @return String - the String value of the result field name
	 * @throws SQLException the sQL exception
	 */
	public static String selectString( Connection conn, String query, String field ) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet res  = stmt.executeQuery( query );
		res.next();
		return res.getString( field );
	}
	
	/**
	 * The method selects the String selected by a given SQL query and the result field name.
	 *
	 * @param query the query
	 * @param field the field
	 * @return String - the String value of the result field name
	 * @throws SQLException the sQL exception
	 */
	public static HashMap<String,String> selectHashMap( Connection conn, String query, String key, String value ) throws SQLException {
		Statement stmt             = conn.createStatement();
		ResultSet res              = stmt.executeQuery( query );
		HashMap<String,String> map = new HashMap<String,String>();

		while ( res.next() )  map.put( res.getString( key ), res.getString( value ) );
		
		return map;
	}
	
	/**
	 * The method selects the String selected by a given SQL query and the result field name.
	 *
	 * @param query the query
	 * @param field the field
	 * @return String - the String value of the result field name
	 * @throws SQLException the sQL exception
	 */
	public static HashSet<String> selectHashSet( Connection conn, String query, String field ) throws SQLException {
		Statement stmt      = conn.createStatement();
		ResultSet res       = stmt.executeQuery( query );
		HashSet<String> set = new HashSet<String>();

		while ( res.next() )  set.add( res.getString( field ) );
		
		return set;
	}
	
	
	/**
	 * The method executes a given insert SQL query against the DB.
	 *
	 * @param query the query
	 * @return boolean - <code>true</code> if the query could be executed, <code>false</code> otherwise
	 * @throws SQLException the sQL exception
	 */
	public static boolean insert( Connection conn, String query ) throws SQLException {
		Statement stmt = conn.createStatement();
		int res        = stmt.executeUpdate( query );
		if ( res > 0 ) return true;
		else return false;
	}
	
	
	/**
	 * The method executes a given update SQL query against the DB.
	 *
	 * @param query the query
	 * @return boolean - <code>true</code> if the query could be executed, <code>false</code> otherwise
	 * @throws SQLException the sQL exception
	 */
	public static boolean update( Connection conn, String query ) throws SQLException {
		return insert( conn, query );
	}
}
