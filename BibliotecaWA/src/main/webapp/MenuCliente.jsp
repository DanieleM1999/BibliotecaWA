<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Scegli cosa vuoi fare:</h1><br><br>
	<form action="login">
		<label for="SceltaOperazioni"></label> <select
			name="SceltaOperazioni">
			<option value="HomeDipendente">Compra un libro</option>
			<option value="HomeCliente">Affitta un libro</option><br>
		</select> <input type="submit" value="Conferma">
	</form>
</body>
</html>