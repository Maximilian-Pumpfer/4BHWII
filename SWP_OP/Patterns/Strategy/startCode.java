public class startCode {

    public static void main(String[] args) {
        Kuh k = new Kuh();
        Affe a = new Affe();

        a.gehen();
        a.schlafen();
        k.schlafen();
        a.setSchlafen(new tiefSchlafen());
        a.schlafen();
    }
    
}
