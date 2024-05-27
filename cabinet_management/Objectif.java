package cabinet_management;

import java.io.Serializable;

public class Objectif implements Serializable {
    private String nom;
    private Terme terme;
    private int note;

    public Objectif(String n) {
        this.nom = n;
    };

    public void Objectif(String nom,
            Terme terme) {

        this.nom = nom;
        this.terme = terme;
    };

    public void setNote(int n) {
        note = n;
    }

    public int getNote() {
        return note;
    }

    public String getNom() {
        return this.nom;
    }
}
