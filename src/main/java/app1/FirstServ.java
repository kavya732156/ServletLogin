package app1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/fs")
public class FirstServ extends HttpServlet 
{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	 {
		 String uname=req.getParameter("username");
		 String password=req.getParameter("password");
		 req.setAttribute("uname", uname);
		req.setAttribute("password", password);
		 RequestDispatcher rd=req.getRequestDispatcher("ss");
			rd.forward(req, resp);
	}

}
