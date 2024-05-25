package cabinet_management;

import java.util.List;
import java.io.Serializable;

public class Epreuve implements Serializable {
    private List<Test> TestList;
    private List<String> observations;

    public Epreuve() {
    };

    public Epreuve(List<Test> t, List<String> o) {
        TestList = t;
        observations = o;
    };

    public void ajouterTest(Test t) {
        TestList.add(t);
    }

    public void SupprimerTest(Test t) {
        for (Test test : TestList) {
            if (test.equals(t)) {
                TestList.remove(test);
            }
        }
    }

    public void ajouterObservation(String o) {
        observations.add(o);
    }

}
