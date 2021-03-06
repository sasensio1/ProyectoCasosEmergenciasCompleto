var table;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaContactos').DataTable({
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
        	 "url": urlTable +'/listarContactos', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data) {
        		 alert('Se ha producido un error obteniendo la lista de contactos. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
        	 }
       	},
       	"columns": [
       	            {"data": "name", 							"width": "25%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "identitynumber__c", 				"width": "23%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true}, 
       	            {"data": "phone",							"width": "25%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "email",							"width": "25%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "sf4twitter__twitter_username__c",	"width": "1%",  "defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false},
       	            {"data": "sfid", 							"width": "1%", 	"defaultContent": "", "searchable": false, 	"orderable": false,	"visible": false}
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
                    	 return '<a href="javaScript:{cargandoGif('+"'" +sfid + "'"+","+"'"+"entidadContacto"+"'"+')}">'+ txtColumn + '</a>';
                    }
        }],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
	
	$('#search').on('click', function() {
			table
			.columns(0).search($('#filtroNombreApellidos').val())
			.columns(1).search($('#filtroRunRut').val())
			.columns(2).search($('#filtroTelefono').val())
			.columns(3).search($('#filtroEmail').val())
			.columns(4).search($('#filtroTwitter').val())
			.draw();
	});
	
	//Añadir opcion de buscar pulsando enter
	$("#filtroRunRut").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroNombreApellidos").on("keyup", function (event) {
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
	$("#filtroTwitter").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
});


//Limpieza campos del buscador.

function limpiarCamposBuscadorContactos() {
	
	if (document.getElementById('filtroRunRut').value != '') {
		document.getElementById('filtroRunRut').value = '';
	}
	if (document.getElementById('filtroNombreApellidos').value != '') {
		document.getElementById('filtroNombreApellidos').value = '';
	}
	if (document.getElementById('filtroTelefono').value != '') {
		document.getElementById('filtroTelefono').value = '';
	}
	if (document.getElementById('filtroEmail').value != '') {
		document.getElementById('filtroEmail').value = '';
	}
	if (document.getElementById('filtroTwitter').value != '') {
		document.getElementById('filtroTwitter').value = '';
	}
	
}
