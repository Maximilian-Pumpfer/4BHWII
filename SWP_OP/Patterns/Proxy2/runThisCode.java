public class runThisCode {
    
    public static void main(String[] args) {
        proxyI p = new proxyI();
        p.connect("amazon.at");
        p.connect("amazon.de");
    }   

}
