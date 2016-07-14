import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class AddC extends HttpServlet
{

String question="",o1="",o2="",o3="",o4="",cans="";
int qno;

public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	PrintWriter pw = res.getWriter();
	
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
	pw.println(".t1{display:table;border-collapse:separate;border-spacing:4px;border-color:solid red;margin-top:60px;align:center;width:60%;}");
	pw.println("th, td {border-bottom: 1px solid #ddd;text-align:center;height:10px;}");
	pw.println("th {background-color: lightskyblue;color: white;text-align:center; height:10px;}");
	pw.println(".b1{border: 2px solid blue;border-radius:12px;padding: 15px 32px;text-align: center;text-color:black;display: inline-block;font-size: 16px;cursor: pointer;}");
	pw.println(".b1:hover{background-color: moccasin;transition-duration:0.4s;}");
	pw.println(".r1{margin-left:100px;}");
	pw.println("</style>");
	pw.println("</head>");
	pw.println("<body bgcolor='lightblue'>");
	pw.println("<div id='main'>");
	pw.println("<div id='first'>");
	pw.println("<div id='f1'> <font size='7' color='white'>Quizathon Manage Exam</font></div>");
	pw.println("<div id='f2'><div id='f21'><img src='rat.jpg' height='100px' width='200px' alt='RAT logo'></div></div>");
	pw.println("</div>");
	pw.println("<div id ='second'>");
	pw.println("<font size='6' color='red'>Add C Question</font>");
	pw.println("<center>");
	pw.println("<table border='1' class='t1'>");
	pw.println("<form method='post'>");
	pw.println("<tr><th> Question  </th><td><input type='text' name='question'  ></td></tr>"); 
	pw.println("<tr><th> Option a</th><td><input type='text' name='o1'  ></td></tr>"); 
	pw.println("<tr><th> Option b </th><td><input type='text' name='o2'  ></td></tr>"); 
	pw.println("<tr><th> Option c </th><td><input type='text' name='o3'  ></td></tr>"); 
	pw.println("<tr><th> Option d</th><td><input type='text' name='o4'  ></td></tr>"); 
	pw.println("<tr><th> Correct answer </th><td><input type='text' name='cans' ></td></tr>"); 
	pw.println("<br><br>");
	pw.println("<tr><td><input type='submit' class='b1' value='Add'></td><td></td></tr>");
	pw.println("</form>");
	pw.println("</table>");
	pw.println("<br><br><br>");
	pw.println("<center><a href='UpdateC'>BACK</a></center>");
	pw.println("</div>");  
    pw.println("</div>");  
    pw.println("</body>");  
    pw.println("</html>");  
	
}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	PrintWriter pw = res.getWriter();
	question= req.getParameter("question");
	o1= req.getParameter("o1");
	o2= req.getParameter("o2");
	o3= req.getParameter("o3");
	o4= req.getParameter("o4");
	cans= req.getParameter("cans");
	
	
try{

	Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query1= "select count(*) from cquestions ";
	PreparedStatement ps= con.prepareStatement(query1);
	
	ResultSet rs= ps.executeQuery();
	rs.last();
	int count= rs.getInt("count(*)");
    
	System.out.println("count of c ques is"+count);	
		
		
		String query2 = " insert into cquestions(Question,a,b,c,d,cans) values(?,?,?,?,?,?) "; 
		PreparedStatement ps1 = con.prepareStatement(query2);
		
		ps1.setString(1,question);
		ps1.setString(2,o1);
		ps1.setString(3,o2);
		ps1.setString(4,o3);
		ps1.setString(5,o4);
		ps1.setString(6,cans);
		int i= ps1.executeUpdate();
		
		res.setContentType("text/html");
			if(i!=0)
			{
		pw.println("<center><font size='6' margin-bottom='30px' color='blue'>Question Added Successfully!</font></center>");
		pw.println("<br><br><center><a href='UpdateC'>Okay</a></center>");
		}
		else
		{pw.println("<center><font size='6' margin-bottom='30px' color='blue'>Try Again!</font></center>");
		pw.println("<br><br><center><a href='UpdateC'>Okay</a></center>");
		
			
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}

	}	
	
	
	
	}

