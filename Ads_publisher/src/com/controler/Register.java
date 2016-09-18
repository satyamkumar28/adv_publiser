package com.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DbManger;
import com.model.RegUserInfo;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String advId = request.getParameter("Id");
		String  advName= request.getParameter("Name");
		String advPassword=request.getParameter("password");
		String advAdd= request.getParameter("Address");
		String advQuestion = request.getParameter("Question");
		String advAns=request.getParameter("Answer");
		String advContact=request.getParameter("Phone");
		 
		
		String name = request.getParameter("Name");
		RegUserInfo info = new RegUserInfo(advName,advId,advPassword,advAdd,advContact,advQuestion,advAns);
		
		if(DbManger.registerAdvertiser(info))
		{
			System.out.println("sucessfully ");
			RequestDispatcher rd=request.getRequestDispatcher("AdvLogin.jsp");
	   		rd.forward(request,response);
		}
	
   	
	

	}
}
