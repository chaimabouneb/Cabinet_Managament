package cabinet_management;

import java.io.Serializable;

public class Data implements Serializable {
    public static String name;
    public static int id;
    public static Orthophoniste orthophoniste;

    public static String[] gender = { "Male", "Female" };

    public static String[] status = { "Consultation", "Suivi", "atelier" };
}
