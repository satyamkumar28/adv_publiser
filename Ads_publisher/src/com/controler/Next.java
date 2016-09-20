package com.controler;



import java.io.*;
import com.model.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Next
 */
@WebServlet("/Next")
public class Next extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Next() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		CustInfo info=(CustInfo)session.getAttribute("info");
		int listtotal=info.getListtotal();
		int start=info.getStart();
		int imgid1=info.getImgid1();
		int previous=info.getPrevious();
		int next=info.getNext();
		if((next+3)<=listtotal)
		{
			start=start+3;
			next=next+3;
			previous=previous+3;
			
		}
		else
		{
			int temp=listtotal%3;
			start=start+3;
			next=next+temp;
			previous=previous+3;
		}
		info.setPrevious(previous);
		info.setStart(start);
		info.setNext(next);
		info.setImgid1(imgid1);
		session.setAttribute("info",info);
		RequestDispatcher rd=request.getRequestDispatcher("ClientPage.jsp");
		rd.forward(request,response);
	}

}
