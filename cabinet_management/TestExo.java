package cabinet_management;

import java.util.List;;

public class TestExo extends Test {
    private List<Exo> exos;

    public TestExo(List<Exo> EXOS) {
        this.exos = EXOS;
    }

    @Override
    public double Calc_Score() {
        double totalScore = 0;

        // Iterate over each question and add its score to the total score
        for (Exo question : exos) {

            totalScore += question.getScore();
        }

        return totalScore;
    }

}
