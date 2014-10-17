package UserDao;

import java.sql.*;
import UserDao.User;

public class Dao implements DaoInterface{
	public Dao(){
	}
	public static void sqlQuery(String sql){
		Connection conn = null;
		Statement stmt = null;
	    
	    try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                    int id = rs.getInt("id");
	                    String name = rs.getString("name");
	                    String tel = rs.getString("tel");
	                    String passwd = rs.getString("passwd"); 
	                    System.out.println(id + "\t" + name + "\t" + tel + "\t" + passwd);
	            }

	    } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    } finally {
	            if (stmt != null) {
	                    try {
	                            stmt.close();
	                    } catch (SQLException e) { }
	            }

	            if (conn != null) {
	                    try {
	                            conn.close();
	                    } catch (SQLException e) { }
	            }
	    }
	}
	public int truncate() {
		System.out.println("before truncate");
		sqlQuery("SELECT * FROM user");
		int truncate = 0;
		
		Connection conn = null;
		Statement stmt = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

	        String sql = "TRUNCATE TABLE user";
	        stmt = conn.createStatement();
	        truncate = stmt.executeUpdate(sql);

	    } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    } finally {
	            if (stmt != null) {
	                    try {
	                            stmt.close();
	                    } catch (SQLException e) { }
	            }

	            if (conn != null) {
	                    try {
	                            conn.close();
	                    } catch (SQLException e) { }
	            }
	    }
		System.out.println("after truncate");
		sqlQuery("SELECT * FROM user");
		return truncate;
	}

	public int insert(User user) {
		System.out.println("before insert");
		sqlQuery("SELECT * FROM user");
		int insert = 0;
		Connection conn = null;
		Statement stmt = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");
	        
	        //String sql = "INSERT INTO user(name,tel) VALUES('"+user.getName()+"','"+user.getTel()+"')";
	        String sql = "INSERT INTO user(name,tel,passwd) VALUES('"+user.getName()+"','"+user.getTel()+"','"+user.getPasswd()+"')";
	        stmt = conn.createStatement();
	        insert = stmt.executeUpdate(sql);
	        ResultSet rs = stmt.executeQuery("SELECT * FROM user");
	        if(rs.next()){
	        	int id = rs.getInt("id");
	            user.setId(id);
	        }
	        
	    } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    } finally {
	            if (stmt != null) {
	                    try {
	                            stmt.close();
	                    } catch (SQLException e) { }
	            }

	            if (conn != null) {
	                    try {
	                            conn.close();
	                    } catch (SQLException e) { }
	            }
	    }
		System.out.println("after insert");
		sqlQuery("SELECT * FROM user");
		return insert;
	}
	public User login(String nameInput, String passInput) {
		User user = new User();
		
		Connection conn = null;
		Statement stmt = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

	        String sql = "SELECT * FROM user WHERE name='"+nameInput+"' AND passwd='"+passInput+"'";
	        System.out.println(sql);
	        
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        if (!rs.next()){
	        	//wrong username or password
	        	user = null;
                System.out.println("set user equal null because wrong name/password");
	        } else{
	        	do {
	        		System.out.println("doing result set loop to get user data");
                    int id = rs.getInt("id");
                    System.out.println("set id: "+id);
                    user.setId(id);
                    String name = rs.getString("name");
                    System.out.println("set name: "+name);
                    user.setName(name);
                    String tel = rs.getString("tel");
                    System.out.println("set tel: "+tel);
                    user.setTel(tel);
	            } while(rs.next());
	        }

	    } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    } finally {
	            if (stmt != null) {
	                    try {
	                            stmt.close();
	                    } catch (SQLException e) { }
	            }

	            if (conn != null) {
	                    try {
	                            conn.close();
	                    } catch (SQLException e) { }
	            }
	    }
		return user;
	}
}
