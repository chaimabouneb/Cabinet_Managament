package cabinet_management;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

class QCU extends Question implements Serializable {
    private String bonneReponse;
    private HashSet<String> propositions;

    public QCU(String enonce, String bonneReponse, HashSet<String> propositions) {
        super(enonce);
        this.bonneReponse = bonneReponse;
        this.propositions = propositions;
    }

   

    public HashSet<String> getPropositions() {
        return propositions;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }
}

