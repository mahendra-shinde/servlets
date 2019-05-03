package com.cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cg.models.Product;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
        arg0.getServletContext().removeAttribute("productList");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	List<Product> productList = new ArrayList<>();
    	ProductDAO dao = new ProductDAO();
    	try {
    	productList = dao.findAll();
    	}catch(Exception ex) {
    		productList = new ArrayList<>();
    		ex.printStackTrace();
    	}
		/*productList.add(new Product(101,"McAloo",120F));
		productList.add(new Product(102,"McTikki",180F));
		productList.add(new Product(103,"Chicken Nuggets",220F));*/
		//Add list of products in ServletContext (Application Scope)
		arg0.getServletContext().setAttribute("productList", productList);
		System.out.println("List of Sample products created !!");
    }
	
   
}
