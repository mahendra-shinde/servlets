package com.cg;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cg.models.Product;

public class ProductDAO {
	 private Connection getConnection()throws Exception {
	    	try {
	    	Class.forName("oracle.jdbc.OracleDriver");
	    	Connection con = DriverManager.getConnection
	    			("jdbc:oracle:thin:@localhost:1521:xe",
	    					"hr","hr");
	    	return con;
	    	}catch(ClassNotFoundException ex) {
	    		throw new Exception("Unable to connect",ex);
	    	}
	   }
	 
	 public List<Product> findAll()throws Exception {
		 Connection con = getConnection();
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery("select * from products");
		 List<Product> products = new ArrayList<Product>();
		 while(rs.next()) {
			 Product temp = new Product(rs.getInt(1), rs.getString(2),rs.getFloat(3));
			 products.add(temp);
		 }
		 return products;
	 }
}
