<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 

<html>
	<head>
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/styles.css" rel="stylesheet" />	
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/jquery-ui.css" rel="stylesheet" />
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />
	
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
  		<script src="../resources/js/jquery-ui.js"></script>
		<script src="../resources/js/jQueryDatatables.js"></script>
		<script src="../resources/js/header.js" lang=""></script>
		<script src="../resources/js/utils.js" lang=""></script>
		<script src="../resources/js/contactos.js" lang=""></script>
	</head>
	<body onload="funcionOnload();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="entidadContacto_title_label_detalle_contacto"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<!-- Mensajes de estado de operación -->
		<c:if test="${not empty param.codigoError}">
			<div>
				<div class="divError" id="divInsertError">
					<label class="labelDivError"><s:message code="notificaciones_label_error_insercion"/></label>
<%-- 					<br/>
					<label class="labelDivError"><s:message code="notificaciones_label_error_codigo"/>&nbsp;${param.codigoError}</label>
					<br/>
					<label class="labelDivError"><s:message code="notificaciones_label_error_mensaje"/>&nbsp;${param.mensajeResultado}</label> --%>
				</div>
			</div>
		</c:if>
		<div id="divAssociationSumError" class="divError">
			<label class="labelDivError"><s:message code="notificaciones_label_error_suministro_association"/></label>
		</div>
		<div id="divAssociationAssetError" class="divError">
			<label class="labelDivError"><s:message code="notificaciones_label_error_asset_search"/></label>
		</div>
		<div id="divAssociationOk" class="divOk">
			<label class="labelDivOk"><s:message code="notificaciones_label_ok_suministro_association"/></label>
		</div>
		<div>
		<form:form name="formEntidadContacto" action="actualizarContacto" modelAttribute="contacto" method="POST">
			<div class="botoneraListado">
				<ul>
					<li><input type="button" name="goCrearCasoByContactoName" value="<s:message code="entidadContacto_table_label_botonCrearCaso"/>" onclick="goCrearCasoByContacto();" /></li>
					<li><input type="button" name="asociarSumministro" value="Asociar Suministro" onclick="abrirAsociarSuministro();" /></li>
				</ul>
			</div>
			<form:hidden path="sfid"/>
			<input type="hidden" value="${editMode}" id="editModeId"/>
			<input type="hidden" value="${sfid}" id="contactSfidId"/>
			<div class="divEntidadDatos">
				<div id="divEntidadContactoSuministros" class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowTablaContactoSuministros" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('tablaContactoSuministros','arrowTablaContactoSuministros'); return false;"/>			
							<label class="divLabel"><s:message code="entidadCuenta_title_label_supply_data_detail" /></label>
						</div>
					</div>
					<div id="tablaContactoSuministros">
						<table class="basicTable">
							<tr>
							    <th><s:message code="entidadContacto_title_label_suministro_empresa" /></th>
							    <th><s:message code="entidadContacto_title_label_suministro_suministro" /></th>
							    <th><s:message code="entidadContacto_title_label_suministro_direccion" /></th>
							    <th><s:message code="entidadContacto_title_label_suministro_comuna" /></th>
							    <th><s:message code="entidadContacto_title_label_suministro_connection_status" /></th>
							    <th><s:message code="entidadContacto_title_label_suministro_supply_status" /></th>
							    <th><s:message code="entidadContacto_title_label_suministro_segmento" /></th>
							    <th><s:message code="entidadContacto_title_label_suministro_relacion" /></th>
							</tr>
							<c:choose>
								<c:when test="${not empty contacto.suministros}">
									<c:forEach items="${contacto.suministros}" var="suministro">
										<tr>
										    <td>${suministro.labelEmpresaPickList}</td>
											<td><a class="link" href="javascript:cargandoGif('${suministro.sfid}','entidadSuministro');">${suministro.name}</a></td>
											<td>${suministro.direccionConcatenada}</td>
											<td>${suministro.comuna}</td>
											<td>${suministro.labelEstadoConexionPickList}</td>
											<td>${suministro.labelEstadoSuministroPickList}</td>
											<td>${suministro.labelTipoSegmentoPickList}</td>
											<td>${suministro.relacionActivo}</td>
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
				<div class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowInformacionPersonal" type="image" src="../resources/images/arrow-down-black.png"  height="15" onclick="showHideCabeceras('informacionPersonal','arrowInformacionPersonal'); return false;"/>										
							<label class="divLabel"><s:message code="entidadContacto_title_label_informacion_personal"/></label>
						</div>
					</div>
				</div>
				<div id="informacionPersonal" class="divEntidad">
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_nombre"/></label>
						</div>
						<div>
							<label>${contacto.name}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_apellidoPaterno"/></label>
						</div>
						<div>
							<label>${contacto.apellidoPaterno}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_apellidoMaterno"/></label>
						</div>
						<div>
							<label>${contacto.apellidoMaterno}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_tipoIdentidad"/></label>
						</div>
						<div>
							<label>${contacto.labelTipoIdentidadPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_run"/></label>
						</div>
						<div>
							<label>${contacto.run}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_canalPreferenteContacto"/></label>
						</div>
						<div>
							<label>${contacto.labelCanalPreferenteContactoPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_telefonoPrincipal"/></label>
						</div>
						<div>
							<label>${contacto.phone}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_telefonoSecundario"/></label>
						</div>
						<div>
							<label>${contacto.telefonoSecundario}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_emailPrincipal"/></label>
						</div>
						<div>
							<label>${contacto.email}</label>
						</div>
						<div>
							
						</div>
					</div>
				</div>	
				<div class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowInformacionSecundaria" type="image" src="../resources/images/arrow-down-black.png"  height="15" onclick="showHideCabeceras('informacionSecundaria','arrowInformacionSecundaria'); return false;"/>							
							<label class="divLabel"><s:message code="entidadContacto_title_label_informacion_secundaria"/></label>
						</div>
					</div>
				</div>
				<div id="informacionSecundaria" class="divEntidad">
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_fechaNacimiento"/></label>
						</div>
						<div>				
							<label><fmt:formatDate pattern="dd/MM/yyyy" value="${contacto.fechaNacimiento}"/></label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_nombreCuenta"/></label>
						</div>
						<div>
							<label><a class="link" href="javascript:cargandoGif('${contacto.cuentaJoin.sfid}','entidadCuenta');">${contacto.cuentaJoin.name}</a></label>
						</div>  
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_direccionContacto"/></label>
						</div>
						<div>
							<label><a class="link" href="javascript:cargandoGif('${contacto.dirContactoJoin.sfid}','entidadDireccion');">${contacto.dirContactoJoin.name}</a></label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_emailSecundario"/></label>
						</div>
						<div>
							<label>${contacto.emailSecundario}</label>
						</div>
					</div>				
				</div>
				<div class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowDatosRSS" type="image" src="../resources/images/arrow-down-black.png"  height="15" onclick="showHideCabeceras('datosRSS','arrowDatosRSS'); return false;"/>					
							<label class="divLabel"><s:message code="entidadContacto_title_label_datos_rrss"/></label>
						</div>
					</div>
				</div>
				<div id="datosRSS" class="divEntidad">
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_nombreUsuarioTwitter"/></label>
						</div>
						<div>
							<label>${contacto.sf4twitterTwitterUsername}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_recuentoSeguidoresTwitter"/></label>
						</div>
						<div>
							<label>${contacto.seguidoresTwitter}</label>
						</div>  
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_influencer"/></label>
						</div>
						<div>
							<label>${contacto.influencer}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_influencerType"/></label>
						</div>
						<div>
							<label>${contacto.influencerType}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_biografiaTwitter"/></label>
						</div>
						<div>
							<label>${contacto.twitterBio}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_idUsuarioTwitter"/></label>
						</div>
						<div>
							<label>${contacto.sf4twitterTwitterUserId}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_nombreUsuarioFacebook"/></label>
						</div>
						<div>
							<label>${contacto.sf4twitterFcbkUsername}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadContacto_table_label_idUsuarioFacebook"/></label>
						</div>
						<div>
							<label>${contacto.sf4twitterFcbkUserId}</label>
						</div>
					</div>				
				</div>
				<div id="divEntidadContactoCasos" class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowTablaContactoCasos" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('tablaContactoCasos','arrowTablaContactoCasos'); return false;"/>			
							<label class="divLabel"><s:message code="entidadContacto_title_label_caso_titulo" /></label>
						</div>
					</div>
					<div id="tablaContactoCasos">
						<table class="basicTable">
							<tr>
								<th><s:message code="entidadContacto_title_label_caso_caso" /></th>
								<th><s:message code="entidadContacto_title_label_caso_i" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_estado" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_fechaApertura" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_submotivo" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_tiempoEstimado" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_canalOrigen" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_nombreProp" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_fechaCierre" /></th>
							    <th><s:message code="entidadContacto_title_label_caso_asunto" /></th>
							</tr>
							<c:choose>
								<c:when test="${not empty contacto.casos}">
									<c:forEach items="${contacto.casos}" var="caso">
										<tr>
											<td><a class="link" href="javascript:cargandoGif('${caso.sfid}','entidadCaso');">${caso.numeroCaso}</a></td>
											<td class="filaImagen">
											<c:if test="${caso.labelEstadoPickList!=null && caso.labelEstadoPickList!='Cerrado' && caso.labelEstadoPickList!='Cancelado'}">					
											<img src="../resources/images/inservice_red_point.png" height="12px" width="12px">
											</c:if>	
											</td>
											<td>${caso.labelEstadoPickList}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${caso.fechaApertura}"/></td>
											<td>${caso.labelSubmotivoPickList}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${caso.fechaEstimadaCierre}"/></td>
											<td>${caso.labelCanalOrigenPickList}</td>
											<td>${caso.userJoin.name}</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${caso.fechaCierre}"/></td>
											<td>${caso.asunto}</td>
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
			</div>
			<div class="divEntidadIndicadores">
				<div id="divEntidadIndicadoresContacto" class="divIndicadoresEventos">
					<div class="divContactosIndicadoresTitulo">
						<div>
							<input id="arrowTablaIndicadoresContacto" type="image" src="../resources/images/arrow-down-white.png"  
								height="15" onclick="showHideCabecerasServicios('tablaIndicadoresContacto','arrowTablaIndicadoresContacto'); return false;"/>			
							<label class="divLabel"><s:message code="entidadContacto_indicadores_titulo_indicadores" /></label>
						</div>
					</div>
					<div id="tablaIndicadoresContacto">
						<table class="servicesTable">
							<tr>
								<td class="filaLiteral"><s:message code="entidadContacto_indicadores_literal_tipo_contacto"/></td>
								<td class="filaValor" colspan="2">${contacto.labelTipoContactoPickList}</td>
							</tr>
							<tr>
								<td class="filaLiteral"><s:message code="entidadContacto_indicadores_literal_run"/></td>
								<td class="filaValor" colspan="2">${contacto.run}</td>
							</tr>
							<tr>
								<td class="filaLiteral"><s:message code="entidadContacto_indicadores_literal_canal_preferente_contacto"/></td>
								<td class="filaValor" colspan="2">${contacto.labelCanalPreferenteContactoPickList}</td>
							</tr>
							<tr>
								<td class="filaLiteral"><s:message code="entidadContacto_indicadores_literal_casos_reiterados"/></td>
								<c:choose>
									<c:when test="${not empty contacto.casosReiterados && contacto.casosReiterados}">
										<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
										<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
									</c:when>
									<c:otherwise>
										<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<td class="filaLiteral"><s:message code="entidadContacto_indicadores_literal_tipo_cuenta_asociada"/></td>
								<td class="filaValor" colspan="2">${contacto.tipoCuentaAsociado}</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="divEntidadEventosSuministro" class="divIndicadoresEventos">
					<div class="divContactosIndicadoresTitulo">
						<div>
							<input id="arrowTablaEventosSuministro" type="image" src="../resources/images/arrow-down-white.png"  
								height="15" onclick="showHideCabecerasServicios('tablaEventosSuministro','arrowTablaEventosSuministro'); return false;"/>			
							<label class="divLabel"><s:message code="entidadContacto_indicadores_titulo_suministro_asociado" /></label>
						</div>
					</div>
					<div id="tablaEventosSuministro">
						<table class="servicesTable">
							<c:choose>
								<c:when test="${empty contacto.suministros}">
									<tr>
										<td colspan="3" class="filaVacia">
											<s:message code="entidadContacto_indicadores_literal_sin_suministros_asociados" />
										</td>
									</tr>
								</c:when>
								<c:when test="${fn:length(contacto.suministros) == 1}">
									<c:forEach items="${contacto.suministros}" var="suministro">
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_estado_suministro"/></td>
											<td class="filaValor" colspan="2">${suministro.labelEstadoSuministroPickList}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_estado_conexion"/></td>
											<c:choose>
												<c:when test="${not empty suministro.estadoConexion && suministro.estadoConexion == '0'}">
													<td class="filaValor" colspan="2"><img src="../resources/images/inservice_green_point.png" height="12px" width="12px">&nbsp;<s:message code="entidadSuministro_indicadores_literal_con_suministro"/></td>
												</c:when>
												<c:otherwise>
													<td class="filaValor" colspan="2"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px">&nbsp;<s:message code="entidadSuministro_indicadores_literal_sin_suministro"/></td>
												</c:otherwise>
											</c:choose>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_corte_deuda"/></td>
											<c:choose>
												<c:when test="${not empty suministro.cortePorDeuda}">
													<c:choose>
														<c:when test="${suministro.cortePorDeuda}">
															<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
															<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>	
														</c:when>
														<c:otherwise>
															<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
														</c:otherwise>
													</c:choose>
												</c:when>
												<c:otherwise>
													<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_sin_informacion"/></td>
												</c:otherwise>
											</c:choose>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_fecha_corte_comercial"/></td>
											<c:choose>
												<c:when test="${not empty suministro.fechaCorte && suministro.fechaCorte != ''}">
													<td class="filaValor" colspan="2"><fmt:formatDate pattern="dd/MM/yyyy" value="${suministro.fechaCorte}"/></td>
												</c:when>
												<c:otherwise>
													<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_sin_informacion"/></td>
												</c:otherwise>
											</c:choose>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_pago_proceso"/></td>
											<c:choose>
												<c:when test="${not empty suministro.pagoEnProceso && suministro.pagoEnProceso}">
													<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
													<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
												</c:when>
												<c:otherwise>
													<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
												</c:otherwise>
											</c:choose>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_electrodependiente"/></td>
											<c:choose>
												<c:when test="${not empty suministro.electrodependiente && suministro.electrodependiente == '1'}">
													<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
													<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
												</c:when>
												<c:otherwise>
													<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
												</c:otherwise>
											</c:choose>
										</tr>
										<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_casos_abiertos"/></td>
										<c:choose>
											<c:when test="${not empty suministro.casos}">
												<c:set var="openCases" value="false"/>
													<c:forEach items="${suministro.casos}" var="caso">
														<c:if test="${caso.labelEstadoPickList ne 'Cerrado' && caso.labelEstadoPickList ne 'Cancelado'}" >
															<c:set var="openCases" value="true"/>
														</c:if>
													</c:forEach>
													<c:if test="${openCases eq true}">
														<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
														<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>												
												    </c:if>	
												    <c:if test="${openCases eq false}">											    
												    	<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
												    </c:if>												    												
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
											</c:otherwise>
										</c:choose>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_casos_reiterados"/></td>
											<c:choose>
												<c:when test="${not empty suministro.casosReiterados && suministro.casosReiterados == '1'}">
													<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
													<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
												</c:when>
												<c:otherwise>
													<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3" class="filaVacia">
											<s:message code="entidadContacto_indicadores_literal_varios_suministros_asociados" />
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>
			</div>
		</form:form> 
		<jsp:include page="asociarSuministroDialog.jsp"/>
		</div>		
	</body>
</html>