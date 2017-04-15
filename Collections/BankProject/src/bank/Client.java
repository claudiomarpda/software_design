package bank;

/**
 * Created by mz on 13/04/17.
 */
public class Client {

    private String name;
    private String cpf;

    public Client() {
        this.name = "Nome e Sobrenome";
        this.cpf = "111.111.111-77";
    }

    public Client(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
