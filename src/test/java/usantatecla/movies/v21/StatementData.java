package usantatecla.movies.v21;

import java.util.ArrayList;
import java.util.List;

public class StatementData {
    private static final int CUSTOMER_NAME_SENTENCE_LIMIT = 1;
    private static final int FIRST_MOVIE_SENTENCE_LIMIT = 2;
    private int frequentPointsPosition;
    private int totalChargePosition;
    private int lastMoviesPosition;
    private String customerName;
    private List<MovieData> movieDataList;
    private Double totalCharge;
    private int frequentRenterPoints;

    public StatementData (String statement){
        this.customerName = "";
        this.movieDataList = new ArrayList<MovieData>();
        this.totalCharge = Double.NaN;
        this.frequentRenterPoints = 0;
        this.segmentStatement(statement);
    }

    private void segmentStatement(String statement){
        String[] x = statement.split("\n");
        this.frequentPointsPosition = x.length-1;
        this.totalChargePosition = x.length-2;
        this.lastMoviesPosition = x.length-3;

        this.customerName = x[0].split(" ")[3];

        for (int i = FIRST_MOVIE_SENTENCE_LIMIT; i < this.lastMoviesPosition; i++ ){
            String[] y = x[i].split("\t");
            MovieData movieData = new MovieData(y[1],Double.parseDouble(y[2]));
            this.movieDataList.add(movieData);
        }
        this.totalCharge = Double.parseDouble(x[this.totalChargePosition].split(" ")[3]);
        this.frequentRenterPoints = Integer.parseInt(x[this.frequentPointsPosition].split(" ")[2]);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<MovieData> getMovieDataList() {
        return movieDataList;
    }

    public Double getTotalCharge() {
        return totalCharge;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
