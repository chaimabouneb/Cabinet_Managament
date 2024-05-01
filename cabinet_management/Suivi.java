package cabinet_management;

import java.time.LocalTime;
import java.util.List;

public class Suivi extends RendezVous {
    private double score;
    private boolean E;
    private List<Objectif> objectifs;

    public Suivi() {
    };

    public Suivi(boolean y, String o, LocalTime t, List<Objectif> objectifs) {
        super(o, t);
        E = y;
        this.objectifs = objectifs;

    };

    public void ajouterObjectif(Objectif o) {
        objectifs.add(o);
    }

    public double getNote() {
        double totalscore = 0;
        for (Objectif o : objectifs) {
            totalscore += o.getNote();
        }
        return totalscore;
    }
}
