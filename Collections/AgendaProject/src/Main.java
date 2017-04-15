import agenda.Agenda;
import agenda.Person;

public class Main {

    public static void main(String[] args) {

        Agenda a = new Agenda();

        Person p1 = new Person();
        Person p2 = new Person("Person B", "2222-2222", "Address Two");
        Person p3 = new Person("Person C", "3333-3333", "Address Three");
        Person p4 = new Person("Person D", "4444-4444", "Address Four");
        Person p5 = new Person("Person E", "5555-5555", "Address Five");
        Person p6 = new Person("Person F", "6666-6666", "Address Six");

        a.insertPerson(p1);
        a.insertPerson(p2);
        a.insertPerson(p3);
        a.insertPerson(p4);
        a.insertPerson(p5);
        a.insertPerson(p6);

        System.out.println("Searching " + p1.getName() + "...");
        System.out.println(a.searchPerson(p1.getName()));
        System.out.println();
        System.out.println("Searching " + p2.getName() + "...");
        System.out.println(a.searchPerson(p2.getName()));
        System.out.println();
        System.out.println("Listing all names...");
        System.out.println(a.listNames());
        System.out.println();
        System.out.println("Listing all people...");

        a.listPeople().forEach(System.out::println);
    }
}
