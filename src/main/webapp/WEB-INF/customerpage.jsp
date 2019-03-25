<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="java.util.List"%>
<%@page import="DBAccess.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Order> orders = (List<Order>) session.getAttribute("orders"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a customer of our wonderful site.
        <table>
            <tr><td>Build your lego house.</td>
            <tr><td>
                    <form name="shop" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="makeOrder">
                        <br>Go to shop<br>
                        <input type="submit" value="Shop">
                    </form>
                </td>
        </table>
        
        
        <table>
            <thead>
                <tr>
                    <th scope="col">Order ID</th>
                    <th scope="col">Length</th>
                    <th scope="col">Width</th>
                    <th scope="col">height</th>
                    <th scope="col">Show</th>
                </tr>
            </thead>
            <tbody>
                <%for(Order o : orders){%>
                <tr>
            <td><%= o.getId() %></td>
            <td><%= o.getLength() %></td>
            <td><%= o.getWidth() %></td>
            <td><%= o.getHeight() %></td>
            <td> <a href="FrontController?command=ShowOrderLine&orderID=<%=o.getId()%>"><button>Vis Stykliste</button></a><td>
                </tr>
            <% }%>
            
            
        </tbody>
    </table>
</body>
</html>
