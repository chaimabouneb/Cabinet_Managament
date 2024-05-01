package cabinet_management;

import java.util.HashSet;
import java.util.List;

public class Boinitial extends Bo {
    private HashSet<Libre> questions;
    private Patient p;

    public void Boinitial() {
    };

    public void Boinitial(HashSet<Libre> questions, Patient p) {
        this.questions = questions;
        this.p = p;
    };

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
}
