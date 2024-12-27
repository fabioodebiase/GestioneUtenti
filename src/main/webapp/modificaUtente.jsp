<%@ page import="entities.Utente" %>
<%@ page import="DAO.UtenteDAO" %>
<%@ page import="java.util.ArrayList" %>
<%
Utente utente = (Utente) request.getAttribute("utente");
%>
<html>
<head>
    <title>Modifica Utente</title>
    <link rel="stylesheet" href="modificaUtente.css">
</head>
<body>

<h2>Modifica:</h2>
<a href = "index.jsp"><span class = "home">Torna alla Home</span></a>
<form action = "ModificaUtente" method = "POST">
    <input type="hidden" id="idUtente" name="idUtente" value="<%=utente.getIdUtente()%>">
    <label for="nomeUtente"> Nome: </label>
    <input type = "text" name = "nomeUtente" id = "nomeUtente" value = "<%= utente.getNome() %>">


    <label for="cognomeUtente"> Cognome:</label>
    <input type = "text" name = "cognomeUtente" id = "cognomeUtente" value = "<%= utente.getCognome() %>">

    <label for="emailUtente"> Email:</label>
    <input type = "email" name = "emailUtente" id = "emailUtente" value = "<%= utente.getEmail() %>">

    <label for="dataNascitaUtente"> Data di Nascita:</label>
    <input type="date" name="dataNascitaUtente" id = "dataNascitaUtente" value = "<%= utente.getDataNascita() %>" required>

    <input type = "submit" value = "Modifica Utente">
</form>

</body>
</html>