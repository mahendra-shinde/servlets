package com.cg.dao;

import java.sql.*;

public class DBUtil {

	public static Connection obtainConnection() throws AppException {
		Connection con =null;
		try {
	    	Class.forName("oracle.jdbc.OracleDriver");
	    	con = DriverManager.getConnection
	    			("jdbc:oracle:thin:@localhost:1521:xe",
	    					"hr","hr");
	    	return con;
	    	}catch(ClassNotFoundException | SQLException ex) {
	    		throw new AppException("Unable to connect",ex);
	    	}
	}
}
