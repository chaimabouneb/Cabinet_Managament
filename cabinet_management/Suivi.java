package cabinet_management;

import java.time.LocalTime;

public class Suivi extends RendezVous {
    private String numdossier;
    private boolean E;

    public Suivi() {
    };

    public Suivi(String d, boolean y, String o, LocalTime t) {
        super(o, t);
        numdossier = d;
        E = y;

    };

}
