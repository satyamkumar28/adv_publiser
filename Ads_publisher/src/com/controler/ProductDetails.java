package com.controler;

import com.database.*;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.CustInfo;


/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//String coins=" coins";
		int price;
		
		
		out.println("OK");
		String productname="";
        ResultSet rs=null;
        Map<Integer,String> products=new HashMap<Integer,String>();
        
        //ArrayList<String> list=new ArrayList<String>();
        try
        {
             Connection con=DBmanager.getconnection();
             PreparedStatement ps=con.prepareStatement("select * from adsproducts");
             rs=ps.executeQuery();
             
             while(rs.next())
             {
            	 productname=rs.getString(1);
            	 price=rs.getInt(2);
            	 //coins=Integer.toString(price)+" coins";
            	 products.put(price,productname);
            	 out.println(productname+"  "+price);
             }
             session.setAttribute("products",products);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
		
	}

}
