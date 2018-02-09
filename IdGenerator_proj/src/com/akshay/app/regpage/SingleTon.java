package com.akshay.app.regpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleTon {
	private static final SingleTon SINGLE;
	private Connection con;
	
	static{
		SINGLE = new SingleTon(); 
	}
	
	private SingleTon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static SingleTon getSingle(){
		return SINGLE;
	}
	
	public Connection getConnection(){
		return con;
	}
	
	@Override
	protected void finalize() throws Throwable {
		if(con!=null)
			con.close();
			con=null;
	}
}
