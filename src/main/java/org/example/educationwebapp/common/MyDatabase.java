package org.example.educationwebapp.common;

import java.sql.*;

public class MyDatabase {
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/education";
        String user = "root";
        String password = "113355";

        return DriverManager.getConnection(url, user, password);
    }
}
