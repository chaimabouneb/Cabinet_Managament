package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Orthophoniste implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private String mtpasse;
    private String email;
    private HashMap<Double, Dossier> patients = null;
    protected Set<Patient> patient;

    protected TreeSet<RendezVous> rendezVousSet = new TreeSet<>();
    private TreeSet<Consultation> ConsultationSet = null;
    private TreeSet<Suivi> SuiviSet = new TreeSet<>();
    private TreeSet<Atelier> AtelierSet = new TreeSet<>();

    // Other methods...

    public TreeSet<RendezVous> getRendezVousSet() {
        return rendezVousSet;
    }

    public TreeSet<Consultation> getConsultations() {
        return ConsultationSet;
    }

    public boolean rendezVousExists(LocalDate date, LocalTime heure) {
        for (RendezVous rendezVous : rendezVousSet) {
            if (rendezVous.getDate().equals(date) && rendezVous.getHeure().equals(heure)) {
                return true; // RendezVous with the given date and hour exists
            }
        }
        return false; // RendezVous with the given date and hour does not exist
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
        SuiviSet.add(c);
    }

    public void ajoutera(Atelier c) {
        AtelierSet.add(c);
    }

    public Orthophoniste(String nom) {
        this.nom = nom;
    }

    public Orthophoniste(String nom, String prenom, String adresse, String numero,
            String email, String p) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero = numero;
        this.email = email;
        this.mtpasse = p;

    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public HashMap getPatients() {
        return patients;
    }

    public void setPatients(HashMap p) {
        patients = p;
    }

    public void addPatient(Dossier d) {
        patients.put(d.getNum(), d);
    }

    public boolean isPatient(Double d) {// Check if a key exists
        if (patients.containsKey(d)) {
            return true;
        } else {
            return false;
        }
    }

    public Dossier getPatient(Double d) {
        if (isPatient(d)) {
            return patients.get(d);
        } else {
            System.out.println("not patient");
            return null;
        }
    }

}
