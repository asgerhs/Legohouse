<%-- 
    Document   : ShowOrderLine
    Created on : Mar 24, 2019, 8:30:11 PM
    Author     : Asger Hermind Sørensen
--%>

<%@page import="java.util.HashMap"%>
<%@page import="DBAccess.BrickCalculator"%>
<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Order order = (Order) session.getAttribute("order"); %>
<% HashMap<String, Integer> hm = (HashMap<String, Integer>) session.getAttribute("bricks"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Order</title>
    </head>
    <body>
        <table>
                <thead>
                    <tr>
                        <th scope="col">2x4</th>
                        <th scope="col">2x2</th>
                        <th scope="col">2x1</th>
                    </tr>
                </thead>
                <tbody>
                <td><%=hm.get("2x4").toString()%></td>
                <td><%=hm.get("2x2").toString()%></td>
                <td><%=hm.get("2x1").toString()%></td>
                </tbody>
        </table>
    </body>
</html>

