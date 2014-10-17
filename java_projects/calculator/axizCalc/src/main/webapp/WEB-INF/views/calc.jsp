<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><spring:message code="calc.calculator" /></title>
</head>
<body>
	<h1><spring:message code="calc.calculator" /></h1>
	<form:form modelAttribute="calcForm" action="calc" method="post">

		<table border="0">
			<tr>
				<td align="right"><spring:message code="calc.instructions" />:</td>
				<td>
<%-- 				<form:input path="left" maxlength="12" /> --%>
					<form:input path="left"  />
				</td>
				<td>
					<form:select path="o">
					  <form:option value="+" label="+" selected="selected"/>
					  <form:option value="*" label="x" />
					  <form:option value="-" label="-" />
					  <form:option value="/" label="/" />
					  <form:option value="%" label="%" />
					</form:select>
				</td>
				<td>
				<%-- <form:input path="right" maxlength="12" /> --%>
				<form:input path="right" />
				</td>
				<td><form:button><spring:message code="calc.submit" /></form:button></td>
			</tr>
		</table>
		
		<c:if test="${not empty resultMsg}">
			<p>
				<c:out value="${resultMsg}" />
			</p>
		</c:if>
		
		<spring:hasBindErrors name="calcForm">
			<p style="color: red; font-weight: bold;">
				<c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code="${error.code}" /><br />
				</c:forEach>
				<form:errors path="left" htmlEscape="false" />
				<form:errors path="right" htmlEscape="false" />
			</p>
		</spring:hasBindErrors>
		
	</form:form>
</body>
</html>
