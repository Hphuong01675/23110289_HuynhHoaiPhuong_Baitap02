package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String SERVER = "HOAIPHUONG\\SQLEXPRESS01";
    private static final String DB_NAME = "userdb";
    private static final String USER = "sa";
    private static final String PASS = "123";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://" + SERVER + ":1433;databaseName=" + DB_NAME + ";encrypt=false";
        return DriverManager.getConnection(url, USER, PASS);
    }
}
