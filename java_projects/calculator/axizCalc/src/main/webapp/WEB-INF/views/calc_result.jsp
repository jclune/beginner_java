<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title><spring:message code="calc.answer" /></title>
</head>
<body>
	<h1><spring:message code="calc.answer" /></h1>
	<c:out value="${resultMsg}" />
</body>
</html>
