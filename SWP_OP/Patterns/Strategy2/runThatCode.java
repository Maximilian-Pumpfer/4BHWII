public class runThatCode {
    
    public static void main(String[] args) {
        
        austrian a = new austrian("Anton aus Tirol");
        italian i = new italian("Giovanni");

        a.talking();
        i.talking();
        i.sleeping();
        i.setSleep(new deepSleep());
        i.sleeping();

    }

}
