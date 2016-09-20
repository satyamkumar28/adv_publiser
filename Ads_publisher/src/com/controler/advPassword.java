package com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.DBmanager;
import com.database.DbManger;
import com.model.CustInfo;
import com.model.RegUserInfo;

/**
 * Servlet implementation class advPassword
 */
@WebServlet("/advPassword")
public class advPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public advPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		RegUserInfo info=(RegUserInfo)session.getAttribute("info");
		String id=info.getId();
		int flag=0;
		out.println(password+"     "+id);
	try
	{       
		RequestDispatcher rd=null;
        con=DbManger.getconnection();
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


