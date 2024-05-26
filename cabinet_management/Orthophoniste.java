package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import java.util.HashSet;

import java.util.Objects;

import java.util.Set;
import java.util.TreeSet;

public class Orthophoniste implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private String mtpasse;
    private String email;

    private HashMap<Double, Dossier> patients = new HashMap<>();
    // protected Set<Patient> patient = new HashSet<>();

    // protected HashMap<Double, Dossier> patients =new HashMap<>() ;
    Double lastKey = 0.0;

    protected Set<Patient> patient = new TreeSet<>();

    protected TreeSet<RendezVous> rendezVousSet = new TreeSet<>();
    private TreeSet<Consultation> ConsultationSet = new TreeSet<>();
    private TreeSet<Suivi> SuiviSet = new TreeSet<>();
    private TreeSet<Atelier> AtelierSet = new TreeSet<>();

    // Constructor for Orthophoniste with only name
    public Orthophoniste(String nom) {
        this.nom = nom;
        // Initialize collections
        this.ConsultationSet = new TreeSet<>();
        this.SuiviSet = new TreeSet<>();
        this.AtelierSet = new TreeSet<>();
        this.patient = new HashSet<>();
        this.patients = new HashMap<>();
    }

    public void addP(Patient p) {
        this.patient.add(p);
    }

    // Constructor for Orthophoniste with all fields
    public Orthophoniste(String nom, String prenom, String adresse, String numero,
            String email, String p) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero = numero;
        this.email = email;
        this.mtpasse = p;
        this.ConsultationSet = new TreeSet<>();
        this.SuiviSet = new TreeSet<>();
        this.AtelierSet = new TreeSet<>();
        this.patient = new HashSet<>();
        this.patients = new HashMap<>();
    }

    // Getters and Setters for fields
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashMap<Double, Dossier> getPatients() {
        return patients;
    }

    public void setPatients(HashMap<Double, Dossier> patients) {
        this.patients = patients;
    }

    public Set<Patient> getPatient() {
        return patient;
    }

    public void setPatient(Set<Patient> patient) {
        this.patient = patient;
    }

    // Methods for managing appointments and patients
    public TreeSet<RendezVous> getRendezVousSet() {
        return rendezVousSet;
    }

    public TreeSet<Consultation> getConsultations() {
        return ConsultationSet;
    }

    public TreeSet<Suivi> getSuivi() {
        return SuiviSet;
    }

    public TreeSet<Atelier> getAtelier() {
        return AtelierSet;
    }

    public Dossier chercheDossier(String nom) {
        return patients.get(nom);
    }

    public boolean rendezVousExists(LocalDate date, LocalTime heure) {
        return rendezVousSet.stream().anyMatch(rv -> rv.getDate().equals(date) && rv.getHeure().equals(heure));
    }

    public boolean authentifierPasse(String passe) throws PassIncorrectException {
        if (this.mtpasse.equals(passe)) {
            return true;
        } else {
            throw new PassIncorrectException();
        }
    }

    public static class PassIncorrectException extends Exception {
        public PassIncorrectException() {
            super("Incorrect password.");
        }
    }

    public void ajouterc(Consultation c) {
        this.ConsultationSet.add(c);
        this.rendezVousSet.add(c);
    }

    public void ajouters(Suivi c) {
        if (SuiviSet == null) {
            SuiviSet = new TreeSet<>();
        }
        SuiviSet.add(c);
        this.rendezVousSet.add(c);
    }

    public void ajoutera(Atelier c) {
        AtelierSet.add(c);
        this.rendezVousSet.add(c);
    }

    /*
     * public void addPatient(Dossier d) {
     * 
     * patients.put(d.getPatient().getNom(), d);
     * }
     */

    public boolean isPatient(Double d) {
        return patients.containsKey(d);
    }

    public Dossier getPatient(String d) {
        return patients.get(d);
    }

    public void addPatient(Dossier d) {
        Double key = lastKey + 1;
        d.setnumdossier(key);
        patients.put(key, d);
        patient.add(d.getpatient());
        lastKey = key;
        System.out.println("puuuted");
    }

    public boolean isPatient(Patient p) {// Check if a patient exists
        for (Patient patientobj : patient) {
            if (patientobj.getnom().equals(p.getnom()) && patientobj.getprenom().equals(p.getprenom())) {
                return true;
            }
        }
        return false;
    }

    public boolean exists(Double d) {
        if (patients.containsKey(d)) {
            return true;
        } else {
            return false;
        }
    }

    public Dossier getPatient(Double d) {
        if (exists(d)) {
            return patients.get(d);
        } else {
            System.out.println("not patient");
            return null;
        }
    }

    public void updateDossier(Dossier d){
        if (exists(d.getNum())){
            patients.put(d.getNum(), d);

        }
        
    }

}
