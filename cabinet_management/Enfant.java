package cabinet_management;

import java.time.LocalDate;

import cabinet_management.ClasseEtude;

public class Enfant extends Patient {
    private String nump1;
    private String nump2;
    private ClasseEtude classeetude;

    public Enfant(String nom) {
        super(nom); // Appelle le constructeur de Patient

    }
}
