public class run {

    public static void main(String[] args) {
            
        tt tirolaZeitung = new tt();
        singleUser s1 = new singleUser("Josef");
        singleUser s2 = new singleUser("Stoani");
        tirolaZeitung.sub(s1);
        tirolaZeitung.sub(s2);
        tirolaZeitung.setNews(new news("I will nimma!"));
        tirolaZeitung.unsub(s1);
        tirolaZeitung.setNews(new news("I will imma nu ned!"));
    }    
}
