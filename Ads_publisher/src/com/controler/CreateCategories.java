package com.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBmanager;
import com.model.AdInfo;

/**
 * Servlet implementation class CreateCategories
 */
@WebServlet("/CreateCategories")
public class CreateCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCategories() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	     PrintWriter out = response.getWriter();
	        String a = request.getParameter("category");
	        AdInfo info = new AdInfo();
	        info.setCategory(a);
	        if(DBmanager.insertCategory(info)){
	        	response.sendRedirect("admin/adminDashBoard.jsp");
	        }
	        else
	        	out.println("Insertion Unsuccessfull");
	        }
	}


