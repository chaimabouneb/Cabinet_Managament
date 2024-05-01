package cabinet_management;

import java.util.List;;

public class TestExo extends Test {
    private List<Exo> exos;

    public TestExo(List<Exo> EXOS) {
        this.exos = EXOS;
    }

    public void ajouterExo(Exo e) {
        exos.add(e);
    }

    @Override
    public void Calc_Score() {
        double totalScore = 0;

        // Iterate over each question and add its score to the total score
        for (Exo question : exos) {
            int index = 0;
            double s = 0;
            for (Exo exo : exos) {
                if (exo.consigne.equals(question)) {
                    index++;
                    s += exo.getScore();
                }
            }
            totalScore += (s / index);
        }
        super.Test(totalScore);
    }

}
