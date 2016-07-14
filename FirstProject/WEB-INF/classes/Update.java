import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Update extends HttpServlet
{

String name1="",fname="",phone="",email="",uname="",pass="";
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
	String query1= "Select * from registration where id=?";
	PreparedStatement ps= con.prepareStatement(query1);
	ps.setInt(1,id);
	ResultSet rs= ps.executeQuery();
	
	while(rs.next())
        {				
			 name1 = rs.getString(1);
			fname = rs.getString(2);
			 phone = rs.getString(3);
			email = rs.getString(4);
			uname = rs.getString(5);
			 pass = rs.getString(6);
			 id = rs.getInt(7);
			System.out.println("id is::::"+id);		
		res.setContentType("text/html");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<style>");
		pw.println("html{margin: 0px; padding: 0px; box-sizing: border-box;}");
		pw.println("*, *:before, *:after {box-sizing: inherit;}body{margin:0px; border:0px;}");
		pw.println("#main{width:100%; height:100%; background-color:cyan;}");
		pw.println(" #f1{width:100%;height:15%;background-color:black; float:left; padding-top:20px; padding-left:30px;}");
		pw.println("#f2{width:100%;height:85%;background-color:hot-pink;float:left;padding-top:20px;padding-left:50px;}");
		pw.println(".b1{border: 2px solid red; border-radius:12px; padding: 15px 32px;text-align: center;text-color:maroon;display: inline-block;font-size: 16px;cursor: pointer}");
		pw.println(".b1:hover{background-color:red;transition-duration:0.4s;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body >");
		pw.println("<div id='main'>");
		pw.println("<div id='f1'>");
		pw.println("<font size='7' color='white'>Quizathon Manage Users </font>");
		pw.println("</div>");
		pw.println("<div id='f2'>");
		pw.println("<font size='6'color='blue'>");
		pw.println("<b>Update Student Information</b></font>");
		pw.println("<br>");
		pw.println("<br><br>");
		pw.println("<center>");
		pw.println("<table>");
		pw.println("<form method='post'>");
		pw.println("<tr>");
		pw.println("<th> Name</th><td><input type='text' name= 'name1' value= "+name1+"  ></td></tr>");
		pw.println("<tr>");
		pw.println("<th>Father's Name </th><td><input type='text' name= 'fname' value= "+fname+" > </td></tr>");
		pw.println("<tr><th>Phone </th><td><input type='text' name= 'phone' value= "+phone+"  > </td></tr>");
		pw.println("<tr><th>Email </th><td><input type='text' name= 'email' value= "+email+" > </td></tr>");
		pw.println("<tr><th>Username </th><td><input type='text' name='uname' value= "+uname+" > </td></tr>");
		pw.println("<tr><th>Password </th><td><input type='text' name= 'pass' value= "+pass+" > </td></tr>");
		pw.println("<tr><th>Id </th><td><input type='text' name= 'id' readonly='true' value= "+id+"  > </td></tr>");
		pw.println("<tr><input type='submit' value='Update' class='b1'></tr>");
		pw.println("</form>");
		
		pw.println("</table>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<br>");
		
		
		pw.println("</center>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");	
		}
		}
	catch(Exception e)
		{	
			e.printStackTrace();
		}
}

		
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{	

	
	 int id= Integer.parseInt(req.getParameter("id"));
	   System.out.println("id is:::"+id);
	   name1 = req.getParameter("name1");
	 System.out.println("name is :::::"+name1);
	fname= req.getParameter("fname");
	phone= req.getParameter("phone");
	 email= req.getParameter("email");
	 uname= req.getParameter("uname");
	 pass= req.getParameter("pass");
	
		
		PrintWriter pw= res.getWriter();
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query= "Update registration set name=?,fathersname=?,mobilenumber=?,emailid=?,username=?,password=? where id=? ";
	PreparedStatement ps= con.prepareStatement(query);
	ps.setString(1,name1);
	ps.setString(2,fname);
	ps.setString(3,phone);
	ps.setString(4,email);
	ps.setString(5,uname);
	ps.setString(6,pass);
	ps.setInt(7,id);
	
	
	 
	
	int i = ps.executeUpdate();
	res.setContentType("text/html");
			if(i!=0)
			{
		pw.println("<center><font size='6' margin-bottom='30px' color='blue'>Record Updated Successfully!</font></center>");
		pw.println("<br><br><center><a href='ViewAllRecords'>Okay</a></center>");
		
	
		}}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
			
		}
}
