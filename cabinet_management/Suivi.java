package cabinet_management;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Suivi extends RendezVous {
    private double score;
    private boolean e;
    private List<Objectif> objectifs;

    public Suivi() {
    }

    public Suivi(boolean e, LocalDate date, LocalTime heure) {
        super(date, heure);
        this.e = e;

    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isE() {
        return e;
    }

    public void setE(boolean e) {
        this.e = e;
    }

    public List<Objectif> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(List<Objectif> objectifs) {
        this.objectifs = objectifs;
    }

    public void ajouterObjectif(Objectif objectif) {
        objectifs.add(objectif);
    }

    public double getNote() {
        double totalScore = 0;
        for (Objectif objectif : objectifs) {
            totalScore += objectif.getNote();
        }
        return totalScore;
    }
}
