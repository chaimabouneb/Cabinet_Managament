package cabinet_management;

public class Objectif {
    private String nom;
    private Terme terme;
    private int note;

    public void Objectif() {
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
}
