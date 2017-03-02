import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** 
 * CONNECTS TO DATABASE
 */
public class DBConnect {

    private static Connection connection;
    
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        
        InputStream inputStream = DBConnect.class.getClassLoader().getResourceAsStream("/db.properties");
        // db.properties file contains the database settings in plain text
        Properties properties = new Properties();
        
        try {
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("unknown DBConnect error occurred");
        }
        
        return connection;
    }
    
    // closes the connection
    public static void closeConnection (Connection toBeClosed) {
        if (toBeClosed == null) {
            return;
        }
        
        try {
            toBeClosed.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error with DBConnect.closeConnection...");
        }
    }
}