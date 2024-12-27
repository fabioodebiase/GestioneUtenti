# Gestione Utenti

## Descrizione
Il progetto è un'applicazione web per gestire una lista di utenti. Consente di aggiungere, visualizzare, modificare ed eliminare utenti, con un'interfaccia basata su JSP, Servlets e database relazionale.

---

## Funzionalità
- **Visualizzazione**: Mostra tutti gli utenti in una tabella.
- **Aggiunta**: Permette di aggiungere nuovi utenti tramite un modulo.
- **Modifica**: Consente di aggiornare i dettagli di un utente.
- **Eliminazione**: Rimuove un utente dal database.
- **Validazione della Data**: Verifica che la data di nascita non sia futura.

---

## Tecnologie Utilizzate
- **Backend**: Java, Servlets
- **Database**: MySQL
- **Frontend**: HTML, CSS, JavaScript, JSP

---


## Struttura del Progetto
- **Frontend**:
  - `index.jsp`: Mostra la lista utenti.
  - `inserisciUtente.jsp`: Modulo per aggiungere nuovi utenti.
  - `modificaUtente.jsp`: Modulo per modificare i dati di un utente.

- **Backend**:
  - Servlets:
    - `InserisciUtenteServlet`: Gestisce l'aggiunta di nuovi utenti.
    - `ModificaUtenteServlet`: Permette di aggiornare i dati utente.
    - `EliminaUtenteServlet`: Elimina un utente.
  - DAO:
    - `UtenteDAO`: Gestisce la connessione al database e le operazioni CRUD.
  -Entities:
  - `Utente`: Classe per la gestione di un utente.
---
