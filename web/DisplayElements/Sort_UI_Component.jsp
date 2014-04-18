<%-- 
    Document   : Sort_UI_Component
    Created on : Apr 6, 2014, 2:39:27 PM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</html>
