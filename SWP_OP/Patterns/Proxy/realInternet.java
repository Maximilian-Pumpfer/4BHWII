import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class realInternet implements internet{
    
    @Override
    public void connect(String site) throws Exception{
        System.out.println("Connected to " + site);
    }

}
