<%-- 
    Document   : CustomRank_UI_Component
    Created on : Apr 6, 2014, 3:50:56 PM
    Author     : Vyu, jhsia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script language="JavaScript">
    function isNumeric(n) {
        return !isNaN(parseFloat(n)) && isFinite(n);
    }
    
    function validateWeighting(form) {        
        var complete = true;
        
        if (!isNumeric(form.Experience.value)) {
            alert("You did not enter a valid value for Experience");
            complete = false;
        }       
        if (!isNumeric(form.DiscSkills.value)) {
            alert("You did not enter a valid value for DiscSkills");
            complete = false;
        }
        if (!isNumeric(form.Defense.value)) {
            alert("You did not enter a valid value for Defense");
            complete = false;
        }
        if (!isNumeric(form.Athleticism.value)) {
            alert("You did not enter a valid value for Athleticism");
            complete = false;
        }
        if (!isNumeric(form.Height.value)) {
            alert("You did not enter a valid value for Height");
            complete = false;
        }        
        if (complete == true){
            form.submit();
        }
    }
</script>

<html>
    <table id="custom" cellpadding="1"> 
            <tr style="font-weight: bold;">
                <form name="customRank" action="CustomRank" method="post">
                    <td title="Use these fields to change the 'Custom' column below" class="menuname"><b>Custom Weights:</b></td>
                    <td width=10></td>

                    <td title="Experience">EXP<br><input type="text" name ="Experience" size="5" 
                        value=${(customRank1 == null) ? "1" : customRank1}></td>
                    <td title="Disc Skills">DISC<br><input type="text" name ="DiscSkills" size="5"
                        value=${(customRank2 == null) ? "1" : customRank2}></td>
                    <td title="Defense">DEF<br><input type="text" name ="Defense" size="5"
                        value=${(customRank3 == null) ? "1" : customRank3}></td>
                    <td title="Athleticism">ATH<br><input type="text" name ="Athleticism" size="5"
                        value=${(customRank4 == null) ? "1" : customRank4}></td>
                    <td title="Height">Height<br><input type="text" name ="Height" size="5"
                        value=${(customRank5 == null) ? "0" : customRank5}></td>
                    <td width=10></td>
                    <td><input type="button" value="Apply" onClick="validateWeighting(this.form)"></td>
                    <input type="hidden" name="gender" value="${gender}">
                </form>
            </tr>
        </table>
</html>
