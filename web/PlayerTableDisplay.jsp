<%-- 
    Document   : PlayerTableDisplay
    Created on : Mar 16, 2014, 5:08:34 PM
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
        <title>EBWL Draft</title>
    </head>
    
    <body>
        <h1>Hello EBWL! The number of elements in list is ${numPlayers}</h1>
        
        <!-- ************************************************************* -->
        <table border="1" cellpadding="5">
            <form name="Add Team" action="UpdatePlayerTeam" method="post">
            <tr>
                <td>Draft a player </td>
                <td>Enter Player Id<br><input type="text" name="playerIdBox" value=""></td>
                <td> Team Name <br>
                    <select name="team">                        
                        <c:forEach items="${teamList}" var="item">
                            <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <input type="submit" name="submit" value="Change Player Team">
                </td>
            </tr>
            </form>
        </table> 
        <!-- ************************************************************* -->
        <a href="index.jsp">Back to Index</a>
        <a href="GetPlayerData">Refresh</a>
        <a href="ClearTeams">Clear Teams</a>
        <a href="ImportData">Import Data</a>
        <a href="AdminPage.jsp">Admin Page</a>
        <!-- ************************************************************* -->
        
        <table border="1" cellpadding="5"> 
            <tr>
                <form name="customRank" action="CustomRank" method="post">
                <td>Customized Ranking</td>
                <td>Experience<br><input type="text" name ="Experience" 
                    value=${(customRank1 == null) ? "50" : customRank1}></td>
                <td>Disc Skills<br><input type="text" name ="Disc Skills" 
                    value="1"></td>
                <td>Defense<br><input type="text" name ="Defense" 
                    value="1"></td>
                <td>Athleticism<br><input type="text" name ="Athleticism" 
                    value="1"></td>
                <td>Height<br><input type="text" name ="Height" 
                    value="1"></td>
                <td><input type="submit" name="submit" value="Apply Custom Weights"></td>
            </tr>
        </table>
               
        <!-- ************************************************************* -->
        <table border="1" cellpadding="5">            
            <tr>
                <form name="selectionBar" action="SortPlayers" method="post">
                    <td>Sort Order</td>                
                    <td> Category 1 <br>
                        <select name="cat1">                        
                            <c:forEach items="${selectCat}" var="item">
                                <option value="${item}"${(track1 == item) ? " selected='selected'" : "" }>${item}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td> Category 2 <br>
                        <select name="cat2">                        
                            <c:forEach items="${selectCat}" var="item">
                                <option value="${item}"${(track2 == item) ? " selected='selected'" : "" }>${item}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td> Category 3 <br>
                        <select name="cat3">                        
                            <c:forEach items="${selectCat}" var="item">
                                <option value="${item}"${(track3 == item) ? " selected='selected'" : "" }>${item}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td> Category 4 <br>
                        <select name="cat4">                        
                            <c:forEach items="${selectCat}" var="item">
                                <option value="${item}"${(track4 == item) ? " selected='selected'" : "" }>${item}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td> Category 5 <br>
                        <select name="cat5">                        
                            <c:forEach items="${selectCat}" var="item">
                                <option value="${item}"${(track5 == item) ? " selected='selected'" : "" }>${item}</option>
                            </c:forEach>
                        </select>
                    </td>                                      
                    <td>                        
                        <input type="checkbox" name="cat6" ${(track6 == "on") ? "checked": ""}>Hide Drafted Players
                    </td>
                    <td>
                        <input type="submit" name="Submit Sort" value="Sort">                   
                    </td> 

                </form>            
            </tr>
        </table>
        
        <table border="1" cellpadding="5">
            <tr>
                    <td>Player Id</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>Team Name</td>
                    <td>Experience</td>
                    <td>Disc Skills</td>
                    <td>Defense</td>
                    <td>Athleticism</td>
                    <td>Stat Totals</td>
                    <td>Custom Weight</td>
                    <td>Height</td>
                    <td>Previous Teams</td>
                    <td>Add. Player Notes</td>
                    <td>Baggage</td>
            </tr>
            <p>
                <c:forEach var="player" items="${playerSet}">
                     <c:if test = "${(player.team == '') || (track6 != 'on')}">   
                        <tr valign ="top">
                            <td>${player.playerId}</td>
                            <td>${player.firstName}</td>
                            <td>${player.lastName}</td>
                            <color:TeamColor teamName="${player.team}"/>
                            <td align="center">${player.statExperience}</td>
                            <td align="center">${player.statDiscSkills}</td>
                            <td align="center">${player.statDefense}</td>
                            <td align="center">${player.statAthleticism}</td>
                            <td align="center">${player.statTotal}</td>
                            <td align="center">${player.statCustom}</td>
                            <td align="center">${player.statHeightFeet}"${player.statHeightInches}'</td>                                
                            <td>${player.descPreviousTeams}</td>
                            <td>${player.descAddPlayerNotes}</td>
                            <td>${player.infoBaggage}</td>
                        </tr>
                    </c:if>                    
                </c:forEach> 
            </p>
        </table>      
    </body>
</html>
