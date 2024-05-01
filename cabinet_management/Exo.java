package cabinet_management;

public class Exo {
    private String consigne;
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

    public void setScore(double s) {
        this.score = s;
    }

    public double getScore() {
        return score;
    }
}
