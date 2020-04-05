<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Benvenuto nella nostra Biblioteca</h1><br><br>
<h3>Per proseguire esegui l'accesso come Dipendente oppure come Cliente:</h3>
	<form action="login">
		<label for="SceltaOperazioni"></label> <select
			name="SceltaOperazioni">
			<h1>Aceddi come </h1>
			<option value="HomeDipendente">Dipendente</option>
			<option value="HomeCliente">Cliente</option><br>
		</select> <input type="submit" value="Conferma">
	</form>
	
</body>
</html>