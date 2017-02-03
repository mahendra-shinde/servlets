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
		case "edit":
			String empid = request.getParameter("id");
			String error;
			if(empid!=null){
				try{
				int id = Integer.parseInt(empid);
				Employee e = service.search(id);
				System.out.println("Employee found: "+e.getDesignation());
				request.setAttribute("emp", e);
				RequestDispatcher view = request.getRequestDispatcher("edit.jsp");
				view.forward(request, response);
				
				}catch(EMSException ex){
					error = "Cannot search employee id "+empid;
					System.out.println("Error "+ex.getMessage());
				}
			}else{
				error="Please select employee to edit";
				response.sendRedirect("index.jsp?error="+error);						
			}
			return;
		case "update":
			Employee e = new Employee();
			e.setName(request.getParameter("name"));
			e.setDesignation(request.getParameter("designation"));
			e.setGender(request.getParameter("gender"));
			e.setPhone(request.getParameter("phone"));
			e.setEmail(request.getParameter("email"));
			String str = request.getParameter("empid");
			e.setEmpId(Integer.parseInt(str));
			try{
			service.update(e);
				request.setAttribute("message", "Record updated!");
			}catch(EMSException ex){
				request.setAttribute("error", "Unable to update, "+ex.getMessage());
			}
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
			
			return;
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
			RequestDispatcher view1 = request.getRequestDispatcher("list.jsp");
			view1.forward(request, response);
			return;
		case "add":
			//code to add employee
			Employee e1 = new Employee();
			e1.setName(request.getParameter("name"));
			e1.setDesignation(request.getParameter("designation"));
			e1.setGender(request.getParameter("gender"));
			e1.setPhone(request.getParameter("phone"));
			e1.setEmail(request.getParameter("email"));
			//save using service
			try{
				int id= service.add(e1);
				e1.setEmpId(id);
			}catch(EMSException ex){
				request.getSession().setAttribute("error", ex.getMessage());
			}
			//store error/success message in SESSION
			request.getSession().setAttribute("emp", e1);
			
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
