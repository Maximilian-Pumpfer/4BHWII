public abstract class roboter {

    private String name;
    public roboter(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    private angriff a;
    private block b;

    public void setAngriff(angriff ang){
        this.a = ang;
    }

    public void setBlock(block bl){
        this.b = bl;
    }

    public void angreifen(){
        this.a.angreifen(this);
    }

    public void blocken(){
        this.b.blocken(this);
    }
    
}

class battleBot extends roboter{

    public battleBot(String n) {
        super(n);
    setAngriff(new starkAngreifen());
    setBlock(new leichtBlocken());
    }
}

class defenseBot extends roboter{

    public defenseBot(String n) {
        super(n);
        setAngriff(new leichtAngreifen());
        setBlock(new starkBlocken());
    }
}