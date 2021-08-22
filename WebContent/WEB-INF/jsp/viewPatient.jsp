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
		Admitted Patient details:<br> <br>
		</h2>
		<table style="padding-left:43%">
			<tr>
		       <td>Id</td>
		       <td>${patientDetails.getId()}</td>
		    </tr>
		    <tr>
		       <td>First Name</td>
		       <td>${patientDetails.getFirstName()}</td>
		    </tr>
		    <tr>
		        <td>Last Name</td>
		        <td>${patientDetails.getLastName()}</td>
		    </tr>
		     <tr>
		        <td><a href="admin.html">Go to Main menu</a></td>
		     </tr>
		 </table>
	</div>
</body>

</html>