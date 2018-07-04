<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Big Small Gamble Result Estimation</title>
<link href = '<c:url value="/css/common.css"/>' rel = "stylesheet" />
<link href = '<c:url value="/css/estimate_next.css"/>' rel = "stylesheet" />

<script type = "text/javascript" src = '<c:url value="/javascript/jquery-3.3.1.js"/>'></script> 
<script type = "text/javascript" src = '<c:url value="/javascript/estimate_next.js"/>'></script> 
</head>
<body>
	<div class="content">
		<table class="bigSmallTable">
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${bigSmallEoList}" var="bigSmallEo">
				<c:if test="${count % 5 eq 0 }">
                	<tr>
                </c:if>
<%--                     <td>${bigSmallEo.round}</td> --%>
                    <td>${bigSmallEo.result}</td>
<%--                     <td>${bigSmallEo.updateDate}</td> --%>
				<c:if test="${count % 5 eq 0 }">
                	</tr>
                </c:if>
				<c:set var="count" value="${count + 1}" scope="page"/>                
            </c:forEach>
		</table>
	</div>
</body>
</html>