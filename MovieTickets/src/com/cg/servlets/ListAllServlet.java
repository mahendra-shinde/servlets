package com.cg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.dao.IMovieDAO;
import com.cg.dao.MovieDAOImpl;
import com.cg.models.Movie;

/**
 * Servlet implementation class ListAllServlet
 */
@WebServlet("/list-all")
public class ListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMovieDAO dao = new MovieDAOImpl();
		List<Movie> movies = dao.findAll();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>List of Movies</h2>");
		out.println("<table><tr>");
		out.println("<td>Title</td><td>Year</td><td>Available Tickets</td><td>&nbsp;</td></tr>");
		for(Movie m : movies) {
		out.println("<tr><td>"+m.getTitle()+"</td>");
		out.println("<td>"+m.getYear()+"</td>");
		out.println("<td>"+m.getAvailableTickets()+"</td>");
		out.println("<td><a href='book-seat?id="+m.getMovieId()+"'>Apply</td>");
		out.println("</tr>");
		}
		out.close();
	}

	

}
