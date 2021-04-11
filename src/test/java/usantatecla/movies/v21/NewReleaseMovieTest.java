package usantatecla.movies.v21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewReleaseMovieTest {

    private static final String MOVIE_NAME = "movieName";
    private static final String CUSTOMER_NAME = "customerName";

    private NewReleaseMovie newReleaseMovie;

    @Before
    public void before(){
        this.newReleaseMovie = new NewReleaseMovie(MOVIE_NAME);
    }

    @Test
    public void testGivenCustomerStatementOfNewReleaseMovieWhenRental1DayThenCorrectCustomerName() {
        String statement = getStatement(1);
        assertEquals(CUSTOMER_NAME, new StatementData(statement).getCustomerName());
    }

    @Test
    public void testGivenCustomerStatementOfNewReleaseMovieWhenRental1DayThenCorrectMovie() {
        String statement = getStatement(1);
        assertEquals(MOVIE_NAME,new StatementData(statement).getTitleMovie(0));
        assertEquals(3.0D,new StatementData(statement).getChargeMovie(0),Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfNewReleaseMovieWhenRental1DayThenCorrectTotalCharge() {
        String statement = getStatement(1);
        assertEquals(3.0D,new StatementData(statement).getTotalCharge(),Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfNewReleaseMovieWhenRental1DayThenCorrectRenterPoints() {
        String statement = getStatement(1);
        assertEquals(1,new StatementData(statement).getFrequentRenterPoints());
    }

    @Test
    public void testGivenCustomerStatementOfNewReleaseMovieWhenRental4DayThenCorrectTotalCharge() {
        String statement = getStatement(4);
        assertEquals(3.0D,new StatementData(statement).getTotalCharge(),Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfNewReleaseMovieWhenRental4DayThenCorrectRenterPoints() {
        String statement = getStatement(4);
        assertEquals(2,new StatementData(statement).getFrequentRenterPoints());
    }

    private String getStatement(int days) {
        Rental rental = new RentalBuilder().movie(this.newReleaseMovie).daysRented(days).build();
        Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();
        return customer.statement();
    }
}
