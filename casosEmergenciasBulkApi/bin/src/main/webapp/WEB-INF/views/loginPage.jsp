<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="resources/css/styles.css" rel="stylesheet">
	</head>
	<body style="background-color:#99CCFF;">
	<center><img src="resources/images/heroku.png"  /></center>
		<center><h1><s:message code="login_label_title"/></h1></center>
	   	<center><h3><s:message code="login_label_text"/>:</h3></center>  
	    
	    <div id="box-page">
		   	<form name='loginUser' action="login" method='POST' name='userView'>
		    	<table align="center">
		    	    <tr><td><br></td></tr>
			    	<tr >
			            <td><h3><s:message code="login_form_label_user"/>:</h3></td>
			            <td><input type='text' name='user' value='' class="buttontext"></td>
			         </tr>
			         <tr >
			            <td><h3><s:message code="login_form_label_password"/>:</h3></td>
			            <td><input type='password' name='pass' class="buttontext" /></td>
			         </tr>
			         <tr><td><br></td></tr>
			         <tr align="center">
			            <td colspan="2"><input name="submit" type="submit" class="button" value='<s:message code="login_form_button_submit"/>' /></td>
			         </tr>
			         <tr >
			         <tr align="center" >
			         	<td colspan="2">
							<h4 style="font-weight:bold;color:red;"><s:message code="${userView.mensajeError}" text=""/></h4><!-- añadiomos text, si loginNoUser es vacio, no existe ninguna etiqueta en los properties y mostrará el valor de text-->		
	        		    </td>
	        		 </tr>					
		    	</table>
		  	</form>	  	
		</div>
		<table align="center" >
			<tr>
				<td>
					<a href="resetPass">Reset Password</a> 	
				</td>
				<td>
					
				</td>
			</tr>		
	    </table> 
	  	<div>
      	</div>
      <!-- 	<div>	     
      		Language : <a href="changLang.do?lang=en">English</a>|<a href="changLang.do?lang=es">Español</a>
    	</div> -->
	</body>
</html>