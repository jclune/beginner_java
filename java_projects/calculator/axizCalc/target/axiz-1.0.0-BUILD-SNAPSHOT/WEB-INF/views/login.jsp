<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Login</title>
</head>
<body>
	<h1>ログイン画面</h1>
	<c:if test="${not empty resultMsg}">
		<p>
			<c:out value="${resultMsg}" />
		</p>
	</c:if>
	<form:form modelAttribute="loginForm" action="doLogin" method="post">
		<table border="0">
			<tr>
				<td align="right">ユーザID:</td>
				<td><form:input path="userId" maxlength="12" /></td>
			</tr>
			<tr>
				<td align="right">パスワード:</td>
				<td><form:password path="userPwd" maxlength="12" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<table style="margin-top: 10px" border="0">
						<tr>
							<td><form:button>ログイン</form:button></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
