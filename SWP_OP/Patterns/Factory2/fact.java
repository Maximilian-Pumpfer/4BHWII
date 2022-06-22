public class fact {

    drinks d;

    public drinks makeDrink(choose c){
        switch(c){
            case be: d = new beer(); break;
            case wi: d = new wine(); break;
            default: d = new beer();
        }
        return d;
    }
    
}

enum choose{
    be, wi
}
