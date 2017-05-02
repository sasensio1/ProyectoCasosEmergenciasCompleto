//Funcion que oculta o muestra todos los suministros de una cuenta.
function allSuministros(numeroSuministros){	
	verCargando();
	$.post("../private/listarSuministrosCuenta",
			{sfidCuenta: document.getElementById('sfidCuenta').value,
			numSuministros: numeroSuministros},
			function(data) {
				ocultarCargando();
				var tablaDatos=  document.getElementById("tablaSuministros");
				var longTabla = tablaDatos.rows.length;
				
				//eliminamos los registros de la tabla actual, !Cuidado! no eliminar la fila 0 que es la cabecera
				for(i = 1; i<longTabla; i++){
					tablaDatos.deleteRow(1);
				}
				
				//Añadimos registros a la tabla nueva. Vamos insertando la fila 1 e iremos recorriendo de manera inversa 
				//la lista de suministros para guardarlos en la tabla
				for(j=data.length -1 ; j >= 0; j--){
					
					var fila= data[j];
					var row = tablaDatos.insertRow(1);
					
					var numero = document.createElement("a");
					numero.href = '../private/entidadSuministro?sfid=' + fila.sfid;
					numero.className = "link";
					numero.text =fila.name;
					
					var numeroSuministro = row.insertCell(0);
				    numeroSuministro.appendChild(numero);				    
				    var idEmpresa = row.insertCell(1);
				    idEmpresa.innerHTML = fila.labelEmpresaPickList;				    
				    var estadoConexcion = row.insertCell(2);
				    estadoConexcion.innerHTML = fila.labelEstadoConexionPickList;				    
				    var estadoSuministro = row.insertCell(3);
				    estadoSuministro.innerHTML = fila.labelEstadoSuministroPickList;				    
				    var electrodependiente = row.insertCell(4);
				    electrodependiente.innerHTML = fila.labelElectrodependientePickList;				    
				    var fechaCorte = row.insertCell(5);
				    fechaCorte.innerHTML =  fila.fechaCorteString;			    
				    var direccionSumiistro = row.insertCell(6);
				    direccionSumiistro.innerHTML = fila.direccionConcatenada;
				    
				    var comuna = row.insertCell(7);
				    comuna.innerHTML =fila.comuna;

				} 
				
				if(numeroSuministros == 'All'){
					//mostramos href 'Mostar 10'
					document.getElementById('hrefNoTodosSuministros').hidden = false;
					document.getElementById('hrefTodosSuministros').hidden = true;
				}else{
					//mostramos href 'Mostar todos'
					document.getElementById('hrefNoTodosSuministros').hidden = true;
					document.getElementById('hrefTodosSuministros').hidden = false;

					
				}
		}); 	
	
}

