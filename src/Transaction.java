import java.time.LocalDate;

public class Transaction {
    private String accountNumber;
    private double amount;
    private LocalDate date;
    private String type;

    public Transaction(String accountNumber, double amount, LocalDate date, String type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
