package cabinet_management;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class RendezVous {
    private LocalDate Date;
    private LocalTime heure;
    private String observation;

    public RendezVous() {
    };

    public RendezVous(String o, LocalTime t) {
        observation = o;
        heure = t;
    }
}
