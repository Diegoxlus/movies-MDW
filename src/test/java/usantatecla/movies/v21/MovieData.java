package usantatecla.movies.v21;

public class MovieData {
    private String title;
    private Double charge;

    public MovieData(String title, Double charge) {
        this.title = title;
        this.charge = charge;
    }

    public String getTitle() {
        return title;
    }

    public Double getCharge() {
        return charge;
    }
}
