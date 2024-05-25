package cabinet_management;

import cabinet_management.ClasseEtude;

public class Enfant extends Patient implements serialisable {
    private String nump1;
    private String nump2;
    private ClasseEtude classeetude;


public Enfant(Patient patient,ClasseEtude c,String n) {
    super(patient.getnom(), patient.getprenom(), patient.getdate(),patient.getadress(),patient.getlieu());
    this.classeetude=c;
    this.nump1=n;

};
}
