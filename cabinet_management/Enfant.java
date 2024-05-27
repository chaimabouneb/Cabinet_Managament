package cabinet_management;

import java.time.LocalDate;

import cabinet_management.ClasseEtude;

public class Enfant extends Patient implements serialisable {
    private String nump1;
    private String nump2;
    private ClasseEtude classeetude;
    private String classeetud;

    public Enfant(Patient patient, ClasseEtude c, String n) {
        super(patient.getnom(), patient.getprenom(), patient.getdate(), patient.getadress(), patient.getlieu());
        this.classeetude = c;
        this.nump1 = n;

    };

    public Enfant(String n, int a, String g, String num1, String c, String num2, String lieunes) {
        super(n, a, g, lieunes);

        this.classeetud = c;
        this.nump1 = num1;
        this.nump2 = num2;
    }

    public Enfant(String n) {
        super(n);
    }

    public String getNum1() {
        return nump1;

    }

    public void setN2(String s) {
        this.nump2 = s;

    }

    public String getNum2() {
        return nump2;

    }

    public void setN1(String s) {
        this.nump1 = s;

    }
}
