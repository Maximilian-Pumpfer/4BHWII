public interface sleep {
    
    public void sleeping(human h);

}

class lightSleep implements sleep{

    @Override
    public void sleeping(human h){
        System.out.println(h.getName() + " Sleeping lightly");
    }

}

class deepSleep implements sleep{

    @Override
    public void sleeping(human h){
        System.out.println(h.getName() + " Sleeping deeply");
    }

}