<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 

<html>
	<head>
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
			
		<link href="../resources/css/jquery-ui.css" rel="stylesheet" />
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />	
		<link href="../resources/css/styles.css" rel="stylesheet" />	
	
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/jQueryDatatables.js"></script>	
  		<script src="../resources/js/jquery-ui.js"></script>
		<script src="../resources/js/header.js" lang=""></script>
        <script src="../resources/js/utils.js" lang=""></script> 
		<script src="../resources/js/casos.js"></script>
	</head>
	<body onload="funcionOnload();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="entidadCaso_title_label_detalle_caso"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<!-- Mensajes de estado de alta, actualizacion e insercion de comentarios de un caso -->
		<div>
			<div id="divCaseModifiedError" class="divError">
				<label class="labelDivError"><s:message code="entidadCasoAlta_error_datonovalidos"/></label>
				<br>
				<label class="labelDivError"><s:message code="entidadCasoAlta_error_revisemensajes"/></label>
			</div>
			<div id="divCaseModifiedOk" class="divOk" >
				<label class="labelDivOk"><s:message code="entidadCaso_modificacion_correcta"/></label>
			</div>
			<!-- Creacion de un comentario de caso -->	
			<div id="divCaseCommentNOCreated" class="divError">
				<label class="labelDivError"><s:message code="entidadCasoAlta_error_datonovalidos"/></label>
				<label class="notificationMessage" id="errorMessage"></label>
			</div>
			<div id="divCaseCommentCreated" class="divOk">
				<label class="labelDivOk"><s:message code="notificaciones_label_ok_comentario_guardado"/></label>
			</div>
			<!-- Alta de un caso -->
			<div id="divCaseCreatedOk" class="divOk">
				<label class="labelDivOk"><s:message code="notificaciones_label_ok_caso_creado"/></label>
			</div>
			<!--  Cancelacion casos -->
			<div id="divCaseCancelError" class="divError">
				<label class="labelDivError"><s:message code="entidadCaso_error_cancelacion"/></label>
			</div>
			<div id="divCaseCancelEstado" class="divError">
				<label class="labelDivError"><s:message code="entidadCaso_error_casocancelado"/></label>
			</div>
			<div id="divCaseCancel" class="divOk">
				<label class="labelDivOk"><s:message code="entidadCaso_ok_cancelacion"/></label>
			</div>
		</div>
		
		<form:form id="formEntidadCasoID" name="formEntidadCaso" action="actualizarCaso" modelAttribute="caso" method="POST">
			<form:hidden path="id"/>
			<form:hidden path="editMode" value="${editMode}"/>
			<form:hidden path="sfid" id="idSfid"/>
			<div>
				<p class="cabeceraTitulo"><s:message code="comentarioCase_label_caso" arguments="${caso.numeroCaso}"/></p>
			</div>
			<div class="botoneraListado">
				<ul>
					<li><input id="Modificar" type="button" name="Modificar" value=<s:message code="entidadCaso_boton_modificar"/>  onclick="modificarCasoButton();" /></li>
					<li><input id="CancelarCaso" type="button" name="CancelarCaso" value="<s:message code="entidadCaso_boton_cancelar_caso"/>"  onclick="cancelarCasoButton();" /></li>
					<li><input id="Guardar" type="button" name="Guardar" value="<s:message code="entidadCaso_boton_guardar"/>" hidden="true" onclick="guardarModificacion();"/></li>
					<li><input id="Cancelar" type="button" name="Cancelar" value="<s:message code="entidadCaso_boton_cancelar"/>" hidden="true"  onclick="cancelarButton();"/></li>
				</ul>
			</div>			
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowDetalleCaso" type="image" src="../resources/images/arrow-down-black.png" 
							height="15" onclick="showHideCabeceras('detalleCaso','arrowDetalleCaso'); return false;"/>				
						<label class="divLabel"><s:message code="entidadCaso_title_label_detalle_caso"/></label>
					</div>
				</div>
			</div>
			<div id="detalleCaso" class="divEntidad">
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
						<form:hidden path="estado" id="idEstado"/>
						<label>${caso.labelEstadoPickList}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_numcaso"/></label>
					</div>
					<div>
						<label>${caso.numeroCaso}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_subestado"/></label>
					</div>
					<div>
						<label>${caso.labelSubestadoPickList}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_numinservice"/></label>
					</div>
					<div>
						<form:hidden path="numeroInservice"/>
						<label>${caso.numeroInservice}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_canalorigen"/></label>
					</div>
					<div>
						<label>${caso.labelCanalOrigenPickList}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_fechahoraapertura"/></label>
					</div>
					<div>
						<label><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${caso.fechaApertura}"/></label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_unidad"/></label>
					</div>
					<div>
						<label>${caso.labelCallCenterPickList}</label>
					</div>					
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_tiempoNormalizacion"/></label>
					</div>
					<div>
						<label><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${caso.fechaEstimadaCierre}"/></label>
					</div> 
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_herokuUsername"/></label>
					</div>
					<div>
						<label>${caso.herokuUsername}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_propietarioCaso"/></label>
					</div>
					<div>
						<c:if test="${caso.userJoin.name!=null}">
							<label>${caso.userJoin.name}</label>					
						</c:if> 
						<c:if test="${caso.userJoin.name==null}">
							<label>${caso.groupJoin.name}</label>
						</c:if> 
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_casoPrincipal"/></label>
					</div>
					<div>
						<label><a class="link" href="javascript:cargandoGif('${caso.casoPrincipalJoin.sfid}','entidadCaso');">${caso.casoPrincipalJoin.numeroCaso}</a></label>					
					</div>
				</div>		
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_fechaHoraCierre"/></label>
					</div>
					<div>
						<label><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${caso.fechaCierre}"/></label>
					</div>
					<div class="divLabel">
						<label>&nbsp;</label>
					</div>
					<div>
						<label>&nbsp;</label>
					</div>
				</div>						
			</div>	
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowDatosEmergencia" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('datosEmergencia','arrowDatosEmergencia'); return false;"/>				
						<label class="divLabel"><s:message code="entidadCaso_title_label_datos_emergencia"/></label>
					</div>
				</div>
			</div>
			<div id="datosEmergencia" class="divEntidad">
				<div>	
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_tipoAtencionInterna"/></label>
					</div>
					<div>
						<label>${caso.labelTypeCasoPickList}</label>
					</div>	
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_description"/></label>
					</div>
					<div>
						<label id="fieldRead">${caso.description}</label>
						<label id="fieldEdit" style="display:none;"><form:input id="descrip" type="text" path="description" class="buttontext" value="${caso.description}"/></label>				
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_submotivo"/></label>
					</div>
					<div>
						<label>${caso.labelSubmotivoPickList}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_condagravante"/></label>
					</div>
					<div>
						<label>${caso.labelCondicionAgravantePickList}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_asunto"/></label>
					</div>
					<div>
						<label>${caso.asunto}</label>
					</div>
					<div>
					</div>
				</div>	
			</div>
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowIdentificacion" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('identificacion','arrowIdentificacion'); return false;"/>			
						<label class="divLabel"><s:message code="entidadCaso_title_label_identificacion"/></label>
					</div>
				</div>
			</div>	
			<div id="identificacion" class="divEntidad">	
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_nombreContacto"/></label>
					</div>
					<div>
						<label><a class="link" href="javascript:cargandoGif('${caso.contactoJoin.sfid}','entidadContacto');">${caso.contactoJoin.name}</a></label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_canalNotificacion"/></label>
					</div>
					<div>
						<label>${caso.labelCanalNotificacionPickList}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_suministro"/></label>
					</div>
					<div>
						<label><a class="link" href="javascript:cargandoGif('${caso.suministroJoin.sfid}','entidadSuministro');">${caso.suministroJoin.name}</a></label>						
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_telefonoContacto"/></label>
					</div>
					<div>
						<label>${caso.telefonoContacto}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_detalleDireccion"/></label>
					</div>
					<div>
						<label><a class="link" href="javascript:cargandoGif('${caso.direccionJoin.sfid}','entidadDireccion');">${caso.direccionJoin.name}</a></label>											
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_emailNotificacion"/></label>
					</div>
					<div>
						<label>${caso.emailNotificacion}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_nombreCuenta"/></label>
					</div>
					<div>
						<label><a class="link" href="javascript:cargandoGif('${caso.cuentaJoin.sfid}','entidadCuenta');">${caso.cuentaJoin.name}</a></label>																	
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_idFacebook"/></label>
					</div>
					<div>
						<label>${caso.facebook}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_direccionSuministro"/></label>
					</div>
					<div>
						<label>
							<c:choose>
								<c:when test="${not empty caso.direccionSuministro}">${caso.direccionSuministro}</c:when>
								<c:otherwise>${caso.direccionJoin.name}</c:otherwise>
							</c:choose>
						</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_twitter"/></label>
					</div>
					<div>
						<label>${caso.twitter}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_comuna"/></label>
					</div>
					<div>
						<label>
							<c:choose>
								<c:when test="${not empty caso.direccionJoin.calleJoin.municipality}">${caso.direccionJoin.calleJoin.labelMunicipalityPickList}</c:when>
								<c:otherwise>${caso.suministroJoin.comuna}</c:otherwise>
							</c:choose>
						</label>					
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_actualizarDatosContacto"/></label>
					</div>
					<div>
						<c:if test="${caso.actDatosContacto == true}">
						    <label><input type="checkbox" id="checkbox" value="true" checked="checked" disabled/>
							</label> 					
						</c:if> 
						<c:if test="${caso.actDatosContacto == false}">
							<label><input type="checkbox" id="checkbox" value="true" disabled/></label>	
						</c:if> 
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_numeroMedidor"/></label>
					</div>
					<div>
						<label>
							<c:choose>
								<c:when test="${not empty caso.numeroMedidor}">${caso.numeroMedidor}</c:when>
								<c:otherwise>${caso.suministroJoin.numeroMedidor}</c:otherwise>
							</c:choose>
						</label>					
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_ani"/></label>
					</div>
					<div>
						<label>${caso.ani}</label>
					</div>
				</div>
			</div>
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowCuerpoMail" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('cuerpoMail','arrowCuerpoMail'); return false;"/>
						<label class="divLabel"><s:message code="entidadCaso_title_label_cuerpoMail"/></label>
					</div>
				</div>
			</div>
			<div id="cuerpoMail" class="divEntidad">
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_cuerpoMail"/></label>
					</div>
					<div>
						<label>${caso.cuerpoMail}</label>
					</div>
					<div>
							
					</div>
				</div>
			</div>		
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowSolucion" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('solucion','arrowSolucion'); return false;"/>			
						<label class="divLabel"><s:message code="entidadCaso_title_label_solucion"/></label>
					</div>
				</div>
			</div>
			<div id="solucion" class="divEntidad">
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_title_label_respuestaCliente"/></label>
					</div>
					<div>
						<label>${caso.respuestaAlCliente}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_title_label_favoravilidadCaso"/></label>
					</div>
					<div>
						<label>${caso.labelFavorabilidadDelCasoPickList}</label>
					</div>
				</div>
			</div>
			
			<div id="divEntidadCasosHistory" class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowTablaCasosHistory" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('tablaCasosHistory','arrowTablaCasosHistory'); return false;"/>			
						<label class="divLabel"><s:message code="entidadCaso_title_label_historial_titulo" /></label>
					</div>
				</div>
				<div id="tablaCasosHistory">
					<table class="basicTable" id="tablaHistorial">
						<tr>
							<th width="15%"><s:message code="entidadCaso_column_label_historia_fecha" /></th>
						    <th width="15%"><s:message code="entidadCaso_column_label_historia_usuario" /></th>
						    <th width="70%"><s:message code="entidadCaso_column_label_historia_accion" /></th>
						</tr>
						<c:choose>
							<c:when test="${not empty caso.historialCaso}">
								<c:forEach items="${caso.historialCaso}" var="hist">
									<tr>
										<td width="15%"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${hist.createddate}"/></td>
										<td width="15%">${hist.userJoin.name}</td>
										<td width="70%"> ${hist.field}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6" class="tablaVacia">
										<s:message code="entidades_empty_case_table" />
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
					<c:if test="${caso.controlHistorialEntradas}">
						<a class="link" href="javaScript:{refrescarHistorial('All')}" id="hrefTodosHistorial">Mostrar todos</a>
						<a class="link" href="javaScript:{refrescarHistorial(10)}" id="hrefNoTodosHistorial" hidden="true">Mostrar 10</a>
					</c:if>
				</div>
			</div>
				
			<div id="divEntidadCasosComments" class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowTablaCasosComments" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('tablaCasosComments','arrowTablaCasosComments'); return false;"/>			
						<label class="divLabel"><s:message code="entidadCaso_title_label_comentarios_titulo" /></label>			
						<input id="NuevoComent" type="button" name="NuevoComent" style='margin-left:8%; 'value='<s:message code="entidadCaso_button_label_comentarios_nuevo"/>' onclick="newComent('${caso.sfid}');" />
					</div>
				</div>
				<div id="tablaCasosComments">
					<table class="basicTable">
						<tr>
						    <th><s:message code="entidadCaso_column_label_comentarios_publica" /></th>
						    <th><s:message code="entidadCaso_column_label_comentarios_comentario" /></th>
						</tr>
						<c:choose>
							<c:when test="${not empty caso.commentarioCaso}">
								<c:forEach items="${caso.commentarioCaso}" var="coment">
									<tr>
										<td>
											<c:if test="${coment.ispublished}">
											    <label><input type="checkbox" id="checkbox" value="true" checked="checked" disabled/>
												</label> 					
											</c:if> 
											<c:if test="${coment.ispublished == false}">
												<label><input type="checkbox" id="checkbox" value="true" disabled/></label>	
											</c:if>
										</td> 
										
										<td>
											<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${coment.createddate}" var="createDate"/>
											<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${coment.lastmodifieddate}" var="lastDate"/> 
										
											<b><s:message code="entidadCaso_texto_label_comentarios_comentario_creado" arguments="${coment.userJoinCreateComment.name}, ${createDate}"/>
											<c:if test="${lastDate != null}">
											 | <s:message code="entidadCaso_texto_label_comentarios_comentario_modificado" arguments="${coment.userJoinModifyComment.name}, ${lastDate}"/>
											</c:if>
										</b> 
										<br>${coment.comment}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6" class="tablaVacia">
										<s:message code="entidades_empty_case_table" />
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
			</div>				
		</form:form>
				
				
		<!-- Dialog combo Cancelar Caso -->
		<div id="dialogCancelarCaso" title="<s:message code="entidadCaso_dialog_labe" arguments="${caso.numeroCaso}"/>" class="dialogLupa">			
			<form:form name="formCancelarCaso" id="formCancelarCasoId" action="cancelarCaso" modelAttribute="caso" method="POST">
				<form:hidden path="sfid"/>
				<div style="padding-top:4%;">
					<form:select id="subEstadoCancelacion" path="subestado" items="${caso.mapSubStatusCancelacion}"/>
				</div>
				<br>
				<div>
					<input id="Aceptar" type="button" name="Aceptar" value=<s:message code="entidadCaso_cancelarCaso_boton_aceptar"/> onclick="guardarCancelarCaso();"/>
					<input id="Cancelar" type="button" name="Cancelar" value="<s:message code="entidadCaso_cancelarCaso_boton_cancelar"/>" onclick="cerrarDialogCancelarCaso();" />
				</div>		
			</form:form>
		</div>
  	</body>
</html>