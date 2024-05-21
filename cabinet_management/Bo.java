package cabinet_management;

import java.util.ArrayList;
import java.util.List;

public class Bo {
    private List<Epreuve> epreuvesCliniques;
    private List<Trouble> Diagnostic;
    private String projettherapeutic;

    public void Bo() {
        this.epreuvesCliniques = new ArrayList<>();
        this.Diagnostic = new ArrayList<>();
    };

    public void Bo(List<Epreuve> epreuvescliniques, List<Trouble> Diagnostic, String projettherapeutic) {
        this.epreuvesCliniques = epreuvescliniques;
        this.Diagnostic = Diagnostic;
        this.projettherapeutic = projettherapeutic;

    };

    public void ajouterEpreuve(Epreuve e) {
        epreuvesCliniques.add(e);
    }

    public void ajouterTrouble(Trouble t) {
        if (!Diagnostic.contains(t)) {
            Diagnostic.add(t);
        } else {
            System.out.println("Le trouble est déjà présent dans le diagnostic.");
        }
    }

     // Getters and setters
     public List<Epreuve> getEpreuvesCliniques() {
        return epreuvesCliniques;
    }

    public void setEpreuvesCliniques(List<Epreuve> epreuvesCliniques) {
        this.epreuvesCliniques = epreuvesCliniques;
    }

    public List<Trouble> getDiagnostic() {
        return Diagnostic;
    }

    public void setDiagnostic(List<Trouble> diagnostic) {
        this.Diagnostic = diagnostic;
    }

    public String getProjetTherapeutique() {
        return projettherapeutic;
    }

    public void setProjetTherapeutique(String projetTherapeutique) {
        this.projettherapeutic = projetTherapeutique;
    }
}

