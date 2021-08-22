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
		Pick a patient to view their bill<br> <br>
		</h2>
		
		<form:form method="POST" action="/MedicalBilling/viewBill" modelAttribute="patient">
		    <table style="padding-left:43%">
		        <tr>
		        	<td>Patient Id:</td>
                    <td><form:select path="id" items="${userIds}" /></td>
		        </tr>
		        <tr>
		            <td><input type="submit" name="nextPage" value="View Bill in Next Page"/></td>
		            <td><input type="submit" name="console" value="View Bill in Console"/></td>
		        </tr>
		        <tr>
		            <td><a href="/MedicalBilling/unauthorizedAdmitPatient"> Admit Patient</a></td>
		            <td><a href="/MedicalBilling/unauthorizedUpdateBill">Update Bill</a></td>
		        </tr>
		        <tr>
		            <td><a href="index.jsp"> Go to main menu</a></td>
		        </tr>
		    </table>
		</form:form>
	</div>
</body>

</html>