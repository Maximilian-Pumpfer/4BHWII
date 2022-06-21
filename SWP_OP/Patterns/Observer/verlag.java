import java.util.*;

public abstract class verlag {
    
    private List<users> us = new ArrayList<users>();

    public void sub(users u){
        us.add(u);
    }

    public void unsub(users u){
        us.remove(u);
    }

    public void sendNews(news n){
        for(users u : us){
            u.sendNews(n);
        }
    }

}
