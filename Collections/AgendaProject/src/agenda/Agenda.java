package agenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Agenda {

    private Map<String, Person> contacts;

    public Agenda() {
        this.contacts = new HashMap<>();
    }

    /**
     * Inserts a person in the collection.
     *
     * @param person to be inserted.
     */
    public void insertPerson(Person person) {
        contacts.put(person.getName(), person);
    }

    /**
     * Searches for the first occurrence of a person.
     *
     * @param name is the key to be found.
     * @return a person if found, null otherwise.
     */
    public Person searchPerson(String name) {
        return contacts.values().stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Lists all people from contacts.
     *
     * @return a list of keys of the collection.
     */
    public List<String> listNames() {
        return new ArrayList<>(contacts.keySet());
    }

    public List<Person> listPeople() {
        return new ArrayList<>(contacts.values());
    }
}
