package cabinet_management;

public abstract class Test {
    private String nom;
    private int score;
    private String conclusion;

    public void Test() {
    };

    public void Test(String nom, int score, String conclusion) {

        this.nom = nom;
        this.score = score;
        this.conclusion = conclusion;
    };

    public abstract double Calc_Score();

}
