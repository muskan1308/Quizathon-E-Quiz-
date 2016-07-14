import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class ManageExam extends HttpServlet
{
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{

PrintWriter pw = res.getWriter();

	res.setContentType("text/html");
pw.println("<html>");
pw.println("<head>");
pw.println("<style>");
pw.println("html{margin: 0px;padding: 0px;box-sizing: border-box;}");
pw.println("*, *:before, *:after {box-sizing: inherit;}");
pw.println(".b1{border: 2px solid blue;border-radius:12px;padding: 15px 32px;text-align: center;text-color:black;display: inline-block;font-size: 40px;cursor: pointer;}");
pw.println(".b1:hover{background-color: blue;transition-duration:0.4s;}");
pw.println("body{margin: 0px;padding: 0px;}");
pw.println("#main{width:100%; height:100%; background-color:hot-pink;}");
pw.println("#f1{width:100%; height:15%;background-color:black; float:left; padding-top:20px; padding-left:30px;}");
pw.println("#f2{width:100%;height:85%; background-color:lightblue; float:left; padding-top:70px; padding-left:60px;}");

pw.println("</style>");
pw.println("</head>");
pw.println("<body bgcolor='hotpink'>");
pw.println("<div id='main'><div id='f1'> <font size='7' color='white'> Quizathon Manage Questions </font></div>");
 pw.println("<div id='f2'>");
 pw.println("<center>");
pw.println("<form action='UpdateJava'><input type='submit' class='b1' value='Manage Java Questions'></form>");
pw.println("</center>");
pw.println("<center>");
pw.println("<form action='UpdateC'><input type='submit' class='b1' value='Manage C Questions'></form>");
pw.println("</center>");
pw.println("<center>");
pw.println("<form action='UpdateCpp'><input type='submit' class='b1' value='Manage C++ Questions'></form>");
pw.println("</center>");
pw.println("<br>");
pw.println("<br>");
pw.println("<br>");
pw.println("<center><a href='Admin'> Back</a></center>");
pw.println("</div>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");

}

public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
	doGet(req,res);
}
}
