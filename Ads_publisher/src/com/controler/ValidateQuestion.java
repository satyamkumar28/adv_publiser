package com.controler;

import com.database.*;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.model.*;


/**
 * Servlet implementation class ValidateQuestion
 */
@WebServlet("/ValidateQuestion")
public class ValidateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateQuestion() {
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

		String id=request.getParameter("userid");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		
		int flag=0;
		

	try
	{       
		RequestDispatcher rd=null;
        con=DBmanager.getconnection();
		PreparedStatement stat= con.prepareStatement("SELECT * FROM adsusers where userid=?" );
		stat.setString(1,id);
		rs=stat.executeQuery();
		if(rs.next())
		{
			String tempquestion,tempanswer;
			tempquestion=rs.getString(6);
			tempanswer=rs.getString(7);
			if((tempquestion.equals(question))&&(tempanswer.equals(answer)))
			{
				flag=1;
			}
		}
		if(flag==1)
		{
			CustInfo info=new CustInfo();
			info.setQuestion(question);
			info.setAnswer(answer);
			info.setId(id);
			session.setAttribute("info",info);
			out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('User ID exists ! ');</SCRIPT>");
		    rd=request.getRequestDispatcher("ResetPassword.jsp");
		}
		else
		{
			  flag=0;
			  out.println("    <SCRIPT type='text/javascript'  language='JavaScript'>window.alert('Data didn't match ! ');</SCRIPT>");
			  rd=request.getRequestDispatcher("ClientLogin.jsp");
		}
		rd.forward(request,response);
	  }
	  catch(Exception e)
		{
			out.println("Error 1 "+e.getMessage());
		}

	}

}
