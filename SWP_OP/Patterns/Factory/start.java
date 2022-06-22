public class start {

    public static void main(String[] args) {
      factory f = new factory();
      cars c = f.createCar(autos.audi);
      cars c1 = f.createCar(autos.bmw);
      System.out.println(c.getName());  
      System.out.println(c1.getName());
    }
    
}
