<%-- 
    Document   : ViewGroup
    Created on : May 27, 2014, 10:04:36 PM
    Author     : DANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group Page</title>
    </head>
    <body>
        <s:iterator var="g" value="groups">
            <h1>Group ${g.name}</h1>
            <table style="border-style: solid ;">
                <tr style="border-style: solid ;">
                    <td></td>
                    <td>Name</td>
                    <td>MP</td>
                    <td>W</td>
                    <td>D</td>
                    <td>L</td>
                    <td>GF</td>
                    <td>GA</td>
                    <td>Pts</td>
                </tr>
            <s:iterator var="c" value="lst">
                <s:if test="%{#c.groupID == #g.id}">
                <tr>                                        
                    <td><img src="http://img.fifa.com/images/flags/3/${c.code}.png"/></td>
                    <td><a href="viewSchedule?team=${c.id}">${c.name}</a></td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                </s:if>
            </s:iterator>
            </table>        
        </s:iterator>
    </body>
</html>
