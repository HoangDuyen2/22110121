package vn.iotstar.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQLConnection {
    private static String url = "jdbc:mysql://localhost:3306/ktract3";
    private static String user = "root";
    private static String password = "1234";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try{
            new DBMySQLConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

