package usantatecla.movies.v21;

import java.util.ArrayList;
import java.util.List;

public class StatementData {
    private static final int CUSTOMER_NAME_SENTENCE_POSITION = 0;
    private static final int CUSTOMER_NAME_DATA_POSITION = 3;
    private static final int TITLE_MOVIE_DATA_POSITION = 1;
    private static final int CHARGE_MOVIE_DATA_POSITION = 2;
    private static final int TOTAL_CHARGE_DATA_POSITION = 3;
    private static final int RENTER_POINTS_DATA_POSITION = 2;
    private static final int FIRST_MOVIE_SENTENCE_LIMIT = 1;
    private static final String SPACE_CHARACTER = " ";
    private static final String END_LINE_CHARACTER = "\n";
    private static final String TABULATION_CHARACTER = "\t";
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
        String[] statementLines = statement.split(END_LINE_CHARACTER);
        int frequentPointsPosition = statementLines.length - 1;
        int totalChargePosition = statementLines.length - 2;
        int lastMoviesPosition = statementLines.length - 3;

        this.customerName = statementLines[CUSTOMER_NAME_SENTENCE_POSITION].split(SPACE_CHARACTER)[CUSTOMER_NAME_DATA_POSITION];

        for (int i = FIRST_MOVIE_SENTENCE_LIMIT; i <= lastMoviesPosition; i++ ){
            String[] movieWords = statementLines[i].split(TABULATION_CHARACTER);
            this.movieDataList.add(new MovieData(movieWords[TITLE_MOVIE_DATA_POSITION],Double.parseDouble(movieWords[CHARGE_MOVIE_DATA_POSITION])));
        }
        this.totalCharge = Double.parseDouble(statementLines[totalChargePosition].split(SPACE_CHARACTER)[TOTAL_CHARGE_DATA_POSITION]);
        this.frequentRenterPoints = Integer.parseInt(statementLines[frequentPointsPosition].split(SPACE_CHARACTER)[RENTER_POINTS_DATA_POSITION]);
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getTitleMovie(int position) {
        return movieDataList.get(position).getTitle();
    }

    public Double getChargeMovie(int position) {
        return movieDataList.get(position).getCharge();
    }

    public Double getTotalCharge() {
        return totalCharge;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
