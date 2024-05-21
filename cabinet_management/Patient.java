package cabinet_management;

import java.time.LocalDate;

public abstract class Patient {
    private String nom;
    private String prenom;
    private String adresse;
    private LocalDate datenes;
    private String lieunes;

    public void Patient(String n, String p) {
        this.nom = n;
        this.prenom = p;
    }

}
