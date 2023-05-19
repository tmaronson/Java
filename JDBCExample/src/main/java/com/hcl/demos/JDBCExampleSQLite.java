package com.hcl.demos;

import java.sql.*;

public class JDBCExampleSQLite {

	// Check database, connection port and get URL.

	/* Get path to file rexon_metals.db and insert it below. */
	static String PATH = <
	path to
	database file
	goes here>rexon_metals.db;
	static final String DB_URL = "jdbc:sqlite:///" + PATH;

	// Obviously password would not be clear text but fine here.
	/*
	 * TODO: Set USER and PASS to username, password you used to configure the
	 * database. They may be blank like below.
	 */
	static final String USER = "";
	static final String PASS = "";

	public static void main(String[] args) {

		getData();
	}

	private static void getData() {

				System.out.println("Connecting to database...");
				// Use try-with-resources
				// 2. Create SQL.
				String sql = "SELECT customer_id, name, region from customer"; // get any table in db sakila.
				// Get connection DriverManager is poor, DataSource is better choice.
				try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						// TODO: Create prepared statement.
						PreparedStatement stmt = ;)
						/* TODO: Get ResultSet from PreparedStatment
						it. */
						{

				/* TODO: Get Customer_id, name, region from
				result set before printing to console. */
					while (rs.next()) { // iterate through ResultSet and print data
						
						System.out.printf("ID: %d, Name: %s, Region: %s\n", id, name, region);
						
					}

				} catch (SQLException se) { // try - catch for Statement, Connection
					se.printStackTrace();
				}
	}
}
