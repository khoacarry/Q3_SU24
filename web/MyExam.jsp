<%-- 
    Document   : MyExam
    Created on : 17 thg 3, 2025, 10:15:00
    Author     : thais
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        List of Executions:
        <table border="1">
            <tr>
                <th>Execution ID</th>
                <th>Array</th>
                <th>Result</th>
            </tr>
            <c:forEach var="e" items="${exe}">
                <tr>
                    <td><a href="?service=detail&id=${e.getExecutionID()}">${e.getExecutionID()}</a></td>
                    <td>
                        <c:forEach items="${e.getExecutionItems()}" var="item" >
                            <span>${item.getArrayItem()}</span>
                        </c:forEach>
                    </td>
                    <td>
                        ${e.getResult()}
                    </td>
                    <td><a href="?service=delete&id=${e.getExecutionID()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <c:set var="detail" value="${item}"/>            
        <table>
            <tr>
                <td>Execution ID:</td>
                <td><input type="text" name="name" value="${detail.getExecutionID()}"></td>
            </tr>
            <tr>
                <td>Array:</td>
                <c:set var="arr" value=""/>
                <c:forEach var="item" items="${detail.getExecutionItems()}">
                    <c:set var="arr" value="${arr}${item.getArrayItem()} "/>
                </c:forEach>
                <td><input type="text" name="name" value="${arr} "></td>
            </tr>
            <tr>
                <td>Result:</td>
                <td><input type="text" name="name" value="${detail.getResult()}"></td>
            </tr>
        </table>
    </body>
</html>
