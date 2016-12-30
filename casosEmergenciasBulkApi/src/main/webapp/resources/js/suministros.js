//Crear caso por suministro
function goCrearCasoBySuministro(){	
	verCargando();
	window.location="../private/goCrearCasoBySuministro";
}

//Crear caso corte por deuda
function crearCasoCorteDeuda(){	
	verCargando();
	$.post( "../private/goCrearCasoBySuministroAndCorte",
		{causa: 'deuda', sfidSum: document.getElementById('sfidSum').value},
		function( data ) {
			if(data!=null){				
				var dataPartes = data.split("$");
				var dataCodigo = dataPartes[0]; 
				var dataMensaje = dataPartes[1]; 
				if(dataCodigo!=null && dataCodigo!=dataPartes && dataMensaje!=null){
					//window.location="../private/entidadSuministro?sfid=a0U5B000000DkEqUAK";
					if(document.getElementById('divInsertError') != null && document.getElementById('divInsertError').style.display=='block'){
						document.getElementById('divInsertError').style.display='none';
					}				
					ocultarCargando();
					document.getElementById('idCodigo').innerText ="Código:"+" "+dataCodigo;
					document.getElementById('idMensaje').innerText ="Mensaje:"+" "+dataMensaje;
					document.getElementById('divCaseCorteCreatedError').style.display='block';
					
				}
				else{				
					window.location=data;
				}
			}				
		}
	);
}

//Crear caso corte programado
function crearCasoCorteProgramado(){
	
	verCargando();
	$.post( "../private/goCrearCasoBySuministroAndCorte",
		{causa: 'progr', sfidSum: document.getElementById('sfidSum').value},
		function( data ) {
			if(data!=null){	
				var dataPartes = data.split("$");
				var dataCodigo = dataPartes[0]; 
				var dataMensaje = dataPartes[1]; 	
				if(dataCodigo!=null && dataCodigo!=dataPartes && dataMensaje!=null){
					if(document.getElementById('divInsertError') != null && document.getElementById('divInsertError').style.display=='block'){
						document.getElementById('divInsertError').style.display='none';
					}
					ocultarCargando();
					document.getElementById('idCodigo').innerText ="Código:"+" "+dataCodigo;
					document.getElementById('idMensaje').innerText ="Mensaje:"+" "+dataMensaje;
					document.getElementById('divCaseCorteCreatedError').style.display='block';
				}
				else{				
					window.location=data;
				}
			}				
		}
	);
}
