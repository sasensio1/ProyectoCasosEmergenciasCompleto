
// FUNCIONES ÚTILES PARA TODAS LAS PÁGINAS
function createUrl() {
	var miUrl = window.location.protocol + "//" + window.location.host;
	if (window.location.pathname.indexOf("/casosEmergencias/") != -1) {
		miUrl = miUrl + "/casosEmergencias";
	}
	return miUrl;
}

function showHideCabeceras(idDiv, idArrow) {
	var div = document.getElementById(idDiv);
	var arrow = document.getElementById(idArrow); 				
	if (div.style.display == '')  {
		div.style.display = 'none';
		arrow.src="../resources/images/arrow-right-black.png";
	} else {
		div.style.display = '';
		arrow.src="../resources/images/arrow-down-black.png";
	}
}

function showHideCabecerasServicios(idDiv, idArrow) {
	var div = document.getElementById(idDiv);
	var arrow = document.getElementById(idArrow); 				
	if (div.style.display == '')  {
		div.style.display = 'none';
		arrow.src="../resources/images/arrow-right-white.png";
	} else {
		div.style.display = '';
		arrow.src="../resources/images/arrow-down-white.png";
	}
}
//--------------------------------------------------------------------

// FUNCIONES PARA MODIFICAR UN CASO
function modificarButton() {
	var modificar = document.getElementById('Modificar');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	
	modificar.hidden = true;
	guardar.hidden = false;
	cancelar.hidden = false;		
	descriptionRead.style.display = 'none'; 
	descriptionEdit.style.display = ''; 
}

function cancelarButton() {
	var modificar = document.getElementById('Modificar');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	
	modificar.hidden = false;
	guardar.hidden = true;
	cancelar.hidden = true;	
	descriptionRead.style.display = '';
	descriptionEdit.style.display = 'none'; 
}

// --------------------------------------------------------------------

// FUNCIONES DE VALIDACIONES DE FORMULARIOS DE BÚSQUEDA
function validateEmail(email) {
    var emailRegex = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    var validated = true;
    if (email != "") {
    	validated =  emailRegex.test(email);
    }
    return validated;
}
//--------------------------------------------------------------------

// FUNCIONES DE PÁGINA DE ALTA DE CASOS
function altaCaso() {
	var validado = validaDatos();
	if (validado) {
		$('#formEntidadCasoAlta').submit();
		return true;
	} else {
		return false;
	}
}

function altaCasoYNuevo() {
	var validado = validaDatos();
	if (validado) {
		$('#redirectHere').val("true");
		$('#formEntidadCasoAlta').submit();
		return true;
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

function cargarDialogSuministro() {
	$('#dialogSuministro').dialog({
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "400",
		width: "750",
		resizable: false,
		create: function (event) {$(event.target).parent().css('position', 'fixed');}
	});
}

function cargarDialogDireccion() {
	$('#dialogDireccion').dialog({
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "400",
		width: "750",
		resizable: false,
		create: function (event) { $(event.target).parent().css('position', 'fixed');}
	});
}

function abrirDialogSuministro() {
	$("#dialogSuministro").dialog( {
		resizable: false,
		height: "auto",
		width: "60%"
	});	
	$("#dialogSuministro").dialog('open');	
	createTableSuministro();//Funcion de popupsTable.js, crea la tabla
}

function abrirDialogDireccion() {
	$("#dialogDireccion").dialog( {
		resizable: false,
		height: "auto",
		width: "60%"
	});	
	$("#dialogDireccion").dialog('open');
	createTableDireccion(); //Funcion de popupsTable.js, crea la tabla
}

function establecerSuministro(sfid, name) {
	document.getElementById('suministro').value = sfid;
	document.getElementById('numSumiRecuperado').value = name;
	$('#dialogSuministro').dialog('close');
}

function establecerDireccion(sfid, name) {
	document.getElementById('direccion').value = sfid;
	document.getElementById('dirRecuperada').value = name;
	$('#dialogDireccion').dialog('close');
}

/*Inici -- funciones Guardar y Cancelar Comentario de un Caso*/
function newComent(sfid){
	 window.location="../private/casoComentarioPage?sfid="+sfid;
}


function cancelComent(sfid){
	 window.location="../private/entidadCaso?editMode=VIEW&sfid="+sfid;
}
/*Fin -- funciones Guardar y Cancelar Comentario de un Caso*/


//Funcion Cancelar Alta de un Caso
function cancelAltaCaso(){
	
	window.location="../private/cancelAltaCaso";
	
	
}

//Limpieza campos del buscador.
function limpiarCamposBuscadorCasos() {
	if (document.getElementById('filtroNumCaso').value != '') {
		document.getElementById('filtroNumCaso').value = '';
	}
}
