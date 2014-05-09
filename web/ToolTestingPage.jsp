<%-- 
    Document   : AdminPage
    Created on : Apr 4, 2014, 12:30:57 AM
    Author     : Vyu, jhsia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="color" uri="/WEB-INF/tlds/ebwlTags.tld" %>

<%@ page import="business.*" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpSession" %>


<script language="JavaScript">
    function validatePlayerID(form) {        
        if (isNaN(parseInt(form.playerIdBox.value)) 
            || !isFinite(form.playerIdBox.value)) {
            alert("You did not enter a valid entry");           
        }
        else {
            form.submit();
        }
    }
</script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tool Testing Page</title>
	<link rel="stylesheet" type="text/css" href="ebwl-test.css">
    </head>
    <body>
        <div id="title"><h1>New Functionality Test Page</h1></div>
    
        <%@ include file="/DisplayElements/AdminLinks_UI_Component.jsp" %>

 
   
<table id="draft" cellpadding="1">
    <form name="TestName" action="NameCleanUp" method="post">
        <tr style="font-weight: bold;">
            <td class="menuname">Test a Name:</td>
            <td title="Check the name of a Player ID">Player ID<br>
                <input type="text" name="playerIdBox" size="10" value=""></td>
            <td>
                <input type="button" value="Test" onClick="validatePlayerID(this.form)">
            </td>
            <td>
                <input type="submit" name="TestAll" value="TestAll">
            </td>
        </tr>        
    </form>
</table> 
<div id="scroll">
    <table class="players" cellpadding="1">
        <c:forEach var="player" items="${DebugCodeAll}">
                <tr>
                    <td class="menuname">${player.firstName}</td>
                    <td class="menuname">${player.lastName}</td>
                </tr>
        </c:forEach>
    </table> 
</div>
    </body>
</html>
