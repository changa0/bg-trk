
/**
 * the application object model (POJO)
 */
public class AppModel {
    
    // properties of an application
    private int appID;
    private String appName;
    private int statusClosed;
    
    public int getAppID() {
        return appID;
    }
    
    public void setAppID(int appID) {
        this.appID = appID;
    }
    
    public String getAppName() {
        return appName;
    }
    
    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    public int getStatusClosed() {
        return statusClosed;
    }
    
    public void setStatusClosed(int statusClosed) {
        this.statusClosed = statusClosed;
    }   
}
