package cabinet_management;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cabinet_management.Cat_Quest;

public class Anam {

    private Map<Cat_Quest, List<QuestionA>> questions = new HashMap<>();

    public Anam() {
        for (Cat_Quest catQuest : Cat_Quest.values()) {
            questions.put(catQuest, new ArrayList<>());
        }
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

    private void initializeChildAnam() {
        List<QuestionA> childQuestions = new ArrayList<>();
        // Structure familiale
        childQuestions.add(new QuestionA("Quelle est la composition de la famille de l'enfant ?"));
        childQuestions.add(new QuestionA("Y a-t-il des frères et sœurs dans la famille ?"));
        // Ajoutez les autres questions de la catégorie Structure familiale

        // Dynamique familiale
        childQuestions.add(new QuestionA("Comment se déroulent les interactions entre les membres de la famille ?"));
        childQuestions.add(new QuestionA("Quels sont les rituels familiaux auxquels l'enfant participe ?"));
        // Ajoutez les autres questions de la catégorie Dynamique familiale

        // Ajoutez les autres catégories avec leurs questions

        questions.put(Cat_Quest.STRUCTURE_FAMILIALE, childQuestions);
        // Ajoutez les autres catégories avec leurs questions
    }

    private void initializeAdultAnam() {
        List<QuestionA> adultQuestions = new ArrayList<>();
        // Histoire de la maladie
        adultQuestions.add(new QuestionA("Quels sont les symptômes principaux de la maladie du patient ?"));
        adultQuestions.add(new QuestionA("Depuis quand les symptômes sont-ils apparus ?"));
        // Ajoutez les autres questions de la catégorie Histoire de la maladie

        // Suivi médical
        adultQuestions.add(new QuestionA("Quels sont les antécédents médicaux du patient ?"));
        adultQuestions.add(new QuestionA("Quelles sont les affections médicales dont le patient a été traité dans le passé ?"));
        // Ajoutez les autres questions de la catégorie Suivi médical

        // Ajoutez les autres catégories avec leurs questions

        questions.put(Cat_Quest.HISTOIRE_MALADIE, adultQuestions);
        // Ajoutez les autres catégories avec leurs questions
    }

    public List<QuestionA> getQuestionsForCategory(Cat_Quest category) {
        return questions.get(category);
    }

}


