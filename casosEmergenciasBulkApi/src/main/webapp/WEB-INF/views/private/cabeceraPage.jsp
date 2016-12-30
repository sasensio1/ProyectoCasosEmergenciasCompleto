<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div  class="divCargando" id="cargandoGif" hidden="true">
	<div>
		<label class="labelCargando">
			<img  src="${pageContext.request.contextPath}/resources/images/loading.gif" width="2%"/>
			<s:message code="notificaciones_label_loading"/>
		</label>
	</div>
</div>
<div id="cabeceraEnel">
	<div id="divImagenEnel">
		<img src="../resources/images/logo.png" id="logoEnel" />
	</div>
	<div id="divNoImagenEnel">
		<a href="../logout"><s:message code="cabeceraPage_href_exit"/></a>
	</div>
</div>

<table id="menuCabecera">
	<tr>
	<td id="posicionamiento">
		<div style="float:left;">
		</div>
		<div style="float:left;">
			<label id="lblMenu"></label>
		</div>
	</td>
	<td id="desplegable">
		<div class="menuListado" onclick="javascript:cambiarLabel('<s:message code="cabeceraPage_label_case"/>');window.location.href='homeCasos'">
			<a href="homeCasos" ><s:message code="cabeceraPage_list_case"/></a>
		</div>
		<div class="menuListado" onclick="javascript:cambiarLabel('<s:message code="cabeceraPage_list_contact"/>');window.location.href='homeContacts'">
			<a href="homeContacts"><s:message code="cabeceraPage_list_contact"/></a>
		</div>
		<div class="menuListado" onclick="javascript:cambiarLabel('<s:message code="cabeceraPage_list_suministro"/>');window.location.href='homeSuministros'">
			<a href="homeSuministros"><s:message code="cabeceraPage_list_suministro"/></a>
		</div>
		<div class="menuListado" onclick="javascript:cambiarLabel('<s:message code="cabeceraPage_list_cuentas"/>');window.location.href='homeCuentas'">
			<a href="homeCuentas" ><s:message code="cabeceraPage_list_cuentas"/></a>
		</div>
	</td>
	<td id="divBotonDesplegable">			
		<input type="button" id="botonDesplegable" name="botonDesplegable" style="align:right;">
	</td>
	</tr>
</table>
<div>
	<div id="divTabs">
		&nbsp;
	</div>
</div>