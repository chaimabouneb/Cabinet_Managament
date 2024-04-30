package cabinet_management;

import java.io.Serializable;

public class Orthophoniste implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private String mtpasse;
    private String email;

    public Orthophoniste() {
    }

    public Orthophoniste(String nom) {
        this.nom = nom;
    }

    public Orthophoniste(String nom, String prenom, String adresse, String numero,
            String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero = numero;
        this.email = email;
        this.mtpasse = null;

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

}
