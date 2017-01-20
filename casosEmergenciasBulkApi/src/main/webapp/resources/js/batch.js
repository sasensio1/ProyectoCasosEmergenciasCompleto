//Metodo que muestra el submenú de API REST

function showBatchBulkApiSubMenu() {
	$('#divBatchBulkApiSubMenu').show();			
}
//Metodo que oculta el submenú de API REST
function hideBatchBulkApiSubMenu() {
	$('#divBatchBulkApiSubMenu').hide();			
}
//Metodo que muestra el menu de fechas de ejecucion

function showTableExecutionDate() {
	$('#tableExecutionDate').show();			
}
//Metodo que oculta el menu de fechas de ejecucion
function hideTableExecutionDate() {
	$('#tableExecutionDate').hide();			
}
//Metodo que setea el proceso seleccionado
function setProcessSelected(processSelected) {
	document.getElementById("process").value=document.getElementById(processSelected).value;			
}

//Redirigimos al metodo del proceso batch del controlador correspondiente

function processBatchControllerMethodRedirection() {
	var maxProcessedDays= document.getElementById("maxProcessedDays").value;
	var startProcess= document.getElementById("filtroComienzoEjecucioBatchMenuId").value;
	var endProcess= document.getElementById("filtroFinEjecucioBatchMenuId").value;
	var proccess= document.getElementById("process").value;
	
	$('#divErrorComienzoEjecucionSuperior').hide();	
	$('#divErrorTiempoEjecucionSuperior').hide();		
	
	startProcess=addSeconsToDateValue(startProcess);
	endProcess=addSeconsToDateValue(endProcess);


	
		switch (proccess)
		{
		   case "pickListTableElection": 
			   window.location="../private/updateHerokuPickListTable";
			   verCargando();
			   break;	   
		   case "fieldLabelTableElection": 
		   	   window.location="../private/updateHerokuFieldLabelTable";
		   	   verCargando();
			   break;		   
		   case "apiRestElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=";
		   	   }
			   break;
		   case "accountElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=Account";
		   	   }
			   break;
		   case "addressElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=Address__c";
		   	   }
			   break;
		   case "assetElection"  : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=Asset";
		   	   }
			   break;
		   case "caseHistoryElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=CaseHistory";
		   	   }
			   break;
		   case "contactElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=Contact";
		   	   }
			   break;
		   case "groupElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=Group";
		   	   }
			   break;
		   case "pointOfDeliveryElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=PointofDelivery__c";
		   	   }
			   break;
		   case "repeatedCasesElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=RepeatedCases__c";
		   	   }
			   break;
		   case "caseCommentElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=CaseComment";
		   	   }
			   break;
		   case "herokuUserElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=HerokuUser__c";
		   	   }
			   break;
		   case "serviceProductElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=ServiceProduct__c";
		   	   }
			   break;
		   case "streetElection" : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=Street__c";
		   	   }
			   break;
		   case "taskElection"  : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=Task";
		   	   }
			   break;
		   case "userElection"  : 
		   	   if(checkBatchDatesExecution(startProcess,endProcess)){
		   		   window.location="../private/updateObjectTablesFromSalesforceApi?processStartDateString="+startProcess+"&processEndDateString="+endProcess+"&objectName=User";
		   	   }
			   break;
			   		
	}
}

function checkBatchDatesExecution(startProcess,endProcess){	
	if(startProcess>endProcess){
		$('#divErrorComienzoEjecucionSuperior').show();	
		return false;
	}
	else{
		if(startProcess!=""&&endProcess!="" ){
			restaFechas=restarFechas(startProcess,endProcess);
			if(restaFechas>=maxProcessedDays){
				$('#divErrorTiempoEjecucionSuperior').show();	
				return false;
			}
			else{	
				verCargando();
				return true;
			}	
		}
		else{
			return true;
		}
	}
}