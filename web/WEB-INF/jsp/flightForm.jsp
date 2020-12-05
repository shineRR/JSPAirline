<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Flight Application</title>
</head>
<body>
    <header>
        <div class="register" align="center">
            <h3>
                <a href="controller?command=goToSignUpPage">Register</a>
                &nbsp;&nbsp;&nbsp;
                <a href="controller?command=goToSignInPage">Log In</a>
                &nbsp;&nbsp;&nbsp;
                <a href="controller?command=goToFlightPage">Flights</a>
            </h3>
        </div>
    </header>

    <div align="center">
        <h3>Flights Management</h3>
        <h4>
            <a href="controller?command=goToNewFlight">Add New Flight</a>
            &nbsp;&nbsp;&nbsp;
            <a href="controller?command=goToFlightPage">List All Flights</a>

        </h4>
    </div>

    <div align="center">
            <c:if test="${flight == null}">
            <form action="controller?command=goToNewFlight" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${flight != null}">
                                Edit Flight
                            </c:if>
                            <c:if test="${flight == null}">
                                Add New Flight
                            </c:if>
                        </h2>
                    </caption>
                    <tr>
                        <th>Src City: </th>
                        <td>
                            <input type="text" name="src" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Dest City: </th>
                        <td>
                            <input type="text" name="dest" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Timestamp: </th>
                        <td>
                            <input type="text" name="timestamp" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>
                <%
                    if(request.getAttribute("error") != null)
                    {
                        out.println(request.getAttribute("error"));
                    }
                %>
    </div>
</body>
</html>