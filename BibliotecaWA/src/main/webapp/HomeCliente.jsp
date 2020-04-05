<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 >Richiesta dati per il Login</h3>


<form action="accediCliente" method="post">
<label for="user">Inserisci Username:</label>
<input type="text" placeholder="Username" name="user" id="user"><br>
<label for="pass">Inserisci Password:</label>
<input style="margin-top:0.5%;" type="Password" placeholder="password" name="pass" id="pass"><br>		
<input style="padding: 8px;margin-left:15%;margin-top:0.5%;" type="submit" value="Conferma" >
</form> 
<br><br><br>
<form action="Start.jsp">
<input style="padding: 8px;margin-left:15%;margin-top:0.5%;" type="submit" value="Indietro">
</form>
<h3>Registrati se sei nuovo su questo sito!</h3>

<form action="RegistraCliente.jsp">
<input style="padding: 8px;margin-left:15%;margin-top:0.5%;" type="submit" value="REGISTRATI!">
</form>
</body>
</html>