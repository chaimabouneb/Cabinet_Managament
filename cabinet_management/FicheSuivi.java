package cabinet_management;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class FicheSuivi {
    private List<Suivi> suivis = null;
    private boolean atteint;

    public void FicheSuivi() {
    };

    public double getTotalScore() {
        double TotalScore = 0;
        for (Suivi s : suivis) {
            TotalScore += s.getNote();

        }
        return TotalScore;
    }
}
