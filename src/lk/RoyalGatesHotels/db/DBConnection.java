package lk.RoyalGatesHotels.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?allowPublicKeyRetrieval=true&useSSL=false", "root", "1234");
    }
    public static DBConnection getInstance() {
        try {
            return (null == dbConnection) ? dbConnection = new DBConnection() : dbConnection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
