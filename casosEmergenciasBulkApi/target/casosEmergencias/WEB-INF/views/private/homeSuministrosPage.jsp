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
		<script src="../resources/js/suministros.js"></script>
	</head>
	<body onload="initHeader();limpiarCamposBuscadorSuministro();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_suministro"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		 
		<form name='formListadoCasos' action="homeSuministrosAction" method='POST'>
			<br><br>
			<div class="formBusqueda">
				<table class="tablaBusqueda">
					<tr>
						<td class="tablaBusquedaTitulo" colspan="2">
							<s:message code="search_form_title_suministro"/>
						</td>
					</tr>
					<tr>
						<td class="tablaBusquedaEtiquetas">
							<label for="filtroNumSuministro"><s:message code="search_form_input_suministro_numero"/></label>
						</td>
						<td class="tablaBusquedaTextos">
							<input type="text" id="filtroNumSuministro" name="filtroNumSuministro" class="column_filter" value="" maxlength="50">
						</td>
					</tr>
					<tr>
						<td class="tablaBusquedaEtiquetas">
							<label for="filtroDireccion"><s:message code="search_form_input_suministro_direccion"/></label>
						</td>
						<td class="tablaBusquedaTextos">
							<input type="text" id="filtroDireccion" name="filtroDireccion" class="column_filter" value="" maxlength="50">
						</td>
					</tr>							
					<tr>
						<td class="tablaBusquedaEtiquetas">
							<label for="filtroRutaLectura"><s:message code="search_form_input_suministro_ruta_lectura"/></label>
						</td>
						<td class="tablaBusquedaTextos">
							<input type="text" id="filtroRutaLectura" name="filtroRutaLectura" class="column_filter" value="" maxlength="50">
						</td>
					</tr>
					<tr>
						<td class="tablaBusquedaEtiquetas">
							<label for="filtroNumMedidor"><s:message code="search_form_input_suministro_numero_medidor"/></label>
						</td>
						<td class="tablaBusquedaTextos">
							<input type="text" id="filtroNumMedidor" name="filtroNumMedidor" class="column_filter" value="" maxlength="50">
						</td>
					</tr>
					<tr>
						<td class="tablaBusquedaBotonera" colspan="2">
							<input type="button" id="search" name="searchButton" class="column_filter" value="Buscar">	
						</td>
					</tr>
				</table>
			</div>
			<div>
				<table id="tablaSuministros" class="display" style="width: 100%;">
					<thead>
			            <tr>
			            	<th width="20%"><s:message code="homeSuministros_table_head_nombreSuministro"/></th>
			                <th width="19%"><s:message code="homeSuministros_table_head_estadoConexion"/></th>
			                <th width="19%"><s:message code="homeSuministros_table_head_estadoSuministro"/></th>
			                <th width="20%"><s:message code="homeSuministros_table_head_direccion"/></th>
			                <th width="19%"><s:message code="homeSuministros_table_head_comuna"/></th>
			                <th width="1%" hidden="true">n_mero_medidor__c</th>
			                <th width="1%" hidden="true">ruta__c</th>
			                <th width="1%" hidden="true">sfid</th>
			            </tr>
		        	</thead>
				</table>
			</div>
		</form>
	</body>
</html>