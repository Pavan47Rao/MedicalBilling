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
<br>
	<div style="text-align: center">
		<h2>
			Hi ${admin.getFirstName()} ${admin.getLastName()}, Choose from the operations below<br> <br>
		</h2>
		<h3>
			<a href="admitPatient.html">Admit a Patient</a>
		</h3>
		<h3>
			<a href="updateBill.html">Update bill of the patient</a>
		</h3>
	</div>
</body>
</html>