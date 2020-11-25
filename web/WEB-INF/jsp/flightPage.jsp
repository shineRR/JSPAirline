<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Books Store Application</title>
</head>
<body>
<div align="center">
    <h3>Flights Management</h3>
    <h4>
        <a href="/new">Add New Flight</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Flights</a>

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
                    <a href="/edit?id=<c:out value='${flight.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${flight.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>