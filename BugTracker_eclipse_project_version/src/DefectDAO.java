import java.util.List;

/**
 * for the bug ticket database operations DAO
 */
public interface DefectDAO {
    
    public void addDefect(DefectModel defect);
    public void deleteDefect(int ticketID);
    public void updateDefect(DefectModel defect);
    public List<DefectModel> getAllDefects();
    public DefectModel getDefectByID(int ticketID);
    
    public List<Integer> filterOpenApps();
}
