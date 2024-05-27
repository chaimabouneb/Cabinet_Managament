package cabinet_management;

import java.io.Serializable;
import java.util.HashSet;

public class TestSimple extends Test implements Serializable {
    private HashSet<Question> questions;

    public TestSimple() {
        super();
        this.questions = new HashSet<>();
    }

    public TestSimple(String nom) {
        super(nom);
        this.questions = new HashSet<>();

        
    }

    public HashSet<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(HashSet<Question> questions) {
        this.questions = questions;
    }

    public void ajouterQuestion(Question q) {
        if (questions == null) {
            questions = new HashSet<>();
        }
        questions.add(q);
    }


    @Override
    public void Calc_Score() {
        int totalScore = 0;
        for (Question question : questions) {
            totalScore += question.getScore();
        }
        this.setScore(totalScore);
    }

    public void initialiserTest() {
        // Questions à choix unique (QCU)
        HashSet<String> propositionsQCU1 = new HashSet<>();
        propositionsQCU1.add("Oiseau");
        propositionsQCU1.add("Poisson");
        propositionsQCU1.add("Mammifère");
        Question qcu1 = new QCU("Quel type d'animal est une baleine ?", "Mammifère", propositionsQCU1);
        ajouterQuestion(qcu1);
    
        HashSet<String> propositionsQCU2 = new HashSet<>();
        propositionsQCU2.add("Lundi");
        propositionsQCU2.add("Mercredi");
        propositionsQCU2.add("Vendredi");
        Question qcu2 = new QCU("Quel jour de la semaine vient après mardi ?", "Mercredi", propositionsQCU2);
        ajouterQuestion(qcu2);
    
        // Questions à choix multiples (QCM)
        HashSet<String> propositionsQCM1 = new HashSet<>();
        propositionsQCM1.add("Rouge");
        propositionsQCM1.add("Bleu");
        propositionsQCM1.add("Jaune");
    
        HashSet<String> bonnesReponsesQCM1 = new HashSet<>();
        bonnesReponsesQCM1.add("Rouge");
        bonnesReponsesQCM1.add("Bleu");
    
        Question qcm1 = new QCM("Quels sont les couleurs primaires parmi les suivantes ?", bonnesReponsesQCM1, propositionsQCM1);
        ajouterQuestion(qcm1);
    
        HashSet<String> propositionsQCM2 = new HashSet<>();
        propositionsQCM2.add("Paris");
        propositionsQCM2.add("Londres");
        propositionsQCM2.add("Berlin");
    
        HashSet<String> bonnesReponsesQCM2 = new HashSet<>();
        bonnesReponsesQCM2.add("Paris");
        bonnesReponsesQCM2.add("Berlin");
    
        Question qcm2 = new QCM("Quelles sont les capitales des pays de l'Union Européenne parmi les suivantes ?", bonnesReponsesQCM2, propositionsQCM2);
        ajouterQuestion(qcm2);
    
        // Questions à réponse libre
        Question reponseLibre1 = new ReponseLibre("Décrivez comment faire un nœud de cravate.", "Explication correcte");
        ajouterQuestion(reponseLibre1);
    
        Question reponseLibre2 = new ReponseLibre("Qu'est-ce que la photosynthèse ?", "Processus par lequel les plantes produisent de l'énergie");
        ajouterQuestion(reponseLibre2);
    
        // Ajout de plus de questions pour atteindre au moins 10
        HashSet<String> propositionsQCU3 = new HashSet<>();
        propositionsQCU3.add("Pomme");
        propositionsQCU3.add("Carotte");
        propositionsQCU3.add("Poire");
        Question qcu3 = new QCU("Lequel de ces fruits est de couleur orange ?", "Carotte", propositionsQCU3);
        ajouterQuestion(qcu3);
    
        HashSet<String> propositionsQCM3 = new HashSet<>();
        propositionsQCM3.add("H2O");
        propositionsQCM3.add("CO2");
        propositionsQCM3.add("O2");
    
        HashSet<String> bonnesReponsesQCM3 = new HashSet<>();
        bonnesReponsesQCM3.add("H2O");
        bonnesReponsesQCM3.add("O2");
    
        Question qcm3 = new QCM("Quelles molécules sont essentielles à la respiration ?", bonnesReponsesQCM3, propositionsQCM3);
        ajouterQuestion(qcm3);
    
        Question reponseLibre3 = new ReponseLibre("Décrivez votre journée idéale.", "Description correcte");
        ajouterQuestion(reponseLibre3);
    
        HashSet<String> propositionsQCU4 = new HashSet<>();
        propositionsQCU4.add("Rome");
        propositionsQCU4.add("Athènes");
        propositionsQCU4.add("Tokyo");
        Question qcu4 = new QCU("Quelle est la capitale de l'Italie ?", "Rome", propositionsQCU4);
        ajouterQuestion(qcu4);
    
        HashSet<String> propositionsQCM4 = new HashSet<>();
        propositionsQCM4.add("Jupiter");
        propositionsQCM4.add("Mars");
        propositionsQCM4.add("Venus");
    
        HashSet<String> bonnesReponsesQCM4 = new HashSet<>();
        bonnesReponsesQCM4.add("Mars");
        bonnesReponsesQCM4.add("Venus");
    
        Question qcm4 = new QCM("Quels sont les planètes telluriques parmi les suivantes ?", bonnesReponsesQCM4, propositionsQCM4);
        ajouterQuestion(qcm4);
    
        Question reponseLibre4 = new ReponseLibre("Qu'est-ce que la gravité ?", "Force qui attire les objets vers le centre de la Terre");
        ajouterQuestion(reponseLibre4);
    }
}