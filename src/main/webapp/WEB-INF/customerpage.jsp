<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
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
                    <form name="Orders" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="ShowOrder">
                        <br>See your order<br>
                        <input type="submit" value="See Orders"
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
                </tr>
            </thead>
            <tbody>
            <td></td>
            <td></td>
            <td></td>
        </tbody>
    </table>
</body>
</html>
