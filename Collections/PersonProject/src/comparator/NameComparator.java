package comparator;

import java.util.Comparator;

/**
 * Compares the name and cpf of two Person objects.
 * If names are equal, compares by cpf.
 */
public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int nameDifference = String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
        if(nameDifference == 0) { // equal names
            // compares by cpf
            return String.CASE_INSENSITIVE_ORDER.compare(o1.getCpf(), o2.getCpf());
        }
        return nameDifference;
    }
}
