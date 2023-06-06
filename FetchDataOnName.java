package org.jsp.jdbcApp;
//Code to fetch a particular record from the cursor or buffer memory where name=? .
import java.sql.*;
import java.util.Scanner;
public class FetchDataOnName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name =sc.nextLine();
		sc.close();
		
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		String qry ="Select * from btm.student where name=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform created");
			//set the value for placeholder before execution
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				double per=rs.getDouble(3);
				System.out.println(id+" "+per);
			}
			else
			{
				System.err.println("No Data Found for Name "+name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("closed all costly resources");
		}
		

	}

}
