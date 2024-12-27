package entities;

import java.util.Date;

public class Utente {
    private int idUtente;
    private String nome;
    private String cognome;
    private String email;
    private Date dataNascita;

    //costruttore di default
    public Utente() {

    }



    //costruttore con parametri
    public Utente(String nome, String cognome,String email, Date dataNascita ){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
    }

    //creo i getter e i setter per gli attributi private

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
}
