package cabinet_management;

import java.io.Serializable;
import java.util.List;

public abstract class Question implements Serializable {
    private String enonce;
    private int score;

    public Question(String enonce) {
        this.enonce = enonce;
    }

    public String getEnonce() {
        return enonce;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
