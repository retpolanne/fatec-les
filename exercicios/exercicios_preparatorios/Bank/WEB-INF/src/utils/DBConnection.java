package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    private DBConnection () {}

    public static Connection getConnection() {
        if (conn == null) {
            instantiateConnection();
        }
        return conn;
    }

    private static void instantiateConnection() {
        String host = System.getenv("DB_HOST");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        String dbType = System.getenv("DB_TYPE");
        String dbName = System.getenv("DB_NAME");
        String connString = "jdbc:%s://%s/%s";
        try {
            Class.forName(System.getenv("DB_CLASS"));
            conn = DriverManager.getConnection(
                String.format(
                    connString, dbType, host, dbName
                ), user, password
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}