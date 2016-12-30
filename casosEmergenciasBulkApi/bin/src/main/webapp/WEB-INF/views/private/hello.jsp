<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<html>
	<head>
		<title>${title}</title>
	</head>
<body>
	<h1><s:message code="hello_text"/> <b>${name}</b></h1>	
	<a href="private/hello?param=param1"> Hola </a>
	
	
	
	Language : <a href="changLang.do?lang=en">English</a>|<a href="changLang.do?lang=es">Español</a>
</body>
</html>