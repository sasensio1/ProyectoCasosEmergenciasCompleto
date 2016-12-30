var table;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaCasos').DataTable({
		"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": true,
		"serverSide": true,
		"processing": true, 
		"ajax": {
			"type": "POST", 
        	"url": urlTable +'/listarCasos', 	        	
        	"contentType": 'application/json; charset=utf-8' ,
        	"error": function(data) {
        		alert('Se ha producido un error obteniendo la lista de casos. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
        	}
       	},
       	"columns": [
       	            {"data": "numeroCaso", 		"width": "20%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true}, 
       	            {"data": "numeroInservice", "width": "16%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "canalOrigen", 	"width": "16%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "estado", 			"width": "16%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "subestado", 		"width": "16%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "submotivo", 		"width": "16%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "sfid", 			"width": "1%", 	"defaultContent": "", "searchable": false, 	"orderable": false,	"visible": false}
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
                    	return '<a href="../private/entidadCaso?editMode=VIEW&sfid=' + sfid + '">' + txtColumn + '</a>';
                     }
                    }],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
	
	$('#search').on('click', function() {
		table
			.columns(0).search($('#filtroNumCaso').val())
			.draw();
	});
});




