<%-- 
    Document   : index
    Created on : Aug 15, 2018, 10:03:21 PM
    Author     : lwetz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="styles/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Welcome to So and So Inc. </h1>
        <h3>We are all about some random stuff that
            really does not interest you, but you are here anyways. </h3>
            
        <form action="Controller" method="post">
            <input type="hidden" name="action" value="show">
            While you are here check out our <input class="clearButton" type="submit" value="employees">.
        </form><br>
        <form action="Controller" method="post">
            <input type="hidden" name="action" value="addEmp">
            You can <input class="clearButton" type="submit" value="add"> someone to the list if you really want to.
        </form><br>
        <form action="Controller" method="post">
            <input type="hidden" name="action" value="search">
            Otherwise <input class="clearButton" type="submit" value="snoop"> through our employees because you don&apos;t have anything better to do.
        </form>
    
</body>
</html>
