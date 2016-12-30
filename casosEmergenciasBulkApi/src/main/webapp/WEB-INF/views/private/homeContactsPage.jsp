<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />	

		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/jQueryDatatables.js"></script>
		<script src="../resources/js/header.js"></script>
		<script src="../resources/js/utils.js"></script>
		<script src="../resources/js/contactosDataTable.js"></script>
	</head>
	<body onload="initHeader();limpiarCamposBuscadorContactos()">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_contact"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<br><br>
		<div id="formBusquedaContactoId" class="formBusqueda">
			<table class="tablaBusqueda">
				<tr>
					<td class="tablaBusquedaTitulo" colspan="2">
						<s:message code="search_form_title_contacto"/>
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroRunRut"><s:message code="search_form_input_contacto_runrut"/></label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="text" id="filtroRunRut" name="filtroRunRut" class="column_filter" value=""  maxlength="50">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroNombreApellidos"><s:message code="search_form_input_contacto_nombre_apellidos"/></label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="text" id="filtroNombreApellidos" name="filtroNombreApellidos" class="column_filter" value=""  maxlength="50">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroTelefono"><s:message code="search_form_input_contacto_telefono"/></label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="tel" id="filtroTelefono" name="filtroTelefono" class="column_filter" value=""  maxlength="50">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroEmail"><s:message code="search_form_input_contacto_email"/></label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="email" id="filtroEmail" name="filtroEmail" class="column_filter" value=""  maxlength="50">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroTwitter"><s:message code="search_form_input_contacto_twitter"/></label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="text" id="filtroTwitter" name="filtroTwitter" class="column_filter" value=""  maxlength="20">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaBotonera" colspan="2">
						<input type="button" id="search" name="searchButton" class="column_filter" value="Buscar">	
					</td>
				</tr>
			</table>
		</div>
<%--  		<center>
			<div>
				<img id="cargandoGif" src="${pageContext.request.contextPath}/resources/images/loading.gif" width="30" style="padding-left: 15px;" hidden="true"/>								
			</div>
		</center>  --%>
		<div>
			<table id="tablaContactos" class="display" style="width: 100%;">
				<thead>
		            <tr>
		           		<th width="25%"><s:message code="homeContacts_table_head_name"/></th>
			            <th width="23%"><s:message code="homeContacts_table_head_accountRun"/></th>
			            <th width="25%"><s:message code="homeContacts_table_head_phone"/></th>
			            <th width="25%"><s:message code="homeContacts_table_head_email"/></th>
			            <th width="1%" hidden="true">sf4twitter__twitter_username__c</th>
			            <th width="1%" hidden="true">sfid</th>
	            	</tr>
        		</thead>
			</table>
		</div>
	</body>
</html>