package idproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    /**
     *
     */
    private static final String URL = "jdbc:mysql://localhost:3306/idproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "user29";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/idproject", "root",  "user29");
    }
}
