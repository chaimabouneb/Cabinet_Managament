package cabinet_management;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import java.time.LocalDate;

public class Bo implements Serializable {
    private LocalDate crea ;

    private List<Test> epreuvesCliniques;

    private List<Trouble> Diagnostic;
    private String projettherapeutic;

    public Bo(LocalDate d) {
        this.crea=d;
        this.epreuvesCliniques = new ArrayList<>();
        this.Diagnostic = new ArrayList<>();
    };



    public void Bo(List<Test> epreuvescliniques, List<Trouble> Diagnostic, String projettherapeutic) {
        this.epreuvesCliniques = epreuvescliniques;
        this.Diagnostic = Diagnostic;
        this.projettherapeutic = projettherapeutic;

    };

    public void ajouterEpreuve(Test e) {
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
    public List<Test> getEpreuvesCliniques() {
        return epreuvesCliniques;
    }

    public void setEpreuvesCliniques(List<Test> epreuvesCliniques) {
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

    public LocalDate getCrea() {
        return crea;
    }

    public void setCrea(LocalDate crea) {
        this.crea = crea;
    }
}
