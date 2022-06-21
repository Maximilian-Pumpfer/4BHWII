public interface users {
    public void sendNews(news n);
}

class singleUser implements users{

    private String name;

    public singleUser(String n){
        this.name = n;
    }

    @Override
    public void sendNews(news n){
            System.out.println(n.getTitle() + " was sent to " + this.name);
    }
}
