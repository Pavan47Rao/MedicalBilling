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
		
		<form:form method="POST" action="/MedicalBilling/updateBill" modelAttribute="expense">
		    <table style="padding-left:43%">
		        <tr>
		        	<td>User:</td>
                    <td><form:select path="patientId" items="${userIds}" /></td>
		        </tr>
		        <tr>
		        	<td>Service:</td>
                    <td><form:select path="service" items="${services}" /></td>
		        </tr>
		        <tr>
		            <td><input type="submit" value="Update Bill"/></td>
		        </tr>
		        <tr>
		            <td><a href="/MedicalBilling/uploadBill">Upload Bill</a></td>
		        </tr>
		        <tr>
		        	<td><a href="admin.html">Go to Admin menu</a></td>
		     	</tr>
		    </table>
		</form:form>
	</div>
</body>
</html>