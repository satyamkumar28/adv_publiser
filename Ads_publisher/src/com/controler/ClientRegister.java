package com.controler;

import com.database.*;

import com.model.*;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class ClientRegister
 */
@WebServlet("/ClientRegister")
public class ClientRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		Connection con=null;
		ResultSet rs=null;

		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		long phno=Long.parseLong(request.getParameter("phno"));
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		
		
		out.println(name+"  "+userid+"  "+password+"  "+address+"  "+phno+"  "+question+"  "+answer);
		
		int rows;
		int flag=0;
		

	try
	{        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","akhilesh","machine187");
		PreparedStatement stat= con.prepareStatement("SELECT * FROM adsusers where userid=?" );
		stat.setString(1,userid);
		rs=stat.executeQuery();
		if(rs.next())
		{
			flag=1;
		}
		else
		{
			  flag=0;
		}
		
		if(flag==1)
		{
			out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('User ID already exists ! ');</SCRIPT>");
		    RequestDispatcher rd=request.getRequestDispatcher("ClientRegistration.jsp");
			rd.forward(request,response);
		}
		
	  }
	  catch(Exception e)
		{
			out.println("Error 1 "+e.getMessage());
		}
	  if(flag==0)
	  {
		try
		{
		       
		    PreparedStatement stat=con.prepareStatement("insert into adsusers values(?,?,?,?,?,?,?,?)");
			stat.setString(1,name);
			stat.setString(2,userid);
			stat.setString(3,password);
			stat.setString(4,address);
			stat.setLong(5,phno);
		    stat.setString(6,question);
			stat.setString(7,answer);
			stat.setInt(8,0);
			
			rows=stat.executeUpdate();
		    
		 if(rows==0)
		 {
			out.println("Error : Inserting data in table");
		 }
		 else
		 {
				out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('Registration Successful ! ');</SCRIPT>");
			    RequestDispatcher rd=request.getRequestDispatcher("ClientLogin.jsp");
				rd.forward(request,response);

		 }

		}
		catch(Exception e)
		{
			out.println("Error 2"+e.getMessage());
		}
	   
	}
  }
}
		
