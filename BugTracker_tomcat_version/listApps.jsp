<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> List of Applications Tracked </title>
</head>

<body bgcolor = "#FFEBCC">
	<h2> List of Applications Tracked </h2>
	<h4><a href = index.html> Return to home page </a></h4>
    <table>
        <thead>
            <tr>
                <th> Application ID </th>
                <th> Name </th>
                <th> Status (0: open , 1: closed)</th>
                <th colspan="2"> Action </th>                
            </tr>
        </thead>
        <tbody>
             <c:forEach items="${appList}" var="app" > 
                <tr>
                    <td><c:out value="${app.appID}" /></td>
                    <td>&emsp;&emsp;<c:out value="${app.appName}" /></td>
                    <td align="center"><c:out value="${app.statusClosed}" /></td>
                    <td><a href="AppControllerServlet?action=edit&appID=<c:out value="${app.appID}"/> "> Update </a> &emsp; </td>                   
                    <td><a href="AppControllerServlet?action=delete&appID=<c:out value="${app.appID}"/> "> Remove </a></td>                    
                </tr>     	                
             </c:forEach> 
        </tbody>
    </table>
    <p>
<%--         Debug: <c:out value="${appList}" /> --%>
    </p>
    <p>
        <a href="AppControllerServlet?action=insert"> Add an Application </a>
    </p>
</body>
</html>