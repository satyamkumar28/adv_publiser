package com.controler;

import com.database.*;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.CustInfo;


/**
 * Servlet implementation class PasswordReset
 */
@WebServlet("/PasswordReset")
public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordReset() {
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
		
		String password=request.getParameter("newpassword");
		CustInfo info=(CustInfo)session.getAttribute("info");
		String id=info.getId();
		int flag=0;
		out.println(password+"     "+id);
	try
	{       
		RequestDispatcher rd=null;
        con=DBmanager.getconnection();
		PreparedStatement stat= con.prepareStatement("Update adsusers set password='"+password+"' where userid='"+id+"'");
		flag=stat.executeUpdate();
		
		if(flag==1)
		{
			out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('Password Updated ! ');</SCRIPT>");
		    rd=request.getRequestDispatcher("ClientLogin.jsp");
		}
		else
		{
			  flag=0;
			  out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('Sorry, Error in updation ! ');</SCRIPT>");
			  rd=request.getRequestDispatcher("ForgotPassword.jsp");
		}
		rd.forward(request,response);
	  }
	  catch(Exception e)
		{
			out.println("Error 1 "+e.getMessage());
		}


		
		
	}

}
