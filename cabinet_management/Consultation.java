package cabinet_management;

import java.time.LocalTime;

public class Consultation extends RendezVous {
    private LocalTime Duree;
    private int age;
    private String nom;
    private String prenom;

    public Consultation() {
    };

    public Consultation(int d, String n, String p, String o, LocalTime t) {
        super(o, t);
        nom = n;
        prenom = p;
        if (d >= 19) {
            Duree = LocalTime.of(1, 30);
        } else {
            Duree = LocalTime.of(2, 30);

        }
    };

}
