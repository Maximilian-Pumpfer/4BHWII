public interface customer {
    
    public void informProd(product p);

}

class cust implements customer{

    private String name;
    public cust(String s){
        this.name = s;
    }

    @Override
    public void informProd(product p){
        System.out.println(this.name + " was informed about " + p.getName());
    }

}
