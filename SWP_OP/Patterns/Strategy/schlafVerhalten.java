public interface schlafVerhalten {
    
    public void schlafen();

}

class leichtSchlafen implements schlafVerhalten{

    @Override
    public void schlafen(){
        System.out.println("Leicht schlafen");
    }

}

class tiefSchlafen implements schlafVerhalten{

    @Override
    public void schlafen(){
        System.out.println("Tief schlafen");
    }

}
