package usantatecla.movies.v21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	private static final String REGULAR_MOVIE_NAME = "regularMovieName";
	private static final String NEW_RELEASE_MOVIE_NAME = "newReleaseMovieName";
	private static final String CHILDREN_MOVIE_NAME = "childrenMovieName";
	private static final String CUSTOMER_NAME = "customerName";
	private static final int DAYS = 10;


	@Test
	public void testGivenCustomerStatementWithoutRentalThenCorrectCustomerName() {
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).build();
		String statement = customer.statement();
		assertEquals(CUSTOMER_NAME, new StatementData(statement).getCustomerName());
	}

	@Test
	public void testGivenCustomerStatementWhenRental10DaysThenCorrectMoviesTitles() {
		Customer customer = new CustomerBuilder()
				.name(CUSTOMER_NAME)
				.rental(this.createRegularMovieRental())
				.rental(this.createNewReleaseMovieRental())
				.rental(this.createChildrenMovieRental())
				.build();

		StatementData statementData = new StatementData(customer.statement());

		assertEquals(REGULAR_MOVIE_NAME, statementData.getTitleMovie(0));
		assertEquals(NEW_RELEASE_MOVIE_NAME, statementData.getTitleMovie(1));
		assertEquals(CHILDREN_MOVIE_NAME, statementData.getTitleMovie(2));
	}

	@Test
	public void testGivenCustomerStatementWhenRental10DaysThenCorrectTotalCharge() {
		Customer customer = new CustomerBuilder()
				.name(CUSTOMER_NAME)
				.rental(this.createRegularMovieRental())
				.rental(this.createNewReleaseMovieRental())
				.rental(this.createChildrenMovieRental())
				.build();

		StatementData statementData = new StatementData(customer.statement());

		assertEquals(32.0D, statementData.getTotalCharge(),Double.NaN);
	}

	@Test
	public void testGivenCustomerStatementWhenRental10DaysThenCorrectRenterPoints() {
		Customer customer = new CustomerBuilder()
				.name(CUSTOMER_NAME)
				.rental(this.createRegularMovieRental())
				.rental(this.createNewReleaseMovieRental())
				.rental(this.createChildrenMovieRental())
				.build();

		StatementData statementData = new StatementData(customer.statement());

		assertEquals(4,statementData.getFrequentRenterPoints());
	}

	private Rental createRegularMovieRental(){
		RegularMovie regularMovie = new RegularMovie(REGULAR_MOVIE_NAME);
		return new RentalBuilder().movie(regularMovie).daysRented(DAYS).build();
	}

	private Rental createNewReleaseMovieRental(){
		NewReleaseMovie newReleaseMovie = new NewReleaseMovie(NEW_RELEASE_MOVIE_NAME);
		return new RentalBuilder().movie(newReleaseMovie).daysRented(DAYS).build();
	}

	private Rental createChildrenMovieRental(){
		ChildrenMovie childrenMovie = new ChildrenMovie(CHILDREN_MOVIE_NAME);
		return new RentalBuilder().movie(childrenMovie).daysRented(DAYS).build();
	}

	
	
}
