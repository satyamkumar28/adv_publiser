package com.controler;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.database.DBmanager;
import com.model.AdInfo;
import com.model.FileManager;

/**
 * Servlet implementation class CreateAds
 */
@WebServlet("/CreateAds")
@MultipartConfig
public class CreateAds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String advTitle=request.getParameter("title");
		System.out.println(advTitle);
		String advTheme="";
		String advDescription=request.getParameter("description");
		String advImage1="";
		String advImage2="";
		String advImage3="";
		String advVideo="";   
		String advCategory=request.getParameter("category");
		String advSubCategory=request.getParameter("subcategory");
		System.out.println(request.getParameter("priority"));
		
		int advPriorty=Integer.parseInt(request.getParameter("priority"));
		AdInfo user = new AdInfo();

		

	         
	        InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("image");
	        if (filePart != null){
	        	user.setSubcategory(advSubCategory);
			System.out.println("1");
			try {
				user.setImg(IOUtils.toByteArray(filePart.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			advTheme = FileManager.saveUploadedFile(user);
	        }
	        ///themeimage end
	        System.out.println("1");
	        Part filePart1 = request.getPart("image1");
	        System.out.println("1");
	        if (filePart1 != null){
	        	user.setSubcategory(advSubCategory);
			System.out.println("2");
			try {
				user.setImg(IOUtils.toByteArray(filePart1.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			advImage1 = FileManager.saveUploadedFile(user);
	        }
	        /////imge1 end
	        
	        Part filePart2 = request.getPart("image2");
	        if (filePart2 != null){
	        	user.setSubcategory(advSubCategory);
			System.out.println("3");
			try {
				user.setImg(IOUtils.toByteArray(filePart2.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			advImage2 = FileManager.saveUploadedFile(user);
	        }
	        /////image2 end
	        
	        Part filePart3 = request.getPart("image3");
	        if (filePart3 != null){
	        	user.setSubcategory(advSubCategory);
			System.out.println("4");
			try {
				user.setImg(IOUtils.toByteArray(filePart3.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			advImage3 = FileManager.saveUploadedFile(user);
	        }
	        
	        Part filePart4 = request.getPart("video");
	        if (filePart4 != null){
	        	user.setSubcategory(advSubCategory);
			System.out.println("2");
			try {
				user.setImg(IOUtils.toByteArray(filePart4.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			advVideo = FileManager.saveUploadedFile(user);
	        }
	       HttpSession session = request.getSession();
	     String advertiserId= session.getAttribute("advertiser").toString();
	     int adid = DBmanager.getId();
	       adid +=1;
		AdInfo createInfo=new AdInfo(advertiserId,adid, advTitle, advTheme, advDescription, advImage1, advImage2, advImage3, advVideo, advCategory, advSubCategory, advPriorty);
		System.out.println(advertiserId+ " "+adid+ " "+advTitle+ " "+advTheme+ " "+advDescription+" "+ advImage1+ " "+advImage2+ " "+advImage3+ " "+advVideo+ " "+advCategory+" "+ advSubCategory+ " "+advPriorty);
		if(DBmanager.addAds(createInfo))
		{
			System.out.println("sucessfully ");
			RequestDispatcher rd=request.getRequestDispatcher("sucess.html");
	   		rd.forward(request,response);
		}
	
		System.out.println("sucess");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		
	
	}

}
