package cabinet_management;

public class Libre extends Question {
    private String reponse;
    private String correctreponse;
    private double scoree;

    public Libre() {
    };

    public Libre(String question, Cat_Quest type, String correction, int n) {
        super(question, type, n);
        correctreponse = correction;

    };

    public void setRponse(String s) {
        reponse = s;
    }

    public void setscore(double s) {
        this.scoree = s;
    }

}
