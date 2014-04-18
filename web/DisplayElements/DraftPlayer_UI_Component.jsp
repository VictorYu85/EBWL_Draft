<%-- 
    Document   : DraftPlayer_UI_Component
    Created on : Apr 6, 2014, 2:23:54 PM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script language="JavaScript">
    function validatePlayerID(form) {        
        if (isNaN(parseInt(form.playerIdBox.value))) {
            alert("You did not enter a valid entry");
        }
        else {
            form.submit();
        }
    }
</script>

<html>    
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
               <input type="button" value="Change Player Team" onClick="validatePlayerID(this.form)">
           </td>
       </tr>
       </form>
   </table> 
</html>
