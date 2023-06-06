package org.jsp.jdbcApp;
//Code to fetch all records from the cursor or buffer memory by using ResultSet Interface:
import java.sql.*;

public class FetchData {

       public static void main(String[] args) {
    	   Connection con =null;
    	   PreparedStatement pstmt=null;
    	   ResultSet rs=null;
    	   String qry ="select * from btm.student";
    	   try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform creted");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name=rs.getString(2);
				double per=rs.getDouble(3);
				System.out.println("Id: "+id);
				System.out.println("Name: "+name);
				System.out.println("Percantage: "+per);
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
    		 if(pstmt!=null) {
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
    		 System.out.println("All costly resources closed");
    	 }
    	   
			
		}
	}


