package usantatecla.movies.v21;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChildrenMovieTest {

    @Test
    public void childrensRental1DayTest() {
        String movieName = "movieName";
        ChildrenMovie movie = new ChildrenMovie(movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental3DayTest() {
        String movieName = "movieName";
        ChildrenMovie movie = new ChildrenMovie(movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental4DayTest() {
        String movieName = "movieName";
        ChildrenMovie movie = new ChildrenMovie(movieName);
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 6)
                .totalAmount(6).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }
}
