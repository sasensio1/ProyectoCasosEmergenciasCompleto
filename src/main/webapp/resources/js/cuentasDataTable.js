var table;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaCuentas').DataTable({
       	/*"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,*/
		"paging": true,
		"serverSide": true,
		   oLanguage: {
		        sProcessing: "<img src='../resources/images/loading.gif' width='25' > Cargando..."
		    },
		"processing": true, 
		"ajax": { 
        	"type": "POST", 
        	 "url": urlTable +'/listarCuentas', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data) {
        		 alert('Se ha producido un error obteniendo la lista de cuentas. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
        	 }
       	},
       	"columns": [
       	            {"data": "name", 				"width": "33%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "mainphone__c",		"width": "32%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "primaryemail__c",		"width": "33%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "identitynumber__c",	"width": "1%",  "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": false},
       	            {"data": "sfid", 				"width": "1%", 	"defaultContent": "", "searchable": false, 	"orderable": false,	"visible": false}
		],
		"columnDefs": [
                    {"targets": 0,
                     "render": function (data, type, full, meta) {
                    	 var sfid = "";
                    	 var txtColumn = "";
                    	 if (full.sfid != null) {
                    		 sfid = full.sfid;
                    	 }
                    	 if (data != null) {
                    		 txtColumn = data;
                    	 }
                    	 return '<a href="javaScript:{cargandoGif('+"'" +sfid + "'"+","+"'"+"entidadCuenta"+"'"+')}">'+ txtColumn + '</a>';
                    }
        }],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
	
	$('#search').on('click', function() {
			table
				.columns(0).search($('#filtroRazonSocial').val())
				.columns(1).search($('#filtroTelefono').val())
				.columns(2).search($('#filtroEmail').val())
				.columns(3).search($('#filtroRunRut').val())
				.draw();
	});
	
	//Añadir opcion de buscar pulsando enter
	$("#filtroRunRut").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroRazonSocial").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroTelefono").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroEmail").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
});


//Limpieza campos del buscador.

function limpiarCamposBuscadorCuentas() {
	
	if (document.getElementById('filtroRunRut').value != '') {
		document.getElementById('filtroRunRut').value = '';
	}
	if (document.getElementById('filtroRazonSocial').value != '') {
		document.getElementById('filtroRazonSocial').value = '';
	}
	if (document.getElementById('filtroTelefono').value != '') {
		document.getElementById('filtroTelefono').value = '';
	}
	if (document.getElementById('filtroEmail').value != '') {
		document.getElementById('filtroEmail').value = '';
	}
}
