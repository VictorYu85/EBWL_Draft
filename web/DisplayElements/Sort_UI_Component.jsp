<%-- 
    Document   : Sort_UI_Component
    Created on : Apr 6, 2014, 2:39:27 PM
    Author     : Vyu
--%>

<table id="sort" cellpadding="1">            
   <form name="selectionBar" action="SortPlayers?gender=${gender}" method="post">
       <tr style="font-weight: bold;">
           <td class="menuname" rowspan=2>Sort Order:</td>                
           <td rowspan=2 width=10></td>
           <td> First <br>
               <select name="cat1">                        
                   <c:forEach items="${selectCat}" var="item">
                       <option value="${item}"${(track1 == item) ? " selected='selected'" : "" }>${item}</option>
                   </c:forEach>
               </select>
           </td>
           <td> Second <br>
               <select name="cat2">                        
                   <c:forEach items="${selectCat}" var="item">
                       <option value="${item}"${(track2 == item) ? " selected='selected'" : "" }>${item}</option>
                   </c:forEach>
               </select>
           </td>
           <td> Third <br>
               <select name="cat3">                        
                   <c:forEach items="${selectCat}" var="item">
                       <option value="${item}"${(track3 == item) ? " selected='selected'" : "" }>${item}</option>
                   </c:forEach>
               </select>
           </td>
           <td> Fourth <br>
               <select name="cat4">                        
                   <c:forEach items="${selectCat}" var="item">
                       <option value="${item}"${(track4 == item) ? " selected='selected'" : "" }>${item}</option>
                   </c:forEach>
               </select>
           </td>
           <td> Fifth <br>
               <select name="cat5">                        
                   <c:forEach items="${selectCat}" var="item">
                       <option value="${item}"${(track5 == item) ? " selected='selected'" : "" }>${item}</option>
                   </c:forEach>
               </select>
           </td>
           <td rowspan=2 width=10></td>
           <td rowspan=2>
               <input type="submit" name="Submit Sort" value="Sort">                   
           </td> 
       </tr>
       <tr>
           <td colspan=5>
               <input type ="checkbox" name="cat6" ${(track6 == "on") ? "checked": ""}>Hide Drafted Players

           </td>
       </tr>    
       <input type="hidden" name="gender" value="${gender}">
   </form>
</table>

