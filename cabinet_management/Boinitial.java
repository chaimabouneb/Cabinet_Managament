package cabinet_management;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class Boinitial extends Bo implements Serializable{
    
    private Anam anam=new Anam();

    public Boinitial(Anam a , LocalDate d) {
        super(d);
        this.anam=a;
    };

    public Anam getAnam() {
        return anam;
    }
    public void setAnam(Anam a){
        this.anam=a;
    }
}
