public interface drinks {
    
    public void volume();

}

class beer implements drinks{

    @Override
    public void volume(){
        System.out.println("5-6%");
    }

}

class wine implements drinks{

    @Override
    public void volume(){
        System.out.println("10-11%");
    }

}