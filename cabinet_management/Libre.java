package cabinet_management;

import java.io.Serializable;

class ReponseLibre extends Question implements Serializable {
    private String bonneReponse;

    public ReponseLibre(String enonce, String bonneReponse) {
        super(enonce);
        this.bonneReponse = bonneReponse;
    }

    
    public String getBonneReponse() {
        return bonneReponse;
    }
}