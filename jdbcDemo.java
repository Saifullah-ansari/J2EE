package org.jspiders.jdbc_App;
import java.sql.*;
public class jdbcDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry ="insert into btm.student value(5,'rohit',60.75)";
		String qry1="insert into btm.student value(4,'nk',77.00)";
		String qry2="insert into btm.student value(6,'mohit',88.98)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class Loaded & Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("connection establish with database server");
			stmt = con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate(qry);
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			System.out.println("data inserted!!!");
			}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null)
			{
				try {
					stmt.close();
				}catch(SQLException e ) {e.printStackTrace();}
			}
			if(con!=null)
			{
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("closed all costly resources");
		}

	}

}
