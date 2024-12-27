<%@ page import="entities.Utente" %>
<%@ page import="DAO.UtenteDAO" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Inserisci Utente</title>
    <link rel="stylesheet" href="inserisciUtente.css">
</head>
<body>

<h2>Inserisci Utente</h2>

<div class="home-container">
    <a href="index.jsp" class="home">Torna alla Home</a>
</div>

<form action="InserisciUtente" method="POST">
    <label for="nomeUtente"> Nome: </label>
    <input type="text" name="nomeUtente" id="nomeUtente" required>

    <label for="cognomeUtente"> Cognome:</label>
    <input type="text" name="cognomeUtente" id="cognomeUtente" required>

    <label for="emailUtente"> Email:</label>
    <input type="email" name="emailUtente" id="emailUtente" required>

    <label for="dataNascitaUtente"> Data di Nascita:</label>
    <input type="date" name="dataNascitaUtente" id="dataNascitaUtente" required >

    <input type="submit" value="Inserisci Utente">
</form>
<script>
    let data = document.getElementById("dataNascitaUtente").value;
    console.log(data)
</script>
</body>
</html>
