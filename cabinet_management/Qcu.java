package cabinet_management;

import java.util.List;

public class Qcu extends Question implements Reponse {

    private int reponse;
    private int correctanswer;

    public Qcu(String question, List<String> options, Cat_Quest type, int cor, int n) {
        super(question, options, type, n);
        this.correctanswer = cor;
    }
    @Override
    public void setScore() {
        // Calculate the score
        double score;
        if (reponse == correctanswer) {
            score = super.note; // Full score for a correct answer
        } else {
            score = 0; // 0 score for an incorrect answer
        }
    
        // Set the score
        super.score = score;
    }
    public int getCorrectAnswer() {
        return correctanswer;
    }

    public boolean isAnswerCorrect(String userAnswer) {
        return userAnswer.equals(correctanswer);
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
