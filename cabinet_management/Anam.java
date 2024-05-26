package cabinet_management;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Anam implements Serializable {

    private Map<Cat_Quest, List<QuestionA>> questions = new HashMap<>();

    public Anam() {
        for (Cat_Quest catQuest : Cat_Quest.values()) {
            questions.put(catQuest, new ArrayList<>());
        }
    }

    public Map<Cat_Quest, List<QuestionA>> getMap(){
        return questions;
    }

    public void ajouterQuestion(Cat_Quest categorie, QuestionA question) {
        List<QuestionA> questionList = questions.get(categorie);
        if (questionList != null) {
            questionList.add(question);
        }
    }

    public List<QuestionA> getQuestions(Cat_Quest categorie) {
        return questions.get(categorie);
    }

    public void initializeChildAnam() {
        ajouterQuestion(Cat_Quest.STRUCTURE_FAMILIALE, new QuestionA("Quelle est la composition de la famille de l'enfant ?"));
        ajouterQuestion(Cat_Quest.STRUCTURE_FAMILIALE, new QuestionA("Y a-t-il des frères et sœurs dans la famille ?"));
        ajouterQuestion(Cat_Quest.DYNAMIQUE_FAMILIALE, new QuestionA("Comment se déroulent les interactions entre les membres de la famille ?"));
        ajouterQuestion(Cat_Quest.DYNAMIQUE_FAMILIALE, new QuestionA("Quels sont les rituels familiaux auxquels l'enfant participe ?"));
        // Add other questions similarly...
    }

    public void initializeAdultAnam() {
        ajouterQuestion(Cat_Quest.HISTOIRE_MALADIE, new QuestionA("Quels sont les symptômes principaux de la maladie du patient ?"));
        ajouterQuestion(Cat_Quest.HISTOIRE_MALADIE, new QuestionA("Depuis quand les symptômes sont-ils apparus ?"));
        ajouterQuestion(Cat_Quest.SUIVI_MEDICAL, new QuestionA("Quels sont les antécédents médicaux du patient ?"));
        ajouterQuestion(Cat_Quest.SUIVI_MEDICAL, new QuestionA("Quelles sont les affections médicales dont le patient a été traité dans le passé ?"));
        // Add other questions similarly...
    }

    public List<QuestionA> getQuestionsForCategory(Cat_Quest category) {
        return questions.get(category);
    }
}


