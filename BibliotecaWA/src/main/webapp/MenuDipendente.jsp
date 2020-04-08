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
	<form action="menuDipendente">
		<label for="SceltaOperazioni"></label> <select
			name="SceltaOperazioni">
			<option value="aggiungiLibro">Aggiungi libro</option>
			<option value="modificaQuantita">Modifica inventario</option>
			<option value="rimuoviLibro">Rimuovi dall'inventario</option>
			<option value="stampaLista">Stampa elenco</option>
			<option value="acquistaLibro">Compra un libro</option>
			<option value="affittaLibro">Affitta un libro</option>
			<option value="visualizzaAcquisti">I miei acquisti</option>
			<option value="visualizzaPrenotazioni">i miei ordini</option><br>
		</select> <input type="submit" value="Conferma">
	</form>
</body>
</html>