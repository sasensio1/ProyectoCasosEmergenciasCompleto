<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<html>
	<head>
		<title>Emergencias App</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
		
		<link href="../resources/css/styles.css" rel="stylesheet">
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />	
		
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/header.js" lang=""></script>
		<script src="../resources/js/utils.js" lang=""></script>
	</head>
	<body onload="initHeader();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="entidadDireccion_title_label_detalle_direccion"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<form:form name="formEntidadDireccion" action="actualizarDireccion" modelAttribute="direccion" method="POST">
			<form:hidden path="sfid"/>
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowDetalleDireccion" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('detalleDireccion','arrowDetalleDireccion'); return false;"/>
						<label class="divLabel"><s:message code="entidadDireccion_title_label_detalle_direccion"/></label>
					</div>
				</div>
			</div>
			<div id="detalleDireccion" class="divEntidad">
				<div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_region"/></label>
					</div>
					<div>
						<label>${direccion.labelRegionPickList}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_comuna"/></label>
					</div>
					<div>
						<label>${direccion.literalComuna}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_tipoDeCalle"/></label>
					</div>
					<div>
						<label>${direccion.labelTipoCallePickList}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_calle"/></label>
					</div>
					<div>
						<label>${direccion.calle}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_numero"/></label>
					</div>
					<div>
						<label>${direccion.numero}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_departamento"/></label>
					</div>
					<div>
						<label>${direccion.departamento}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_codigoDeDireccion"/></label>
					</div>
					<div>
						<label>${direccion.name}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadDireccion_table_label_direccionConcatenada"/></label>
					</div>
					<div>
						<label>${direccion.direccionConcatenada}</label>
					</div>
				</div>
			</div>	
		</form:form> 		
	</body>
</html>