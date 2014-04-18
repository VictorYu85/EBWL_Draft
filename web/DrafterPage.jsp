<%-- 
    Document   : DrafterPage
    Created on : Apr 4, 2014, 12:44:15 AM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="color" uri="/WEB-INF/tlds/ebwlTags.tld" %>

<%@ page import="business.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drafter Page</title>
    </head>
    <body>
        <h1>Welcome to the draft!</h1>
        <a href="GetPlayerData?user=user&cat6=${cat6}">Refresh</a>
        <a href="index.jsp">Back to Index</a>
        <%@ include file="/DisplayElements/CustomRank_UI_Component.jsp" %>
        <%@ include file="/DisplayElements/Sort_UI_Component.jsp" %>
        <%@ include file="/DisplayElements/PlayerTable_UI_Component.jsp" %>
    </body>
</html>
