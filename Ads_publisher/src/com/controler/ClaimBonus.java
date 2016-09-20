package com.controler;

import com.database.*;
import com.model.*;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class ClaimBonus
 */
@WebServlet("/ClaimBonus")
public class ClaimBonus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClaimBonus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Connection con=null;
		ResultSet rs=null;
		int i=0,j=0;
		
		CustInfo info=(CustInfo)session.getAttribute("info");
		String userid=(String)session.getAttribute("userid");
		int popimgid=info.getPopupimgid();
		out.println("Hello");
		try
		{
			con=DBmanager.getconnection();
			PreparedStatement ps=con.prepareStatement("insert into adshistory values(?,?)");
			ps.setString(1, userid);
			ps.setInt(2, popimgid);
			i=ps.executeUpdate();
			
			PreparedStatement ps1=con.prepareStatement("update adsusers set ewallet=ewallet+5 where userid=?");
			ps1.setString(1, userid);
			i+=ps1.executeUpdate();
			
			
			if(i>1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Close.jsp");
				rd.forward(request,response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
