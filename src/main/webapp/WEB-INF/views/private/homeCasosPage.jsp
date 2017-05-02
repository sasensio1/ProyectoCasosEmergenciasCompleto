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
		<script src="../resources/js/casosDataTable.js"></script>
	</head>
	<body onload="initHeader();limpiarCamposBuscadorCasos();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_case"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		 
		<form name="formListadoCasos" action="homeCasosAction" method="POST">
			<br><br>
			<div class="formBusqueda">
				<table class="tablaBusqueda">
					<tr>
						<td class="tablaBusquedaTitulo" colspan="2">
							<s:message code="search_form_title_caso"/>
						</td>
					</tr>
					<tr>
						<td class="tablaBusquedaEtiquetas">
							<label for="filtroNumCaso"><s:message code="search_form_input_caso_numero"/></label>
						</td>
						<td class="tablaBusquedaTextos">
							<input type="text" id="filtroNumCaso" name="filtroNumCaso" class="column_filter" value=""  maxlength="50">
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
				<table id="tablaCasos" class="display" style="width: 100%;"> 
					<thead>
			            <tr>
			                <th width="20%"><s:message code="homeCasos_table_head_numCasos"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_numInservice"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_canalOrigen"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_estado"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_subestado"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_submotivo"/></th>
			                <th width="1%" hidden="true">sfid</th>
			            </tr>
		        	</thead>
				</table>
			</div>
		</form>
	</body>
</html>