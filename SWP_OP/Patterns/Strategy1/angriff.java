public interface angriff {
    
    public void angreifen(roboter r);

}

class leichtAngreifen implements angriff{

    @Override
    public void angreifen(roboter r){
        System.out.println(r.getName() + ":Leicht angreifen");
    }

}

class starkAngreifen implements angriff{

    @Override
    public void angreifen(roboter r){
        System.out.println(r.getName() + ":Stark angreifen");
    }

}