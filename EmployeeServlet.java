package com.cg.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.exceptions.EMSException;
import com.cg.models.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//Create instance of Service
		IEmployeeService service = new EmployeeService();
		
		switch(action){
		case "list":
			try{
			//code to list employees from service
			List<Employee> emps=service.getAll();
			//add list into SESSION
			request.getSession().setAttribute("emplist", emps);
			//forward request to "list.jsp"
			}catch(EMSException ex){
				request.getSession().setAttribute("error", ex.getMessage());
			}
			RequestDispatcher view = request.getRequestDispatcher("list.jsp");
			view.forward(request, response);
			return;
		case "add":
			//code to add employee
			Employee e = new Employee();
			e.setName(request.getParameter("name"));
			e.setDesignation(request.getParameter("designation"));
			e.setGender(request.getParameter("gender"));
			e.setPhone(request.getParameter("phone"));
			e.setEmail(request.getParameter("email"));
			//save using service
			try{
				int id= service.add(e);
				e.setEmpId(id);
			}catch(EMSException ex){
				request.getSession().setAttribute("error", ex.getMessage());
			}
			//store error/success message in SESSION
			request.getSession().setAttribute("emp", e);
			
			RequestDispatcher view2 = request.getRequestDispatcher("success.jsp");
			view2.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
