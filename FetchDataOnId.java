package org.jsp.jdbcApp;
//Code to fetch a particular record from the cursor or buffer memory where id=? .
import java.sql.*;
import java.util.Scanner;
public class FetchDataOnId {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id: ");
		int id=sc.nextInt();
		sc.close();
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String qry ="select * from btm.student where id=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established");
			pstmt =con.prepareStatement(qry);
			System.out.println("platform created");
			//Set the value for placeholder before Execution
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				String name=rs.getString(2);
				double per=rs.getDouble(3);
				System.out.println(name+ " "+per);
			}
			else
			{
				System.err.println("No Data found for Id"+id);
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
			System.out.println("Closed All costly Resources");
		}
	}
}


