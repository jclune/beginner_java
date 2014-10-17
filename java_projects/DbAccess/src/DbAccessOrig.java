import java.sql.*;

public class DbAccessOrig {
        public static void main(String[] args) {
                Connection conn = null;
                Statement stmt = null;

                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost/ca", "root", "");

                        stmt = conn.createStatement();
                        String sql = "SELECT * FROM user";
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
