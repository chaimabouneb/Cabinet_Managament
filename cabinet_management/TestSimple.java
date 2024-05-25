package cabinet_management;

import java.util.HashSet;

public class TestSimple extends Test {
    private HashSet<Question> questions;

    public TestSimple(String nom, HashSet<Question> questions) {
        super(nom);
        this.questions = questions;
    }

    public HashSet<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(HashSet<Question> questions) {
        this.questions = questions;
    }

    public void ajouterQuest(Question q) {
        questions.add(q);
    }

    @Override
    public void Calc_Score() {

        // Iterate over each question and add its score to the total score

    }

}