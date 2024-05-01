package cabinet_management;

import java.util.List;

public class Epreuve {
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
