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
		<script src="../resources/js/direcciones.js"></script>
	</head>
	<body onload="initHeader();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_direccion"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<br><br>
		<div class="formBusqueda">
			<table class="tablaBusqueda">
				<tr>
					<td class="tablaBusquedaTitulo" colspan="2">
						<s:message code="search_form_title_direccion"/>
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroComuna"><s:message code="search_form_input_direccion_comuna"/></label>
					</td>
					<td class="tablaBusquedaTextos">
						<c:if test="${not empty picklistsComuna}">
							<select id="filtroComuna" name="filtroComuna" class="column_filter">
								<option value="" selected></option>							
								<c:forEach items="${picklistsComuna}" var="datosComuna">
   									<option value="${datosComuna.codigo}">${datosComuna.valor}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroCalle"><s:message code="search_form_input_direccion_calle"/></label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="text" id="filtroCalle" name="filtroCalle" class="column_filter" value="" maxlength="50">
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
			<table id="tablaDirecciones" class="display" style="width: 100%;">
				<thead>
		            <tr>
		           		<th width="15%"><s:message code="homeDirecciones_table_head_codigoDireccion"/></th>
			            <th width="20%"><s:message code="homeDirecciones_table_head_calle"/></th>
			            <th width="15%"><s:message code="homeDirecciones_table_head_numero"/></th>
			            <th width="20%"><s:message code="homeDirecciones_table_head_comuna"/></th>
			            <th width="28%"><s:message code="homeDirecciones_table_head_direccionConcatenada"/></th>
			            <th width="1%" hidden="true">comuna__c</th>
		                <th width="1%" hidden="true">sfid</th>
	            	</tr>
        		</thead>
			</table>
		</div>
	</body>
</html>