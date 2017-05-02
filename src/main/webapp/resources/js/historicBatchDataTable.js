var table;
var exportTable;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaHistoricBatchs').DataTable({
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
        	"url": urlTable +'/private/listarHistoricBatchs', 	        	
        	"contentType": 'application/json; charset=utf-8' ,
        	/*"success":function(data) {
        		alert('sdfsfsf');
        	},*/
        	"error": function(data) {
        		alert('Se ha producido un error obteniendo la lista de historicBatchs. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
        	}
       	},
       	"columns": [
       	            {"data": "object", 				"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true}, 
       	            {"data": "operation", 			"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "startDate", 			"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "sfidRecord", 			"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "success", 			"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true,     	            
       	             "render": function (data){
	       	              if(data){
	       	            	  return '<input type="checkbox" checked="checked" disabled="true"' + $('<div/>').text(data).html() + '">';
	       	              }
	       	              else{
	       	            	  return '<input type="checkbox" disabled="true"' + $('<div/>').text(data).html() + '">';	
	       	              }
       	             }
       	            },       	            
       	            {"data": "errorCause", 			"width": "15%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "endDate", 			"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "endDateFilter", 		"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false},
       	            {"data": "startDateFilter", 	"width": "15%", "defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false}


		],
		/*"columnDefs": [
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
                   	 return '<a href="javaScript:{cargandoGif('+"'" +sfid + "'"+","+"'"+"entidadHistoricBatch"+"'"+')}">'+ txtColumn + '</a>';
                     }
                    }],*/
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
		
	$('#search').on('click', function() {
				
		table
			.columns(0).search($('#filtroObjetoHistoricBatch').val())
			.columns(1).search($('#filtroOperacionHistoricBatch').val())
			.columns(2).search($('#filtroComienzoOperacionHistoricBatch').val())
			.columns(3).search($('#filtroSfidRegistroHistoricBatch').val())
			.columns(4).search($('#filtroSuccessHistoricBatch').val())
			.columns(6).search($('#filtroFinalOperacionHistoricBatch').val())
			.columns(7).search($('#filtroFinalOperacionHistoricBatchPickListFilter').val())
			.columns(8).search($('#filtroComienzoOperacionHistoricBatchPickListFilter').val())
			.draw();
	});
	
	
	//Añadir opcion de buscar pulsando enter
	$("#filtroObjetoHistoricBatch").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroOperacionHistoricBatch").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroComienzoOperacionHistoricBatch").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroSfidRegistroHistoricBatch").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroSuccessHistoricBatch").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroFinalOperacionHistoricBatch").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroFinalOperacionHistoricBatchPickListFilter").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
	$("#filtroComienzoOperacionHistoricBatchPickListFilter").on("keyup", function (event) {
	    if (event.keyCode==13) {
	        $("#search").get(0).click();
	    }
	});
});

//Limpieza campos del buscador.
function limpiarCamposBuscadorHistoricBatchs() {
	if (document.getElementById('filtroObjetoHistoricBatch').value != '') {
		document.getElementById('filtroObjetoHistoricBatch').value = '';
	}
	if (document.getElementById('filtroOperacionHistoricBatch').value != '') {
		document.getElementById('filtroOperacionHistoricBatch').value = '';
	}
	if (document.getElementById('filtroComienzoOperacionHistoricBatch').value != '') {
		document.getElementById('filtroComienzoOperacionHistoricBatch').value = '';
	}
	if (document.getElementById('filtroSfidRegistroHistoricBatch').value != '') {
		document.getElementById('filtroSfidRegistroHistoricBatch').value = '';
	}
	if (document.getElementById('filtroSuccessHistoricBatch').value != '') {
		document.getElementById('filtroSuccessHistoricBatch').value = '';
	}
	if (document.getElementById('filtroFinalOperacionHistoricBatch').value != '') {
		document.getElementById('filtroFinalOperacionHistoricBatch').value = '';
	}
	if (document.getElementById('filtroFinalOperacionHistoricBatchPickListFilter').value != '') {
		document.getElementById('filtroFinalOperacionHistoricBatchPickListFilter').value = '';
	}
	if (document.getElementById('filtroComienzoOperacionHistoricBatchPickListFilter').value != '') {
		document.getElementById('filtroComienzoOperacionHistoricBatchPickListFilter').value = '';
	}
	
	
	//Exportar Datatable en formato excel	
	$('#btnExport').on('click', function() {
		
		exportTable = document.getElementById('tablaHistoricBatchs');
		fnExcelReport(exportTable);
	});
}

