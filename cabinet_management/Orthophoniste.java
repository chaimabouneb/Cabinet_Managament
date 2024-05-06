package cabinet_management;

import java.io.Serializable;
import java.util.HashMap;

public class Orthophoniste implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private String mtpasse;
    private String email;
    private HashMap<Double, Dossier> patients = null;

    public Orthophoniste() {
    }

    public Orthophoniste(String nom) {
        this.nom = nom;
    }

    public Orthophoniste(String nom, String prenom, String adresse, String numero,
            String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero = numero;
        this.email = email;
        this.mtpasse = null;

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
