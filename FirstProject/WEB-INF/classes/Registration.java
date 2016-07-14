import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Registration extends HttpServlet
{
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	int flag1=0,flag2=0;
PrintWriter pw = res.getWriter();
res.setContentType("text/html");
String s1= req.getParameter("name");
String s2= req.getParameter("fname");
String s3= req.getParameter("mobile");
String s4= req.getParameter("email");
String s5= req.getParameter("uname");
String s6= req.getParameter("pass");
String s7= req.getParameter("utype");

String id= "";
for (int i=0;i<7;i++)
{
id+=(int)((Math.random()*9)+1);
System.out.println(id);
}


	
	try{
		Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query1= "insert into registration values(?,?,?,?,?,?,?,?)";
	String query2= "insert into login values(?,?,?,?)";
	
	
	PreparedStatement ps= con.prepareStatement(query1);
	ps.setString(1,s1);
	ps.setString(2,s2);
	ps.setString(3,s3);
	ps.setString(4,s4);
	ps.setString(5,s5);
	ps.setString(6,s6);
	ps.setString(8,s7);
	ps.setString(7,id);
	flag1= ps.executeUpdate();	
	PreparedStatement ps1= con.prepareStatement(query2);
	ps1.setString(1,s5);
	ps1.setString(2,s6);
	ps1.setString(3,id);
	ps1.setString(4,s7);
	flag2= ps1.executeUpdate();
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}

	
	
	if(flag1==flag2)
	{ 
		pw.println("<body bgcolor='skyblue'><font size='5' color='blue'> <center>Registration successful! Go back and Login</center></font></body>");
		  pw.println("<center><a href='../index.html'>Back</a></center>");
	}
	else
	{
	pw.println("<body bgcolor='skyblue'><font size='5' color='blue'><center> Registration failed!Go back and Retry </center></font></body>");		
	pw.println("<center><a href='../index.html'> Back </a></center>");
	}
}
}









