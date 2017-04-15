package comparator;

import java.util.Comparator;

/**
 * Compares the birth of two Person objects.
 */
public class DateComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int yearDifference = Integer.compare(o1.getBirth().getYear(), o2.getBirth().getYear());
        if(yearDifference != 0) { // years are different, we have a solution
            return yearDifference;
        }

        int monthDifference = Integer.compare(o1.getBirth().getMonth(), o2.getBirth().getMonth());
        if(monthDifference != 0) { // months are different, we have a solution
            return yearDifference;
        }

        // year and month are equal, the days decide
        return Integer.compare(o1.getBirth().getDay(), o2.getBirth().getDay());
    }
}
