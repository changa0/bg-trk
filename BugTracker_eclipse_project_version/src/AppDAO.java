import java.util.List;

/**
 * for the applications database operations, a data access object (DAO)
 */
public interface AppDAO {
    
    public void addApp(AppModel app);
    public void deleteApp(int appID);
    public void updateApp(AppModel app);
    public List<AppModel> getAllApps();
    public AppModel getAppByID(int appID);    
}
