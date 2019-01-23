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
    private Long frequenceDeplacement;
    private Long porteeVisuel;

    private Localisation maLocalisation;

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

    public Long getFrequenceDeplacement() {
        return frequenceDeplacement;
    }

    public void setFrequenceDeplacement(Long frequenceDeplacement) {
        this.frequenceDeplacement = frequenceDeplacement;
    }

    public Long getPorteeVisuel() {
        return porteeVisuel;
    }

    public void setPorteeVisuel(Long porteeVisuel) {
        this.porteeVisuel = porteeVisuel;
    }

    public Localisation getMaLocalisation() {
        return maLocalisation;
    }

    public void setMaLocalisation(Localisation maLocalisation) {
        this.maLocalisation = maLocalisation;
    }
}
