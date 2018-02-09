package com.akshay.app.regpage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdGenerator {
	
	public static int userId()
	{
		int id = 1;
		Connection con = SingleTon.getSingle().getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select max(Id) from user1");
			if(rs.next()){
				id=(rs.getInt(1))+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
