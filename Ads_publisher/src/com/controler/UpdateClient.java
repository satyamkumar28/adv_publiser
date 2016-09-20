package com.controler;

import com.database.*;

import java.io.*;
import com.model.CustInfo;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UpdateClient
 */
@WebServlet("/UpdateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		Connection con=null;
		ResultSet rs=null;

		

  		
		String name=request.getParameter("name");
		String userid=(String)session.getAttribute("userid");
		String address=request.getParameter("address");
		
		long phno=Long.parseLong(request.getParameter("phno"));
		
		
		
		
		int flag=0;
		try
		{        
			con=DBmanager.getconnection();
			PreparedStatement stat= con.prepareStatement("Update adsusers set name='"+name+"',address='"+address+"',phno="+phno+" where userid=?" );
			stat.setString(1,userid);
			flag=stat.executeUpdate();
			
			
			
			
			
		if(flag==1)
		{
			out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('User ID already exists ! ');</SCRIPT>");
		    RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");
			rd.forward(request,response);
			
			CustInfo info=(CustInfo)session.getAttribute("info");
			info.setName(name);
			info.setId(userid);
			info.setAddress(address);
			info.setPhone(phno);
			session.setAttribute("info",info);
			
		}
		
	  }
	  catch(Exception e)
		{
			out.println("Error 1 "+e.getMessage());
		}
	
	  

	}

}
