package cabinet_management;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Dossier {
    private HashSet<Bo> bilans = null;
    private Patient patient;
    private double numerodossier;
    private HashMap<LocalDate, RendezVous> RendezVous;
    private FicheSuivi fiches;

    public void ajouterBo(Bo b) {
        if (b.getClass().getName() == "Boinitial") {

            System.out.println("there is already a bo");

        } else {

            bilans.add(b);
        }
    }

    public void CreerNvDossier(Bo b, double num, Patient patient) {
        if (b.getClass().getName() == "Boinitial") {
            if (bilans == null) {
                bilans.add(b);
                this.numerodossier = num;
                this.patient = patient;
            }

        }
    }

    public Double getNum() {
        return numerodossier;
    }

}
