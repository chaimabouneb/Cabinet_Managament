package cabinet_management;

import java.util.List;

public abstract class Question {
    private Cat_Quest type;
    private String enonce;
    protected List<String> options;
    protected int note;
    protected double score;

    public Question(String question, List<String> options, Cat_Quest type, int note) {
        this.enonce = question;
        this.options = options;
        this.type = type;
        this.note = note;

    }

    public Question(String question, Cat_Quest type, int note) {
        this.enonce = question;
        this.options = null;
        this.type = type;
        this.note = note;

    }

    public Question() {
    }

    public String getQuestion() {
        return enonce;
    }

    public List<String> getOptions() {
        return options;
    }

    public abstract void setScore();

    public double getScore() {
        return score;
    }

}
