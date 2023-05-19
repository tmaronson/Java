package com.hcl.demos;

import java.sql.*;

import static java.sql.Types.VARCHAR;

public class JDBCExampleFuncStoredProcs {
	// Get Type 4 Java Driver
	// static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// Check database, connection port and get URL.
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";

	// Obviously password would not be clear text.
	
	/* TODO: Set USER and PASS to username, password you used
     to configure the database. They may be blank like below. */
	static final String USER = "root";
	static final String PASS = "passwd";
	

	public static void main(String[] args) {

		JDBCExampleFuncStoredProcs jdbc = new JDBCExampleFuncStoredProcs();
		jdbc.getConnection();
	}

	private void getConnection() {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			
			System.out.println("Connecting to database...");
			// Will use datasource normally.
			getData(conn);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void getData(Connection conn) throws SQLException {

		System.out.println("Creating CallableStatement...");
		

			/* TODO: 
			1. Complete the  CallableStatement to call your
			stored procedure 'afford_film_choices'. 
			2. Set the value of the value of the input parameter
			   to 2.25.
			3. Execute the query to get the ResultSet.
			4. Complete the console output print statements
			   to display the film_id, title, rental_rate,
			   description.
			*/
			try (CallableStatement cs2 = ) {
				cs2.setDouble(1, 2.25);
				try (ResultSet rs = ) {

					while (rs.next()) {
						System.out.printf("%d  ", rs.getInt(""));
						System.out.printf("%s ", rs.getString(""));
						System.out.printf("%10.2f  ", rs.getDouble(""));
						System.out.printf("%s  \n", rs.getString(""));
					}

				} catch (SQLException se) {
					se.printStackTrace();
				}
			} 
		} 
	}

