package org.akshay.app.regform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleTon {
	private static final SingleTon single;
	private Connection con = null;
	static{
		single = new SingleTon();
	}
	
	private SingleTon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static SingleTon geSingleTon(){
		return single;
	}
	
	public Connection getConnection(){
		return con;
	}
	
	protected void finalze() throws Throwable{
		if(con!=null)
			con.close();
		con=null;
	}
}
