var estadoCancelado = 'ESTA008';
var estadoCerrado = 'ESTA007';

function funcionOnload(){
	initHeader(); 
	checkUpdates(); 
	cargarDialogCancelacion();
}

// FUNCIONES PARA MODIFICAR UN CASO
function modificarCasoButton() {
	ocultarDivNotificacion();
	

	var modificar = document.getElementById('Modificar');
	var modificar = document.getElementById('Modificar');
	var cancelarCaso = document.getElementById('CancelarCaso');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	var datosEmergenciaDiv = document.getElementById('datosEmergencia');
	var arrowDatosEmergenciaDiv = document.getElementById('arrowDatosEmergencia');
	

	modificar.hidden = true;
	modificar.hidden = true;
	cancelarCaso.hidden = true;
	guardar.hidden = false;
	cancelar.hidden = false;	
		
	if (datosEmergenciaDiv.style.display == 'none'){
		datosEmergenciaDiv.style.display = '';
		arrowDatosEmergenciaDiv.src="../resources/images/arrow-down-black.png";
	}
	
	descriptionRead.style.display = 'none'; 
	descriptionEdit.style.display = '';
	
	//Ponemos el foco en el campo descripcion
	document.getElementById('descrip').focus();
}

function cancelarButton() {
	var modificar = document.getElementById('Modificar');
	var modificar = document.getElementById('Modificar');
	var cancelarCaso = document.getElementById('CancelarCaso');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	
	document.getElementById('descrip').value=document.getElementById('fieldRead').innerText;
	
	modificar.hidden = false;
	modificar.hidden = false;

	cancelarCaso.hidden = false;
	guardar.hidden = true;
	cancelar.hidden = true;	
	descriptionRead.style.display = '';
	descriptionEdit.style.display = 'none'; 
}

function guardarModificacion(){
	var form=document.getElementById('formEntidadCasoID');
	verCargando();
	form.submit();	
}

function cargarDialogCancelacion() {
	$("#dialogCancelarCaso").dialog({
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "auto",
		width: "13%",
		position:{
			my: "center center", 
			at: "center center",
			of: $('#detalleCaso') 
		},
		create: function (event) {}
	});
}

function cancelarCasoButton() {
	
	var comboSubestado = document.getElementById('subEstadoCancelacion');
	var estado = document.getElementById('idEstado').value;
	
	ocultarDivNotificacion();
	
	if(estado == estadoCancelado || estado == estadoCerrado){
		//No se puede cancelar, el caso ya esta cerrado y cancelado
		$('#divCaseCancelEstado').show();		
	}else{
		$('#dialogCancelarCaso').dialog('open');
	}
	
}

function guardarCancelarCaso(){
	var subEstado = document.getElementById('subEstadoCancelacion').value;
	
	if(subEstado != null && subEstado != "" && subEstado != 'Default'){
		cerrarDialogCancelarCaso();
		verCargando();
		document.getElementById('formCancelarCasoId').submit();
	}else{
		alert("Error: Debe seleccionar un valor de la lista.");
	}
	
}

function cerrarDialogCancelarCaso(){
	$('#dialogCancelarCaso').dialog('close');
}

function checkUpdates() {
	if ($('#editMode').val() == 'UPDATED_OK') {
		$('#divCaseModifiedOk').show();
	} else if ($('#editMode').val() == 'UPDATED_ERROR') {
		$('#divCaseModifiedError').show();
	} else if ($('#editMode').val() == 'CREATED_OK') {
		$('#divCaseCommentCreated').show();
	} else if ($('#editMode').val() == 'CREATED_ERROR') {
		$('#divCaseCommentNOCreated').show();
	} else if ($('#editMode').val() == 'INSERTED_OK') {
		$('#divCaseCreatedOk').show();
	} else if ($('#editMode').val() == 'INSERTED_ERROR') {
	  $('#divCaseCreatedError').show();
	} else if ($('#editMode').val() == 'CANCEL_OK') {
		$('#divCaseCancel').show();
	} else if ($('#editMode').val() == 'CACEL_ERROR') {
	  $('#divCaseCancelError').show();
	}
}


function checkUpdates() {
	if ($('#editMode').val() == 'UPDATED_OK') {
		$('#divCaseModifiedOk').show();
	} else if ($('#editMode').val() == 'UPDATED_ERROR') {
		$('#divCaseModifiedError').show();
	} else if ($('#editMode').val() == 'CREATED_OK') {
		$('#divCaseCommentCreated').show();
	} else if ($('#editMode').val() == 'CREATED_ERROR') {
		$('#divCaseCommentNOCreated').show();
	} else if ($('#editMode').val() == 'INSERTED_OK') {
		$('#divCaseCreatedOk').show();
	} else if ($('#editMode').val() == 'INSERTED_ERROR') {
	  $('#divCaseCreatedError').show();
	} else if ($('#editMode').val() == 'CANCEL_OK') {
		$('#divCaseCancel').show();
	} else if ($('#editMode').val() == 'CACEL_ERROR') {
	  $('#divCaseCancelError').show();
	}
}


/*Inicio -- Funciones Comentario de un caso*/
function checkCaseCommentCreation() {	
	if(document.getElementById('comment').value==''){
		$('#divCaseCommentNOCreated').show();		
	}
	else{
		verCargando();
		document.getElementById('formComentarioCaso').submit();
	}

}

function newComent(sfid){
	 verCargando();
	 window.location="../private/casoComentarioPage?sfid="+sfid;
}


function cancelComent(sfid){
	 verCargando();
	 window.location="../private/entidadCaso?editMode=VIEW&sfid="+sfid;
}
/*Fin -- Funciones Comentario de un caso*/


/*Inicio -- Funciones Alta de un caso*/
function cancelAltaCaso(){
	verCargando();
	window.location="../private/cancelAltaCaso";	
}

function altaCaso() {
	verCargando();
	var validado = true; //validaDatos();
	if (validado) {
		$('#formEntidadCasoAlta').submit();
		return true;
	} else {
		return false;
	}
}

function altaCasoYNuevo() {
	var validado = true; //validaDatos();
	if (validado) {
		$('#redirectToNewCase').val("true");
		$('#formEntidadCasoAlta').submit();
		return true;newComent('${caso.sfid}');
	} else {
		return false;
	}
}

function validaDatos() {
	if (document.getElementById('suministro') && document.getElementById('suministro').value == ''
			&& document.getElementById('direccion') && document.getElementById('direccion').value == '') {
		document.getElementById('errorMessage').innerHTML= '<s:message code="entidadCasoAlta_error_sumiodire"/>';		    		
		document.getElementById('divError').style.display= 'block';
		return false;
	}
	return true;
}

function limpiarDireccion() {
	if (document.getElementById('direccion') && document.getElementById('direccion').value != '') {
		document.getElementById('direccion').value = '';
		document.getElementById('dirRecuperada').value = '';
	}
}

function limpiarSuministro() {
	if (document.getElementById('suministro') && document.getElementById('suministro').value != '') {
		document.getElementById('suministro').value = '';
		document.getElementById('numSumiRecuperado').value = '';
	}
}
/*Fin -- Funciones Alta de un caso*/

function ocultarDivNotificacion(){
	$('#divCaseModifiedOk').hide();
	$('#divCaseModifiedError').hide();
	$('#divCaseCommentCreated').hide();
	$('#divCaseCommentNOCreated').hide();
	$('#divCaseCreatedOk').hide();
	$('#divCaseCreatedError').hide();
	$('#divCaseCancel').hide();
	$('#divCaseCancelError').hide();
	$('#divCaseCancelEstado').hide();
}


//Funcion que oculta o muestra todos los historicos de un caso (si tiene mas de 10 entradas)
function refrescarHistorial(numeroEntradas){	
	$.post("../private/listarHistorialCaso",
			{sfid: document.getElementById('idSfid').value,
			entradas: numeroEntradas},
			function(data) {
				var tablaDatos=  document.getElementById("tablaHistorial");
				var longTabla = tablaDatos.rows.length;
				
				//eliminamos los registros de la tabla actual, !Cuidado! no eliminar la fila 0 que es la cabecera
				for(i = 1; i<longTabla; i++){
					tablaDatos.deleteRow(1);
				}
				
				//Añadimos registros a la tabla nueva. Vamos insertando la fila 1 e iremos recorriendo de manera inversa 
				//la lista de suministros para guardarlos en la tabla
				for(j=data.length -1 ; j >= 0; j--){
					
					var fila= data[j];
					var row = tablaDatos.insertRow(1);
					
					var fechaCreacion = row.insertCell(0);
					fechaCreacion.innerHTML =  fila.createddateString;	
					var userName = row.insertCell(1);
					userName.innerHTML = fila.userJoin.name;						
					var accion = row.insertCell(2);
					accion.innerHTML = fila.field;

				} 
				
				if(numeroEntradas == 'All'){
					//mostramos href 'Mostar 10'
					document.getElementById('hrefNoTodosHistorial').hidden = false;
					document.getElementById('hrefTodosHistorial').hidden = true;
				}else{
					//mostramos href 'Mostar todos'
					document.getElementById('hrefNoTodosHistorial').hidden = true;
					document.getElementById('hrefTodosHistorial').hidden = false;
					
				}
		});	
}