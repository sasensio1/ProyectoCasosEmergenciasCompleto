<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

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
		<script type="text/javascript">
			var objetoSeleccionado = '<s:message code="entidadCuenta_title_label_account_detail"/>';
		</script>
		<jsp:include page="cabeceraPage.jsp" />		
		<div id="divEntidadCuenta" class="divEntidad">
			<div class="subtitleAltaEntidad">
				<div>
					<input id="arrowEntidadCuenta" type="image" src="../resources/images/arrow-down-black.png"  	height="15" onclick="showHideCabeceras('tablaDatosPersona','arrowEntidadCuenta'); return false;"/>			
					<label class="divLabel"><s:message code="entidadCuenta_title_label_person_data_detail" /></label>
				</div>
			</div>
		</div>
			<div id="tablaDatosPersona" class="divEntidad">
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_account_name" /></label>
					</div>
					<div>
						<label>${cuenta.name}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_birthdate" /></label>
					</div>
					<div>
						<label>${cuenta.fechaNacimiento}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_first_name" /></label>
					</div>
					<div>
						<label>${cuenta.apellidoPaterno}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_run" /></label>
					</div>
					<div>
						<label>-</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_last_name" /></label>
					</div>
					<div>
						<label>${cuenta.apellidoMaterno}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_first_email" /></label>
					</div>
					<div>
						<label>${cuenta.emailPrincipal}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_first_phone" /></label>
					</div>
					<div>
						<label>${cuenta.phone}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_second_email" /></label>
					</div>
					<div>
						<label>${cuenta.emailSecundario}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_second_phone" /></label>
					</div>
					<div>
						<label>${cuenta.telefonoSecundario}</label>
					</div>
					<div class="divLabel">
					</div>
					<div></div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_identity_type" /></label>
					</div>
					<div>
						<label>${cuenta.labelTipoIdentidadPickList}</label>
					</div>
					<div class="divLabel">
					</div>
					<div></div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_address" /></label>
					</div>
					<div>
						<label>${cuenta.direccion}</label>
					</div>
					<div class="divLabel">
					</div>
					<div></div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_main_account" /></label>
					</div>
					<div>
						<label>${cuenta.accountsource}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadCuenta_title_label_company_id" /></label>
					</div>
					<div>
						<label>${cuenta.labelIdEmpresaPickList}</label>
					</div>
				</div>
			</div>
		<div id="divEntidadCuentaSuministros" class="divEntidad">
			<div class="subtitleAltaEntidad">
				<div>
					<input id="arrowTablaCuentaSuministros" type="image" src="../resources/images/arrow-down-black.png"  
						height="15" onclick="showHideCabeceras('tablaCuentaSuministros','arrowTablaCuentaSuministros'); return false;"/>			
					<label class="divLabel"><s:message code="entidadCuenta_title_label_supply_data_detail" /></label>
				</div>
			</div>
			<div id="tablaCuentaSuministros">
				<table class="basicTable">
					<tr>
						<th><s:message code="entidadCuenta_title_label_supply_number" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_company_id" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_connection_status" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_supply_status" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_electrodependent" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_powercut_date" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_supply_address" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_commune" /></th>
					</tr>
					<c:choose>
						<c:when test="${not empty cuenta.suministros}">
							<c:forEach items="${cuenta.suministros}" var="suministro">
								<tr>
									<td><a class="link" href="../private/entidadSuministro?sfid=${suministro.sfid}">${suministro.name}</a></td>
									<td>${suministro.labelEmpresaPickList}</td>
									<td>${suministro.labelEstadoConexionPickList}</td>
									<td>${suministro.labelEstadoSuministroPickList}</td>
									<td>${suministro.electrodependiente}</td>
									<td>${suministro.fechaCorte}</td>
									<td>${suministro.direccionConcatenada}</td>
									<td>${suministro.comuna}</td>
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
		<div id="divEntidadCuentaContactos" class="divEntidad">
			<div class="subtitleAltaEntidad">
				<div>
					<input id="arrowTablaCuentaContactos" type="image" src="../resources/images/arrow-down-black.png" 
						height="15" onclick="showHideCabeceras('tablaCuentaContactos','arrowTablaCuentaContactos'); return false;"/>							
					<label class="divLabel"><s:message code="entidadCuenta_title_label_contact_data_detail" /></label>
				</div>
			</div>
			<div id="tablaCuentaContactos">
				<table class="basicTable">
					<tr>
						<th><s:message code="entidadCuenta_title_label_contact_name" /></th>
					    <th><s:message code="entidadCuenta_title_label_contact_run" /></th>
					    <th><s:message code="entidadCuenta_title_label_contact_main_telephone" /></th>
					    <th><s:message code="entidadCuenta_title_label_contact_main_email" /></th>
					</tr>
					<c:choose>
						<c:when test="${not empty cuenta.contactos}">
							<c:forEach items="${cuenta.contactos}" var="contacto">
								<tr>
									<td><a class="link" href="../private/entidadContacto?sfid=${contacto.sfid}">${contacto.name}</a></td>
									<td>${contacto.accountRun}</td>
									<td>${contacto.phone}</td>
									<td>${contacto.email}</td>
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
	</body>
</html>