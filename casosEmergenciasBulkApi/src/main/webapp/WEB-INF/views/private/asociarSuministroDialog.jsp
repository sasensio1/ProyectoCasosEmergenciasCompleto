<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Dialog combo Asociar Suministro a Contacto -->
<div id="dialogAsociarSuministroContacto" title="Búsqueda" class="dialogLupa">	
	<form id="asociarSuministroId" action="listarAsociarSuministros"  method="POST" name="formAsociarSuministro">	
		<input id="sfidContAsociadoID" type="hidden" value="${contacto.sfid}" name="sfidContAsociado">
		<div id="divAssociationErrorSearch" class="divError">
			<label class="labelDivError"><s:message code="notificaciones_label_error_campos_incompletos"/></label>
		</div>
		<div id="busquedaSuministro" class="divEntidad, divLabel">
			<table  class="tablaBusqueda">
				<tr>
					<td colspan="2" class="tablaBusquedaTitulo">
						Búsqueda por Suministro
					</td>
					<td colspan="2" class="tablaBusquedaTitulo">
						Búsqueda por Dirección
					</td>		
				</tr>
				<!-- SuministroPorDireccionController -->
				<tr>
					<td rowspan="3" class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Número de Suministro</label>
					</td>
					<td class="tablaAsociarSuministroTextos" rowspan="3">
						<input type="text" name="nameSuministro" value="" id="idNameSuministro" class="buttontext">
					</td>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Comuna</label>
					</td>
					<td class="tablaAsociarSuministroTextos">					
						<select id="idComuna" name= "mapComuna">
							<c:forEach items="${suministroDial.mapComuna}" var="comuna">
								<option value="${comuna.value}">								
									${comuna.value}								
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Calle</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input type="text" name="calle" value="" id="idDireccionConcatenada" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Número</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input type="text" name="numero" value="" id="idNumero" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaBotonera">
						<input id="crearCasoDireccion" type="button" name="crearCasoDirecion" value="Crear Caso Dirección" onclick="abrirDialogoCasoDireccion();"/>
					</td>
					<td colspan="3" align="right">
						<input id="buscar" type="button" name="buscar" value="Buscar" />					
					</td>					
				</tr>
			</table>
		</div>		
	</form>
	<div>
	</div>		
	<div>
		<table id="tablaSuministros" class="display" style="width: 100%;">
			<thead>
	            <tr>
	            	<th width="18%">Número de Suministro</th>
	                <th width="31%">Dirección</th>
	                <th width="15%">Comuna</th>
	                <th width="18%">Estado de Conexión</th>
	                <th width="15%">Empresa</th>
	                <th width="1%" hidden="true">sfid</th>
	                <th width="1%" hidden="true">calle</th>
	                <th width="1%" hidden="true">numero</th>
	            </tr>
        	</thead>
		</table>
	</div>
	<jsp:include page="crearCasoPorDireccionDialog.jsp"/>	
</div>