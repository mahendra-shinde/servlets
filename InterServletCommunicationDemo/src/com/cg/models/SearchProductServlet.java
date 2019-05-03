package com.cg.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/search")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init()
	{
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(101,"McAloo",120F));
		productList.add(new Product(102,"McTikki",180F));
		productList.add(new Product(103,"Chicken Nuggets",220F));
		//Add list of products in ServletContext (Application Scope)
		getServletContext().setAttribute("productList", productList);
		System.out.println("List of Sample products created !!");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int productId = 0;
		List<Product> products = 
				(List<Product>)
				getServletContext().getAttribute("productList");
		
		try {
			productId = Integer.parseInt(id.trim());
			for(Product p : products) {
				if(p.getId()==productId) {
					response.getWriter().append("Product Found: "+p.getName());
					return;
				}
			}
			response.getWriter().append("Product with ID "+productId+" was not found!");
		}catch(NumberFormatException ex) {
			System.out.println("Invalid Number!");
			response.sendRedirect("index.html");
			return;
		}
		
	}

}
