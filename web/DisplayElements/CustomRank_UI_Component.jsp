<%-- 
    Document   : CustomRank_UI_Component
    Created on : Apr 6, 2014, 3:50:56 PM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table border="1" cellpadding="5"> 
            <tr>
                <form name="customRank" action="CustomRank" method="post">
                <td>Customized Ranking</td>
                <td>Experience<br><input type="text" name ="Experience" 
                    value=${(customRank1 == null) ? "10" : customRank1}></td>
                <td>Disc Skills<br><input type="text" name ="Disc Skills" 
                    value=${(customRank2 == null) ? "10" : customRank2}></td>
                <td>Defense<br><input type="text" name ="Defense" 
                    value=${(customRank3 == null) ? "10" : customRank3}></td>
                <td>Athleticism<br><input type="text" name ="Athleticism" 
                    value=${(customRank4 == null) ? "10" : customRank4}></td>
                <td>Height<br><input type="text" name ="Height" 
                    value=${(customRank5 == null) ? "0" : customRank5}></td>
                <td><input type="submit" name="submit" value="Apply Custom Weights"></td>
            </tr>
        </table>
</html>
