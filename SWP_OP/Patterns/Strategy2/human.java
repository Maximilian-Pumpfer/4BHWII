public class human {

    private String name;
    public human(String s){
        this.name = s;
    }

    public String getName(){
        return this.name;
    }

    private talk ta;
    private sleep sl;

    public void setTalk(talk t){
        this.ta = t;
    }

    public void setSleep(sleep s){
        this.sl = s;
    }

    public void talking(){
        this.ta.talking(this);
    }

    public void sleeping(){
        this.sl.sleeping(this);
    }
    
}

class italian extends human{

    public italian(String s) {
        super(s);
        setSleep(new lightSleep());
        setTalk(new yelling());
    }
   
}

class austrian extends human{

    public austrian(String s) {
        super(s);
        setSleep(new deepSleep());
        setTalk(new whisper());
    }
   
}