import bank.Account;
import bank.Bank;
import bank.Client;

public class Main {

    public static void main(String[] args) {

        Bank b = new Bank();

        Account a1 = new Account();
        Account a2 = new Account("102", 10);
        Account a3 = new Account("103", 100);
        Account a4 = new Account("104", 100);
        Account a5 = new Account("105", 1000);
        Account a6 = new Account("106", 10000);

        Client c1 = new Client();
        Client c2 = new Client("Client C2", "222.222.222-22");
        Client c3 = new Client("Client C3", "333.333.333-33");
        Client c4 = new Client("Client C4", "444.444.444-44");

        b.insert(a1, c1);
        b.insert(a2, c2);
        b.insert(a3, c3);
        b.insert(a4, c3);
        b.insert(a5, c4);
        b.insert(a6, c4);

        System.out.println("Searching account " + a1.getNumber() + "...");
        System.out.println(b.searchAccount(a1.getNumber()));
        System.out.println();
        System.out.println("Searching client " + c1.getCpf());
        System.out.println(b.searchClient(c1.getCpf()));
        System.out.println();
        System.out.println("Searching client " + c2.getCpf() + " accounts...");
        System.out.println(b.searchClientAccounts(c2.getCpf()));
        System.out.println();
        System.out.println("Searching client " + c3.getCpf() + " accounts...");
        System.out.println(b.searchClientAccounts(c3.getCpf()));
        System.out.println();
        System.out.println("Searching client " + c4.getCpf() + " accounts...");
        System.out.println(b.searchClientAccounts(c4.getCpf()));

    }
}
