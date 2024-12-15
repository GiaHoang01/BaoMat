package Pojo;

import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84862
 */
public class Connect {

    private static String url = "jdbc:oracle:thin:@localhost:1521/";
    public static String database = "";
    public static String user = "";
    public static String pass = "";
    public static Connection conn;
    
    public static void setConnectionDetails(String url, String database, String user, String pass) {
        Connect.url = url;
        Connect.database = database;
        Connect.user = user;
        Connect.pass = pass;
    }

    public static boolean Connect() {
        try {
            if (user.equals("sys") || user.equals("SYS")) {
                user += " as sysdba";
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Buoc 2: Tao doi tuong Connection  
            String temp = "" + url + database;
            conn = DriverManager.getConnection(temp, user, pass);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            Connect(); // Nếu chưa kết nối, gọi lại phương thức Connect()
        }
        return conn;
    }

}
