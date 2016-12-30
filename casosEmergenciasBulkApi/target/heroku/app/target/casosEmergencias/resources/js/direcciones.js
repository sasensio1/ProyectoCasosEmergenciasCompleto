var table;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaDirecciones').DataTable({
       	"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": true,
		"serverSide": true,
		"processing": true, 
		"ajax": { 
        	"type": "POST", 
        	 "url": urlTable +'/listarDireccionesHome', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data) {
        		 alert('Se ha producido un error obteniendo la lista de direcciones. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
        	 }
       	},
       	"columns": [
       	            {"data": "name", 					"width": "15%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "calle__c", 				"width": "20%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true}, 
       	            {"data": "altura__c",				"width": "15%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "literalcomuna__c",		"width": "20%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "direccionconcatenada__c", "width": "28%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "comuna__c", 				"width": "1%",  "defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false},
       	            {"data": "sfid", 					"width": "1%", 	"defaultContent": "", "searchable": false, 	"orderable": false,	"visible": false}
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
                    	 return '<a href="../private/entidadDireccion?sfid=' + sfid + '">' + txtColumn + '</a>';
                    }
        }],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
	
	$('#search').on('click', function() {
		table
			.columns(1).search($('#filtroCalle').val())
			.columns(5).search($('#filtroComuna').val())
			.draw();
	});
});