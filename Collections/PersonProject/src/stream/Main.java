package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("111.111.111-11", "Equal Name", new Date(2, 6, 1990)),
                new Person("222.222.222-22", "Person B", new Date(1, 6, 1990)),
                new Person("333.333.333-33", "Person C", new Date(1, 1, 1993)),
                new Person("555.555.555-55", "Equal Name", new Date(1, 1, 2007)),
                new Person("444.444.444-44", "Person D", new Date(1, 1, 1999))
        );

        System.out.println("#Streams");
        System.out.println("Sorting Person objects by name, if equal names, sorts by cpf...");
        persons.stream().sorted(Person::nameDifference).forEach(System.out::println);
        System.out.println();

        System.out.println("Sorting Person objects by birth date...");
        persons.stream().sorted(Person::birthDifference).forEach(System.out::println);

    }
}
