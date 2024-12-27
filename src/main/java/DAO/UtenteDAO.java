package DAO;

import entities.Utente;

import java.sql.*;
import java.util.ArrayList;

public class UtenteDAO {
    //creo un oggetto connessione
    static Connessione connessione = new Connessione();

    //creo un metodo statico per l'inserimento di un utente
    public static void aggiungiUtente(Utente utente) {
        // Stringa SQL per l'inserimento
        String sql = "INSERT INTO utenti (nome, cognome, email, data_nascita) VALUES (?, ?, ?, ?)";

        // Blocco try/catch per verificare la connessione al DB
        try (Connection conn = connessione.connessioneDB();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            if (conn != null) {
                // Impostazione dei parametri per il PreparedStatement
                preparedStatement.setString(1, utente.getNome());
                preparedStatement.setString(2, utente.getCognome());
                preparedStatement.setString(3, utente.getEmail());
                preparedStatement.setDate(4, new java.sql.Date(utente.getDataNascita().getTime()));

                // Esecuzione della query
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            // Log dell'errore e rilancio dell'eccezione
            System.err.println("Errore durante l'inserimento dell'utente: " + e.getMessage());
            throw new RuntimeException("Errore durante l'inserimento dell'utente nel database.", e);
        }
    }

    public static ArrayList<Utente> getListaUtenti(){
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        String sql = "SELECT * FROM utenti";
        try(Connection conn = connessione.connessioneDB()){
            if (conn != null){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){
                    Utente newUtente = new Utente();
                    newUtente.setIdUtente(resultSet.getInt("id_utente"));
                    newUtente.setNome(resultSet.getString("nome"));
                    newUtente.setCognome(resultSet.getString("cognome"));
                    newUtente.setEmail(resultSet.getString("email"));
                    newUtente.setDataNascita(resultSet.getDate("data_nascita"));
                    listaUtenti.add(newUtente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUtenti;
    }

    public static void eliminaUtente(int idUtente){
        String sql = "DELETE FROM utenti WHERE id_utente = ?";
        try(Connection conn = connessione.connessioneDB()){
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1,idUtente);
                preparedStatement.executeUpdate();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static Utente getUtenteById(int id){
        Utente findUtente = new Utente();
        String sql = "SELECT * FROM utenti WHERE id_utente = ?";
        try(Connection conn = connessione.connessioneDB()){
            if (conn != null){

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){

                    findUtente.setIdUtente(resultSet.getInt("id_utente"));
                    findUtente.setNome(resultSet.getString("nome"));
                    findUtente.setCognome(resultSet.getString("cognome"));
                    findUtente.setEmail(resultSet.getString("email"));
                    findUtente.setDataNascita(resultSet.getDate("data_nascita"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findUtente;
    }

    public static void updateUtente(Utente utente) {
        String sql = "UPDATE Utenti SET nome = ?, cognome = ?, email = ?, data_nascita = ? WHERE id_utente = ?";
        try (Connection conn = connessione.connessioneDB()) {
            if (conn != null) {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, utente.getNome());
                preparedStatement.setString(2, utente.getCognome());
                preparedStatement.setString(3, utente.getEmail());
                preparedStatement.setDate(4, new java.sql.Date(utente.getDataNascita().getTime()));
                preparedStatement.setInt(5, utente.getIdUtente());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
