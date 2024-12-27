package controllers;

import DAO.UtenteDAO;
import entities.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/InserisciUtente")
public class InserisciUtenteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nomeUtente");
        String cognome = req.getParameter("cognomeUtente");
        String email = req.getParameter("emailUtente");
        String data = req.getParameter("dataNascitaUtente");

        // Formato per la conversione della data
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Converte la data dal formato yyyy-MM-dd in un oggetto Date
            Date dataNascita = inputFormat.parse(data);
            Utente newUtente = new Utente(nome,cognome,email,dataNascita);
            UtenteDAO.aggiungiUtente(newUtente);

            resp.sendRedirect("index.jsp");
        } catch (ParseException e) {

            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato della data non valido. Assicurati di utilizzare il formato yyyy-MM-dd.");
        } catch (RuntimeException e) {
            // Gestione di eventuali errori runtime
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Si è verificato un errore durante l'elaborazione della richiesta.");
        }
    }
}