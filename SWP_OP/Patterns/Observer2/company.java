import java.util.*;

public class company {

    private List<customer> allCust = new ArrayList<customer>();
    
    public void sub(customer c){
        allCust.add(c);
    }
    
    public void unsub(customer c){
        allCust.remove(c);
    }

    public void inform(product p){
        for(customer c : allCust){
            c.informProd(p);
        }
    }

}
