public interface kunden {

    public String getName();
    
}

class einzelkunde implements kunden{

    private String name;

    public einzelkunde(String n){
        this.name = n;
    }

    @Override
    public String getName(){
        return this.name;
    }

}