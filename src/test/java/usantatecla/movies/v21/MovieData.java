package usantatecla.movies.v21;

public class MovieData {
    String title;
    Double price;

    public MovieData(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
}
