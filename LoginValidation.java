package com.jsp.jdbcApp;
//code for Login Validation using Standard step of JDBC.
import java.sql.*;
import java.util.Scanner;

public class LoginValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name?? ");
		String name=sc.nextLine();
		
		System.out.println("Enter Password: ");
		String password=sc.nextLine();
		sc.close();
		
		Connection con =null;
		PreparedStatement pstmt=null;
		String qry="select username from btm1.user where name=? and password=?";
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("connection Established");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform created");
			//Set value for placeholder before Execution
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				String username=rs.getString(1);
				System.out.println("Welcome "+username);
			}
			else {
				System.err.println("Invalid name or password");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	

}
