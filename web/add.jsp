<%-- 
    Document   : add
    Created on : Aug 15, 2018, 10:03:21 PM
    Author     : lwetz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
        <link href="styles/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Add an Employee</h1>

        <a href="Controller">Home</a>
        <br>
        <c:if test="${message != null}">
            <h2 class="error">${message}</h2>
        </c:if>
        <br>
        <form action="Controller" method="post">
            <input type="hidden" name="action" value="add">

            <label>Employee ID</label>
            <input class="searchInput" type="text" name="empID" value="${empID}"><br>

            <label>First Name</label>
            <input class="searchInput" type="text" name="fName" value="${fName}"><br>

            <label>Middle Name</label>
            <input class="searchInput" type="text" name="mName" value="${mName}"><br>

            <label>Last Name</label>
            <input class="searchInput" type="text" name="lName" value="${lName}"><br>

            <label>Employee Type</label>
            <input class="radio" type="radio" name="empType" id="Salary" value="Salary">Salary
            <c:if test="${message != null}"><span class="error">*</span></c:if><br>

                <label>&nbsp;</label>
                <input class="searchInput" type="radio" name="empType" id="Hourly" value="Hourly">Hourly
            <c:if test="${message != null}"><span class="error">*</span></c:if><br>

                <label>&nbsp;</label>
                <input class="searchInput" type="radio" name="empType" id="None" value="None">None
            <c:if test="${message != null}"><span class="error">*</span></c:if><br>

                <label>Salary</label>
                <input class="searchInput" type="number" name="salary" min="1000" step="1000"value="${salary}"><br>

            <label>Hourly Rate</label>
            <input class="searchInput" type="number" name="rate"  step="0.01" min="0" value="${rate}"><br>

            <label>Average Weekly Hours</label>
            <input class="searchInput" type="number" name="hours"
                   min="1" value="${hours}"><br>

            <label>Birth Date</label>
            <input class="searchInput" type="date" name="bDay" max="${today}"value="${bDay}"><br>

            <label>Hire Date</label>
            <input class="searchInput" type="date" name="hireDate" value="${hireDate}" max="${today}"><br>

            <c:if test="${message != null}">
                <label class="error">Please select type</label>
            </c:if>
            <c:if test="${message == null}">
                <label>&nbsp;</label>
            </c:if>
            <input class="searchInput"  type="submit" value="Add">

        </form>
    </body>
</html>
