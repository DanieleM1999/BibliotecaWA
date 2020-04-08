<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 >Richiesta dati per la registrazione</h3>


<form action="registraDipendente" method="post">
<label for="user">Inserisci Username:</label>
<input type="text" placeholder="Username" name="user" id="user"><br>
<label for="pass">Inserisci Password:</label>
<input style="margin-top:0.5%;" type="Password" placeholder="password" name="pass" id="pass"><br>		
<input style="padding: 8px;margin-left:15%;margin-top:0.5%;" type="submit" value="Conferma" >
</form> 

<form action="HomeDipendente.jsp">
<input style="padding: 8px;margin-left:15%;margin-top:0.5%;" type="submit" value="Indietro">
</form>
</body>
</html>