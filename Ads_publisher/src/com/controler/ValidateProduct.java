package com.controler;

import com.database.*;

import java.io.*;

import com.model.*;



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class ValidateProduct
 */
@WebServlet("/ValidateProduct")
public class ValidateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		RequestDispatcher rd=null;
		String productname;
		int productprice=0,ewallet,i=0;
		
		CustInfo info=(CustInfo)session.getAttribute("info");
		String user=info.getId();
		productname=request.getParameter("purchaseproduct");
		
		CustInfo temp=new CustInfo();
		productname=temp.findProductname(productname);
		info.setProductname(productname);
		productprice=DBproductprice.getproductprice(info.getProductname());
		
		info.setProductprice(productprice);
		
		ewallet=info.getEwallet();
		
						
		if(productprice<=ewallet)
		{	
			ewallet=ewallet-productprice;
			info.setEwallet(ewallet);
			i=EwalletUpdate.setupdatedewallet(user, ewallet);
			i=PurchaseHistoryEntry.setproducthistory(user, productname);
			rd=request.getRequestDispatcher("ClientPage.jsp");
		}	
		else
		{
			out.println("Not sufficient balance in your Wallet !");
			Thread t=new Thread(new Delay3());
			t.start();
			rd=request.getRequestDispatcher("ClientPage.jsp");
		}	
		rd.forward(request,response);

	}

}
