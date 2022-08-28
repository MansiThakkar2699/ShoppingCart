package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection 
{
	public static Connection getConnection() throws ClassNotFoundException,SQLException
	{
		String url="jdbc:postgresql://localhost:5432/eshop";
		Class.forName("org.postgresql.Driver");
		Connection conn=DriverManager.getConnection(url,"postgres","root");
		return conn;
	}
}