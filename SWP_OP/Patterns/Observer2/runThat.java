public class runThat {

    public static void main(String[] args) {
        amazon a = new amazon();
        cust c = new cust("Joe");
        cust c1 = new cust("Marcl");
        a.sub(c);
        a.sub(c1);
        a.inform(new product("NVIDIA GeForce RTX 3080"));
        a.unsub(c1);
        a.inform(new product("NVIDIA GeForce RTX 3080TI"));
    }
    
}
