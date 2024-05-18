package cabinet_management;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Map;

public class Atelier extends RendezVous {
    private String thematique;
    private Map<String, Dossier> patientFolders; // liste num dossier des patients

    public Atelier() {
    };

    public Atelier(String s, LocalDate o, LocalTime t) {
        super(o, t);
        thematique = s;
        // patientFolders = pf;

    };
}
