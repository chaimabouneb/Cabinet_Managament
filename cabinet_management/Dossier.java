package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Dossier implements Serializable {

    private HashSet<Bo> bilans;
    private static final long serialVersionUID = 2L;
    private Patient patient;
    private Double numerodossier; // Changed to String to accommodate UUID
    private HashMap<LocalDate, RendezVous> rendezVous;
    private FicheSuivi fiches;

    public void Dossier(Patient p) {
        this.patient = p;
    }

    public Dossier(Patient patient) {
        this.patient = patient;
        this.bilans = new HashSet<>();
        this.rendezVous = new HashMap<>();
        // this.numerodossier = generateUniqueSerialNumber();
        patient.setAdmet();
    }

    private String generateUniqueSerialNumber() {
        return UUID.randomUUID().toString();
    }

    public void ajouterBo(Bo b) {
       
            bilans.add(b);
        
    }

    public Patient getPatient() {
        return patient;
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
    public HashSet<Bo> getBo(){
        return bilans;

    }

    public void setBo(HashSet<Bo> b){
        bilans=b;
    }

    
}
