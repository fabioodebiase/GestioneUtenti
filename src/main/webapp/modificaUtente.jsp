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
    <span class = "error">La data non e' valida</span>
    <input type = "submit" value = "Modifica Utente" class = "submit">
</form>

<script>
    let dataInput = document.getElementById("dataNascitaUtente");
    let today = new Date();
    let error = document.querySelector(".error");
    let submit = document.querySelector(".submit");
    dataInput.addEventListener("change", () => {
        let data = dataInput.value;
        let selectedDate = new Date(data);

        // Controlla se la data selezionata è successiva a oggi
        if (selectedDate > today) {
           error.style.display = "block";
            submit.style.display = "none"
        } else {
            error.style.display = "none";
            submit.style.display = "block"
        }
    });
</script>

</body>
</html>