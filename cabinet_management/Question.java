package cabinet_management;

import java.util.List;

public abstract class Question {
    private Cat_Quest type;
    private String enonce;
    protected List<String> options;

    public Question(String question, List<String> options, Cat_Quest type) {
        this.enonce = question;
        this.options = options;
        this.type = type;
    }

    public Question() {
    }

    public String getQuestion() {
        return enonce;
    }

    public List<String> getOptions() {
        return options;
    }
}
