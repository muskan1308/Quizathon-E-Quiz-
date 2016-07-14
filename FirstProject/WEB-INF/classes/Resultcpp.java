import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Resultcpp extends HttpServlet
{
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	
	PrintWriter pw = res.getWriter();
	HttpSession cppsession = req.getSession(false);
	Integer cpc=(Integer)cppsession.getAttribute("cppcorrect");
	Integer cpw=(Integer)cppsession.getAttribute("cppwrong");
	Integer cppskipped =(Integer)cppsession.getAttribute("cppskip");
	System.out.println("c corrrect in cresult are="+cpc);
	int cppmarks= cpc*5;
	
	res.setContentType("text/html");
	pw.println("<html>");
	pw.println("<head>");
	pw.println("<style>");
	pw.println("html{margin: 0px;padding: 0px;box-sizing: border-box;}");
	pw.println("*, *:before, *:after {box-sizing: inherit;}");
	pw.println("body{margin: 0px;padding: 0px;}");
	pw.println("#main{background-color:lightblue;width:100%;height:100%;}");
	pw.println("#first{background-color:black;height:15%;width:100%;float:left;}");
	pw.println("#f1{background-color:black;width:50%;height:100%;float:left;padding-top:30px;padding-left:30px;}");
	pw.println("#f2{background-color:black;width:50%;height:100%;float:left;}");
	pw.println("#f21{background-color:black;width:30%;height:100%;float:right;padding-top:0px;}");
	pw.println("#second{padding-left:30px;padding-top:30px;height:85%;width:100%;float:left;}");
	pw.println(".t1{display:table;border-collapse:separate;border-spacing:4px;border-color:solid red;margin-top:60px;align:center;width:60%;	height:80px;}");
	pw.println("th, td {border-bottom: 1px solid #ddd;text-align:center;height:60px;}");
	pw.println("th {background-color: lightskyblue;color: white;text-align:center;}");
	pw.println(".b1{border: 2px solid blue;border-radius:12px;padding: 15px 32px;text-align: center;text-color:black;display: inline-block;font-size: 16px;cursor: pointer;}");
	pw.println(".b1:hover{background-color: blue;transition-duration:0.4s;}");
	pw.println(".r1{margin-left:100px;}");
	pw.println("</style>");
	pw.println("</head>");
	pw.println("<body bgcolor='lightblue'>");
	pw.println("<div id='main'>");
	pw.println("<div id='first'>");
	pw.println("<div id='f1'> <font size='7' color='white'> Quizathon Results </font></div>");
	pw.println("<div id='f2'><div id='f21'><img src='"+req.getContextPath()+"/images/rat.jpg' height='100px' width='200px' alt='RAT logo'></div></div>");
	pw.println("</div>");
	pw.println("<div id ='second'>");
	pw.println("<font size='6' color='red' face='sans-serif'> Thankyou for your time. Please check your result!</font>");
	pw.println("<center>");
	pw.println("<table border='1' class='t1'>");
	pw.println("<tr><th> Subject </th><th> Correct Answers </th><th> Wrong Answers </th><th> Skipped Questions </th><th> Marks Obtained </th></tr>");
	pw.println("<tr><td> C++ </td> <td>"+cpc+"</td><td>"+cpw+"</td><td>"+cppskipped+"</td><td>"+cppmarks+"</td></tr>");
    pw.println("</table>");
	pw.println("</center>");
    pw.println("<br>");  
    pw.println("<br>");  
    pw.println("<br>");  
	pw.println("<center>");
    pw.println("<form action='Sections'>");  
    pw.println("<input type='submit' value= 'Take another test' class='b1'></form>");  
	
    pw.println("<form action='Logout'>");  
    pw.println("<input type='submit' value= 'Log Out' class='b1'></form>");  
    pw.println("</center>");
	pw.println("</div>");  
    pw.println("</div>");  
    pw.println("</body>");  
    pw.println("</html>");  
}
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	return;
}
}
