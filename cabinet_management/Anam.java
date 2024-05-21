package cabinet_management;
import java.util.HashMap;
import java.util.Map;

public class Anam {

    private Map<Cat_Quest, String> questions;

    public Anam() {
        questions = new HashMap<>();
    }

    public void ajouterQuestion(Cat_Quest categorie, String question) {
        questions.put(categorie, question);
    }

    public String getQuestion(Cat_Quest categorie) {
        return questions.get(categorie);
    }
}

