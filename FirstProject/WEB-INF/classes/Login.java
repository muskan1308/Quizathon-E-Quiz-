import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Login extends HttpServlet
{
	String s3="";
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{

PrintWriter pw = res.getWriter();

String s1= req.getParameter("username");
String s2= req.getParameter("password");
HttpSession loginsession = req.getSession();
loginsession.setAttribute("id1",s1);
loginsession.setAttribute("id2",s2);

try{

Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query1= "select * from login where Username=? and Password=?";
	PreparedStatement ps= con.prepareStatement(query1);
	ps.setString(1,s1);
	ps.setString(2,s2);
	ResultSet rs= ps.executeQuery();
	
	if(rs.next()==true)
        {				
			
			s3 = rs.getString(4);
			
			if(s3.equalsIgnoreCase("admin"))
			{
				res.sendRedirect("Admin");
			}
			else
			{
				System.out.println("utype is ="+s3);
			res.sendRedirect("../Welcome.html");
			}
		}
        else
        {
			res.setContentType("text/html");
	
           pw.println("<body bgcolor='black'><font size='3' color='white'><center>Username or Password incorrect!Go back and try again</center></font></body>");
           pw.println("<center><form action='../index.html'><input type='submit' value='Back'></form></center>");
        }
	
		}
	catch(Exception e)
		{	
			e.printStackTrace();
		}
		
	}
}
