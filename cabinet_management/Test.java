package cabinet_management;

import java.io.Serializable;

public abstract class Test implements Serializable {
    private String nom;
    private double score;
    private String conclusion;

    public void Test() {
    };

    public void Test(double s) {
        this.score = s;
    }

    public void Test(String nom, double score, String conclusion) {

        this.nom = nom;
        this.score = score;
        this.conclusion = conclusion;
    };

    public abstract void Calc_Score();

    public void ajouterConclusion(String s) {
        this.conclusion = s;
    }

}
