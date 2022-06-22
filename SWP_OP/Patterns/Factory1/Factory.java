public class Factory {

    books b;

    public books createBook(genre t){
        switch (t) {
            case Thriller: b = new thriller(); break;        
            case Fantasy: b = new fantasy(); break;
            default: b = new thriller(); break;
        }
        return b;
    }
 
}

enum genre{
    Thriller, Fantasy
}   