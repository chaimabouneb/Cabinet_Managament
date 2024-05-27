package cabinet_management;

import java.io.Serializable;

public abstract class Test  implements Serializable{
    private String nom;
    private double score;
    private String conclusion;

    public Test() {}

    public Test(String nom) {
        this.nom = nom;
    }

    public Test(String nom, double score, String conclusion) {
        this.nom = nom;
        this.score = score;
        this.conclusion = conclusion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract void Calc_Score();

    public void ajouterConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public double getScore() {
        return score;
    }

    protected void setScore(double score) {
        this.score = score;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String c){
        this.conclusion=c;

    }
}

