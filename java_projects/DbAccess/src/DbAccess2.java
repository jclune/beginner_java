/*
 * Java6までの書き方。Java7ではもっと簡潔に書ける。
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.*;

public class DbAccess2 {
	public static void main(String[] args) {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement stmt = null;
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("nameを入力してください。");
			String inputName = reader.readLine();
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

			//stmt = conn.createStatement();
			//String sql = "SELECT * FROM user WHERE name='" + inputName + "'";
			
			String sql = "SELECT * FROM user WHERE name=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, inputName);
			
			//ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String passwd = rs.getString("passwd");
				
				System.out.println(id + "\t" + name + "\t" + tel + "\t" + passwd);
			} else {
				System.out.println(inputName + "は存在しません。");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
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
