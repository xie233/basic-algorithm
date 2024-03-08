package org.jim.structural.bridge;

import java.sql.*;

public class JdbcMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");//加载及注册JDBC驱动程序
        String url = "jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        String query = "select * from test";
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next()) {
            rs.getString(1);
            rs.getInt(2);
        }
    }
}
