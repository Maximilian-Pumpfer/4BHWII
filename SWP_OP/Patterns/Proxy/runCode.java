public class runCode {

    public static void main(String[] args) throws Exception {
        internet pI = new proxyInternet();
        try{
        pI.connect("google.com");
        pI.connect("reddut.com");
    }catch(Exception e){
        System.out.println(e);
    }
}
}
