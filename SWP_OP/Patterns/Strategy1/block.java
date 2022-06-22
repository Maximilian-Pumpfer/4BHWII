public interface block {
    
    public void blocken(roboter r);

}

class leichtBlocken implements block{

    @Override
    public void blocken(roboter r){
        System.out.println(r.getName() + ": Leicht blocken");
    }

}

class starkBlocken implements block{

    @Override
    public void blocken(roboter r){
        System.out.println(r.getName() + ": Stark blocken");
    }

}