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
        <table style="border-style: solid ;">
            <tr style="border-style: solid ;">
                <td>Code</td>
                <td>Group ID</td>
                <td>ID</td>
                <td>Name</td>
                <td></td>
            </tr>

        <s:iterator var="c" value="lst">
            <tr>
                <td>${c.code}</a></td>
                <td>${c.groupID}</td>
                <td>${c.ID}</td>
                <td>${c.name}</td>
                <td><img src="http://img.fifa.com/images/flags/3/${c.code}.png"/></td>
            </tr>
        </s:iterator>
    </body>
</html>
