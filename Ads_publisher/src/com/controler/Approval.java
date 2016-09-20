package com.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBmanager;

/**
 * Servlet implementation class Approval
 */
@WebServlet("/Approval")
public class Approval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approval() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int adid  = Integer.parseInt(request.getParameter("adid"));
		if(request.getParameter("bt1")!=null){
			if(DBmanager.approve(adid)){
				System.out.println();
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/approvedsuccess.jsp");
				dispatcher.forward(request, response);
			}
			else{
				System.out.println("some problem with approve function");
			}
		}
		if(request.getParameter("bt2")!=null){
			if(DBmanager.deleteAd(adid)){
				System.out.println();
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/successremove.jsp");
				dispatcher.forward(request, response);
			}
			else{
				System.out.println("some problem with deletead function");
			}
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
