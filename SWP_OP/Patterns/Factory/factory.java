public class factory {

    public cars createCar(autos car){
        cars c;
        switch(car){
            case audi: 
            c = new Audi(); break;
            case bmw:
            c = new Bmw(); break;
            default: 
            c = new Vw(); break;
        }
        return c;
    }
    
}

enum autos {
    audi, bmw
}