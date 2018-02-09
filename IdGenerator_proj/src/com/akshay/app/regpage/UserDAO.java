package com.akshay.app.regpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	
	public static void addUser(User user){
		Connection con = SingleTon.getSingle().getConnection();		
		//User user = new User();
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into user1 values(?,?,?,?,?)");
			pstmt.setInt(1,IdGenerator.userId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getGender());
			
			int s = pstmt.executeUpdate();
			if(s==1){
				System.out.println("User Registered Successfully!!!!! with Id "+ (IdGenerator.userId()-1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
