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
<form action = "/savePatient">
Id: <input type="number" id="pId"> <br> <br>
First Name: <input type="text" id="pFirstName"> <br><br>
Last Name: <input type="text" id="pLastName"> <br><br>
<input type="submit" value="ADMIT">
</form>
</div>
</body>
</html>