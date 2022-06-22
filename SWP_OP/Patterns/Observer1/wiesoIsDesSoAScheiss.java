public class wiesoIsDesSoAScheiss {

    public static void main(String[] args) {

        einzelkunde k = new einzelkunde("Güntha");
        einzelkunde k1 = new einzelkunde("Jopepe");
        dhl d = new dhl();
        d.sub(k);
        d.setWerbung(new werbung("AboutYou"));
        d.sub(k1);
        d.setWerbung(new werbung("Amazon"));
        d.unsub(k);
        d.setWerbung(new werbung("Trivago"));
    }
}
