package cabinet_management;

import java.io.Serializable;

public class Trouble implements Serializable {
    private String nom;
    private CategorieTrouble categorie;

    public Trouble(String nom, CategorieTrouble categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CategorieTrouble getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieTrouble categorie) {
        this.categorie = categorie;
    }
}
