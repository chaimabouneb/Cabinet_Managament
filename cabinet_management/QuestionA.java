package cabinet_management;

import java.io.Serializable;

public class QuestionA  implements Serializable{

        private String question;
        private String reponse;
    
        public QuestionA(String question) {
            this.question = question;
        }
    
        public String getQuestion() {
            return question;
        }
    
        public String getReponse() {
            return reponse;
        }
    
        public void setReponse(String reponse) {
            this.reponse = reponse;
        }
    }
    

