package cabinet_management;

import java.util.List;

public class Qcm extends Question implements Reponse {
    private List<Integer> reponses;
    private List<Integer> correctreponse;

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
