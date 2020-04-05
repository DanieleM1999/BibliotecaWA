<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Sezione dedicata ai dipendenti</h4>
<h3>Accedi al sito con il tuo profilo</h3>
	<form action="accediDipendente">
		<label for="nome">Inserisci l'username:</label> <br> 
		<input type="text" id="nome" name="nome"> <br><br> 
		<label for="password">Inserisci la password:</label> <br> 
		<input type="text" id="password" name="password"><br><br> 
		<input type="submit" value="Conferma">
	</form>
<br><br><br><br>
	<h3>Registrati se sei nuovo su questo sito!</h3>
	<form action="registraDipendente">
		<label for="nome">Inserisci l'username:</label> <br> 
		<input type="text" id="nome" name="nome"> <br><br> 
		<label for="password">Inserisci la password:</label> <br> 
		<input type="text" id="password" name="password"><br><br> 
		<input type="submit" value="Conferma">
	</form>
</body>
</html>