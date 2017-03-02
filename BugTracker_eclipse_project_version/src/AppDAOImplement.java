
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *  Does CRUD creation, read, update, delete table operations for application objects
 */
public class AppDAOImplement implements AppDAO {

    private Connection connection;
    
    public AppDAOImplement() {
        connection = DBConnect.getConnection();
    }
    
    @Override
    public void addApp(AppModel app) {
        try {           
            String query = "INSERT INTO applications (appName, statusClosed) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString( 1, app.getAppName() );
            preparedStatement.setInt( 2, app.getStatusClosed() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }      
    }

    @Override
    public void deleteApp(int appID) {
        try {
            String query = "DELETE FROM applications WHERE appID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, appID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }  
    }

    @Override
    public void updateApp(AppModel app) {
        try {
            String query = "UPDATE applications SET appName=?, statusClosed=? where appID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString( 1, app.getAppName() );
            preparedStatement.setInt( 2, app.getStatusClosed() );
            preparedStatement.setInt(3, app.getAppID());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }  
    }

    @Override
    public List<AppModel> getAllApps() {
        List<AppModel> appList = new ArrayList<AppModel>();
        try {           
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM applications" );
            while ( resultSet.next() ) {
                AppModel app = new AppModel();
                app.setAppID( resultSet.getInt("appID") );
                app.setAppName( resultSet.getString("appName") );
                app.setStatusClosed( resultSet.getInt("statusClosed") );
                appList.add(app);
            }
            resultSet.close();
            statement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }  
        return appList;
    }

    @Override
    public AppModel getAppByID(int appID) {
        AppModel app = new AppModel();
        try {           
            String query = "SELECT * FROM applications WHERE AppID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt( 1, appID );
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                app.setAppID( resultSet.getInt("appID") );
                app.setAppName( resultSet.getString("appName") );
                app.setStatusClosed( resultSet.getInt("statusClosed") );
            }
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }  
        return app;
    }
}
