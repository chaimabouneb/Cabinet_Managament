package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Patient implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private LocalDate datenes;
    private String lieunes;
    private boolean admet = false;
    private String Gender;

    // Constructeur principal
    public Patient(String n) {
        this.nom = n;
    }

    // Autres constructeurs pour initialiser différents champs
    public Patient(String nom, String prenom, String adresse, LocalDate datenes, String lieunes) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.datenes = datenes;
        this.lieunes = lieunes;
    }

    // Getters et setters
    public boolean isAdmet() {
        return admet;
    }

    public void setAdmet() {
        this.admet = true;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDatenes() {
        return datenes;
    }

    public void setDatenes(LocalDate datenes) {
        this.datenes = datenes;
    }

    public String getLieunes() {
        return lieunes;
    }

    public void setLieunes(String lieunes) {
        this.lieunes = lieunes;
    }
}
