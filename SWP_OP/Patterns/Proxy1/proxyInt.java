import java.util.ArrayList;
import java.util.List;

public class proxyInt implements inter{

    realInt rI = new realInt();

    private static List<String> banned = new ArrayList<String>();
    
    static{
        banned.add("cornhub.com");
    }

    @Override
    public void connect(String s){
        if(banned.contains(s)){
            System.out.println("This site is banned!");
        }else{
            rI.connect(s);
        }
    }
}
