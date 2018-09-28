<%-- 
    Document   : search
    Created on : Aug 2, 2018, 10:53:51 PM
    Author     : lwetz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <link href="styles/main.css" rel="stylesheet" type="text/css"/>
    </head>

    <h2>Search for employees hired before or after date picked.</h2><br>
    <h3 class="error">${errorMessage}</h3><br>
    <form action="Controller" method="post">
        <input type="hidden" name="action" value="searchResults">

        <label>Choose a date:  </label>
        <c:if test="${hireDate != null}">
            <input class="searchInput" type="date" name="searchDate" value="${hireDate}" max="${today}"><br>
        </c:if>
        <c:if test="${hireDate == null}">
            <input class="searchInput" type="date" name="searchDate" value="${today}" max="${today}"><br>
        </c:if>

        <label>&nbsp;</label>
        <input class="searchInput" type="radio" name="searchValue" value="before">Before<br>

        <label>&nbsp;</label>
        <input class="searchInput" type="radio" name="searchValue" value="after">After<br>           

        <label>&nbsp;</label>
        <input class="searchInput" type="submit" value ="Search">
    </form>
    <br>
    <a href="Controller">Home</a>
    <br>

    <c:if test="${message != null}">
        <h2>${message}</h2>

        <c:if test="${!linkMap.isEmpty()}">
            <table style="overflow-x:auto;">
                <tr>
                    <th>Employee ID</th>
                    <th>Name</th>
                    <th>Hire Date</th>
                    <th>Employee Type</th> 
                    <th>Yearly Cost</th>
                </tr>

                <c:forEach var="item" items="${linkMap}">
                    <tr>
                        <td>${item.key}</td>
                        <td>${item.value.firstName} ${item.value.lastName}</td>
                        <td>${item.value.hireDate}</td>
                        <td>${item.value.type}</td>
                        <td>${item.value.calcYearlyCompensation()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </c:if> 



</html>
