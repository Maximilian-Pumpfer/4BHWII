public class werbung {
    
    private String title;
    public werbung(String t){
        this.title = t;
    }

    public void getWerbung(kunden k){
        System.out.println(k.getName() + " bekommt Werbung von " + this.title);
    }

}
