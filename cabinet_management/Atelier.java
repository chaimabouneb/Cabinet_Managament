package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

public class Atelier extends RendezVous implements Serializable {
    private String thematique;
    private Map<String, Dossier> patientFolders;
    // liste num dossier des patients
    private ArrayList<String> pn;

    public Atelier() {
    };

    public Atelier(String s, LocalDate o, LocalTime t) {
        super(o, t);
        thematique = s;
        pn = new ArrayList<String>();
        // patientFolders = pf;

    };

    public void setPn(ArrayList<String> s) {
        pn = s;
    }

    public ArrayList<String> getPn() {
        return pn;
    }

    public String getPatientNames() {
        return String.join(", ", this.pn);
    }

    public void Addpn(String s) {
        pn.add(s);
    }

    public void setPat(Map<String, Dossier> d) {
        this.patientFolders = d;
    }

    public Map<String, Dossier> getPat() {
        return this.patientFolders;
    }

}
