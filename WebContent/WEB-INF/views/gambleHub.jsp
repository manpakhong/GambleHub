<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Gamble Hub Home Page</title>
        <style type="text/css">
            .error {
                color: red;
            }
            table {
                width: 50%;
                border-collapse: collapse;
                border-spacing: 0px;
            }
            table td {
                border: 1px solid #565454;
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <h1>Input Form</h1>
        <form:form action="addResult" method="post" modelAttribute="bigSmallEo">
            <table>
                <tr>
                    <td>Round</td>
                    <td>
                        <form:input path="round" /> <br />
                        <form:errors path="round" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Point</td>
                    <td>
                        <form:input path="point" /> <br />
                        <form:errors path="point" cssClass="error" />
                    </td>
                </tr>                
                <tr>
                    <td>Result</td>
                    <td>
                        <form:input path="result" /> <br />
                        <form:errors path="result" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>
         
         
        <h2>Gamble Results</h2>
        <table>
            <tr>
                <td><strong>Round</strong></td>
                <td><strong>Point</strong>
                <td><strong>Result</strong></td>
                <td><strong>Date</strong></td>
            </tr>
            <c:forEach items="${bigSmallEoList}" var="bigSmallEo">
                <tr>
                    <td>${bigSmallEo.round}</td>
                    <td>${bigSmallEo.point}</td>
                    <td>${bigSmallEo.result}</td>
                    <td>${bigSmallEo.updateDate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>