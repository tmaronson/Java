package com.hcl.demos;

import java.sql.*;

public class JDBCExamplePrepStmt {
	// Get Type 4 Java Driver
	// static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// Check database, connection port and get URL.
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";

	/* TODO: Set USER and PASS to username, password you used
     to configure the database. They may be blank like below. */
	static final String USER = "";
	static final String PASS = "";

	public static void main(String[] args) {

		JDBCExamplePrepStmt jdbc = new JDBCExamplePrepStmt();
		jdbc.getConnection();
	}

	private void getConnection() {

		System.out.println("Connecting to database...");
		// DataSource is preferred but use DriverManager here.
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			getData(conn);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getData(Connection conn) {

		System.out.println("Creating PreparedStatement...");
		// TODO: Create query to SELECT all actors from table.
		String sql = ""; // get actor table in db sakila.
		try (PreparedStatement stmt = conn.prepareStatement(sql); 
			 ResultSet rs = stmt.executeQuery();) {
		/* TODO:Iterate through result set and store the 3 fields
		first_name, last_name, last_update */
			while (rs.next()) { // iterate through ResultSet and print data
		/* TODO:Iterate through result set and store the  fields
		actor_id, first_name, last_name, last_update */

				System.out.printf("ID: %d", id);
				System.out.printf(", Name: %s %s", firstName, lastName);
				System.out.printf(", date: %s \n", date);
			}
			/* TODO:Insert data into table 'actor' Use 
			first_name = 'Robert', last_name = 'Kinsey' */
			sql = "";
			/* TODO: Complete the PreparedStatement statement. Then
			set the data and execute*/
			try (PreparedStatement stmt2 = ) {
				
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
