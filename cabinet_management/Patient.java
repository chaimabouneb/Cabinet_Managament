package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public  class  Patient implements   Comparable<Patient> ,Serializable{
    private static final long serialVersionUID = 3L; // Ensure version compatibility

    private String nom;
    private String prenom;
    private String adresse;
    private LocalDate datenes;
    private String lieunes;
    private boolean isAdulte;
   


    public Patient(String n,String p,LocalDate d,String a,String l){
        this.nom=n;
        this.prenom=p;
        this.datenes=d;
        setAdulte(d);
        this.adresse=a;
        this.lieunes=l;
    }
    
    public Patient (String n,String p,LocalDate d){
        this.nom=n;
        this.prenom=p;
        this.datenes=d;
        setAdulte(d);
    }
    
    public  Patient (String a,String l){
        this.adresse=a;
        this.lieunes=l;
    }

    public void setAdulte(LocalDate d){
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(d, currentDate);
        int years = age.getYears();
        if (years<18 ){
            this.isAdulte=false;
        }
        else{
            this.isAdulte=true;
        }

    }

    public int getAge(LocalDate d){
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(d, currentDate);
        int years = age.getYears();
        return years;
    }


    public String getnom(){
        return nom;
    }

    public String getprenom(){
        return prenom;
    }

    public boolean  isAdulte(LocalDate d){
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(d, currentDate);
        int years = age.getYears();
        if (years<18 ){
            return false;
        }
        else{
            return true;
        }
    }

    public LocalDate getdate(){
        return datenes;
    }

    public String getlieu(){
        return lieunes;
    }

    public String getadress(){
        return adresse;
    }


    public boolean getAdulte(){
        return isAdulte;
    }

    public void setlieu(String l){
        this.lieunes=l;
 
    }

    public void setadress(String a){
        this.adresse=a;
 
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return nom.equals(patient.getnom()) && prenom.equals(patient.getnom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }

    @Override
    public int compareTo(Patient other) {
        // Comparaison par nom, puis par prénom
        int lastNameComparison = this.nom.compareTo(other.getnom());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return this.prenom.compareTo(other.getprenom());
    }
    

}
