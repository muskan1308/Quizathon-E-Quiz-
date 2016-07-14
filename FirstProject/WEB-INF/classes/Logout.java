import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
public class Logout extends HttpServlet
{
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{

int flag=0;


HttpSession loginsession = req.getSession(false);
loginsession.invalidate();
flag=1;
if(flag==1){
RequestDispatcher rd = req.getRequestDispatcher("../index.html");
rd.forward(req, res);
}      
}
}