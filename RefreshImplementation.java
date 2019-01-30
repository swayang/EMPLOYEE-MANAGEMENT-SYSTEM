package org.oecm19.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RefreshImplementation extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		HttpSession session1=req.getSession(false);
		
		if(session1 ==null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			 out.println("<font color=red>  SESSION EXPIRED ...LOG IN AGAIN.</font>");
	 		 rd.include(req	, resp);
		}
		else
     		{
     			resp.sendRedirect("SessionSuccessful.jsp");
     		}
		}
		
		
	}


