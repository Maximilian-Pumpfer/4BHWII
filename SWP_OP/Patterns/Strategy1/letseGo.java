public class letseGo {

    public static void main(String[] args) {

        battleBot b1 = new battleBot("bot1");
        defenseBot b2 = new defenseBot("bot2");
        b1.angreifen();
        b2.blocken();
        b2.setAngriff(new starkAngreifen());
        b2.angreifen();
    
    }
}