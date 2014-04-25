<%-- 
    Document   : PlayerTable_UI_Component
    Created on : Apr 6, 2014, 2:42:38 PM
    Author     : Vyu, jhsia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div id="playerheader">
	<table class="players" cellpadding="1">
            <tr class="header">
                <td width=24 title="Arbitrary ID for drafting">ID</td>
                <td width=135>Name</td>
                <td width=99>Team</td>
                <td width=45>Height</td>
                <td width=26 title="Experience">EXP</td>
                <td width=30 title="Disc Skills">DISC</td>
                <td width=25 title="Defense">DEF</td>
                <td width=27 title="Athleticism">ATH</td>
                <td width=34 title="Raw total of 4 basic stats to the left">Total</td>
                <td width=51 title="Ranking total using customized weighting system. Height measured in feet.">Custom</td>
                <td width=300>Previous Teams</td>
                <td width=170>Additional Player Notes</td>
                <td width=135>Baggage</td>
            </tr>
	</table>
    </div>

    <div id="scroll">
    	<table class="players" cellpadding="1">
            <c:forEach var="player" items="${playerSet}">
                 <c:if test = "${(player.team == '') || (track6 != 'on')}">   
                    <tr valign ="top">
                        <td width=24 align="center">${player.playerId}</td>
                        <td width=135><b>${player.firstName}&nbsp;${player.lastName}</b></td>
                        <color:TeamColor teamName="${player.team}"/>
                        <td width=45 align="center">${player.statHeightFeet}"${player.statHeightInches}'</td>                     
                        <td width=26 align="center">${player.statExperience}</td>
                        <td width=30 align="center">${player.statDiscSkills}</td>
                        <td width=25 align="center">${player.statDefense}</td>
                        <td width=27 align="center">${player.statAthleticism}</td>
                        <td width=34 align="center">${player.statTotal}</td>
                        <td width=51 align="center">${player.statCustom}</td>
                        <td width=300>${player.descPreviousTeams}</td>
                        <td width=170>${player.descAddPlayerNotes}</td>
                        <td width=135>${player.infoBaggage}</td>
                    </tr>
                </c:if>                    
            </c:forEach> 
    	</table> 
    </div>
</html>
