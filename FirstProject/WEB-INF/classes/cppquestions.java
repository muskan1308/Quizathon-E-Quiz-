import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class cppquestions extends HttpServlet
	{
		int correct,wrong,skip,userans,flag=0;
		int qCount=1;
		String cans,o1,o2,o3,o4,q;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{	
		
		
		
		PrintWriter pw = res.getWriter();
	try{

	Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query1= "Select * from cppquestions where Qno=?";
	PreparedStatement ps= con.prepareStatement(query1);
	ps.setInt(1,qCount);
	ResultSet rs= ps.executeQuery();
	
	res.setContentType("text/html");
	if(rs.next())
	{
		 q = rs.getString(2);
		 o1 = rs.getString(3);
		 o2 = rs.getString(4);
		 o3 = rs.getString(5);
		 o4 = rs.getString(6);
		cans= rs.getString(7);
	
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<style>");
		pw.println("html{margin: 0px; padding: 0px; box-sizing: border-box;}");
		pw.println("*, *:before, *:after {box-sizing: inherit;}body{margin:0px; border:0px;}");
		pw.println("#main{width:100%; height:100%; background-color:cyan;}");
		pw.println(" #f1{width:100%;height:15%;background-color:black; float:left; padding-top:20px; padding-left:30px;}");
		pw.println("#f2{width:100%;height:85%;background-color:hot-pink;float:left;padding-top:100px;padding-left:100px;}");
		pw.println(".b1{border: 2px solid red; border-radius:12px; padding: 15px 32px;text-align: center;text-color:maroon;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer}");
		pw.println(".b1:hover{background-color:red;transition-duration:0.4s;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body bgcolor='hot-pink'>");
		pw.println("<div id='main'>");
		pw.println("<div id='f1'>");
		pw.println("<font size='7' color='white'>Quizathon </font>");
		pw.println("</div>");
		pw.println("<div id='f2'>");
		pw.println("<font size='5'color='black'>");
		pw.println("Question");
		pw.println(qCount+"::"+q);
		pw.println("</font>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<form action='cppquestions' method='post'>");
		pw.println("<input type='radio'name='ans'value='a'>");
		pw.print(o1);
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<input type='radio'name='ans'value='b'>");
		pw.print(o2);
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<input type='radio'name='ans'value='c'>");
		pw.print(o3);
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<input type='radio'name='ans'value='d'>");
		pw.println(o4);
		pw.println("<br><br>");
		pw.println("<input type='radio'name='ans'value='Skip'>");
		pw.print("Skip Question");
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<input type='submit' class='b1' value= 'Next'>");
		pw.println("</form>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</body>");
		pw.println("</html>");
	}
	else if(rs.next()==false)
	{
		flag=1;		
		HttpSession cppsession= req.getSession();
		cppsession.setAttribute("cppskip",skip);
		cppsession.setAttribute("cppcorrect",correct);
		cppsession.setAttribute("cppwrong",wrong);
		
		
		System.out.println("end of cpp questions");
		res.setContentType("text/html");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<style>");
		pw.println("html{margin: 0px; padding: 0px; box-sizing: border-box;}");
		pw.println("*, *:before, *:after {box-sizing: inherit;}body{margin:0px; border:0px;}");
		pw.println("#main{width:100%; height:100%; background-color:cyan;}");
		pw.println(" #f1{width:100%;height:15%;background-color:black; float:left; padding-top:20px; padding-left:30px;}");
		pw.println("#f2{width:100%;height:85%;background-color:hot-pink;float:left;padding-top:100px;padding-left:100px;}");
		pw.println(".b1{border: 2px solid red; border-radius:12px; padding: 15px 32px;text-align: center;text-color:maroon;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer}");
		pw.println(".b1:hover{background-color:red;transition-duration:0.4s;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body bgcolor='hotpink'>");
		pw.println("<div id='main'>");
		pw.println("<div id='f1'>");
		pw.println("<font size='7' color='white'>Quizathon </font>");
		pw.println("</div>");
		pw.println("<div id='f2'>");
		pw.println("<font size='6'color='black'>");
		pw.println("<center>");
		pw.println("<b>You've reached the end of CPP Questions</b></font>");
		pw.println("</center>");
		pw.println("<br><br>");
		pw.println("<br><br>");
		pw.println("<center>");
		pw.println("<form action='Resultcpp' method='get'>");
		pw.println("<input type='submit' value='Go to Results Page' class='b1'>");
		pw.println("</form>");
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
	qCount++;
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{	
	
		String userans= req.getParameter("ans");
		if(userans!=null)
		{
			if(userans.equals("Skip"))
				skip++;
			else if(userans.equals(cans))
				correct++;
			else
				wrong++;
		}
		else{
			skip++;
			}
	System.out.println(correct+":::"+wrong+":::"+skip);
	
	
	doGet(req,res);
	}
	
	}
	
	
	