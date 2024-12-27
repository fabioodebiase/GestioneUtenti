<%@ page import="entities.Utente" %>
<%@ page import="DAO.UtenteDAO" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="home.css">
</head>
<body>
<%
ArrayList<Utente> listaUtenti = UtenteDAO.getListaUtenti();
    %>

    <h2>Gestione Utenti</h2>
    <div class="inserisci-container">
        <a href="inserisciUtente.jsp"><span class="inserisci">Inserisci Utente</span></a>
    </div>

    <div class="container">
        <% if (listaUtenti != null && !listaUtenti.isEmpty()) { %>
        <div class="table-container">
            <table border="1" cellpadding="10" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Email</th>
                    <th>Data di Nascita</th>
                    <th>Azioni</th>
                </tr>
                </thead>
                <tbody>
                <% for (Utente utente : listaUtenti) { %>
                <tr>
                    <td><%= utente.getIdUtente() %></td>
                    <td><%= utente.getNome() %></td>
                    <td><%= utente.getCognome() %></td>
                    <td><%= utente.getEmail() %></td>
                    <input type="hidden" value="<%= utente.getDataNascita() %>" class="dataNascita">
                    <td class="dataNascitaUtente"></td>
                    <td>
                        <a href="EliminaUtente?idUtente=<%= utente.getIdUtente() %>"><button class="delete">Elimina</button></a>
                        <a href="ModificaUtente?idUtente=<%= utente.getIdUtente() %>"><button class="modify">Modifica</button></a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <% } else { %>
        <span class="null-value">Lista vuota!</span>
        <% } %>
    </div>
    <script>
        // Ottieni tutti gli elementi con la classe "dataNascita"
        let dataElements = document.querySelectorAll(".dataNascita");
        let dataNascitaUtenteElements = document.querySelectorAll(".dataNascitaUtente");

        // Itera su ogni elemento e modifica il contenuto
        dataElements.forEach((dataElement, index) => {
            let data = dataElement.value;

            // Dividi la data in anno, mese e giorno
            let array = data.split("-");
            let anno = array[0];
            let mese = array[1];
            let giorno = array[2];

            // Aggiorna il corrispondente elemento di visualizzazione
            if (dataNascitaUtenteElements[index]) {
                dataNascitaUtenteElements[index].innerHTML = `${giorno}/${mese}/${anno}`;
            }
        });
    </script>
</body>
</html>
