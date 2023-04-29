package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Student;

//Below class is used to write JDBC code
public class StudentDao {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/spring1";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
	private static Connection cn = null;
	private static Statement stm = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String insertQry = "insert into student(name, email, pw, mobile) values(?, ?, ?, ?)";
	private static final String displayOneStudentQry = "select * from student where sno=?";
	private static final String displayAllStudentsQry = "select * from student";
	private static final String updateQry = "update student set name=?, email=?, pw=?, mobile=? where sno=?";
	private static final String deleteQry = "delete from student where sno=?";
	
	public static Student getOneStudent(int sno){
		Student s = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = cn.prepareStatement(displayOneStudentQry);
			ps.setInt(1, sno);
			
			rs = ps.executeQuery();
			rs.next();
			String n = rs.getString("name");
			String e = rs.getString("email");
			String p = rs.getString("pw");
			long m = rs.getLong("mobile");
				
			s = new Student(n, e, p, m);
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
		return s;
	}
	
	public static ArrayList<Student> getAllStudents(){
		ArrayList<Student> al = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			stm = cn.createStatement();
			
			rs = stm.executeQuery(displayAllStudentsQry);
			while(rs.next()) {
				int i = rs.getInt("sno");
				String n = rs.getString("name");
				String e = rs.getString("email");
				String p = rs.getString("pw");
				long m = rs.getLong("mobile");
				
				Student s = new Student(i, n, e, p, m);
				
				al.add(s);
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
			if(stm != null) {
				try {
					stm.close();
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
		
		return al;
	}

	public static void insertStudent(Student s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = cn.prepareStatement(insertQry);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void updateStudent(Student s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = cn.prepareStatement(updateQry);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			ps.setInt(5, s.getSno());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void deleteStudent(int sno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = cn.prepareStatement(deleteQry);
			ps.setInt(1, sno);
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cn != null) {
				try {
					cn.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
