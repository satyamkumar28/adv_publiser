package com.controler;

import com.database.*;

import java.io.IOException;
import java.sql.*;
import com.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBuser
 */
@WebServlet("/DBuser")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
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
		CustInfo info=(CustInfo)request.getAttribute("info");
		String id=info.getId();
		String name="",address;
		Long phone;
		int ewallet;
		try
		{
			ResultSet rs=DBuser.getresultset(id);
			info.setName(rs.getString(1));
			info.setId(rs.getString(2));
			info.setPassword(rs.getString(3));
			info.setAddress(rs.getString(4));
			info.setPhone(rs.getLong(5));
			info.setQuestion(rs.getString(6));
			info.setAnswer(rs.getString(7));
			info.setEwallet(rs.getInt(8));
			
			request.setAttribute("info",info);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
