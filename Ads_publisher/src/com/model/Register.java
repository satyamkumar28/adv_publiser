package com.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.DbManger;
import com.controller.RegUserInfo;

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
		/*
		String advId = request.getParameter("Id");
		String  advname= request.getParameter("Name");
		String advPassword=request.getParameter("Password");
		String advAdd= request.getParameter("Address");
		String advQuestion = request.getParameter("Question");
		String advAns=request.getParameter("Answer");
		String advContact=request.getParameter("Phone");
		 
		RegUserInfo user = new RegUserInfo();
		RegUserInfo info;
		*/
		String name = request.getParameter("Name");
		RegUserInfo info =null;
		info = DbManger.getInfo(name);
		System.out.println("infoFound");
   	 if(!(info.equals(null))){
   		request.setAttribute("Uinfo",info);
   		RequestDispatcher rd=request.getRequestDispatcher("/AdvertiserPanel/html/AdvLogin.html");
   		rd.forward(request,response);
	}

	}
}
