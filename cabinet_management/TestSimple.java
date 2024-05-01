package cabinet_management;

import java.util.HashSet;

public class TestSimple extends Test {
    private HashSet<Question> questions;

    public TestSimple(HashSet<Question> questions) {
        this.questions = questions;
    }

    @Override
    public double Calc_Score() {
        double totalScore = 0;

        // Iterate over each question and add its score to the total score
        for (Question question : questions) {
            question.setScore(); // Ensure each question's score is calculated
            totalScore += question.getScore();
        }

        return totalScore;
    }

}
