package com.controler;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.database.DbManger;
import com.model.CreateAdvInfo;

/**
 * Servlet implementation class CreateAdvertiser
 */
@WebServlet("/CreateAdvertiser")
public class CreateAdvertiser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String advDescription;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAdvertiser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String advUser=request.getParameter("userid");
		//String advId="1";
		
		String advTitle=request.getParameter("title");
		String advTheme=request.getParameter("image");
		String advDescription=request.getParameter("description");
		String advImage1=request.getParameter("image1");
		String advImage2=request.getParameter("image2");
		String advImage3=request.getParameter("image3");
		String advVideo=request.getParameter("video");
		String advCategory=request.getParameter("category");
		String advSubCategory=request.getParameter("subcategory");
		String advPriorty=request.getParameter("priorty");
		
		
	        
		CreateAdvInfo createInfo=new CreateAdvInfo(advUser, advTitle, advTheme, advDescription, advImage1, advImage2, advImage3, advVideo, advCategory, advSubCategory, advPriorty);
		if(DbManger.uploadImage(createInfo))
		{
			System.out.println("sucessfully ");
			RequestDispatcher rd=request.getRequestDispatcher("sucess.html");
	   		rd.forward(request,response);
		}
	
		System.out.println("sucess");
	}
}

