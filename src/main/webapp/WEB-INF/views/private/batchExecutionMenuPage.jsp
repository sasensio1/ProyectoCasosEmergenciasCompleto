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
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />	
		

		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/jQueryDatatables.js"></script>
		<script src="../resources/js/header.js"></script>
		<script src="../resources/js/utils.js"></script>
		<script src="../resources/js/batch.js"></script>
	</head>
	<body onload="initHeader();showNotifications();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_menuBatch"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<!-- Mensajes de estado de procesos Batch -->		
		<c:if test="${not empty param.mostrarMensaje && param.mostrarMensaje eq true}">
			<c:choose>
				<c:when test="${not empty param.hayError && param.hayError eq true}">
					<div>
						<div class="divError" id="divInsertError">
							<label class="labelDivError"><s:message code="notificaciones_label_error_mensaje"/>&nbsp;${param.mensajeResultado}</label>
						</div>						
					</div>
					<br>					
				</c:when>
				<c:otherwise>
					<div>
						<div id="divInsertOk" class="divOk" >
							<label class="labelDivOk">${param.mensajeResultado}</label>
						</div>	
					</div>
					<br>					
				</c:otherwise>
			</c:choose>
			<div >
				<a href="<c:out value="homeHistoricBatch" />">Historial de registros</a>
			</div>
			<br>
		</c:if>
		<!-- Mensajes de estado de procesos Batch -->
		
		<!-- Mensajes de estado de operación -->
		<div id="divErrorComienzoEjecucionSuperior" class="divError" style="display:none;margin-top:2%;">
			<label><s:message code="batchMenu_error_comienzo_ejecucion_superior"/></label>
		</div>
		<div id="divErrorTiempoEjecucionSuperior" class="divError" style="display:none;margin-top:2%;">
			<label><s:message code="batchMenu_error_tiempo_ejecucion_superior"/></label>
		</div>
		 <!-- Mensajes de estado de operación -->
		 
		<form name="formMenuBatch" action="homeHistoricBatchsAction" method="POST">
			<input type="hidden" value="${maxProcessedDays}" id="maxProcessedDays"/>
			<input type="hidden" value="" id="process"/>
			<div class="formBusqueda">
				<div id="divBatchMenu">				
					<table class="tablaBusqueda">	
						<tr>
							<td class="tablaBusquedaTitulo">
						    	<s:message code="search_form_title_executeProcess"/>						    	
							</td>							
					    </tr>			
						<tr id="tableExecutionDate" style="display:none;">
							<td>
								<label for="filtroComienzoEjecucioBatchMenu"><s:message code="search_form_input_batchMenu_comienzo_ejecucion"/></label>
								<input type="datetime-local" step="1"  id=filtroComienzoEjecucioBatchMenuId name="filtroComienzoEjecucioBatchMenu"  value="">
				            </td>	
				            <td>
								<label for="filtroFinEjecucioBatchMenuId"><s:message code="search_form_input_batchMenu_final_ejecucion"/></label>
								<input type="datetime-local" step="1"  id="filtroFinEjecucioBatchMenuId" name="filtroFinEjecucioBatchMenu"  value="">
				            </td>
			            </tr>
			        <tr >
			        <td style="padding-top: 1%;">	            		             
		            <INPUT TYPE="radio" id="pickListTableButton" name="radios" value="pickListTableElection" CHECKED onclick="hideBatchBulkApiSubMenu();hideTableExecutionDate();setProcessSelected('pickListTableButton')">
			        <label ><s:message code="search_form_input_batchMenu_picklist_Table"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="fieldLableTableButton" name="radios" value="fieldLabelTableElection" onclick="hideBatchBulkApiSubMenu();hideTableExecutionDate();setProcessSelected('fieldLableTableButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_Label_Table"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="apiRestButton" name="radios" value="apiRestElection" onclick="showBatchBulkApiSubMenu();showTableExecutionDate();setProcessSelected('apiRestButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_api_Rest"/></label>
		            <BR>
		            </td>
		            </tr>		            
		        </table>		        
		        </div>
		        <div id="divBatchBulkApiSubMenu" style="display:none;padding-left: 5%;"  >
		            <INPUT TYPE="radio" id="accountButton" name="radios" value="accountElection" CHECKED onclick="setProcessSelected('accountButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_account"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="addressButton" name="radios" value="addressElection" onclick="setProcessSelected('addressButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_address"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="assetButton" name="radios" value="assetElection" onclick="setProcessSelected('assetButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_asset"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="caseHistoryButton" name="radios" value="caseHistoryElection" onclick="setProcessSelected('caseHistoryButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_case_History"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="contactButton" name="radios" value="contactElection" onclick="setProcessSelected('contactButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_contact"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="groupButton" name="radios" value="groupElection" onclick="setProcessSelected('groupButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_group"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="pointOfDeliveryButton" name="radios" value="pointOfDeliveryElection" onclick="setProcessSelected('pointOfDeliveryButton')">
			        <label ><s:message code="search_form_input_batchMenu_point_Of_Delivery"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="repeatedCasesButton"name="radios" value="repeatedCasesElection" onclick="setProcessSelected('repeatedCasesButton')">
			        <label ><s:message code="search_form_input_batchMenu_repeated_Cases"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="caseCommentButton"name="radios" value="caseCommentElection" onclick="setProcessSelected('caseCommentButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_case_Comment"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="herokuUserButton"name="radios" value="herokuUserElection" onclick="setProcessSelected('herokuUserButton')">
			        <label ><s:message code="search_form_input_batchMenu_field_heroku_User"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="serviceProductButton" name="radios" value="serviceProductElection" onclick="setProcessSelected('serviceProductButton')">
			        <label ><s:message code="search_form_input_batchMenu_service_Product"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="streetButton" name="radios" value="streetElection" onclick="setProcessSelected('streetButton')">
			        <label ><s:message code="search_form_input_batchMenu_street"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="taskButton" name="radios" value="taskElection" onclick="setProcessSelected('taskButton')">
			        <label ><s:message code="search_form_input_batchMenu_task"/></label>
		            <BR>
		            <INPUT TYPE="radio" id="userButton" name="radios" value="userElection" onclick="setProcessSelected('userButton')">
			        <label ><s:message code="search_form_input_batchMenu_user"/></label>
		            <BR>
		        </div>
		        <br/>
		        <br/>
		        <div style="padding-left: 1%;" >
					<button type="button" id="executeBatchButton" onclick="processBatchControllerMethodRedirection()"> Ejecutar </button>
	        	</div>
	        	<div>
	        		<br>
	        	</div>	
	        </div>       		     
		</form>
	</body>
</html>