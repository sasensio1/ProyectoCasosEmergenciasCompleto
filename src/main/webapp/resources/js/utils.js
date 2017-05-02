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


//Exportar Datatable en formato excel

function fnExcelReport(tab)
{
    var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
    var textRange; var j=0;

    for(j = 0 ; j < tab.rows.length ; j++) 
    {     
        tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
    }

    tab_text=tab_text+"</table>";
    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
    tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE "); 

    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
    {
        txtArea1.document.open("txt/html","replace");
        txtArea1.document.write(tab_text);
        txtArea1.document.close();
        txtArea1.focus(); 
        sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
    }  
    else                 //other browser not tested on IE 11
        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

    return (sa);
}

//Función para calcular los días transcurridos entre dos fechas
function restarFechas(f1,f2)
 {
 var aFecha1 = f1.split('-'); 
 var aFecha2 = f2.split('-'); 
 var asubFecha1 = aFecha1[2].split('T'); 
 var asubFecha2 = aFecha2[2].split('T'); 


 var fFecha1 = new Date(aFecha1[0],aFecha1[1],asubFecha1[0]); 
 var fFecha2 = new Date(aFecha2[0],aFecha2[1],asubFecha2[0]); 
 var dif = fFecha2 - fFecha1;
 var dias = Math.round(dif / (1000 * 60 * 60 * 24)); 
 return dias;
 }


//Función para añadir los segundos al valor de un datetime cuando los seteamos a :00
function addSeconsToDateValue(f1) {
	if(f1!="" ){
		 var aFecha1 = f1.split('-'); 
		 var asubFecha1 = aFecha1[2].split('T'); 
		 var aasubFecha = asubFecha1[1].split(':'); 
		 if(aasubFecha[2]==null){
			 f1=f1+":00";
		 };
	}
 return f1;
 }



