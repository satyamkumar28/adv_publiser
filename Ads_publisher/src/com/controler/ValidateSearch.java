package com.controler;

import com.database.*;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.model.CustInfo;



/**
 * Servlet implementation class ValidateSearch
 */
@WebServlet("/ValidateSearch")
public class ValidateSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateSearch() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String category,subcategory,title;
		category=request.getParameter("category");
		subcategory=request.getParameter("subcategory");
		
		CustInfo info=(CustInfo)session.getAttribute("info");
		ArrayList<String> ads=new ArrayList<String>();
		
		try
		{
			Connection con=DBmanager.getconnection();
			PreparedStatement ps=con.prepareStatement("Select * from advertiser_table where cat='"+category+"' and sub-cat='"+subcategory+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				title=rs.getString(3);
				ads.add(title);
			}
			session.setAttribute("ads",ads);
			RequestDispatcher rd=request.getRequestDispatcher("SearchDisplay.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
