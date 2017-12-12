package de.hdm.Fahrtenbuch.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.appengine.api.utils.SystemProperty;

public class DBConnection {

	private static Connection con = null;

	// Datenbankverbindung aufbauen
	public static Connection connection() {
		if (con == null) {
			try {
				if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {

					Class.forName("com.mysql.jdbc.GoogleDriver");

					//Code anderes Projekt: 	                    
					//con = DriverManager.getConnection("jdbc:google:mysql://project4u-165512:hdm-project4u/project4u?user=root");
	
					con = DriverManager.getConnection("jdbc:google:mysql://fahrtenbuch-187414:fahrtenbuch/Fahrtenbuch?user=root");

				} else {

					// lokale DatenkbankURL
					Class.forName("com.mysql.jdbc.Driver");
					
					//Code anderes Projekt: 	                    
					//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project4u", "root", null);
			
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fahrtenbuch", "root", null);
				}

			} catch (Exception e) {
				con = null;
				e.printStackTrace();
			}

		}
		return con;
	}

	/**
	 * Schließt das ResultSet, das Statement und die Connection.
	 * 
	 * @param rs
	 *            ResultSet
	 * @param stmt
	 *            Statement
	 * @param con
	 *            Datenbankverbindung
	 * @throws Exception
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection con) throws IllegalArgumentException {

	}

}
