var table;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaSuministros').DataTable({
       	"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": true,
		"serverSide": true,
		"processing": true, 
		"ajax": { 
        	"type": "POST", 
        	 "url": urlTable +'/listarSuministros', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data) {
        		 alert('Se ha producido un error obteniendo la lista de suministros. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
        	 }
       	},
       	"columns": [
       	            {"data": "name", 						"width": "20%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true}, 
       	            {"data": "estadoConexion",				"width": "19%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "estadoSuministro", 			"width": "19%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "DireccionConcatenada__c", 	"width": "20%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "comuna", 						"width": "19%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "n_mero_medidor__c",			"width": "1%", 	"defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false},
       	            {"data": "ruta__c",						"width": "1%", 	"defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false},
       	            {"data": "sfid", 						"width": "1%", 	"defaultContent": "", "searchable": false, 	"orderable": false,	"visible": false}
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
                    	 return '<a href="../private/entidadSuministro?sfid=' + sfid + '">' + txtColumn + '</a>';
                    }
        }],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
	
	$('#search').on('click', function() {
		table
			.columns(0).search($('#filtroNumSuministro').val())
			.columns(3).search($('#filtroDireccion').val())
			.columns(5).search($('#filtroNumMedidor').val())
			.columns(6).search($('#filtroRutaLectura').val())
			.draw();
	});
});

//Limpieza campos del buscador.

function limpiarCamposBuscadorSuministro() {
	
	if (document.getElementById('filtroNumSuministro').value != '') {
		document.getElementById('filtroNumSuministro').value = '';
	}
	if (document.getElementById('filtroDireccion').value != '') {
		document.getElementById('filtroDireccion').value = '';
	}
	if (document.getElementById('filtroRutaLectura').value != '') {
		document.getElementById('filtroRutaLectura').value = '';
	}
	if (document.getElementById('filtroNumMedidor').value != '') {
		document.getElementById('filtroNumMedidor').value = '';
	}
}
