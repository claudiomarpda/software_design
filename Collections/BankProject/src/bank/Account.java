package bank;

public class Account {

    private String number;
    private double balance;

    public Account() {
        number = "7777";
        balance = 77;
    }

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double value) {
        this.balance -= value;
    }

    public void credit(double value) {

    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
