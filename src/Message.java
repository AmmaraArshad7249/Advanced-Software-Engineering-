import java.time.LocalDateTime;

public class Message {
    private String accountNumber;
    private String accountName;
    private LocalDateTime date;
    private String text;

    public Message(String accountNumber, String accountName, LocalDateTime date, String text) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.date = date;
        this.text = text;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}