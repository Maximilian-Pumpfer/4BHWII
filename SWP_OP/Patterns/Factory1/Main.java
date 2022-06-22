public class Main {

    public static void main(String[] args) {
        Factory f = new Factory();
        books b = f.createBook(genre.Thriller);
        b.lesen();
    }
    
}
