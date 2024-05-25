package cabinet_management;

import java.util.HashSet;
import java.util.List;

public class Boinitial extends Bo {
    private HashSet<Libre> questions;
    private Patient p;
    private Anam anam;

    public void Boinitial() {
    };

    public void Boinitial(HashSet<Libre> questions, Patient p) {
        this.questions = questions;
        this.p = p;
    };

    public Boinitial(boolean estEnfant) {
        this.anam = new Anam();

        if (estEnfant) {
            initialiserAnamEnfant();
        } else {
            initialiserAnamAdulte();
        }
    }

    public boolean isEnfant() {
        if (p.getClass().getName() == "Enfant") {
            return true;
        } else {
            return false;
        }

    }

    public HashSet<Libre> getQuest() {
        if (isEnfant()) {
            return questions;
        } else {
            return null;
        }
    }

    private void initialiserAnamAdulte() {
        // Initialiser les questions de l'anamnèse pour un adulte
        
    }

    private void initialiserAnamEnfant() {
        // Initialiser les questions de l'anamnèse pour un enfant
       
    }

    public Anam getAnam() {
        return anam;
    }
}
