<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		Enter Patient details below<br> <br>
		</h2>
		
		<form:form method="POST" action="/MedicalBilling/admitPatient" modelAttribute="patient">
		    <table style="padding-left:43%">
		        <tr>
		        	<td><form:label path="id">Id</form:label></td>
		            <td><form:input path="id"/></td>
		        </tr>
		        <tr>
		            <td><form:label path="firstName">First Name</form:label></td>
		            <td><form:input path="firstName"/></td>
		        </tr>
		        <tr>
		            <td><form:label path="lastName">Last Name</form:label></td>
		            <td><form:input path="lastName"/></td>
		        </tr>
		        <tr>
		            <td><input type="submit" value="Admit"/></td>
		        </tr>
		    </table>
		</form:form>
	</div>
</body>

</html>