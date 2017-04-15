package comparator;

public class Person {

    private String cpf;
    private String name;
    private Date birth;

    public Person(String cpf, String name, Date birth) {
        this.cpf = cpf;
        this.name = name;
        this.birth = birth;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
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
