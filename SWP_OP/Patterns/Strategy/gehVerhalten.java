public interface gehVerhalten {
    
    public void gehen();

}

class langsamGehen implements gehVerhalten{

    @Override
    public void gehen(){
        System.out.println("Langsam gehen");
    }

}

class schnellGehen implements gehVerhalten{

    @Override
    public void gehen(){
        System.out.println("Schnell gehen");
    }

}
