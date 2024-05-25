package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Dossier implements Serializable {
    private HashSet<Bo> bilans;
    private Patient patient;
    private String numerodossier; // Changed to String to accommodate UUID
    private HashMap<LocalDate, RendezVous> rendezVous;
    private FicheSuivi fiches;

    public Dossier(Patient patient) {
        this.patient = patient;
        this.bilans = new HashSet<>();
        this.rendezVous = new HashMap<>();
        this.numerodossier = generateUniqueSerialNumber();
        patient.setAdmet();
    }

    private String generateUniqueSerialNumber() {
        return UUID.randomUUID().toString();
    }

    public void ajouterBo(Bo b) {
        if (b.getClass().getName().equals("Boinitial")) {
            System.out.println("there is already a bo");
        } else {
            bilans.add(b);
        }
    }

    public Patient getPatient() {
        return patient;
    }

    public void addRendezVous(LocalDate l, RendezVous r) {
        rendezVous.put(l, r);
    }

    public String getNum() {
        return numerodossier;
    }
}
