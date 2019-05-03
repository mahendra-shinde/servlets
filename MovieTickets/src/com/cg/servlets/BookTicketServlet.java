package com.cg.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.dao.IMovieDAO;
import com.cg.dao.MovieDAOImpl;
import com.cg.models.Movie;

/**
 * Servlet implementation class BookTicketServlet
 */
@WebServlet("/book-seat")
public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int movieId = Integer.parseInt(id); 
		//TODO: Please add try-catch for handling NumberFormatException 
		IMovieDAO dao = new MovieDAOImpl();
		Movie m = dao.findById(movieId);
		if(m.getAvailableTickets()==0) {
			response.getWriter().append("No tickets available, click <a href=list-all>here</a> to go back");
			return;
		}
		m.setAvailableTickets(m.getAvailableTickets()-1);
		dao.update(m); //UPDATE movie in DB
		response.getWriter().append("Ticket Booked, click <a href=list-all>here</a> to go back");
	}

}
