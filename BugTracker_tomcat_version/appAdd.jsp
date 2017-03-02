<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Add New Application </title>
</head>

<body bgcolor = "#FFEBCC">
<h2> Add a new application to the system </h2>
    <form action="AppControllerServlet" method="post">
        <fieldset>
<%-- not needed since automatically incremented
			<div>
                <label for="appID"> Application ID </label> 
                <input type="text" name="appID" value="<c:out value="${applications.appID}" />" 
                readonly="readonly" placeholder="Application ID" />
            </div> --%>
            <br />
            <div>
                <label for="appName"> Application Name: </label> 
                <input type="text" name="appName" value="<c:out value="${applications.appName}" />" 
                placeholder="Sample Application (50 characters)" maxlength="50" size="40" required />
            </div>
            <input type="hidden" name="statusClosed" value="0"/>
            <br />
            
<!--      not needed, use hidden       
            <br />
			<div>
                <label for="statusClosed"> Status ( 0: open 1: closed ) </label>  
                <input type="text" name="statusClosed" value="0" readonly="readonly" />
            </div>            
            <br />  --> 
            <div>
                <input type="submit" value="Submit" />
            </div>
            
        </fieldset>
    </form>
    
    <p><a href = index.html> Return to home page </a> &emsp;&emsp;
    <a href = AppControllerServlet?action=list> List of applications </a></p>
    
</body>
</html>