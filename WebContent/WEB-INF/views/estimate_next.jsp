<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Big Small Gamble Result Estimation</title>
<link href = '<c:url value="/css/common.css"/>' rel = "stylesheet" />
<link href = '<c:url value="/css/estimate_next.css"/>' rel = "stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/estimate_next.js"></script>

</head>
<body>
	<div class="content">
		<table class="bigSmallTable">
			<c:set var="count" value="0" scope="page" />
			<c:set var="isTrClosed" value="false" scope="page" />
			<c:forEach items="${bigSmallEoList}" var="bigSmallEo">
				<c:if test="${count % 5 eq 0 }">
                	<tr>
                	<c:set var="isTrClosed" value="false" scope="page" />
                </c:if>
<%--                     <td>${bigSmallEo.round}</td> --%>
                    <td>${bigSmallEo.result}</td>
<%--                     <td>${bigSmallEo.updateDate}</td> --%>
				<c:if test="${count % 5 eq 4 }">
                	</tr>
					<c:set var="isTrClosed" value="true" scope="page" />
                </c:if>
				<c:set var="count" value="${count + 1}" scope="page"/>                
            </c:forEach>
            <c:if test="${isTrclosed eq false}">
            	</tr>
            </c:if>
		</table>
		<div>Final Result:"${nextBettingSuggestion}"
		</div>
	</div>
</body>
</html>