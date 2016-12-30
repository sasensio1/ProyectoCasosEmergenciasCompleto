<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<body onload="initHeader();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="entidadSuministro_title_label_detalle_suministro"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<form:form name="formEntidadSuministro" action="actualizarSuministro" modelAttribute="suministro" method="POST">
			<div class="botoneraListado">
				<ul>
					<li><input type="submit" name="goCrearCasoBySuministro" value="<s:message code="homeCasos_button_nuevocaso"/>" /></li>
				</ul>
			</div>
			<form:hidden path="sfid"/>
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
							<label>${suministro.direccionConcatenada}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_direccionSuministro"/></label>
						</div>
						<div>
							<label>${suministro.direccionCliente}</label>
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
										<td><a class="link" href="../private/entidadContacto?sfid=${contacto.sfid}">${contacto.name}</a></td>
										<td>${contacto.relacionActivo}</td>
										<c:if test="${contacto.principal}">
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
							<input id="arrowCuentaRelacionada" type="image" src="../resources/images/arrow-down-black.png"  
								height="15" onclick="showHideCabeceras('cuentaRelacionada','arrowCuentaRelacionada'); return false;"/>
							<label class="divLabel"><s:message code="entidadSuministro_title_label_cuenta_relacionada"/></label>								
						</div>
					</div>			
				</div>
				<div id="cuentaRelacionada" class="divEntidad">
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_cuenta"/></label>
						</div>
						<div>
							<label><a class="link" href="../private/entidadCuenta?sfid=${suministro.cuentaJoin.sfid}">${suministro.cuentaJoin.name}</a></label>
						</div>		
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_runRut"/></label>
						</div>
						<div>
							<label>${suministro.runRut}</label>
						</div>
					</div>
					<div>
						<div class="divLabel">
							<label><s:message code="entidadSuministro_title_label_tipoCuenta"/></label>
						</div>
						<div>
							<label>${suministro.tipoCuenta}</label>
						</div>
					</div>	
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
							<label>${suministro.labelElectrodependientePicklist}</label>
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
							    <th><s:message code="entidadSuministro_title_label_caso_estado" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_fechaApertura" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_submotivo" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_tiempoEstimado" /></th>
							    <th><s:message code="entidadSuministro_title_label_caso_canalOrigen" /></th>
							</tr>
							<c:choose>
								<c:when test="${not empty suministro.casos}">
									<c:forEach items="${suministro.casos}" var="caso">
										<tr>
											<td><a class="link" href="../private/entidadCaso?editMode=VIEW&sfid=${caso.sfid}">${caso.numeroCaso}</a></td>
											<td>${caso.descripcionEstado}</td>
											<td>${caso.fechaApertura}</td>
											<td>${caso.labelSubmotivoPickList}</td>
											<td>${caso.tiempoEstimacion}</td>
											<td>${caso.labelCanalOrigenPickList}</td>
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
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_falla_sector"/></td>
										<c:choose>
											<c:when test="${not empty suministro.suministroAfectado && not empty suministro.tipoEvento 
													&& suministro.suministroAfectado && suministro.tipoEvento == '2'}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor">SI</td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2">NO</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_corte_programado"/></td>
										<c:choose>
											<c:when test="${not empty suministro.suministroAfectado && not empty suministro.tipoEvento 
													&& suministro.suministroAfectado && suministro.tipoEvento == '1'}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor">SI</td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2">NO</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_corte_deuda"/></td>
										<c:choose>
											<c:when test="${not empty suministro.cortePorDeuda && suministro.cortePorDeuda}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor">SI</td>	
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2">NO</td>
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
												<td class="filaValor">SI</td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2">NO</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_electrodependiente"/></td>
										<c:choose>
											<c:when test="${not empty suministro.electrodependiente && suministro.electrodependiente == '1'}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor">SI</td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2">NO</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_casos_abiertos"/></td>
										<c:choose>
											<c:when test="${not empty suministro.casosAbiertos && suministro.casosAbiertos}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor">SI</td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2">NO</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr>
										<td class="filaLiteral"><s:message code="entidadSuministro_indicadores_literal_casos_reiterados"/></td>
										<c:choose>
											<c:when test="${not empty suministro.casosReiterados && suministro.casosReiterados == '1'}">
												<td class="filaImagen"><img src="../resources/images/inservice_red_point.png" height="12px" width="12px"></td>
												<td class="filaValor">SI</td>
											</c:when>
											<c:otherwise>
												<td class="filaValor" colspan="2">NO</td>
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
							<c:choose>
								<c:when test="${not empty suministro}">
									<tr>
										<td colspan="3" class="filaVacia">
											<s:message code="entidadSuministro_indicadores_literal_sin_informacion" />
										</td>
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
			</div>
		</form:form>			
 	</body>
</html>