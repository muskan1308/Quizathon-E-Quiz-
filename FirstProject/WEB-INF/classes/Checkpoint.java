import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Checkpoint extends HttpServlet
{
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	HttpSession session = req.getSession();
	String s1=(String)session.getAttribute("id1");
	String s2=(String)session.getAttribute("id2");
	String s3= req.getParameter("condition");
	System.out.println(s3);
	if(s3.equals("disagree"))
	{
		System.out.println("inside disagree");
		HttpSession loginsession =req.getSession(false);
	loginsession.invalidate();
	res.sendRedirect("../index.html");
	}
	else if(s3.equalsIgnoreCase("agree"))
	{	System.out.println("inside agreee");		
		 res.sendRedirect("Sections");
	}
	
}
}