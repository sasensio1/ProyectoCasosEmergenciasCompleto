<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
			
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />	
		<link href="../resources/css/styles.css" rel="stylesheet" />	
	
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/header.js" lang=""></script>
        <script src="../resources/js/utils.js" lang=""></script> 
	</head>
	<body onload="initHeader(); checkUpdates();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="entidadCaso_title_label_detalle_caso"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<form:form name="formEntidadCaso" action="actualizarCaso" modelAttribute="caso" method="POST">
			<form:hidden path="id"/>
			<form:hidden path="editMode" value="${editMode}"/>
			<form:hidden path="sfid"/>
			<div class="botoneraListado">
				<ul>
					<li><input id="Modificar" type="button" name="Modificar" value="Modificar"  onclick="modificarButton();" /></li>
					<li><input id="Guardar" type="submit" name="Cancelar" value="Guardar" hidden="true"/></li>
					<li><input id="Cancelar" type="button" name="Cancelar" value="Cancelar" hidden="true"  onclick="cancelarButton();"/></li>
				</ul>
			</div>			
			<!-- INICIO---Mensajes de actualización de caso -->	
					
			<div id="divError" class="divError">
				<label><s:message code="entidadCasoAlta_error_datonovalidos"/></label>
				<br>
				<label><s:message code="entidadCasoAlta_error_revisemensajes"/></label>
				<br>
				<label id="errorMessage"></label>
			</div>
			<div id="divOk" class="divOk" >
				<label>Los datos se han modificado correctamente</label>
			</div>
			
			<!-- FIN---Mensajes de actualización de caso -->
				
			<!-- INICIO---Mensajes de creación de un comentario de caso -->	
			
			<div id="divCaseCommentNOCreated" class="divError">
				<label><s:message code="entidadCasoAlta_error_datonovalidos"/></label>
				<label id="errorMessage"></label>
			</div>
			<div id="divCaseCommentCreated" class="divOk">
				<label>El comentario se ha guardado correctamente</label>
			</div>
			
			<!-- FIN---Mensajes de creación de un comentario de caso -->	
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
						<label>${caso.fechaApertura}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_tiempoNormalizacion"/></label>
					</div>
					<div>
						<label>${caso.fechaEstimadaCierre}</label>
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
						<label><s:message code="entidadCaso_table_label_propietarioCaso"/></label>
					</div>
					<div>
						<label>${caso.userJoin.name}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_fechaHoraCierre"/></label>
					</div>
					<div>
						<label>${caso.fechaCierre}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_herokuUsername"/></label>
					</div>
					<div>
						<label>${caso.herokuUsername}</label>
					</div>
					<div>
							
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
						<label><s:message code="entidadCaso_table_label_description"/></label>
					</div>
					<div>
						<label id="fieldRead">${caso.description}</label>
						<label id="fieldEdit" style="display:none;"><form:input type="text" path="description" class="buttontext" value="${caso.description}"/></label>
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
						<label><a class="link" href="../private/entidadContacto?sfid=${caso.contactoJoin.sfid}">${caso.contactoJoin.name}</a></label>
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
						<label><a class="link" href="../private/entidadSuministro?sfid=${caso.suministroJoin.sfid}">${caso.suministroJoin.name}</a></label>
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
						<label><a class="link" href="../private/entidadDireccion?sfid=${caso.direccionJoin.sfid}">${caso.direccionJoin.name}</a></label>
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
						<label><a class="link" href="../private/entidadCuenta?sfid=${caso.cuentaJoin.sfid}">${caso.cuentaJoin.name}</a></label>
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
						<label>${caso.direccionSuministro}</label>
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
						<label>${caso.comuna}</label>					
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCaso_table_label_actualizarDatosContacto"/></label>
					</div>
					<div>
						<c:if test="${caso.actDatosContacto}">
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
						<label>${caso.numeroMedidor}</label>
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
						<label><s:message code="entidadCaso_title_label_cuerpoMail"/></label>
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
					<table class="basicTable">
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
										<td width="70%">
											<c:if test="${hist.labelFieldPickList != null}">
												${hist.labelFieldPickList}
											</c:if>
											<c:if test="${hist.labelFieldPickList == null}">
												<!-- Si fieldLabel es null mostramo el campo 'field' -->
												<c:if test="${hist.fieldLabel != null}">
													<s:message code="entidadCaso_texto_label_historia_accion_1" arguments="${hist.fieldLabel.label}"/>
												</c:if>
												<c:if test="${hist.fieldLabel == null}">
													<s:message code="entidadCaso_texto_label_historia_accion_1" arguments="${hist.field}"/>
												</c:if>
												<c:if test="${hist.labelOldValuePickList != ''}">
													<s:message code="entidadCaso_texto_label_historia_accion_2" arguments="${hist.labelOldValuePickList}"/>
												</c:if>
												<c:if test="${hist.labelNewValuePickList != ''}">
													<s:message code="entidadCaso_texto_label_historia_accion_3" arguments="${hist.labelNewValuePickList}"/>
												</c:if>
												.
											</c:if>								
										</td>
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
  	</body>
</html>