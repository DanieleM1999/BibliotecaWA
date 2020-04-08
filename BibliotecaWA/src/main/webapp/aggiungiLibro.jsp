<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 >Inserisci i dati del libro:</h3>


<form action="aggiungiLibro" method="post">
<label for="titolo">Inserisci titolo:</label>
<input type="text" placeholder="titolo" name="titolo" id="titolo"><br>
<label for="autore">Inserisci autore:</label>
<input type="text" placeholder="autore" name="autore" id="autore"><br>
<label for="qntt">Inserisci quantita totale:</label>
<input type="text" placeholder="00" name="qntt" id="qntt"><br>
<label for="qntn">Inserisci quantita noleggio:</label>
<input type="text" placeholder="00" name="qntn" id="qntn"><br>
<input style="padding: 8px;margin-left:15%;margin-top:0.5%;" type="submit" value="Conferma" >
</form> 
<br><br><br>
<form action="MenuDipendente.jsp">
<input style="padding: 8px;margin-left:15%;margin-top:0.5%;" type="submit" value="Indietro">
</form>


</form>
</body>
</html>