
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

/**
 * Application servlet class AppControllerServlet
 */
@WebServlet("/AppControllerServlet")
public class AppControllerServlet extends HttpServlet {
	
    private AppDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String LIST_APPS = "/listApps.jsp";
    public static final String ADD_APP = "/appAdd.jsp";
    public static final String EDIT_APP = "/appEdit.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppControllerServlet() {
        dao = new AppDAOImplement();
    }

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String forward = "";
        String action = request.getParameter("action");
 
        if ( action.equalsIgnoreCase("delete") ) {
            forward = LIST_APPS;
            int appID = Integer.parseInt( request.getParameter("appID") );
            dao.deleteApp(appID);
            request.setAttribute( "appList", dao.getAllApps() );
        }
        else if ( action.equalsIgnoreCase("edit") ) {
            forward = EDIT_APP;
            int appID = Integer.parseInt( request.getParameter("appID") );
            AppModel app = dao.getAppByID(appID);
            request.setAttribute("applications", app);
        }
        else if ( action.equalsIgnoreCase("insert") ) {
            forward = ADD_APP;
        }
        else {
            forward = LIST_APPS;
            request.setAttribute("appList", dao.getAllApps() );

            
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppModel app = new AppModel();
		app.setAppName( request.getParameter("appName") );
		app.setStatusClosed( Integer.parseInt( request.getParameter("statusClosed") ) );
		String appID = request.getParameter("appID");
		
		if (appID == null || appID.isEmpty() ) {
		    dao.addApp(app);
		} else {
		    app.setAppID( Integer.parseInt(appID) );
		    dao.updateApp(app);		    
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_APPS);
		request.setAttribute("appList", dao.getAllApps());
		view.forward(request, response);
	}
}
