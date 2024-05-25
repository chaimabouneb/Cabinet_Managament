package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Orthophoniste implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private String mtpasse;
    private String email;
    private HashMap<String, Dossier> patients = new HashMap<>();
    protected Set<Patient> patient = new HashSet<>();
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

    public HashMap<String, Dossier> getPatients() {
        return patients;
    }

    public void setPatients(HashMap<String, Dossier> patients) {
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

    public void addPatient(Dossier d) {
        patients.put(d.getPatient().getNom(), d);
    }

    public boolean isPatient(Double d) {
        return patients.containsKey(d);
    }

    public Dossier getPatient(Double d) {
        return patients.get(d);
    }
}
