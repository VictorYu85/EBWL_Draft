<%-- 
    Document   : DraftPlayer_UI_Component
    Created on : Apr 6, 2014, 2:23:54 PM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <table id="draft" cellpadding="1">
        <form name="Add Team" action="UpdatePlayerTeam" method="post">
            <tr style="font-weight: bold;">
                <td class="menuname">Draft Player:</td>
                <td title="Find ID for the desired player in the table below.">Player ID<br>
                    <input type="text" name="playerIdBox" size="10" value=""></td>
                <td title="For mistakes or trades, use 'Undraft Player' at the bottom."> Team <br>
                    <select name="team">                        
                        <c:forEach items="${teamList}" var="item">
                            <option value="${item}">${item}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <input type="button" value="Assign" onClick="validatePlayerID(this.form)">
                </td>
            </tr>
        </form>
   </table> 
</html>
