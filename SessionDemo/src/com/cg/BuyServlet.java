package com.cg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/buynow")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<form action='deliver' method='post'>");
		out.println("Enter address for delivery: ");
		out.println("<textarea name='address' cols=30 rows=3></textarea>");
		out.println("<input type='submit' value='deliver'>");
		out.println("</form>");
		
//		Cookie cookie = new Cookie("product", product);
//		cookie.setMaxAge(10); //Self Destroy after 10 seconds
//		response.addCookie(cookie);
		HttpSession session = request.getSession();
		session.setAttribute("product", product);
		out.close();
	}

}
