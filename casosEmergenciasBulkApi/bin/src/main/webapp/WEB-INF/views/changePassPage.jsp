<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="resources/css/styles.css" rel="stylesheet">
	</head>
	<body style="background-color:#99CCFF;">
	 	<!-- <center><img src="resources/images/heroku.png"  /></center> -->
		  	<center><h1><s:message code="changePass_label_title"/>:</h1></center> 
		  	 	    
		    <div id="box-page">
			  	<form name='changePassForm' action="changePass" method='POST' name='userView'>
			  		<input type="hidden" name="sfid" value="${userView.sfid}"/>
				    <table align="center">
				        <tr align="center">
				           <td><h3 style="font-weight:bold;color:black"><s:message code="changePass_form_label_pass"/></h3></td>
				        </tr>
				        <tr align="center">
				        	<td>
				        		<input type='password' name='pass' />
				        	</td>
				        </tr>
				        </tr><tr><td><br></td></tr>
				        <tr align="center">
				           <td><input name="submit" type="submit" class="button" value='<s:message code="changePass_form_button_submit"/>' /></td>
				        </tr>
						<tr><td><br></td></tr>
						<tr>
	        				<td >
							 	<h4 style="font-weight:bold;color:red;"><s:message code="${userView.mensajeError}" text=""/></h4>
							 	<h4 style="font-weight:bold;color:green;"><s:message code="${userView.mensaje}" text=""/> </h4>		
	        				</td>
	        			</tr>
					</table>
			 	</form>
		 	</div>		 	
	</body>
</html>
