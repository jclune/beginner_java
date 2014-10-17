import java.sql.*;
import java.io.*;

public class DbAccess {
        public static void main(String[] args) {
    			dbRead("SELECT * FROM user");
    			dbRead("SELECT * FROM user WHERE name='"+input()+"'");
        		//dbWrite();
        		//dbRead();
        }
        public static String input(){
        	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        	try{
        		String line = read.readLine();
        		return line;
        	}catch(IOException e){
        		e.printStackTrace();
        		return null;
        	}catch(NumberFormatException e){
        		e.printStackTrace();
        		return null;
        	}
        }
        public static void dbWrite(){
        	Connection conn = null;
        	Statement stmt = null;
        	
        	try{
        		Class.forName("com.mysql.jdbc.Driver");
        		conn = DriverManager.getConnection("jdbc:mysql://localhost/ca","root","");
        		
        		stmt = conn.createStatement();
        		String sql = "SELECT * FROM user";
        		ResultSet rs = stmt.executeQuery(sql);
 
                while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String tel = rs.getString("tel");

                        System.out.println(id + "\t" + name + "\t" + tel);
                }
        		
        	}catch(ClassNotFoundException e){
        		e.printStackTrace();
        	}catch(SQLException e){
        		e.printStackTrace();
        	} finally{
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
        public static void dbRead(String sql){
        		
        }
}