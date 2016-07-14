import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class ViewAllRecords extends HttpServlet
{
	String name,fname,mobile,email,uname,id;
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
	
	PrintWriter pw = res.getWriter();
	
	try{

	Class.forName("com.mysql.jdbc.Driver");
	String dburl="jdbc:mysql://localhost:3306/firstproject";
	Connection con= DriverManager.getConnection(dburl,"root","rat");
	String query1= "select * from registration ";
	PreparedStatement ps= con.prepareStatement(query1);
	
	ResultSet rs= ps.executeQuery();
	
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
	pw.println(".t1{display:table;border-collapse:separate;border-spacing:4px;border-color:solid red;margin-top:60px;align:center;width:90%;}");
	pw.println("th, td {border-bottom: 1px solid #ddd;text-align:center;height:20px;}");
	pw.println("th {background-color: lightskyblue;color: white;text-align:center; height:40px;}");
	pw.println(".b1{border: 2px solid blue;border-radius:12px;padding: 15px 32px;text-align: center;text-color:black;display: inline-block;font-size: 16px;cursor: pointer;}");
	pw.println(".b1:hover{background-color: moccasin;transition-duration:0.4s;}");
	pw.println(".r1{margin-left:100px;}");
	pw.println("</style>");
	pw.println("</head>");
	pw.println("<body bgcolor='lightblue'>");
	pw.println("<div id='main'>");
	pw.println("<div id='first'>");
	pw.println("<div id='f1'> <font size='7' color='white'> Quizathon Manage Users </font></div>");
	pw.println("<div id='f2'><div id='f21'><img src='"+req.getContextPath()+"/images/rat.jpg' height='100px' width='200px' alt='RAT logo'></div></div>");
	pw.println("</div>");
	pw.println("<div id ='second'>");
	pw.println("<font size='7' color='red' face='sans-serif'><b> Student Details </b></font>");
	pw.println("<center>");
	pw.println("<table border='1' class='t1'>");
	pw.println("<tr><th> Name </th><th> Father's Name </th><th> Mobile Number </th><th> Email Id </th><th> Username </th><th> Id </th><th> Update </th><th> Delete </th></tr>");
	while(rs.next()){
		 name = rs.getString(1);
		 fname = rs.getString(2);
		 mobile = rs.getString(3);
		 email = rs.getString(4);
		 uname = rs.getString(5);
		id = rs.getString(7);

	pw.println("<tr><td> "+name+" </td> <td>"+fname+"</td><td>"+mobile+"</td><td>"+email+"</td><td>"+uname+"</td><td>"+id+" </td><td><a href='Update?id="+id+"'>Update</a></td><td><a href='Delete?id="+id+"'>Delete</a></td></tr>");
	}
	pw.println("</table>");
	pw.println("</center>");
    pw.println("<br>");  
    pw.println("<br>");  
    pw.println("<br>");  
	pw.println("<center><a href='Admin'>Back</a></center>");
	
	pw.println("</div>");  
    pw.println("</div>");  
    pw.println("</body>");  
    pw.println("</html>");  
}

catch(Exception e)
{
e.printStackTrace();
}


}
}
