package cabinet_management;

public class Adulte extends Patient implements serialisable {
    private String diplome;
    private String profession;
    private String num;

    public Adulte(Patient patient,String d,String pr,String n) {
        super(patient.getnom(), patient.getprenom(), patient.getdate(),patient.getadress(),patient.getlieu());
        this.diplome=d;
        this.profession=pr;
        this.num=n;

    };

}
