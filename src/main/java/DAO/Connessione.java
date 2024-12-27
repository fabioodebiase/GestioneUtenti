package DAO;

import java.sql.*;

public class Connessione {
    String url = "jdbc:mysql://localhost:3306/gestioneutenti";
    String username = "root";
    String password = "root";
    public Connection connessioneDB(){ //restituisce un parametro di tipo Connection
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection(url,username,password);

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trovato");

        } catch (SQLException e){
            System.out.println("Connessione fallita!");
        }

        return null;
    }

}