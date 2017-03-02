<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> List of Bug Report Tickets </title>
</head>

<body bgcolor = "#FFEBCC">
	<h2> List of Defects Tracked </h2>
	<h4><a href = index.html> Return to home page </a></h4>
    <table>
        <thead>
            <tr>
                <th> Bug ID </th>
                <th> Application ID </th>
                <th> Bug Name </th>                
                <th> Status (0: open , 1: resolved) </th>
                <th> Priority (0: low - 4: high) </th>
                <th> Assigned to </th>
                <th> Summary </th>
                <th> Detail </th>
                <th colspan="2"> Action </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${defectList}" var="defect">
                <tr>
                    <td align="center"><c:out value="${defect.ticketID}" /></td>
                    <td align="center"><c:out value="${defect.appID}" /></td>                    
                    <td><c:out value="${defect.ticketName}" /></td>
                    <td align="center"><c:out value="${defect.statusClosed}" /></td>
                    <td align="center"><c:out value="${defect.priority}" /></td>
                    <td><c:out value="${defect.assignee}" /></td>                    
                    <td><c:out value="${defect.summary}" /></td>
                    <td><c:out value="${defect.dDescript}" /></td>                    
                    <td><a
                        href="DefectControllerServlet?action=edit&ticketID=<c:out value="${defect.ticketID}"/> "> Update </a>  &emsp; </td>
                    <td><a
                        href="DefectControllerServlet?action=delete&ticketID=<c:out value="${defect.ticketID}"/> "> Delete </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="DefectControllerServlet?action=insert"> Add a Defect </a>
    </p>
</body>
</html>