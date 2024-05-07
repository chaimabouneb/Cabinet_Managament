package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends RendezVous implements Serializable {
    private LocalTime duree;
    private int age;
    private String nom;

    public Consultation() {
    }

    public Consultation(int age, String name) {
        this.age = age;
        this.nom = name;
    }

    public Consultation(int d, String n, LocalDate date, LocalTime t) {
        super(date, t);
        nom = n;

        if (d >= 19) {
            duree = LocalTime.of(1, 30);
        } else {
            duree = LocalTime.of(2, 30);
        }
    }

    public LocalTime getDuree() {
        return duree;
    }

    public int getage() {
        return age;
    }

    public String getnom() {
        return nom;
    }

    public void setDuree(LocalTime duree) {
        this.duree = duree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
