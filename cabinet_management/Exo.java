package cabinet_management;

public class Exo {
    public String consigne;
    private String material;
    private int note;
    private double score;

    public Exo() {

    };

    public Exo(String s, String m, int n) {
        this.consigne = s;
        this.material = m;
        this.note = n;

    }

    public Exo(String consigne, String materiel) {
        this.consigne = consigne;
        this.material = materiel;
    }

    public String getConsigne() {
        return consigne;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }

    public String getMateriel() {
        return material;
    }

    public void setMateriel(String materiel) {
        this.material = materiel;
    }

    public void setScore(double s) {
        this.score = s;
    }

    public double getScore() {
        return score;
    }
}
