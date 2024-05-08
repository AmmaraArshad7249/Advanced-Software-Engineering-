import java.time.LocalDateTime;

public class Issue extends Message{

	public Issue(String accountNumber, String accountName, LocalDateTime date, String text) {
		super(accountNumber, accountName, date, text);
	}


}
