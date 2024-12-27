<%@ page import="entities.Utente" %>
<%@ page import="DAO.UtenteDAO" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Inserisci Utente</title>
    <link rel="stylesheet" href="inserisci.css">
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
    <span class = "error">La data non e' valida</span>
    <input type="submit" value="Inserisci Utente" class = "submit">
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
