package bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {

    private Map<Account, Client> registers;

    public Bank() {
        registers = new HashMap<>();
    }

    public void insert(Account account, Client client) {
        registers.put(account, client);
    }

    /**
     * Searches the first occurrence of an account.
     *
     * @param accountNumber desired
     * @return the account if found, null otherwise.
     */
    public Account searchAccount(String accountNumber) {
        return registers.keySet().stream()
                .filter(a -> a.getNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    /**
     * Searches the first occurrence of a client.
     *
     * @param cpf is the unique ID of the client.
     * @return the client if found, null otherwise.
     */
    public Client searchClient(String cpf) {
        return registers.values().stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    /**
     * Searches all accounts of a client.
     *
     * @param cpf is the unique ID of the client.
     * @return a list of accounts if any is found, empty list otherwise.
     */
    public List<Account> searchClientAccounts(String cpf) {
        return registers.entrySet().stream()
                .filter(m -> m.getValue().getCpf().equals(cpf))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
