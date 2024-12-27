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
import java.util.Date;

@WebServlet("/ModificaUtente")
public class ModificaUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idUtente"));
        Utente findUtente = UtenteDAO.getUtenteById(id);
        req.setAttribute("utente",findUtente);
        req.getRequestDispatcher("modificaUtente.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utente updateUtente = new Utente();
        updateUtente.setIdUtente(Integer.parseInt(req.getParameter("idUtente")));
        updateUtente.setNome(req.getParameter("nomeUtente"));
        updateUtente.setCognome(req.getParameter("cognomeUtente"));
        updateUtente.setEmail(req.getParameter("emailUtente"));
        String data = req.getParameter("dataNascitaUtente");

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date dataNascita = inputFormat.parse(data);
            updateUtente.setDataNascita(dataNascita);
            UtenteDAO.updateUtente(updateUtente);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
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
