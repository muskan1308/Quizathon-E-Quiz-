import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Delete extends HttpServlet
{
	int id;
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw = res.getWriter();
	id= Integer.parseInt(req.getParameter("id"));
	System.out.println("id is:::"+id);

try{

	Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query1= "Delete from registration where id=?";
	PreparedStatement ps= con.prepareStatement(query1);
	ps.setInt(1,id);
	int i= ps.executeUpdate();
	
	res.setContentType("text/html");
			if(i!=0)
			{
		pw.println("<center><font size='6' margin-bottom='30px' color='blue'>Record Deleted Successfully!</font></center>");
		pw.println("<br><br><center><a href='ViewAllRecords'>Okay</a></center>");
		}
		else
		{
			pw.println("<center><font size='6' color='blue'>Try Again!</font></center>");
			pw.println("<br><br><center><a href='ViewAllRecords'>Okay</a></center>");
		}
}
		catch(Exception e)
		{
		e.printStackTrace();
		}
}
}