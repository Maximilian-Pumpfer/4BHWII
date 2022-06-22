public interface books {
    public void lesen();
}

class thriller implements books{
    @Override
    public void lesen(){
        System.out.println("Gruselig!");
    }
}

class fantasy implements books{
    @Override
    public void lesen(){
        System.out.println("Mysteriös!");
    }
}
