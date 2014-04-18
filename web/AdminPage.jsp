<%-- 
    Document   : AdminPage
    Created on : Apr 4, 2014, 12:30:57 AM
    Author     : Vyu
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin Draft Page</h1>
    </body>
    <%@ include file="/DisplayElements/DraftPlayer_UI_Component.jsp" %>
    <%@ include file="/DisplayElements/AdminLinks_UI_Component.jsp" %>
    <%@ include file="/DisplayElements/Sort_Admin_UI_Component.jsp" %>
    <%@ include file="/DisplayElements/PlayerTable_UI_Component.jsp" %>
</html>
