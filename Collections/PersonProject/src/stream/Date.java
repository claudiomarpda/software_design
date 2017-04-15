package stream;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Compares the name, month and year with another Date object.
     *
     * @param other date to be compared with this
     * @return the result of the comparison according to Comparable interface
     */
    public int dateDifference(final Date other) {
        int yearDifference = Integer.compare(this.year, other.year);
        if(yearDifference != 0) { // years are different, we have a solution
            return yearDifference;
        }

        int monthDifference = Integer.compare(this.month, other.month);
        if(monthDifference != 0) { // months are different, we have a solution
            return yearDifference;
        }

        // year and month are equal, the days comparison decide
        return Integer.compare(this.day, other.day);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
