
/**
 * the bug/defect ticket object model (POJO)
 */
public class DefectModel {
    
    // properties of a defect ticket
    private int ticketID;
    private int appID;
    private String ticketName;
    private int statusClosed;
    private int priority;
    private String assignee;
    private String summary;
    private String dDescript; // "detailed description"
    
    public int getTicketID() {
        return ticketID;
    }
    
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
    
    public int getAppID() {
        return appID;
    }
    
    public void setAppID(int appID) {
        this.appID = appID;
    }
    
    public String getTicketName() {
        return ticketName;
    }
    
    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
    
    public int getStatusClosed() {
        return statusClosed;
    }
    
    public void setStatusClosed(int statusClosed) {
        this.statusClosed = statusClosed;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }          
    
    public String getAssignee() {
        return assignee;
    }
    
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    
    public String getSummary() {
        return summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public String getdDescript() {  // have to use getdDescript instead of getDDescript, 
        return dDescript;           // obscure issue with naming and parsing causes problems 
    }
    
    public void setdDescript(String dDescript) { // same as above
        this.dDescript = dDescript;
    }
    
}