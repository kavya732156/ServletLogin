package app1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ss")
public class SecondServ  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		String uname= (String) req.getAttribute("uname");
		String password= (String) req.getAttribute("password");
		
		PrintWriter out=resp.getWriter();
		out.println("<html> <body bgcolor='orange' > ");
		out.println(uname +  " " +password );
		out.println("</html> </body>");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		String iqry="insert into corejava_db.login values(?,?) ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306 ? user=root & password=kavya" );
			System.out.println("Connection established");
			pstmt=con.prepareStatement(iqry);
			pstmt.setString(1, uname);
			pstmt.setString(2, password);
			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("data inserted sucessfully.....");
			}
			else {
				System.out.println("data not inserted.....");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
