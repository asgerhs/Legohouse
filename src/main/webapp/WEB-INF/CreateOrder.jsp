<%-- 
    Document   : shop
    Created on : Mar 22, 2019, 12:22:47 PM
    Author     : Asger Hermind Sørensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>
        <table>
            <tr><td>Build your lego house.</td>
                <td>
                    <form name="shop" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="CreateOrder">
                        Set the desired length:<br>
                        <input type="text" name="length" >
                        Set the desired width:<br>
                        <input type="text" name="width" >
                        Set the desired height:<br>
                        <input type="text" name="height" >
                        <input type="submit" value="Submit">
                    </form>
                </td>
        </table>
    </body>
</html>
