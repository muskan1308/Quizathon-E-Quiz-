import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Test extends HttpServlet
	{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{	
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<style>");
		pw.println("html{ margin:0px; padding:0px;}");
		pw.println("body{ margin:0px; padding:0px;}");
		pw.println("</style></head>");
		pw.println("<body bgcolor='hot-pink'>");
		pw.println("<form action='bullshit' name='waddup'>");
		pw.println("<input type='radio' name='bs' value='youknow'>");
		pw.println("</form>");
		pw.println("</body>");
		
	}
	}