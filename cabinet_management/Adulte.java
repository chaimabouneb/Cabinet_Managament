package cabinet_management;

import java.time.LocalDate;

public class Adulte extends Patient {
    private String diplome;
    private String profession;
    private String num;

    // Constructeur de la classe Adulte
    public Adulte(String n) {
        super(n);
    }

    public Adulte(String n, String prenom, String adresse, LocalDate datenes, String lieunes, String diplome,
            String profession, String num) {
        super(n, prenom, adresse, datenes, lieunes);
        this.diplome = diplome;
        this.profession = profession;
        this.num = num;
    }

    // Getters et setters pour les nouveaux champs
    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
