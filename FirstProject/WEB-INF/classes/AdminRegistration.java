import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class AdminRegistration extends HttpServlet
{
	int flag1=0;
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	
PrintWriter pw = res.getWriter();
res.setContentType("text/html");

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<style>");
		pw.println("html{margin: 0px; padding: 0px; box-sizing: border-box;}");
		pw.println("*, *:before, *:after {box-sizing: inherit;}body{margin:0px; border:0px;}");
		pw.println("#main{width:100%; height:100%; background-color:cyan;}");
		pw.println(" #f1{width:100%;height:15%;background-color:black; float:left; padding-top:20px; padding-left:30px;}");
		pw.println("#f2{width:100%;height:85%;background-color:hot-pink;float:left;padding-top:20px;padding-left:50px;}");
		pw.println(".b1{border: 2px solid red; border-radius:12px; padding: 15px 32px;text-align: center;text-color:maroon;display: inline-block;margin-top:50px;font-size: 16px;cursor: pointer}");
		pw.println(".b1:hover{background-color:red;transition-duration:0.4s;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body >");
		pw.println("<div id='main'>");
		pw.println("<div id='f1'>");
		pw.println("<font size='7' color='white'>Quizathon </font>");
		pw.println("</div>");
		pw.println("<div id='f2'>");
		pw.println("<font size='6'color='blue'>");
		
		pw.println("<b>Admin Registration Panel</b></font>");
		pw.println("<br>");
		pw.println("<br><br>");
		pw.println("<center>");
		pw.println("<table>");
		pw.println("<form method='post'>");
		pw.println("<tr>");
		pw.println("<th> Username</th><td><input type='text' name='u1' required ></td></tr>");
		pw.println("<tr>");
		pw.println("<th>Password </th><td><input type='text' name='p1' required > </td></tr>");
		pw.println("<tr><td><input type='submit' value='Register' class='b1'></td></tr>");
		pw.println("</form>");
		pw.println("</table>");
		
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<center><a href='Admin'>BACK </a></center>");
		pw.println("<br>");
		pw.println("<br>");
		
		
		pw.println("</center>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");			
	
}	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
	PrintWriter pw = res.getWriter();
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	
	String query2= "insert into login values(?,?,?,?)";
	String s4= "admin";
	String s1= req.getParameter("u1");
	System.out.println("username is:::"+s1);
	String s2= req.getParameter("p1");
	String s3="";
	for (int i=0;i<7;i++)
	{
		s3+=(int)((Math.random()*9)+1);
		System.out.println(s3);
	}
	
	PreparedStatement ps= con.prepareStatement(query2);
	ps.setString(1,s1);
	ps.setString(2,s2);
	ps.setString(3,s3);
	ps.setString(4,s4);
	
	flag1= ps.executeUpdate();	
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}

	
	
	if(flag1==1)
	{ 
		pw.println("<body bgcolor='skyblue'><font size='4' color='white'> <center>Registration successful!</center></font></body>");
		pw.println("<center><a href='Admin'>Okay</a></center>");
		  
	}
	else
	{
	pw.println("<body bgcolor='skyblue'><font size='3' color='white'><center> Registration failed!Retry </center></font></body>");
	pw.println("<center><a href='Admin'>Okay</a></center>");
		  		
	}
}
}









