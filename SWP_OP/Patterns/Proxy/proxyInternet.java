import java.util.*;

public class proxyInternet implements internet{

    private internet rI = new realInternet();

    private static List<String> banned = new ArrayList<String>();
    
    static{
        banned.add("google.at");
        banned.add("reddut.com");
    }

    @Override
    public void connect(String site) throws Exception{
        if(banned.contains(site)){
            throw new Exception("Site is banned!");
        }
        rI.connect(site);
    }
    
}
