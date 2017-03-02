
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class DefectControllerServlet
 */
@WebServlet("/DefectControllerServlet")
public class DefectControllerServlet extends HttpServlet {
    
    private DefectDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_DEFECTS = "/listDefects.jsp";
	public static final String ADD_DEFECT = "/defectAdd.jsp";
	public static final String EDIT_DEFECT = "/defectEdit.jsp";
       
    public DefectControllerServlet() {
        dao = new DefectDAOImplement();
    }

	/**
	 * blank
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
 
        if ( action.equalsIgnoreCase("delete") ) {
            forward = LIST_DEFECTS;
            int ticketID = Integer.parseInt( request.getParameter("ticketID") );
            dao.deleteDefect(ticketID);
            request.setAttribute( "defectList", dao.getAllDefects() );
        }
        else if ( action.equalsIgnoreCase("edit") ) {
            forward = EDIT_DEFECT;
            int ticketID = Integer.parseInt( request.getParameter("ticketID") );
            DefectModel defect = dao.getDefectByID(ticketID);
            request.setAttribute("defects", defect);
            request.setAttribute("openAppList", dao.filterOpenApps());
        }
        else if ( action.equalsIgnoreCase("insert") ) {
            forward = ADD_DEFECT;
            request.setAttribute("openAppList", dao.filterOpenApps());
        }
        else {
            forward = LIST_DEFECTS;
            request.setAttribute("defectList", dao.getAllDefects() );
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * blank
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    DefectModel defect = new DefectModel();
	    defect.setAppID( Integer.parseInt( request.getParameter("appID") ) );
	    defect.setTicketName( request.getParameter("ticketName") );
	    defect.setStatusClosed( Integer.parseInt( request.getParameter("statusClosed") ) );
	    defect.setPriority( Integer.parseInt( request.getParameter("priority") ) );
	    defect.setAssignee( request.getParameter("assignee") );
	    defect.setSummary( request.getParameter("summary") );
	    defect.setdDescript( request.getParameter("dDescript") );
	    
	    String ticketID = request.getParameter( "ticketID" );
	    if (ticketID == null || ticketID.isEmpty() ) {
	        dao.addDefect(defect);
	    } else {
	        defect.setTicketID( Integer.parseInt(ticketID) );
	        dao.updateDefect(defect);
	    }
	    
        RequestDispatcher view = request.getRequestDispatcher(LIST_DEFECTS);
        request.setAttribute( "defectList", dao.getAllDefects() );
        view.forward(request, response);	        
	}
}
