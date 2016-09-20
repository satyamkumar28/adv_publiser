package com.controler;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.CustInfo;

/**
 * Servlet implementation class Previous
 */
@WebServlet("/Previous")
public class Previous extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Previous() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		CustInfo info=(CustInfo)session.getAttribute("info");
		int start=info.getStart();
		int previous=info.getPrevious();
		int next=info.getNext();
		if(previous==1)
		{
			
		}
		else
		{
			previous=previous-3;
			start=start-3;
			int temp=next%3;
			if((next-3)<=0)
			{
				
			}
			else
			{
				if(temp==0)
				{
					next=next-3;
				}
				else
				{
					next=next-temp;
				}
			}
			
			
			info.setPrevious(previous);
			info.setStart(start);
			info.setNext(next);
		}
		session.setAttribute("info",info);
		RequestDispatcher rd=request.getRequestDispatcher("ClientPage.jsp");
		rd.forward(request,response);
	}

}
