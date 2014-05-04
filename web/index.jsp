<%-- 
    Document   : index
    Created on : Mar 16, 2014, 4:09:50 PM
    Author     : Vyu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EBWL 2014-2015 Draft Portal</title>
	<link rel="stylesheet" type="text/css" href="ebwl.css">
	<map name="captain">
		<area shape="rect" coords="1, 1, 150, 200" href="GetPlayerData?gender=Female&refresh=yes">
		<area shape="rect" coords="151, 1, 300, 200" href="GetPlayerData?gender=Male&refresh=yes">
	</map>
    </head>
    <body>
        <table align=center width=620>
	    <tr align=center>
		<td colspan=2><h1 align=center>EBWL 2014-2015 Draft Portal</h1></td>
	    </tr>
            <tr>
                <td><a href="SetUser?user=admin"><img src="images/manager.jpg" width="300" height="200"></a></td>
                <td><img src="images/captain.jpg" usemap="#captain" width="300" height="200"></td>
            </tr>
        </table>      
    </body>
</html>
