
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *  Does CRUD creation, read, update, delete table operations for bug ticket objects
 */
public class DefectDAOImplement implements DefectDAO {

    private Connection connection;
    
    public DefectDAOImplement() {
        connection = DBConnect.getConnection();
    }
    
    @Override
    public void addDefect(DefectModel defect) {
        try {           
            String query = "INSERT INTO defects (appID, ticketName, tickStatusClosed, "
                    + "priority, assignee, summary, dDescript ) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt( 1, defect.getAppID() );
            preparedStatement.setString( 2, defect.getTicketName() );
            preparedStatement.setInt( 3, defect.getStatusClosed() );
            preparedStatement.setInt( 4, defect.getPriority() );
            preparedStatement.setString( 5, defect.getAssignee());
            preparedStatement.setString( 6, defect.getSummary() );
            preparedStatement.setString( 7, defect.getdDescript() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }              
    }

    @Override
    public void deleteDefect(int ticketID) {
        try {
            String query = "DELETE FROM defects WHERE ticketID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ticketID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
        sqle.printStackTrace();
        }
    }       

    @Override
    public void updateDefect(DefectModel defect) {
        try {
            String query = "UPDATE defects SET appID=?, ticketName=?, tickStatusClosed=?, priority=?, "
                    + "assignee=?, summary=?, dDescript=? where ticketID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt( 1, defect.getAppID() );
            preparedStatement.setString( 2, defect.getTicketName() );
            preparedStatement.setInt( 3, defect.getStatusClosed() );
            preparedStatement.setInt( 4, defect.getPriority() );
            preparedStatement.setString( 5, defect.getAssignee());
            preparedStatement.setString( 6, defect.getSummary() );
            preparedStatement.setString( 7, defect.getdDescript() );
            preparedStatement.setInt( 8, defect.getTicketID() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }      
    }

    @Override
    public List<DefectModel> getAllDefects() {
        List<DefectModel> defectList = new ArrayList<DefectModel>();
        try {           
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM defects" );
            while ( resultSet.next() ) {
                DefectModel defect = new DefectModel();
                defect.setTicketID( resultSet.getInt("ticketID") );
                defect.setAppID( resultSet.getInt("appID") );
                defect.setTicketName( resultSet.getString("ticketName") );
                defect.setStatusClosed( resultSet.getInt("tickStatusClosed") );
                defect.setPriority( resultSet.getInt("priority") );
                defect.setAssignee( resultSet.getString("assignee") );
                defect.setSummary( resultSet.getString("summary") );
                defect.setdDescript( resultSet.getString("dDescript") );                

                defectList.add(defect);
            }
            resultSet.close();
            statement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return defectList;
    }

    @Override
    public DefectModel getDefectByID(int ticketID) {
        DefectModel defect = new DefectModel();
        try {           
            String query = "SELECT * FROM defects WHERE ticketID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt( 1, ticketID );
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while ( resultSet.next() ) {
                defect.setTicketID( resultSet.getInt("ticketID") );
                defect.setAppID( resultSet.getInt("appID") );
                defect.setTicketName( resultSet.getString("ticketName") );
                defect.setStatusClosed( resultSet.getInt("tickStatusClosed") );
                defect.setPriority( resultSet.getInt("priority") );
                defect.setAssignee( resultSet.getString("assignee") );
                defect.setSummary( resultSet.getString("summary") );
                defect.setdDescript( resultSet.getString("dDescript") ); 
            }
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }  
        return defect;
    }
    
    @Override
    public List<Integer> filterOpenApps() {
        List<Integer> openAppList = new ArrayList<Integer>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT appID FROM applications WHERE statusClosed=0");
            while ( resultSet.next() ) {
                int appID = resultSet.getInt(1);   // 1 is "appID" here
                openAppList.add(appID);
            }
            resultSet.close();
            statement.close();            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }        
        return openAppList;
    }
}
