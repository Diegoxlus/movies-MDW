package usantatecla.movies.v21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularMovieTest {

    private static final String MOVIE_NAME = "movieName";
    private static final String CUSTOMER_NAME = "customerName";

    private RegularMovie regularMovie;

    @Before
    public void before() {
        this.regularMovie = new RegularMovie(MOVIE_NAME);
    }

    @Test
    public void testGivenCustomerStatementOfRegularMovieWhenRental1DayThenCorrectCustomerName() {
        String statement = getStatement(1);
        assertEquals(CUSTOMER_NAME, new StatementData(statement).getCustomerName());
    }

    @Test
    public void testGivenCustomerStatementOfRegularMovieWhenRental1DayThenCorrectMovie() {
        String statement = getStatement(1);
        assertEquals(MOVIE_NAME, new StatementData(statement).getTitleMovie(0));
        assertEquals(2.0D, new StatementData(statement).getChargeMovie(0), Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfRegularMovieWhenRental1DayThenCorrectTotalCharge() {
        String statement = getStatement(1);
        assertEquals(2.0D, new StatementData(statement).getTotalCharge(), Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfRegularMovieWhenRental1DayThenCorrectRenterPoints() {
        String statement = getStatement(1);
        assertEquals(1, new StatementData(statement).getFrequentRenterPoints());
    }

    @Test
    public void testGivenCustomerStatementOfRegularMovieWhenRental4DayThenCorrectTotalCharge() {
        String statement = getStatement(4);
        assertEquals(5.0D, new StatementData(statement).getTotalCharge(), Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfRegularMovieWhenRental4DayThenCorrectRenterPoints() {
        String statement = getStatement(4);
        assertEquals(1, new StatementData(statement).getFrequentRenterPoints());
    }

    private String getStatement(int days) {
        Rental rental = new RentalBuilder().movie(this.regularMovie).daysRented(days).build();
        Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();
        return customer.statement();
    }
}
