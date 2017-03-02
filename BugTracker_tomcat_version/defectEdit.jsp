<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Edit Bug Ticket </title>
</head>

<body bgcolor = "#FFEBCC">
<h2> Edit a bug ticket </h2>
<h4> Please check if bug is already reported before submitting a new bug! </h4>
    <form action="DefectControllerServlet" method="post" >
        <fieldset>
<%-- not needed
			<div>
                <label for="ticketID"> Bug Ticket ID </label> <input type="text"
                    name="ticketID" value="<c:out value="${defects.ticketID}" />"
                    readonly="readonly" placeholder="Ticket ID" />
            </div> --%>
            <input type="hidden" name="ticketID" value="<c:out value="${defects.ticketID}" />" />
            <br />            
<%--             
            <div>
                <label for="appID"> Application ID </label> <input type="text"
                    name="appID" value="<c:out value="${defects.appID}" />"
                    placeholder="#" required />
            </div>  --%>
			<div>
                <label for="appID"> Application ID: </label> 
                <select name="appID" >
                <c:forEach items="${openAppList}" var="appID" >
                	<option> <c:out value="${appID}" /> </option>
                </c:forEach>	
                </select>
            </div>
            <br />
            <div>
                <label for="ticketName"> Bug Name: </label> <input type="text"
                    name="ticketName" value="<c:out value="${defects.ticketName}" />"
                    placeholder="ex: Crash #3" maxlength="50" required />
            </div>            
            <br />
            <div>
                <label for="statusClosed"> Status: &emsp; </label> 
                <input type="radio" name="statusClosed" value="0" checked /> Open &emsp; 
                <input type="radio" name="statusClosed" value="1" /> Closed
            </div>
            <br />
            <div>
                <label for="priority"> Priority: </label><br /><br /> 
                <input type="radio" name="priority" value="0" checked /> 0 (low) <br />  
                <input type="radio" name="priority" value="1" /> 1 <br /> 
                <input type="radio" name="priority" value="2" /> 2 <br /> 
                <input type="radio" name="priority" value="3" /> 3 <br /> 
                <input type="radio" name="priority" value="4" /> 4 (high)
            </div>
<%--             
            <div>
                <label for="statusClosed"> Status ( 0: open 1: closed ): </label> <input type="text"
                    name="statusClosed" value="<c:out value="${defects.statusClosed}" />"
                    placeholder="0 or 1" size="2"/>
            </div>
            <br />
            <div>
                <label for="priority"> Priority (0: low - 4: high): </label> <input type="text"
                    name="priority" value="<c:out value="${defects.priority}" />"
                    placeholder="0-4" size="2" />
            </div> --%>
            <br />
            <div>
                <label for="assignee"> Assigned to: </label> <input type="text"
                    name="assignee" value="<c:out value="${defects.assignee}" />"
                    placeholder="ex: John (25 characters)" maxlength="25" />
            </div>
            <br />                      
            <div>
                <label for="summary"> Summary: </label> <input type="text"
                    name="summary" value="<c:out value="${defects.summary}" />" 
                    placeholder="Brief summary of bug (100 characters)" size="50" maxlength="100" />
            </div>
            <br />
            <div>
                <label for="dDescript"> Detailed Description:</label><br />
                <textarea class="text" cols="70" rows="6" name="dDescript" 
                placeholder="Describe in detail (300 characters)" 
                maxlength="300" ><c:out value="${defects.dDescript}" /></textarea>                                                      
            </div>  
            <br />                        
            <div>
                <input type="submit" value="Save Changes" />
            </div>
            
        </fieldset>
    </form>
    
    <p><a href = index.html> Return to home page </a> &emsp;&emsp;
    <a href = DefectControllerServlet?action=list> Return to list of bug reports </a></p>
    
</body>
</html>