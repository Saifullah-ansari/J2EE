package org.jsp.jdbcApp;
//code to insert multiple data into database server by using PreparedStatement interface with PlaceHolder:
import java.sql.*;

public class InsertMultipal {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt =null;
		String qry = "insert into btm.student value(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connectin Established");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform created ");
			//SET the value Place holder before Execution
			pstmt.setInt(1,101);
			pstmt.setString(2, "Rahul");
			pstmt.setDouble(3, 45.55);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,102);
			pstmt.setString(2, "Nitish");
			pstmt.setDouble(3, 45.55);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,103);
			pstmt.setString(2, "Sid");
			pstmt.setDouble(3, 45.55);
			pstmt.executeUpdate();
			
			System.out.println("Data Inserted Successfully");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				if(con!=null)
				{
					try {
						con.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				System.out.println("All costly resources Closed");
			}
		}

	}

}
