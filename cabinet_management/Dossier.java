package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Dossier implements Serializable {

    private HashSet<Bo> bilans;
    private static final long serialVersionUID = 2L;
    private Patient patient;
    private Double numerodossier; // Changed to String to accommodate UUID
    private HashMap<LocalDate, RendezVous> rendezVous;
    private Set<FicheSuivi> fiches;

    public Dossier(Patient patient) {
        this.patient = patient;
        this.bilans = new HashSet<>();
        this.rendezVous = new HashMap<>();
        this.fiches = new HashSet<>();
        patient.setAdmet();
    }

    public void addF(FicheSuivi f) {
        if (fiches == null) {
            fiches = new HashSet<>(); // Initialize fiches if it's null
        }
        fiches.add(f); // Add the element to fiches
    }

    public Set<FicheSuivi> getFiche() {
        return fiches;
    }

    public void setFiche(Set<FicheSuivi> s) {
        this.fiches = s;
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

    public HashMap<LocalDate, RendezVous> getRendezvous() {
        return rendezVous;
    }

    public void CreerNvDossier(Bo b, Double num, Patient patient) {
        if (b.getClass().getName() == "Boinitial") {
            if (bilans == null) {
                bilans.add(b);
                this.numerodossier = num;
                this.patient = patient;
            }

        }

    }

    public void addRendezVous(LocalDate l, RendezVous r) {
        rendezVous.put(l, r);
    }

    public Double getNum() {
        return numerodossier;
    }

    public Patient getpatient() {
        return patient;
    }

    public void setnumdossier(Double n) {
        this.numerodossier = n;
    }

}
