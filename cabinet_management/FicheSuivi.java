package cabinet_management;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class FicheSuivi implements Serializable {
    private List<Suivi> suivis = null;
    private List<Objectif> o;
    private boolean atteint;
    private LocalDate d;
    private int num;

    public FicheSuivi(List<Objectif> o, LocalDate d, int n, boolean a) {
        this.o = o;
        this.d = d;
        this.num = n;
        this.atteint = a;
    };

    public boolean isAtteint() {
        return atteint;
    }

    public void setAtteint(boolean atteint) {
        this.atteint = atteint;
    }

    public List<Objectif> getO() {
        return o;
    }

    public LocalDate getD() {
        return d;
    }

    public void setD(LocalDate d) {
        this.d = d;
    }

    public void setO(List<Objectif> o) {
        this.o = o;
    }

    public double getTotalScore() {
        double TotalScore = 0;
        for (Suivi s : suivis) {
            TotalScore += s.getNote();

        }
        return TotalScore;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int n) {
        this.num = n;
    }
}
