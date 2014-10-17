package jp.co.ca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.ca.entity.User;

public class UserDaoImpl implements UserDao{
	public UserDaoImpl(){
	}

	@Override
	public int delete(int id) {
		System.out.println("before delete");
		sqlQuery("SELECT * FROM user");
		int delete = 0;
		
    	Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

            String sql = "DELETE FROM user WHERE id='"+id+"'";
            stmt = conn.createStatement();
            delete = stmt.executeUpdate(sql);
	
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
		System.out.println("after delete");
		sqlQuery("SELECT * FROM user");
		return delete;
	}

	@Override
	public List<User> findAll() {
		List<User> list = null;
		
    	Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

            String sql = "SELECT * FROM user";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.isBeforeFirst()){
            	list = new ArrayList<User>();
	            while (rs.next()) {
	                    int id = rs.getInt("id");
	                    String name = rs.getString("name");
	                    String tel = rs.getString("tel");
	                    // String passwd = rs.getString("passwd");
	                    User user = new User();
	                    user.setId(id);
	                    user.setName(name);
	                    user.setTel(tel);
	                    //user.setPasswd(passwd);
	                    list.add(user);
	            }
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
		return list;
	}

	@Override
	public User findById(int idInput) {
		User user = new User();
		
    	Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

            String sql = "SELECT * FROM user WHERE id='"+idInput+"'";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                    int id = rs.getInt("id");
                    user.setId(id);
                    String name = rs.getString("name");
                    user.setName(name);
                    String tel = rs.getString("tel");
                    user.setTel(tel);
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

	@Override
	public int insert(User user) {
		System.out.println("before insert");
		sqlQuery("SELECT * FROM user");
		int insert = 0;
		Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");
            
            String sql = "INSERT INTO user(name,tel) VALUES('"+user.getName()+"','"+user.getTel()+"')";
            //String sql = "INSERT INTO user(name,tel) VALUES('"+user.getName()+"','"+user.getTel()+"','"+user.getPasswd()+"')";
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

	@Override
	public int update(User user) {
		System.out.println("before update");
		sqlQuery("SELECT * FROM user");
		int update = 0;
    	Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

            String sql = "UPDATE user SET name='"+user.getName()+"' WHERE id='"+user.getId()+"'";
            stmt = conn.createStatement();
            update = stmt.executeUpdate(sql);
	
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
		System.out.println("after update");
		sqlQuery("SELECT * FROM user");
		return update;
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

                        System.out.println(id + "\t" + name + "\t" + tel);
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
}
