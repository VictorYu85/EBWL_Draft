<%-- 
    Document   : DrafterPage
    Created on : Apr 4, 2014, 12:44:15 AM
    Author     : Vyu, jhsia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="color" uri="/WEB-INF/tlds/ebwlTags.tld" %>

<%@ page import="business.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EBWL 2014-2015 Player Draft bbbbb ${sqlError}
        <br></title>
	<link rel="stylesheet" type="text/css" href="ebwl.css">
    </head>
    <body>
        <div id="title"><h1>EBWL 2014-2015 Player Draft</h1></div>
        
        <div id="nav">
	    <a href="GetPlayerData?gender=${gender}&refresh=yes">&nbsp;Refresh </a> &nbsp;
            <a href="index.jsp">&nbsp;Back to Index </a> &nbsp;
	
        <%@ include file="/DisplayElements/Gender_Toggle_UI_Component.jspf" %>
        </div>
        
        <%@ include file="/DisplayElements/CustomRank_UI_Component.jsp" %>
        <%@ include file="/DisplayElements/Sort_UI_Component.jsp" %>
        <%@ include file="/DisplayElements/PlayerTable_UI_Component.jsp" %>
    </body>
</html>
