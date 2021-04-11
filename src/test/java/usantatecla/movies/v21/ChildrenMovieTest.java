package usantatecla.movies.v21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChildrenMovieTest {

    private static final String MOVIE_NAME = "movieName";
    private static final String CUSTOMER_NAME = "customerName";

    private ChildrenMovie childrenMovie;

    @Before
    public void before(){
        this.childrenMovie = new ChildrenMovie(MOVIE_NAME);
    }

    @Test
    public void testGivenCustomerStatementOfChildrenMovieWhenRental1DayThenCorrectCustomerName() {
        String statement = getStatement(1);
        assertEquals(CUSTOMER_NAME, new StatementData(statement).getCustomerName());
    }

    @Test
    public void testGivenCustomerStatementOfChildrenMovieWhenRental1DayThenCorrectMovie() {
        String statement = getStatement(1);
        assertEquals(MOVIE_NAME,new StatementData(statement).getTitleMovie(0));
        assertEquals(1.5D,new StatementData(statement).getChargeMovie(0),Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfChildrenMovieWhenRental1DayThenCorrectTotalCharge() {
        String statement = getStatement(1);
        assertEquals(1.5D,new StatementData(statement).getTotalCharge(),Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfChildrenMovieWhenRental1DayThenCorrectRenterPoints() {
        String statement = getStatement(1);
        assertEquals(1,new StatementData(statement).getFrequentRenterPoints());
    }

    @Test
    public void testGivenCustomerStatementOfChildrenMovieWhenRental4DayThenCorrectTotalCharge() {
        String statement = getStatement(4);
        assertEquals(6.0D,new StatementData(statement).getTotalCharge(),Double.NaN);
    }

    @Test
    public void testGivenCustomerStatementOfChildrenMovieWhenRental4DayThenCorrectRenterPoints() {
        String statement = getStatement(4);
        assertEquals(1,new StatementData(statement).getFrequentRenterPoints());
    }

    private String getStatement(int days) {
        Rental rental = new RentalBuilder().movie(this.childrenMovie).daysRented(days).build();
        Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();
        return customer.statement();
    }
}
