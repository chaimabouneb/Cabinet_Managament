package cabinet_management;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

class QCM extends Question implements Serializable {
    private HashSet<String> bonnesReponses;
    private HashSet<String> propositions;

    public QCM(String enonce, HashSet<String> bonnesReponses, HashSet<String> propositions) {
        super(enonce);
        this.bonnesReponses = bonnesReponses;
        this.propositions = propositions;
    }

   

    public HashSet<String> getPropositions() {
        return propositions;
    }

    public HashSet<String> getBonnesReponses() {
        return bonnesReponses;
    }
}
