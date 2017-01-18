<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.png">
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />	
		

		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/jQueryDatatables.js"></script>
		<script src="../resources/js/header.js"></script>
		<script src="../resources/js/utils.js"></script>
		<script src="../resources/js/historicBatchDataTable.js"></script>
	</head>
	<body onload="initHeader();">
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_menuBatch"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		 
		<form id="formMenuBatch" action="homeHistoricBatchsAction" method="POST">
		<div id="batchPrincipalMenu">
             <input type="radio" id="PiclListTableButton" value="radio1" CHECKED>
             PickList Table
            <BR>
            <input type="radio" id="FieldaLabelTableButton" value="radio2">
             Field Lable Table
            <BR>
            <input type="radio" id="CaseCommentButton" value="radio3">
             Case Comment
            <BR>
            <input type="radio" id="HerokuUserButton" value="HerokuUser__c">
             Heroku User
            <BR>
            <input type="radio" id="ApiRestButton" value="radio3">
             API REST
        </div>
        <div id="batchBulkApiSubMenu">
            <input type="radio" id="AccountButton" value="Account" CHECKED>
             Account
            <BR>
            <input type="radio" id="AddressButton" value="Address__c">
             Address
            <BR>
            <input type="radio" id="AssetButton" value="Asset">
             Asset
            <BR>
            <input type="radio" id="CaseHistoryButton" value="CaseHistory">
             CaseHistory
            <BR>
            <input type="radio" id="ContactButton" value="Contact">
             Contact
            <BR>
            <input type="radio" id="GroupButton" value="Group">
             Group
            <BR>
            <input type="radio" id="PointOfDeliveryButton" value="PointofDelivery__c">
             Point Of Delivery
            <BR>
            <input type="radio" id="RepeatedCasesButton" value="RepeatedCases__c">
             Repeated Cases
            <BR>
            <input type="radio" id="ServiceProductButton" value="ServiceProduct__c">
             Service Product
            <BR>
            <input type="radio" id="StreetButton" value="Street__c">
             Street
            <BR>
            <input type="radio" id="TaskButton" value="Task">
             Task
            <BR>
            <input type="radio" id="UserButton" value="User">
             User
            <BR>
        </div>                   
        <input type="submit" value="Submit">       		       
		</form>
	</body>
</html>