package cabinet_management;

import java.util.List;

public class Qcm extends Question implements Reponse {
    private List<Integer> reponses;
    private List<Integer> correctreponse;

    public Qcm(String question, List<String> options, Cat_Quest type, List<Integer> cor, int n) {
        super(question, options, type, n);
        this.correctreponse = cor;
    }

    @Override
    public void setuserselction(List<Integer> reponses) {
        // Validate user answer indices
        for (int index : reponses) {
            if (index < 0 || index >= super.options.size()) {
                throw new IllegalArgumentException("Invalid user answer index: " + index);
            }
        }
        this.reponses = reponses;

    }

    @Override

    public void setScore() {
        int totalCorrectChoices = correctreponse.size();
        int userCorrectChoices = 0;

        // Count the number of correct choices selected by the user
        for (int userChoice : reponses) {
            if (correctreponse.contains(userChoice)) {
                userCorrectChoices++;
            }
        }

        // Calculate the score
        double score;
        if (totalCorrectChoices == 0) {
            // No correct choices, so score is 0
            score = 0;
        } else {
            score = ((double) userCorrectChoices / totalCorrectChoices) * super.note;
        }

        // Set the score
        super.score = score;
    }

    public void setCorrectAnswerIndices(List<Integer> correctAnswerIndices) {
        // Validate correct answer indices
        for (int index : correctAnswerIndices) {
            if (index < 0 || index >= options.size()) {
                throw new IllegalArgumentException("Invalid correct answer index: " + index);
            }
        }
        this.correctreponse = correctAnswerIndices;
    }

    // Method to check if a given answer index is correct
    public boolean isAnswerCorrect(int userAnswerIndex) {
        return correctreponse.contains(userAnswerIndex);
    }

    public List<Integer> getUserAnswerIndices() {
        return reponses;
    }

}
