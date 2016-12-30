<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="resources/css/styles.css" rel="stylesheet">
	</head>
	<body style="background-color:#99CCFF;">
	<center><img src="resources/images/heroku.png"  /></center>
		
			<center><h1><s:message code="reset_label_title"/></h1></center>
	  		<center><h3><s:message code="reset_label_text"/>:</h3> </center> 
	    
	    	<div id="box-page">
		  		<form name='resetForm' action="sendEmail" method='POST' >
			    	<table align="center" >
						<tr align="center">
				           	<td>
				           		<h3 style="font-weight:bold;color:black"><s:message code="reset_form_label_user"/></h3>
				           	</td>				        	
				        </tr>
				        <tr align="center" >
				       		<td>
				        		<input type='text' name='userName' value='' class="buttontext">
				        	</td>				        
				        </tr><tr><td><br></td></tr>
				        <tr align="center" >
				        	<td >
				        		<input name="submit" type="submit" class="button" value='<s:message code="reset_form_button_submit" />'/>
				        	</td>
				        </tr><tr> <td><br></td></tr><tr>
				        <tr align="center" >
	        				<td colspan="2">
							 	<h4 style="font-weight:bold;color:red;"><s:message code="${userView.mensajeError}" text=""/></h4>
							 	<h4 style="font-weight:bold;color:green;"><s:message code="${userView.mensaje}" text=""/> <s:message code="${userView.email}" text=""/></h4>		
	        				</td>
        				</tr> 
					</table>
			 	</form>
		 	</div>		 	
	</body>
</html>