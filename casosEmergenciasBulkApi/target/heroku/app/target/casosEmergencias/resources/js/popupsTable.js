var tableSuministro;
var tableDireccion;
var urlTable = createUrl();



function createTableDireccion() {	
	
	//Comprobamos si la tabla esta creada
	if(tableDireccion == null){
		tableDireccion= $('#tablaDireccionesPopUp').DataTable( {
			"scrollY": "250px",
			"scrollX": true,
			"scrollCollapse": true,
			"paging": true,
			"serverSide": true,
			"deferLoading": 0,
			"processing": true, 
			"ajax": { 
	        	"type": "POST", 
	        	 "url": urlTable +'/listarDireccionesPopUp', 	        	
	        	 "contentType": 'application/json; charset=utf-8' ,
	        	 "error": function(data){
	        		 alert('Se ha producido un error obteniendo la lista de direcciones. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
	        	 }
	       	}, 
	       	"columns": [ 
	       	            {"data": "name","width" : "30%","defaultContent": ""}, 
	       	            {"data": "numero", "width":"10%", "defaultContent": ""},
	       	            {"data": "comuna", "width":"20%", "defaultContent": ""},
	       	            {"data": "calle", "width":"30%", "defaultContent": ""},
	       	            {"data": "departamento", "width":"9%", "defaultContent": ""},
	       	            {"data": "sfid", "width":"1%", "visible": false, "defaultContent": ""}
	       	            ],
	       "columnDefs": [
	                    {"targets":0,
	                     "render": function (data, type, full, meta){
	                    	 var codigoDireccion = "";
	                    	 var idDireccion = "";
	                    	 if(full.name != null){
	                    		 codigoDireccion = full.name;
	                     	 }
	                    	 if(full.sfid != null){
	                    		 idDireccion = full.sfid;
	                     	 }
	                    	 return '<input type="button" class="buttonLink" onclick="javascript:establecerDireccion(\''+ idDireccion + '\',\'' + codigoDireccion + '\')" value="' + codigoDireccion + '" >';
	                     	}
		    	   		}
		    	   		],
			"lengthMenu": [[10, 25, 100, -1], [10, 25, 100, "All"]],
			"order": [[0, 'asc']],      
	        "deferRender": true, 
	  
		});
		$('#searchDireccion').on('click', function(){
			var allCase = true;
			first = false;
			tableDireccion.search($('#txtNombreDireccion').val(),allCase).draw();
		});
	}
}


function createTableSuministro() {
	
	//Comprobamos si la tabla esta creada
	if(tableSuministro==null){
		tableSuministro= $('#tablaSuministrosPopUp').DataTable( {
			"scrollY": "250px",
			"scrollX": true,
			"scrollCollapse": true,
			"paging": true,
			"serverSide": true,
			"deferLoading": 0,
			"processing": true, 
			"ajax": { 
	        	"type": "POST", 
	        	 "url": urlTable +'/listarSuministrosPopUp', 	        	
	        	 "contentType": 'application/json; charset=utf-8' ,
	        	 "error": function(data){
	        		 alert('Se ha producido un error obteniendo la lista de suministros. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
	        	 }
	       	}, 
	       	"columns": [ 
	       	            {"data": "name", "width" : "30%","defaultContent": ""}, 
	       	            {"data": "idEmpresa", "width":"15%", "defaultContent": ""},
	       	            {"data": "comuna", "width":"15%", "defaultContent": ""},
	       	            {"data": "direccionConcatenada", "width":"39%", "defaultContent": ""},
	       	            {"data": "sfid", "width":"1%", "defaultContent": "", "visible": false}
	       	            ],
	       "columnDefs": [
	                    {"targets":0,
	                     "render": function (data, type, full, meta){
	                    	 var numeroSuministro = "";
	                    	 var idSuministro = "";
	                    	 if(full.name != null){
	                    		 numeroSuministro = full.name;
	                     	 }
	                    	 if(full.sfid != null){
	                    		 idSuministro = full.sfid;
	                     	 }
	                    	 return '<input type="button" class="buttonLink" onclick="javascript:establecerSuministro(\''+ idSuministro + '\',\'' + numeroSuministro + '\')" value="' + numeroSuministro + '" >';
	                     	}
		    	   		}
		    	   		],
			"lengthMenu": [[10, 25, 100, -1], [10, 25, 100, "All"]],
			"order": [[0, 'asc']],      
	        "deferRender": true, 
	  
		});
	
		$('#searchSuministro').on('click', function() {
			var allCase = true;
			first = false;
			tableSuministro.column(0).search($('#txtNumeroSuministro').val(), allCase).column(2).search($('#txtComuna').val(), allCase).draw();
		});
	}
	
}