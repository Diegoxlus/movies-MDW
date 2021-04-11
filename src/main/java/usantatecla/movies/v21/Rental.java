package usantatecla.movies.v21;

public class Rental {

    private final Movie movie;

    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    public int getDaysRented() {
        return daysRented;
    }

    public String getTitleMovie() {
        return movie.getTitle();
    }

}
