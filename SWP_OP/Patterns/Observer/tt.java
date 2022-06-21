public class tt extends verlag{
    private news ne;

    public void setNews(news n){
        this.ne = n;
        sendNews(n);
    }

    public news getNews(){
        return this.ne;
    }
}
