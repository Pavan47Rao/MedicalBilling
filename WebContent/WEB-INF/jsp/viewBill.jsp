<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css">
	body {
		background-image: url('https://cdn.crunchify.com/bg.png');
	}
	</style>
</head>
<body>
	<div style="text-align: center">
		<h2>
		Patient and the bill details<br> <br>
		</h2>
		<table style="padding-left:37%">
		
			<tr>
		    	<th>Patient Id</th>
		    	<th>First Name</th>
		   		<th>Last Name</th>
		   	</tr>
		   	
		   	<tr>
		   		<td>${patient.getId()}</td>
		   		<td>${patient.getFirstName()}</td>
		   		<td>${patient.getLastName()}</td>
		   	</tr>
			<tr></tr>
			<tr>
		    	<th>Code</th>
		    	<th>Procedure/Item</th>
		   		<th>Cost</th>
		   	</tr>
		    <c:forEach items="${items}" var="billItem">
		    	<tr>
		            <td><c:out value="${billItem.getCode()}"/></td>
		            <td><c:out value="${billItem.getDesc()}"/></td>
		            <td>$<c:out value="${billItem.getCost()}"/></td>  
		        </tr>
		    </c:forEach>
		    <tr>
		    	<th>Total Cost</th>
		    	<td></td>
		    	<td>$${total}</td>
		    </tr>
		    <tr>
		        <td><a href="/MedicalBilling/selectPatient"> Go to patient menu</a></td>
		    </tr>
		</table>
	</div>
</body>
</html>