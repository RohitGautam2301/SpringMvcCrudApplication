package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techpalle.model.Admin;

public class AdminDao {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/spring1";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
	private static Connection cn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String loginQry = "select * from admin where admin_username=? and admin_password=?";
	
	public static boolean validateAdmin(Admin a) {
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = cn.prepareStatement(loginQry);
			ps.setString(1, a.getAdminUsername());
			ps.setString(2, a.getAdminPassword());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				b = true;
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) {
				try {
					rs.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn != null) {
				try {
					cn.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}
	
}
