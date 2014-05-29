<%-- 
    Document   : schedule
    Created on : May 28, 2014, 9:05:37 AM
    Author     : DucNM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule Page</title>
    </head>
    <body>
        <table style="border-style: solid ;">
            <tr style="border-style: solid ;">
                <td>ID</td>
                <td>STAGE</td>
                <td>KICK OFF</td>
                <td>HOME</td>
                <td>AWAY</td>
                <td>VENUE</td>
            </tr>
            <s:iterator var="m" value="matchs">
                <tr>
                    <td>${m.id}</a></td>
                    <td>${m.stage}</td>
                    <td>${m.kickoff}</td>
                    <td>${m.home.name}</td>
                    <td>${m.away.name}</td>
                    <td>${m.venue.name}</td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
