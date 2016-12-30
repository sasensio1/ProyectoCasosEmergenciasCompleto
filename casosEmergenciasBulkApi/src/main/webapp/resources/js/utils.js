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


// FUNCIONES PARA OCULTAR O MOSTAR DIV DE ERROR
function showNotifications() {
	if ($('#divInsertError').length) {
		$('#divInsertError').show();
	} else if ($('#divInsertOk').length) {
		$('#divInsertOk').show();
	}
}

// FUNCIONES CREAR Y ABRIR POPUPS PAGINAS DE CREACION
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
	createTableDireccion(); //Funcion de popupsTable.js, crea la tablaa
}

function establecerSuministro(sfid, name,direccionSfid,direccionName) {
	document.getElementById('suministro').value = sfid;
	document.getElementById('suministroString').value = name;
	document.getElementById('numSumiRecuperado').value = name;
	if(direccionName!=null && direccionSfid!=null ){
		document.getElementById('direccion').value = direccionSfid;
		document.getElementById('direccionString').value = direccionName;
		document.getElementById('dirRecuperada').value = direccionName;
	}
	$('#dialogSuministro').dialog('close');
}

function establecerDireccion(sfid, name) {
	document.getElementById('direccion').value = sfid;
	document.getElementById('direccionString').value = name;
	document.getElementById('dirRecuperada').value = name;
	$('#dialogDireccion').dialog('close');
}

function cargandoGif(sfid,page) {
	verCargando();
	if(page=="entidadCaso"){
	window.location="../private/entidadCaso?editMode=VIEW&sfid=" + sfid ;
	}
	if(page=="entidadContacto"){
		window.location="../private/entidadContacto?editMode=VIEW&sfid=" + sfid ;
		}
	if(page=="entidadSuministro"){
		window.location="../private/entidadSuministro?sfid=" + sfid ;
		}
	if(page=="entidadCuenta"){
		window.location="../private/entidadCuenta?sfid=" + sfid ;
		}
	if(page=="entidadDireccion"){
		window.location="../private/entidadDireccion?sfid=" + sfid ;
		}
}

//Metodo que muestra el div de "cargando.."
function verCargando(){
	document.getElementById("cargandoGif").hidden=false;
}

//Metodo que oculta el div de "cargando.."
function ocultarCargando(){
	document.getElementById("cargandoGif").hidden=true;
}



