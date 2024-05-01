package cabinet_management;

import java.util.List;

public class Bo {
    private List<Epreuve> epreuvescliniques;
    private List<Trouble> Diagnostic;
    private String projettherapeutic;

    public void Bo() {
    };

    public void Bo(List<Epreuve> epreuvescliniques, List<Trouble> Diagnostic, String projettherapeutic) {
        this.epreuvescliniques = epreuvescliniques;
        this.Diagnostic = Diagnostic;
        this.projettherapeutic = projettherapeutic;

    };

    public void ajouterEpreuve(Epreuve e) {
        epreuvescliniques.add(e);
    }

    public void ajouterTrouble(Trouble t) {
        for (Trouble trbl : Diagnostic) {
            if (trbl.equals(t)) {
                System.out.println("error");
            }
        }
        Diagnostic.add(t);
    }

}
