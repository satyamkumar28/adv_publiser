package com.controler;

import com.database.*;
import com.model.*;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



/**
 * Servlet implementation class ValidateClient
 */
@WebServlet("/ValidateClient")
public class ValidateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		RequestDispatcher rd=null;
		Connection con=null;
		ResultSet rs=null;
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		int flag=0;
		String name="",address="",question="",answer="";
		int ewallet=0,previous=1,next=3,start=1,popupimgid=1;
		long phone=0;
		
		out.println("Ok1");
		try
		{			
	        con=DBmanager.getconnection();
			PreparedStatement stat= con.prepareStatement("SELECT * FROM adsusers where userid=? and password=?" );
			stat.setString(1,userid);
			stat.setString(2,password);
			out.println("Ok");
			rs=stat.executeQuery();
			
			if(rs.next())
			{
				flag=1;
				name=rs.getString(1);
				address=rs.getString(4);
				phone=rs.getLong(5);
				question=rs.getString(6);
				answer=rs.getString(7);
				ewallet=rs.getInt(8);
		
			}
			else
			{
				  flag=0;
			}
		
			if(flag==1)
			{
				CustInfo info=new CustInfo();
				info.setName(name);
				info.setId(userid);
				info.setPassword(password);
				info.setAddress(address);
				info.setPhone(phone);
				info.setQuestion(question);
				info.setAnswer(answer);
				info.setEwallet(ewallet);
				info.setPrevious(previous);
				info.setStart(start);
				info.setNext(next);
				info.setPopupimgid(popupimgid);
				session.setAttribute("info",info);
				session.setAttribute("userid",userid);
			    rd=request.getRequestDispatcher("ClientPage.jsp");
			
			}
			else
			{
					out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('Wrong Userid or password ! Try again ! ');</SCRIPT>");
				    rd=request.getRequestDispatcher("ClientLogin.jsp");
				    
			}
			
			rd.forward(request,response);
		
		}
	    catch(Exception e)
		{
			out.println("Exception aa gyi"+e.getMessage());
		}
	}
}