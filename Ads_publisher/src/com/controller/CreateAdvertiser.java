package com.controller;

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
		//String advApprove="No";
		
	//	String firstName = request.getParameter("firstName");
	   //     String lastName = request.getParameter("lastName");
	         
	        InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("image");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	        Part filePart1 = request.getPart("image1");
	        if (filePart1 != null) {
	            // prints out some information for debugging
	            System.out.println(filePart1.getName());
	            System.out.println(filePart1.getSize());
	            System.out.println(filePart1.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart1.getInputStream();
	        }
	        Part filePart2 = request.getPart("image2");
	        if (filePart2 != null) {
	            // prints out some information for debugging
	            System.out.println(filePart2.getName());
	            System.out.println(filePart2.getSize());
	            System.out.println(filePart2.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart2.getInputStream();
	        }
	        Part filePart3 = request.getPart("image3");
	        if (filePart3 != null) {
	            // prints out some information for debugging
	            System.out.println(filePart3.getName());
	            System.out.println(filePart3.getSize());
	            System.out.println(filePart3.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart3.getInputStream();
	        }
	        Part filePart4 = request.getPart("video");
	        if (filePart4 != null) {
	            // prints out some information for debugging
	            System.out.println(filePart4.getName());
	            System.out.println(filePart4.getSize());
	            System.out.println(filePart4.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart4.getInputStream();
	        }
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

