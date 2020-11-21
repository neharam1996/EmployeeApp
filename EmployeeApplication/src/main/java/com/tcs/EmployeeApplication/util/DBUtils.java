package com.tcs.EmployeeApplication.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DBUtils {
	@Autowired
	DataSource dataSource;
	public Connection getConnection() 
	{
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
			return connection;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
