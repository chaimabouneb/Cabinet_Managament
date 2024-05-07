package cabinet_management;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class RendezVous implements Comparable<RendezVous> {
    private LocalDate date;
    private LocalTime heure;
    private String observation;

    public RendezVous() {
    }

    @Override
    public int compareTo(RendezVous other) {
        String thisDateTime = this.date.toString() + this.heure.toString();
        String otherDateTime = other.date.toString() + other.heure.toString();
        return thisDateTime.compareTo(otherDateTime);
    }

    public RendezVous(LocalDate d, LocalTime heure) {
        this.date = d;
        this.heure = heure;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
