package bad.robot.refactoring.chapter1;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    static double getChargeFor(Rental rental) {
        double amount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (rental.getDaysRented() > 2)
                    amount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (rental.getDaysRented() > 3)
                    amount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }

    static int calculateFrequentRenterPoints(Rental rental, int points) {
        // add frequent renter points
        points++;
        // add bonus for a two day new release rental
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
            points++;
        return points;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

}
