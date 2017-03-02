<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Edit Application </title>
</head>

<body bgcolor = "#FFEBCC">
<h2> Edit a tracked application </h2>
    <form action="AppControllerServlet" method="post">
        <fieldset>
<%--
			<div>
                <label for="appID"> Application ID </label> 
                <input type="text" name="appID" value="<c:out value="${applications.appID}" />" 
                readonly="readonly" placeholder="#" />
            </div>  --%>
            <input type="hidden" name="appID" value="<c:out value="${applications.appID}" />" />
            <br />
            <div>
                <label for="appName"> Application Name: </label> 
                <input type="text" name="appName" value="<c:out value="${applications.appName}" />" 
                placeholder="Sample Application (50 characters)" maxlength="50" size="40" required />
            </div>
            <br />
			<div>
                <label for="statusClosed"> Status: &emsp; </label> 
                <input type="radio" name="statusClosed" value="0" checked /> Open &emsp; 
                <input type="radio" name="statusClosed" value="1" /> Closed
            </div>       
            <br />
            <div>
            	<input type="submit" value="Save Changes" />
            </div>
            
        </fieldset>
    </form>
    
    <p><a href = index.html> Return to home page </a> &emsp;&emsp;
    <a href = AppControllerServlet?action=list> Return to list of applications </a></p>
    
</body>
</html>