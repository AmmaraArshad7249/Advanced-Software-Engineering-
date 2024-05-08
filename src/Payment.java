
public class Payment {
	String accountName, toAccount;
	double amount;
	int intervalInDays;

	
	public Payment(String accountName, String toAccount, double amount, int intervalInDays) {
		this.accountName = accountName;
		this.toAccount = toAccount;
		this.amount = amount;
		this.intervalInDays = intervalInDays;
	}
	
	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getIntervalInDays() {
		return intervalInDays;
	}

	public void setIntervalInDays(int intervalInDays) {
		this.intervalInDays = intervalInDays;
	}
}
