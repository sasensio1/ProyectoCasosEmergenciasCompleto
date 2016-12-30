<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 

<html>
	<head>
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/styles.css" rel="stylesheet" />	
	
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/header.js" lang=""></script>
		<script src="../resources/js/utils.js" lang=""></script>
		<script src="../resources/js/suministros.js" lang=""></script>
	</head>
	<body onload="initHeader();showNotifications();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="entidadSuministro_title_label_detalle_suministro"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<!-- Mensajes de inserccion caso por corte-->	
		<div>
			<div id="divCaseCorteCreatedError" class="divError">
<%-- 				<label class="labelDivError"><s:message code="notificaciones_label_error_insercion"/></label>
				<br/>
				<label class="labelDivError" id="idCodigo"><s:message code="notificaciones_label_error_codigo"/></label>
				<br/> --%>
				<label class="labelDivError" id="idMensaje"><s:message code="notificaciones_label_error_mensaje"/></label>
			</div>
		</div>
		<!-- Mensajes de estado de operación -->
		<c:if test="${not empty param.codigoError}">
			<div>
				<div class="divError" id="divInsertError">
<%-- 					<label class="labelDivError"><s:message code="notificaciones_label_error_insercion"/></label>
					<br/>
					<label class="labelDivError"><s:message code="notificaciones_label_error_codigo"/>&nbsp;${param.codigoError}</label>
					<br/> --%>
					<label class="labelDivError"><s:message code="notificaciones_label_error_mensaje"/>&nbsp;${param.mensajeResultado}</label>
				</div>
			</div>
		</c:if>
		<form:form name="formEntidadSuministroName" id="formEntidadSuministro" action="actualizarSuministro" modelAttribute="suministro" method="POST">	
				<div class="botoneraCentrado">
					<ul>
						<li><input type="button" name="goCrearCasoBySuministroName" value="<s:message code="entidadSuministro_table_label_botonCrearCaso"/>" onclick="goCrearCasoBySuministro();" /></li>
						<li><input type="button" name="corteDeudaName" value="<s:message code="entidadSuministro_table_label_botonCorteDeuda"/>" onclick="crearCasoCorteDeuda();"  /></li>
						<li><input type="button" name="corteProgramadoName" value="<s:message code="entidadSuministro_table_label_botonCorteProg"/>" onclick="crearCasoCorteProgramado();" /></li>
					</ul>
				</div>			
			<form:hidden path="sfid" id="sfidSum"/>
			<div class="divEntidadDatos">
				<div class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowDetalleSuministro" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('detalleSuministro','arrowDetalleSuministro'); return false;"/>
							<label class="divLabel"><s:message code="entidadSuministro_title_label_detalle_suministro"/></label>
						</div>
					</div>
				</div>
				<div id="detalleSuministro" class="divEntidad">
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_identificadorSuministro"/></label>
						</div>
						<div>
							<label>${suministro.name}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_detalleDireccion"/></label>
						</div>
						<div>
							<label><a class="link" href="javascript:cargandoGif('${suministro.dirSuministroJoin.sfid}','entidadDireccion');">${suministro.dirSuministroJoin.name}</a></label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_direccionSuministro"/></label>
						</div>
						<div>
							<label>${suministro.direccionConcatenada}</label>			
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_tipoSegmento"/></label>
						</div>
						<div>
							<label>${suministro.labelTipoSegmentoPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_comuna"/></label>
						</div>
						<div>
							<label>${suministro.comuna}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_medidaDisciplina"/></label>
						</div>
						<div>
							<label>${suministro.labelMedidaDisciplinaPickList}</label>
						</div>
					</div>
					<div>		
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_estadoSuministro"/></label>
						</div>	
						<div>
							<label>${suministro.labelEstadoSuministroPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_numeroSuministro"/></label>
						</div>
						<div>
							<label>${suministro.numeroSuministro}</label>
						</div>
					</div>	
				</div>
				<div id="divEntidadSuministroCasos" class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowTablaSuministroContactos" type="image" src="../resources/images/arrow-down-black.png"  
							height="15" onclick="showHideCabeceras('tablaSuministroContactos','arrowTablaSuministroContactos'); return false;"/>			
						<label class="divLabel"><s:message code="entidadSuministro_title_label_contactos_relacionados" /></label>
					</div>
				</div>
				<div id="tablaSuministroContactos">
					<table class="basicTable">
						<tr>
							<th><s:message code="entidadSuministro_title_label_contactos_nombre_contacto" /></th>
						    <th><s:message code="entidadSuministro_title_label_contactos_tipo_relacion" /></th>
						    <th><s:message code="entidadSuministro_title_label_contactos_contacto_principal" /></th>
						    
						</tr>
						<c:choose>
							<c:when test="${not empty suministro.contactosRelacionados}">
								<c:forEach items="${suministro.contactosRelacionados}" var="contacto">
									<tr>
										<td><a class="link" href="javascript:cargandoGif('${contacto.sfid}','entidadContacto');">${contacto.name}</a></td>									
										<td>${contacto.relacionActivo}</td>
										<c:if test="${contacto.principal==true} ">
						    				<td><input type="checkbox" id="checkbox" value="true" checked="checked" disabled/></td>					
										</c:if> 
										<c:if test="${contacto.principal == false}">
											<td><input type="checkbox" id="checkbox" value="true" disabled/></td>	
										</c:if> 
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
							<input id="arrowTablaSuministroCuentas" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('tablaSuministroCuentas','arrowTablaSuministroCuentas'); return false;"/>
							<label class="divLabel"><s:message code="entidadSuministro_title_label_cuentas_relacionadas"/></label>								
						</div>
					</div>			
				</div>							
				<div id="tablaSuministroCuentas">
					<table class="basicTable">
						<tr>
							<th><s:message code="entidadSuministro_title_label_cuenta" /></th>
						    <th><s:message code="entidadSuministro_title_label_numeroIdentidad"/></th>
						    <th><s:message code="entidadSuministro_title_label_tipoCuenta" /></th>
						    
						</tr>
						<c:choose>
							<c:when test="${not empty suministro.cuentasRelacionadas}">
								<c:forEach items="${suministro.cuentasRelacionadas}" var="cuenta">
									<tr>
										<td><a class="link" href="javascript:cargandoGif('${cuenta.sfid}','entidadCuenta');">${cuenta.name}</a></td>									
										<td>${cuenta.run}</td>
										<td>${cuenta.labelTipoIdentidadPickList}</td>												
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
				<div class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowDatosSuministro" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('datosSuministro','arrowDatosSuministro'); return false;"/>
							<label class="divLabel"><s:message code="entidadSuministro_title_label_datos_suministro"/></label>
						</div>
					</div>
				</div>	
				<div id="datosSuministro" class="divEntidad">	
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_idEmpresa"/></label>
						</div>
						<div>
							<label>${suministro.labelEmpresaPickList}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_tarifa"/></label>
						</div>
						<div>
							<label>${suministro.tarifa}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_electrodependiente"/></label>
						</div>
						<div>
							<label>${suministro.labelElectrodependientePickList}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_fullElectric"/></label>
						</div>
						<div>
							<label>${suministro.labelFullElectricPickList}</label>
						</div>
					</div>			
				</div>
				<div class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowDatosComerciales" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('datosComerciales','arrowDatosComerciales'); return false;"/>
							<label class="divLabel"><s:message code="entidadSuministro_title_label_datos_comerciales"/></label>
						</div>
					</div>
				</div>
				<div id="datosComerciales" class="divEntidad">
					<div>	
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_nombreBoleta"/></label>
						</div>
						<div>
							<label>${suministro.nombreDuenoBoleta}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_direccionReparto"/></label>
						</div>
						<div>
							<label>${suministro.direccionBoleta}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_ruta"/></label>
						</div>
						<div>
							<label>${suministro.ruta}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_comunaReparto"/></label>
						</div>
						<div>
							<label>${suministro.labelComunaRepartoPickList}</label>
						</div>
					</div>
				</div>		
				<div class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>	
							<input id="arrowDatosTecnicos" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('datosTecnicos','arrowDatosTecnicos'); return false;"/>			
							<label class="divLabel"><s:message code="entidadSuministro_title_label_datos_tecnicos"/></label>
						</div>
					</div>
				</div>
				<div id="datosTecnicos" class="divEntidad">
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_propiedadMedidor"/></label>
						</div>
						<div>
							<label>${suministro.labelPropMedidorPickList}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_subestacionElectricaConexion"/></label>
						</div>
						<div>
							<label>${suministro.labelSubestacionElecPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_modeloMedidor"/></label>
						</div>
						<div>
							<label>${suministro.modeloMedidor}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_numeroAlimentador"/></label>
						</div>
						<div>
							<label>${suministro.alimentador}</label>
					    </div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_marcaMedidor"/></label>
						</div>
						<div>
							<label>${suministro.marcaMedidor}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_numeroTransformador"/></label>
						</div>
						<div>
							<label>${suministro.numeroTransformador}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_numeroMedidor"/></label>
						</div>
						<div>
							<label>${suministro.numeroMedidor}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_tipoConexion"/></label>
						</div>
						<div>
							<label>${suministro.labelTipoConexionPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_procesoLectura"/></label>
						</div>
						<div>
							<label>${suministro.labelProcesoLecturaPickList}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_tipoMedida"/></label>
						</div>
						<div>
							<label>${suministro.labelTipoMedidaPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_medidaDisciplina"/></label>
						</div>
						<div>
							<label>${suministro.labelMedidaDisciplinaPickList}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_tipoLectura"/></label>
						</div>
						<div>
							<label>${suministro.labelTipoLecturaPickList}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_tipoTransformador"/></label>
						</div>
						<div>
							<label>${suministro.labelTipoTransformadorPickList}</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_bloque"/></label>
						</div>
						<div>
							<label>${suministro.bloque}</label>
					    </div>
					</div>
					<div>
						<div class="divLabel">
							<label>&nbsp;</label>
						</div>
						<div>
							<label>&nbsp;</label>
						</div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_horarioRacionamientio"/></label>
						</div>
						<div>
							<label>${suministro.horarioRacionamiento}</label>
						</div>
					</div>
				</div>
				<div id="divEntidadSuministroCasos" class="divEntidad">
					<div class="subtitleAltaEntidad">
						<div>
							<input id="arrowTablaSuministroCasos" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('tablaSuministroCasos','arrowTablaSuministroCasos'); return false;"/>			
							<label class="divLabel"><s:message code="cabeceraPage_list_case" /></label>
						</div>
					</div>
					<div id="tablaSuministroCasos">
						<table class="basicTable">
							<tr>
								<th><s:message code="entidadSuministro_title_label_caso_caso" /></th>
								<th><s:message code="entidadSuministro_title_label_caso_i" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_estado" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_fechaApertura" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_submotivo" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_tiempoEstimado" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_canalOrigen" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_nombreProp" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_fechaCierre" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_asunto" /></th>
							</tr>
							<c:choose>
								<c:when test="${not empty suministro.casos}">
									<c:forEach items="${suministro.casos}" var="caso">
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
											<td>
												<c:if test="${caso.userJoin!=null &&caso.userJoin.name!=null}">
													<label>${caso.userJoin.name}</label>					
												</c:if> 
												<c:if test="${caso.userJoin!=null && caso.userJoin.name==null}">
													<label>${caso.groupJoin.name}</label>
												</c:if> 
												<c:if test="${caso.userJoin==null}">
													<label>&nbsp;</label>					
												</c:if> 
											</td>	
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
				<div id="divEntidadIndicadoresSuministro" class="divIndicadoresEventos">
					<div class="divSuministrosIndicadoresTitulo">
						<div>
							<input id="arrowTablaIndicadoresSuministro" type="image" src="../resources/images/arrow-down-white.png"  
								height="15" onclick="showHideCabecerasServicios('tablaIndicadoresSuministro','arrowTablaIndicadoresSuministro'); return false;"/>			
							<label class="divLabel"><s:message code="entidadSuministro_indicadores_titulo_indicadores" /></label>
						</div>
					</div>
					<div id="tablaIndicadoresSuministro">
						<table class="servicesTable">
							<c:choose>
								<c:when test="${not empty suministro}">
									<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_title_label_estadoSuministro"/></td>
										<c:choose>
											<c:when test="${not empty suministro.labelEstadoSuministroPickList}">
												<td class="filaValor" colspan="2">${suministro.labelEstadoSuministroPickList}</td>
											</c:when>
										</c:choose>
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
									<%-- <tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_falla_sector"/></td>
										<c:choose>
											<c:when test="${not empty suministro.suministroAfectado && not empty suministro.tipoEvento 
													&& suministro.suministroAfectado && suministro.tipoEvento == '2'}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
											</c:otherwise>
										</c:choose>
									</tr> 
									<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_corte_programado"/></td>
										<c:choose>
											<c:when test="${not empty suministro.suministroAfectado && not empty suministro.tipoEvento 
													&& suministro.suministroAfectado && suministro.tipoEvento == '1'}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
											</c:otherwise>
										</c:choose>
									</tr> --%>
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
											<c:when test="${not empty suministro.casosReiterados && suministro.casosReiterados > 0}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3" class="filaVacia">
											<s:message code="entidadSuministro_indicadores_literal_sin_informacion" />
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>
				<div id="divEntidadEventosSuministro" class="divIndicadoresEventos">
					<div class="divSuministrosIndicadoresTitulo">
						<div>
							<input id="arrowTablaEventosSuministro" type="image" src="../resources/images/arrow-down-white.png"  
								height="15" onclick="showHideCabecerasServicios('tablaEventosSuministro','arrowTablaEventosSuministro'); return false;"/>			
							<label class="divLabel"><s:message code="entidadSuministro_indicadores_titulo_eventos" /></label>
						</div>
					</div>
					<div id="tablaEventosSuministro">
						<table class="servicesTable">
							<c:set var="contEventos" value="0" scope="page"/>
							<c:choose>
								<c:when test="${not empty suministro && not empty suministro.listadoEventos && not empty suministro.listadoEventos.evento}">
									<c:forEach items="${suministro.listadoEventos.evento}" var="eventoSum">
										<c:set var="count" value="${count + 1}" scope="page"/>
										<c:if test="${count > 1}">
											<tr>
											<td class="filaLiteral">&nbsp;</td>
											<td class="filaValor">&nbsp;</td>
										</tr>
										</c:if>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_tipo"/></td>
											<td class="filaValor">${eventoSum.tipo}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_numero"/></td>
											<td class="filaValor">${eventoSum.nevento}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_vecino"/></td>
											<c:choose>
												<c:when test="${eventoSum.vecino}">
													<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_si"/></td>
												</c:when>
												<c:otherwise>
													<td class="filaValor"><s:message code="entidadSuministro_indicadores_literal_no"/></td>
												</c:otherwise>
											</c:choose>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_numero_incidencia"/></td>
											<td class="filaValor">${eventoSum.nincidencia}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_numero_descargo"/></td>
											<td class="filaValor">${eventoSum.ndescargo}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_fecha_inicio"/></td>
											<td class="filaValor"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${eventoSum.fechaInicio.toGregorianCalendar().time}"/></td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_fecha_inicio_programada"/></td>
											<td class="filaValor"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${eventoSum.fechaInicioProgramada.toGregorianCalendar().time}"/></td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_fecha_termino_programada"/></td>
											<td class="filaValor"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${eventoSum.fechaTerminoProgramada.toGregorianCalendar().time}"/></td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_descripcion"/></td>
											<td class="filaValor">${eventoSum.descripcionTipoEvento}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_comuna"/></td>
											<td class="filaValor">${eventoSum.comuna}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_titulo_descargo"/></td>
											<td class="filaValor">${eventoSum.tituloDescargo}</td>
										</tr>
										<tr>
											<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_evento_tipo_incidencia"/></td>
											<td class="filaValor">${eventoSum.tipoIncidencia}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="2" class="filaVacia">
											<s:message code="entidadSuministro_indicadores_literal_sin_informacion" />
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>
			</div>
		</form:form>			
 	</body>
</html>
