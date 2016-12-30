<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/jquery-ui.css" rel="stylesheet" />
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />
		
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/jQueryDatatables.js"></script>	
  		<script src="../resources/js/jquery-ui.js"></script>
		<script src="../resources/js/utils.js" lang=""></script>
  		<script src="../resources/js/popupsTable.js"></script>
		<script src="../resources/js/header.js" lang=""></script>
	</head>
	<body onload="initHeader(); cargarDialogSuministro(); cargarDialogDireccion();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="entidadCasoAlta_title_label_detalle_caso"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<!-- Botonera superior -->
		<div class="divCabeceraEntidad">
			<div class="botoneraListado botoneraCentrado">
				<ul>

					<li><input type="button" name="Guardar" value="<s:message code="entidadCasoAlta_button_guardar"/>" onclick="altaCaso();"/></li>
					<li><input type="button" name="GuardarYNuevo" value="<s:message code="entidadCasoAlta_button_guardarynuevo"/>" onclick="altaCasoYNuevo();"/></li>
					<li><input type="button" name="Cancelar" value="<s:message code="entidadCasoAlta_button_cancelar"/>" onclick="cancelAltaCaso();" /></li>

				</ul>
			</div>
		</div>
		<!-- Mensajes de estado de operación -->
		<div id="divError" class="divError" style="display:none;margin-top:2%;">
			<label><s:message code="entidadCasoAlta_error_datonovalidos"/></label>
			<br>
			<label><s:message code="entidadCasoAlta_error_revisemensajes"/></label>
			<br>
			<label id="errorMessage"></label>
		</div>
		<!-- Identificación de campos obligatorios -->
		<div>
			<div class="subtitlePrincipalAltaEntidad">
				<div class="titleObligatorio"></div>
				<div class="titleObligatorioTexto">
					<label><s:message code="entidadCasoAlta_table_title_label_infoobligatorio"/></label>
				</div>
			</div>
		</div>
		<div>
			<form:form name="formEntidadCasoAlta" id="formEntidadCasoAlta" action="altaCaso" modelAttribute="caso" method="POST">
				<input type="hidden" name="redirectToNewCase" id="redirectToNewCase" value="false"/>
				<form:hidden path="sfid"/>
				<div id="divEntidadCasoAlta" class="divEntidad">
					<!-- iNFORMACIÓN DEL CASO -->
					<div class="subtitleAltaEntidad">
						<div><label><s:message code="entidadCasoAlta_table_title_label_infoentidad"/></label></div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_motivo"/></label>
						</div>
						<div>
							<label>${caso.labelPeticionPickList}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_estado"/></label>
						</div>
						<div>
							<div class="divObligatorio"></div>
							<form:select path="estado" items="${caso.mapStatus}"/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_numinservice"/></label>
						</div>
						<div>
							<label>${caso.numeroInservice}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_subestado"/></label>
						</div>
						<div>
							<label>${caso.subestado}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_tiempoNormalizacion"/></label>
						</div>
						<div>
							<label>${caso.fechaEstimadaCierre}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_canalorigen"/></label>
						</div>
						<div>
							<label>${caso.canalOrigenLabel}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_propietarioCaso"/></label>
						</div>
						<div>
							<label>${caso.propietarioCaso}</label>
						</div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_casoPrincipal"/></label>
						</div>
						<div>
							<label>${caso.parent}</label>
						</div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
					</div>
					
					<!-- DATOS EMERGENCIA -->
					<div class="subtitleAltaEntidad">
						<div><label class="divLabel"><s:message code="entidadCasoAlta_table_title_label_datosemergencia"/></label></div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_type"/></label>
						</div>
						<div>
							<label>${caso.typeLabel}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_asunto"/></label>
						</div>
						<div>
							<label>${caso.asunto}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_submotivo"/></label>
						</div>
						<div>
							<form:select path="submotivo" items="${caso.mapSubMotivo}"/>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_description"/></label>
						</div>
						<div>
							<form:textarea path="description" rows="3" cols="40" cssClass=""/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_condagravante"/></label>
						</div>
						<div>
							<form:select path="condicionAgravante" items="${caso.mapCondicionAgravante}"/>
						</div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
					</div>
					
					<!-- IDENTIFICACIÓN -->
					<div class="subtitleAltaEntidad">
						<div><label class="divLabel"><s:message code="entidadCasoAlta_table_title_label_identificacion"/></label></div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_nombreContacto"/></label>
						</div>
						<div>
							<form:hidden path="nombreContacto"/>
							<label>${caso.contactoJoin.name}</label>
						</div>
						<div class="divLabel"><label><s:message code="entidadCaso_table_label_canalNotificacion"/></label></div>
						<div>
							<form:select path="canalNotificacion" items="${caso.mapCanalNotificacion}"/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_identificadorSuministro"/></label>
						</div>
						<div>
							<form:hidden path="suministro"/>
							<c:choose>
								<c:when test="${not empty caso.suministroJoin}">
									<input type="text" id="numSumiRecuperado" disabled="disabled" value="${caso.suministroJoin.name}"/>
								</c:when>
								<c:otherwise>
									<input type="text" id="numSumiRecuperado" disabled="disabled"/>
									<input type="button" id="botonLupaSuministro" class="lupa" onclick="abrirDialogSuministro();">					
									<input type="button" id="textSuministro" class="limpiarCampo" onclick="limpiarSuministro();" value="<s:message code="entidadCasoAlta_table_label_limpiar"/>"/>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="divLabel"><label><s:message code="entidadCaso_table_label_telefonoContacto"/></label></div>
						<div>
							<form:input path="telefonoContacto"/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadDireccion_table_label_codigoDeDireccion"/></label>
						</div>
						<div>
							<form:hidden path="direccion"/>
							<c:choose>
								<c:when test="${not empty caso.direccionJoin}">
									<input type="text" id="dirRecuperada" disabled="disabled" value="${caso.direccionJoin.name}"/>
								</c:when>
								<c:otherwise>
									<input type="text" id="dirRecuperada" disabled="disabled"/>
									<input type="button" id="botonLupaDireccion" class="lupa" onclick="abrirDialogDireccion();">
									<input type="button" id="textDireccion" class="limpiarCampo" onclick="limpiarDireccion();" value="<s:message code="entidadCasoAlta_table_label_limpiar"/>" />
								</c:otherwise>
							</c:choose>
						</div>
						<div class="divLabel"><label><s:message code="entidadCaso_table_label_emailNotificacion"/></label></div>
						<div>
							<form:input path="emailNotificacion"/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_nombreCuenta"/></label>
						</div>
						<div>
							<form:hidden path="nombreCuenta"/>
							<label>${caso.cuentaJoin.name}</label>
						</div>
						<div class="divLabel"><label><s:message code="entidadCaso_table_label_idFacebook"/></label></div>
						<div>
							<form:input path="facebook"/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
						<div class="divLabel"><label><s:message code="entidadCaso_table_label_twitter"/></label></div>
						<div>
							<form:input path="twitter"/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
						<div class="divLabel"><label><s:message code="entidadCaso_table_label_actualizarDatosContacto"/></label></div>
						<div>
							<form:checkbox path="actDatosContacto"/>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
						<div class="divLabel"><label><s:message code="entidadCaso_table_label_ani"/></label></div>
						<div>
							<label>${caso.ani}</label>
						</div>
					</div>
					
					<!-- CUERPO MAIL -->
					<div class="subtitleAltaEntidad">
						<div><label><s:message code="entidadCaso_title_label_cuerpoMail"/></label></div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_table_label_cuerpoMail"/></label>
						</div>
						<div class="divAreaTexto">
							<form:textarea path="description" rows="2" cols="60" cssClass=""/>
						</div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
					</div>
					<!-- SOLUCIÓN -->
					<div class="subtitleAltaEntidad">
						<div><label><s:message code="entidadCaso_title_label_solucion"/></label></div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_title_label_respuestaCliente"/></label>
						</div>
						<div>
							<form:textarea path="description" rows="3" cols="60" cssClass=""/>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadCaso_title_label_favoravilidadCaso"/></label>
						</div>
						<div>
							<form:select path="favorabilidadDelCaso" items="${caso.mapFavorabilidadCaso}"/>
						</div>
					</div>
				</div>
				<!-- Dialog suministro -->
				<div id="dialogSuministro" title="<s:message code="dialog_title_suministro"/>" class="dialogLupa">
					<div class="divBusquedaDialog">
						<input type="text" id="txtNumeroSuministro"/>
						<input type="text" id="txtComuna"/>
						<input type="button" id="searchSuministro" value="<s:message code="btn_label_boton_ir"/>"/>
						<br>
						<label><s:message code="dialog_label_busqueda_nombre"/></label>
					</div>
					<div>
				  		<table id="tablaSuministrosPopUp" class="display" data-page-length="10" data-order="[[ 0, &quot;asc&quot; ]]">
								<thead>
						            <tr>
						            	<th width="30%"><s:message code="homeSuministros_table_head_nombreSuministro"/></th>
						            	<th width="15%"><s:message code="homeSuministros_table_head_idEmpresa"/></th>
						            	<th width="15%"><s:message code="homeSuministros_table_head_comuna"/></th>
						            	<th width="39%"><s:message code="homeSuministros_table_head_direccionConcat"/></th>		
						            	<th width="1%" hidden="true">sfid</th>	            	
						            </tr>
					        	</thead>
						</table>
					</div>
				</div>
				<!-- Dialog direccion -->
				<div id="dialogDireccion" title="<s:message code="dialog_title_direccion"/>" class="dialogLupa">
					<div class="divBusquedaDialog">
						<input type="text" id="txtNombreDireccion"/>
						<input type="button" id="searchDireccion" value="<s:message code="btn_label_boton_ir"/>"/>
						<br>
						<label><s:message code="dialog_label_busqueda_nombre"/></label>
					</div>
					<div>
				  		<table id="tablaDireccionesPopUp" class="display" data-page-length="10" data-order="[[ 0, &quot;asc&quot; ]]">
							<thead>
					            <tr>
					            	<th width="30%"><s:message code="homeDirecciones_table_head_codigoDireccion"/></th>
					            	<th width="10%"><s:message code="homeDirecciones_table_head_numero"/></th>
					            	<th width="20%"><s:message code="homeDirecciones_table_head_comuna"/></th>
					            	<th width="30%"><s:message code="homeDirecciones_table_head_calle"/></th>
					            	<th width="9%"><s:message code="homeDirecciones_table_head_departamento"/></th>
					            	<th width="1%" hidden="true">sfid</th>
					            </tr>
				        	</thead>
						</table>
					</div>
				</div>
			</form:form>
		</div>
		<!-- Botonera inferior -->
		<div class="divCabeceraEntidad">
			<div class="botoneraListado botoneraCentrado botoneraInferior">
				<ul>
					<li><input type="button" name="Guardar" value="<s:message code="entidadCasoAlta_button_guardar"/>" onclick="altaCaso();"/></li>
					<li><input type="button" name="GuardarYNuevo" value="<s:message code="entidadCasoAlta_button_guardarynuevo"/>" onclick="altaCasoYNuevo();"/></li>
					<li><input type="button" name="Cancelar" value="<s:message code="entidadCasoAlta_button_cancelar"/>" onclick="cancelAltaCaso();" /></li>
				</ul>
			</div>
		</div>
	</body>
</html>