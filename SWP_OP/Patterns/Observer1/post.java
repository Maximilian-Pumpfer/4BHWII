import java.util.ArrayList;
import java.util.List;

public class post {

    private List<kunden> kunden = new ArrayList<kunden>();
    
    public void sub(kunden k){
        kunden.add(k);
    }

    public void unsub(kunden k){
        kunden.remove(k);
    }

    public void spam(werbung w){
        for(kunden k : kunden){
            w.getWerbung(k);
        }
    }

}
