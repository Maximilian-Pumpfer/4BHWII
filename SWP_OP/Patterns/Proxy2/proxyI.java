import java.util.ArrayList;
import java.util.List;

public class proxyI implements intern{

    realI r = new realI();

    private static List<String> banned = new ArrayList<String>();

    static{
        banned.add("amazon.de");
    }

    @Override
    public void connect(String s){
        if(banned.contains(s)){
            System.err.println("This site is banned");
        }else{
            r.connect(s);
        }
    }
    
}
