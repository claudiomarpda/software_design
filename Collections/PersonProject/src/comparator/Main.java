package comparator;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("111.111.111-11", "Equal Name", new Date(2, 6, 1990)),
                new Person("222.222.222-22", "Person B", new Date(1, 6, 1990)),
                new Person("333.333.333-33", "Person C", new Date(1, 1, 1993)),
                new Person("555.555.555-55", "Equal Name", new Date(1, 1, 2007)),
                new Person("444.444.444-44", "Person D", new Date(1, 1, 1999))
        );

        // Block01: TreeSet
        // if enabled, Block02 must be disabled (commented)

        TreeSet<Person> treeSet1 = new TreeSet<>(new NameComparator());
        TreeSet<Person> treeSet2 = new TreeSet<>(new DateComparator());

        treeSet1.addAll(persons);
        treeSet2.addAll(persons);

        System.out.println("TreeSet");
        System.out.println("Sorting Person objects by name, if equal names, sorts by cpf...");
        treeSet1.forEach(System.out::println);
        System.out.println();

        System.out.println("Sorting Person objects by birth date...");
        treeSet2.forEach(System.out::println);
        System.out.println();


        // Block02: sort() method from List
        // if enabled, Block01 must be disabled (commented)
/*
        System.out.println("List sort()");
        System.out.println("Sorting by sort() from List according to NameComparator...");
        persons.sort(new NameComparator());
        persons.forEach(System.out::println);
        System.out.println();

        System.out.println("Sorting by sort() from List according to DateComparator...");
        persons.sort(new DateComparator());
        persons.forEach(System.out::println);
*/
    }
}
