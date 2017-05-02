<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>Emergencias App Login Page</title>
		
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/favicon.png">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
	</head>
	<body>
		<header>
			<section id="logo-section">
				<img src="${pageContext.request.contextPath}/resources/images/enel_logo_new.png" width="200" />
				<p id="login-text"><s:message code="login_label_title"/></p>
			</section>
		</header>
	    <div id="box-login">
			<form name="loginUser" id="login-user" action="login" method="POST" name="userView">
				<table id="login-user-table">
					<tr>
						<td colspan="2" align="center"><h4 style="font-weight: bold; color: red;"><s:message code="${userView.mensajeError}" text="" /></h4></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><p id="login-info"><s:message code="login_label_text"/>:</p></td>
					</tr>
					<tr>
						<td align="right"><label for="user"><s:message code="login_form_label_user"/>:</label></td>
						<td><input type="text" name="user" value="" class=""></td>
					</tr>
					<tr>
						<td align="right"><label for="pass"><s:message code="login_form_label_password"/>:</label></td>
						<td><input type="password" name="pass" class="" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input name="submit" type="submit" class="" value="<s:message code="login_form_button_submit"/>"/></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>