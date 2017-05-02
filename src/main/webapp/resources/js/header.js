function cambiarLabel(valorMenu) {
	var label = objetoSeleccionado;
	if (valorMenu != null && valorMenu != 'undefined' && valorMenu != '') {
		label = valorMenu;
	}
	document.getElementById('lblMenu').innerHTML= label;
}

function initHeader() {
	$(document).ready(function() {
		cambiarLabel(null);
	    $("#botonDesplegable").click(function(){
	    	desplegarMenu();
	    });
	    $(".menuListado").click(function(){
	    	desplegarMenu();
	    });
	    var divLista = $('#desplegable');
	    var botonDes = $("#botonDesplegable");
	    $(document).bind('click',function(event){
	    	if(divLista.is(':visible') && event.target != divLista[0]
	    	 && event.target != botonDes[0]){
	    		$('#desplegable').hide();
	    	}
	    });
	    function desplegarMenu(){
	    	if(divLista.is(':visible')){
	    		$('#desplegable').hide();
	    	}else{
	    		$('#desplegable').show();
	    	}
	    }
	});
}