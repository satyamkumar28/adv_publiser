package com.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.DBmanager;

import com.model.AdInfo;


/**
 * Servlet implementation class Testing
 */
@WebServlet("/test")
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); // session object created
		ArrayList<AdInfo> alist=null;
		String category = null;
		String subcategory = null;
		if(request.getParameter("button1")!=null){
			String param = request.getParameter("search");
			
		if(DBmanager.categoryexist(param)){
			alist = DBmanager.showAds(param);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showAds.jsp");
			request.setAttribute("display", alist);
			dispatcher.forward(request, response);
		}
		else if(DBmanager.subcategoryexist(param)){
			alist = DBmanager.showAds1(param);
			RequestDispatcher dispatcher = request.getRequestDispatcher("showAds.jsp");
			request.setAttribute("display", alist);
			dispatcher.forward(request, response);
		}
		else{
			out.println("No Advertisment found");
		}
		}
		///////after button click
		
		if(request.getParameter("param1")!=null){
			category=request.getParameter("param1");
			
				alist = DBmanager.showAds(category);
				RequestDispatcher dispatcher = request.getRequestDispatcher("showAds.jsp");
				request.setAttribute("display", alist);
				dispatcher.forward(request, response);
			
		}
		else if(request.getParameter("param2")!=null){
			subcategory=request.getParameter("param2");
			
				alist = DBmanager.showAds1(subcategory);
				RequestDispatcher dispatcher = request.getRequestDispatcher("showAds.jsp");
				request.setAttribute("display", alist);
				dispatcher.forward(request, response);
		}
		else{
			out.println("No Advertisment found");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
