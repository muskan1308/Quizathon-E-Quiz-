import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class DeleteCpp extends HttpServlet
{
	int qno;
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
PrintWriter pw = res.getWriter();
	qno= Integer.parseInt(req.getParameter("qno"));
	System.out.println("qno is:::"+qno);

try{

	Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query1= "Delete from cppquestions where Qno=?";
	PreparedStatement ps= con.prepareStatement(query1);
	ps.setInt(1,qno);
	int i= ps.executeUpdate();
	String query2="Alter table cppquestions drop column Qno";
	PreparedStatement ps1= con.prepareStatement(query2);
	ps1.executeUpdate();
	String query3= "alter table cppquestions add Qno int not null Auto_Increment primary key first";
	PreparedStatement ps2= con.prepareStatement(query3);
	ps2.executeUpdate();
	res.setContentType("text/html");
			if(i!=0)
			{
		pw.println("<center><font size='6' margin-bottom='30px' color='blue'>Question Deleted Successfully!</font></center>");
		pw.println("<br><br><center><a href='UpdateCpp'>Okay</a></center>");
		}
		else
		{
			pw.println("<center><font size='6' color='blue'>Try Again!</font></center>");
			pw.println("<br><br><center><a href='UpdateCpp'>Okay</a></center>");
		}
}
		catch(Exception e)
		{
		e.printStackTrace();
		}
}
}