public interface talk {
    
    public void talking(human h);

}

class whisper implements talk{

    @Override
    public void talking(human h){
        System.out.println(h.getName() + " Whispering");
    }

}

class yelling implements talk{

    @Override
    public void talking(human h){
        System.out.println(h.getName() + " Yelling");
    }

}