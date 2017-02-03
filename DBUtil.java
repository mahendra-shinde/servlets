package com.cg.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/*
 * DBUtil class to access a connection pool 
 */
public class DBUtil {
	static Connection connection;

	public static Connection obtainConnection() throws NamingException, SQLException {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context
					.lookup("java:/myDS");
			connection = source.getConnection();
		
		return connection;
	}
}
