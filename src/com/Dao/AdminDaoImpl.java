package com.Dao;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import com.masai.utility.DBUtil;



	public class AdminDaoImpl implements Admin {

		@Override
		public String AdminLogin(String username, String password) {
			
			String message = "Username And User password Not Found";
			
			
			try (Connection con = DBUtil.provideConnection()){
				
				PreparedStatement ps = con.prepareStatement("select * from Admin Where Admin_username =?AND  Admin_password =?");
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					message = "Login Sucessfull";
				}
				
				
				
			} catch (SQLException se) {
			
				se.getMessage();
			}
			
			
			
			return message;
			
			
		}

	}


