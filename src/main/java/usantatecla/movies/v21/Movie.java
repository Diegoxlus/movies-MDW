package usantatecla.movies.v21;

public abstract class Movie {

    private static final int FREQUENT_RENTER_POINTS = 1;

    private final String title;

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return Movie.FREQUENT_RENTER_POINTS;
    }

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
