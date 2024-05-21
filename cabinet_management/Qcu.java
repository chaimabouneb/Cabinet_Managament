package cabinet_management;

import java.util.List;

public class Qcu extends Question implements Reponse {

    private int reponse;
    private int correctanswer;

    public Qcu(String question, List<String> options, Cat_Quest type, int cor, int n) {
        super(question, options, type, n);
        this.correctanswer = cor;
    }

    public void setScore(double score) {
        this.score = score;
    }

    

    

    @Override
    public void setuserselction(List<Integer> reponses) {
        if (reponses.size() > 1) {
            throw new IllegalArgumentException("Only one answer can be selected.");
        } else if (reponses.size() == 1) {
            this.reponse = reponses.get(0);
        } else {
            // Handle case when no answer is selected
            // For example, you can set reponse to a default value or throw an error
            throw new IllegalArgumentException("No answer selected.");
        }
    }
}
