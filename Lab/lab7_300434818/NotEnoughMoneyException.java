public class NotEnoughMoneyException extends IllegalStateException {
    private double amount;
    private double balance;

    public NotEnoughMoneyException(double amount, double balance) {
        super("you have not enough money to withdraw " + amount + "$");
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getMissingAmount() {
        return amount - balance;
    }
}
