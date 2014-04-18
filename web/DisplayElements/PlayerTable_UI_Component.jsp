<%-- 
    Document   : PlayerTable_UI_Component
    Created on : Apr 6, 2014, 2:42:38 PM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</html>
