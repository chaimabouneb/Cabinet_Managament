package cabinet_management;

import java.io.Serializable;
import java.util.TreeSet;

public class Data implements Serializable {
    public static String name;
    public static int id;
    public static Orthophoniste orthophoniste;
    // public static TreeSet<Consultation> ConsultationSet;
    public static String[] gender = { "Male", "Female" };

    public static String[] status = { "Consultation", "Suivi", "atelier" };

    public static void ad(Consultation c) {
        // ConsultationSet.add(c);
    }

}
