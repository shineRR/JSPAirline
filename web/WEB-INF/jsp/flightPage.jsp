<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>JSPAirline - Flights Page</title>
</head>
<body>

<header>
<%--    <c:if test='(request.getAttribute("role") != null)'>--%>
        <div class="register" align="center">
            <h3>
                <a href="controller?command=goToSignUpPage">Register</a>
                &nbsp;&nbsp;&nbsp;
                <a href="controller?command=goToSignInPage">Log In</a>
                &nbsp;&nbsp;&nbsp;
                <a href="controller?command=goToFlightPage">Flights</a>
            </h3>
        </div>
<%--    </c:if>>--%>
</header>

<div align="center">
    <h3>Flights Management</h3>
    <h4>
        <a href="controller?command=goToNewFlight">Add New Flight</a>
    </h4>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Flights</h2></caption>
        <tr>
            <th>ID</th>
            <th>Src</th>
            <th>Dest</th>
            <th>Timestamp</th>
        </tr>
        <c:forEach var="flight" items="${listFlight}">
            <tr>
                <td><c:out value="${flight.id}" /></td>
                <td><c:out value="${flight.src}" /></td>
                <td><c:out value="${flight.dest}" /></td>
                <td><c:out value="${flight.timestamp}" /></td>
                <td>
                    <a href="controller?command=goToNewFlight?id=<c:out value='${flight.id}?method=edit' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="controller?command=goToNewFlight?id=<c:out value='${flight.id}?method=delete' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>