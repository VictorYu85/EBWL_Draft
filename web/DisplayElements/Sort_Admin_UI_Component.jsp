<%-- 
    Document   : AdminSort_UI_Component
    Created on : Apr 6, 2014, 3:05:40 PM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <table border="1" cellpadding="5">            
        <tr>
            <form name="selectionBar" action="SortPlayers" method="post">
                <td>Sort Order</td>                                                                    
                <td>                        
                    <input type="checkbox" name="cat6" ${(track6 == "on") ? "checked": ""}>Hide Drafted Players
                </td>
                <td>
                    <input type="submit" name="Submit Sort" value="Sort">                   
                </td> 
            </form>            
        </tr>
    </table>
</html>
