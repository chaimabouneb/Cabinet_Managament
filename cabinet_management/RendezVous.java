
package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.binding.StringBinding;

public abstract class RendezVous implements Comparable<RendezVous>, Serializable {
    private static final long serialVersionUID = 1L; // Ensure version compatibility

    private LocalDate date;
    private LocalTime heure;
    private String observation;
    private String gender;

    public RendezVous() {
        // Default constructor
    }

    public RendezVous(LocalDate date, LocalTime heure, String gender) {
        this.date = date;
        this.heure = heure;
        this.gender = gender;

    }

    public RendezVous(LocalDate date, LocalTime heure) {
        this.date = date;
        this.heure = heure;

    }

    @Override
    public int compareTo(RendezVous other) {
        if (this.date == null && other.date == null) {
            return 0;
        } else if (this.date == null) {
            return -1;
        } else if (other.date == null) {
            return 1;
        } else {
            int dateComparison = this.date.compareTo(other.date);
            if (dateComparison != 0) {
                return dateComparison;
            } else {
                return this.heure.compareTo(other.heure);
            }
        }
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
