package viniki.ccm.insset.viniki;

import java.io.File;
import java.util.Collection;
import java.util.Date;

public class Utilisateur {
    private String idUtilisateur;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String emailUtilisateur;
    private String adresseUtilisateur;
    private Date dateNaissanceUtilisateur;

    // Options
    private Integer frequenceDeplacement;
    private Integer porteeVisuel;


    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getAdresseUtilisateur() {
        return adresseUtilisateur;
    }

    public void setAdresseUtilisateur(String adresseUtilisateur) {
        this.adresseUtilisateur = adresseUtilisateur;
    }

    public Date getDateNaissanceUtilisateur() {
        return dateNaissanceUtilisateur;
    }

    public void setDateNaissanceUtilisateur(Date dateNaissanceUtilisateur) {
        this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
    }

    public Integer getFrequenceDeplacement() {
        return frequenceDeplacement;
    }

    public void setFrequenceDeplacement(Integer frequenceDeplacement) {
        this.frequenceDeplacement = frequenceDeplacement;
    }

    public Integer getPorteeVisuel() {
        return porteeVisuel;
    }

    public void setPorteeVisuel(Integer porteeVisuel) {
        this.porteeVisuel = porteeVisuel;
    }
}
