public abstract class viech {
    
    private gehVerhalten gV;
    private schlafVerhalten sV;

    public void setGehen(gehVerhalten g){
        this.gV = g;
    }
    public void setSchlafen(schlafVerhalten s){
        this.sV = s;
    }
    public void gehen(){
        this.gV.gehen();
    }
    public void schlafen(){
        this.sV.schlafen();
    }

}

class Kuh extends viech{
    public Kuh(){
    setGehen(new langsamGehen());
    setSchlafen(new tiefSchlafen());
    }
}

class Affe extends viech{
    public Affe(){
    setGehen(new schnellGehen());
    setSchlafen(new leichtSchlafen());
    }
}
