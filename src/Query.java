import java.time.LocalDateTime;

public class Query extends Message{

	public Query(String accountNumber, String accountName, LocalDateTime date, String text) {
		super(accountNumber, accountName, date, text);
	}

}
