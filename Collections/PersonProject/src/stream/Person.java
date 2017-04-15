package stream;

public class Person {

    private String cpf;
    private String name;
    private Date birth;

    public Person(String cpf, String name, Date birth) {
        this.cpf = cpf;
        this.name = name;
        this.birth = birth;
    }

    /**
     * Compares the name of two Person objects.
     *
     * @param other person to be compared
     * @return the result of the comparison according to Comparator interface
     */
    public int nameDifference(final Person other) {
        int nameDifference = String.CASE_INSENSITIVE_ORDER.compare(this.name, other.name);
        if(nameDifference == 0) { // equal names
            // cpf comparison decides it
            return cpfDifference(other);
        }
        return nameDifference;
    }

    /**
     * Compares the  cpf of two Person objects.
     *
     * @param other person to be compared with this
     * @return the result of the comparison according to Comparator interface
     */
    private int cpfDifference(final Person other) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.cpf, other.cpf);
    }

    /**
     * Compares the birth of two Person objects.
     */
    public int birthDifference(final Person other) {
        return birth.dateDifference(other.birth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
