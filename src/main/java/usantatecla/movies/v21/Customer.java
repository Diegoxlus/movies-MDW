package usantatecla.movies.v21;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;

    private final List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + this.getName() + "\n";
        for (Rental rental : this.rentals) {
            result += "\t" + rental.getTitleMovie() + "\t" + rental.getCharge() + "\n";
        }
        result += "Amount owed is " + this.getTotalCharge() + "\n";
        result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

}
