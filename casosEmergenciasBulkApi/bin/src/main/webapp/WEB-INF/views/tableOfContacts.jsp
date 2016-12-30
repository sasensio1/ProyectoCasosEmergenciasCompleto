<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="resources/css/styles.css" rel="stylesheet">
	<script type="text/javascript">
			$(document).ready(function() {
			    $('#tablaContactos').DataTable();			    
			});
	</script>
</head>
<body>
<form name='formListadoContactos' action="listar" method='POST'>
		<div>
			<table id="tablaContactos" class="display" data-page-length="25" data-order="[[ 1, &quot;asc&quot; ]]">
				<thead>
		            <tr>
		            <!-- <th data-orderable="false"> -->
		                <th width="20%">Id</th>
		                <th width="16%">Sfid</th>
		                <th width="16%">Nombre</th>
		                <th width="16%">RUN</th>
		                <th width="16%">Telefono</th>
		                <th width="16%">Email</th>		                
		            </tr>
	        	</thead>
	        	<tbody>
	        		<c:forEach items="${contacts}" var="datosContacto">
						<tr>
							<td>${datosContacto.name}</td>
							<td>${datosContacto.id}</td>
							<td>${datosContacto.sfid}</td>							
							<td>${datosContacto.accountRun}</td>
							<td>${datosContacto.phone}</td>
							<td>${datosContacto.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>