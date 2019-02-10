<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.rabbitforever.common.factories.UtilsFactory" %>
<%@ page import="com.rabbitforever.common.utils.DateUtils" %>
<% UtilsFactory utilsFactory = UtilsFactory.getInstance(); 
DateUtils dateUtils = utilsFactory.getInstanceOfDateUtils();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css"/>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/baccarat.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/common_utils.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/baccarat.js"></script>
<title>Baccarat</title>
</head>
<body>
	<div class="mainContentDiv">
	<label for="date" class="dateLabel"><%= dateUtils.getTodayDisplayDateString() %></label>
	<input type="hidden" class="dateParamInput" value="<%= dateUtils.getDateParamString() %>" />
	<table class="baccaratTable">
		<thead>
			<tr>
				<th></th>
				<th>Session</th>
				<th>Round</th>
				<th>Input</th>
				<th>Count</th>
				<th>Odd/Even</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="button" value="Add" class="addNewButton" onclick="addNewButton_onclick(event)"/></td>
				<td><input type="text" value="<%= dateUtils.getDateParamString() %>" class="sessionInput"/></td>
				<td><input type="text" value="" class="roundInput" /></td>
				<td><input type="text" value="" class="resultInput" onkeydown="resultInput_onkeydown(event)" onchange="resultInput_onchange(event)" /></td>
				<td><label for="count" class="countLabel"></label></td>
				<td><label for="oddEven" class="oddEvenLabel"></label></td>
			</tr>
		</tbody>

	</table>
	</div>
</body>
</html>