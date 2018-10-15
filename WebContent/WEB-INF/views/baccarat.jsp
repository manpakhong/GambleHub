<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css"/>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/baccarat.css"/>
<script type = "text/javascript" src = '<c:url value="/javascript/jquery-3.3.1.js"/>'></script> 
<script type = "text/javascript" src = '<c:url value="/javascript/baccarat.js"/>'></script> 
<title>Insert title here</title>
</head>
<body>
	<div class="mainContentDiv">
	<table class="baccaratTable">
		<thead>
			<tr>
				<th>Input</th>
				<th>Count</th>
				<th>Odd/Even</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" value=""/></td>
				<td><label for="count"></label></td>
				<td><label for="oddEven"></label></td>
			</tr>
		</tbody>

	</table>
	</div>
</body>
</html>