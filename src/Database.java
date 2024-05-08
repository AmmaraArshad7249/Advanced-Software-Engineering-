import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Database {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/bankingsoftwaresystem";
	private static final String USER = "root";
	private static final String PASSWORD = "new_password";

	public static void updateAccountDetailsInDatabase(BankAccount bankAccount) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE BankAccount SET name = ?, email = ?, phone = ?, address = ?, city = ?, zipcode = ?, accountType = ?, balance=?, encryption=? WHERE accountNumber = ?")) {
			statement.setString(1, bankAccount.getName());
			statement.setString(2, bankAccount.getEmail());
			statement.setString(3, bankAccount.getPhone());
			statement.setString(4, bankAccount.getAddress());
			statement.setString(5, bankAccount.getCity());
			statement.setString(6, bankAccount.getZipcode());
			statement.setString(7, bankAccount.getAccountType());
			statement.setDouble(8, bankAccount.getAmount());
			statement.setBoolean(9, bankAccount.isEncryption());
			statement.setInt(10, Integer.parseInt(bankAccount.getNo()));

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				// System.out.println("Account details updated successfully.");
			} else {
				// System.out.println("Failed to update account details.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public static BankAccount authenticate(String username, String password) {
		BankAccount bankAccount = null;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM BankAccount WHERE username = ? AND password = ?")) {
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				bankAccount = new BankAccount(resultSet.getString("name"), resultSet.getString("email"),
						resultSet.getString("phone"), resultSet.getString("address"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("city"), resultSet.getString("zipcode"),
						resultSet.getString("accountType"), resultSet.getBoolean("encryption"),
						resultSet.getDouble("balance"));
				bankAccount.setNo(resultSet.getString("accountNumber"));
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return bankAccount;
	}

	public static void addRecurringPayment(Payment payment) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO payment (accountName,toAccount, amount, intervalInDays) VALUES (?, ?, ?,?)")) {
			statement.setString(1, payment.getAccountName());
			statement.setString(2, payment.getToAccount());
			statement.setDouble(3, payment.getAmount());
			statement.setInt(4, payment.getIntervalInDays());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				// System.out.println("Recurring payment added successfully.");
			} else {
				// System.out.println("Failed to add recurring payment.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public static ArrayList<Payment> getAllRecurringPayments(String accountName) {
		ArrayList<Payment> recurringPayments = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM payment WHERE accountName = ?");) {
			statement.setString(1, accountName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String toAccount = resultSet.getString("toAccount");
				double amount = resultSet.getDouble("amount");
				int intervalInDays = resultSet.getInt("intervalInDays");
				Payment payment = new Payment(accountName, toAccount, amount, intervalInDays);
				recurringPayments.add(payment);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return recurringPayments;
	}

	public static void saveAccountToDatabase(BankAccount bankAccount) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO BankAccount (name, email, phone, address,username, password,  city, zipcode, accountType, balance, encryption) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
			statement.setString(1, bankAccount.getName());
			statement.setString(2, bankAccount.getEmail());
			statement.setString(3, bankAccount.getPhone());
			statement.setString(4, bankAccount.getAddress());
			statement.setString(5, bankAccount.getUsername());
			statement.setString(6, bankAccount.getPassword());
			statement.setString(7, bankAccount.getCity());
			statement.setString(8, bankAccount.getZipcode());
			statement.setString(9, bankAccount.getAccountType());
			statement.setDouble(10, bankAccount.getAmount());
			statement.setBoolean(11, bankAccount.isEncryption());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				// System.out.println("Account added successfully.");
			} else {
				// System.out.println("Failed to add account.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public static void deleteAccountFromDatabase(BankAccount bankAccount) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM BankAccount WHERE accountNumber = ?")) {
			statement.setInt(1, Integer.parseInt(bankAccount.getNo()));

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				// System.out.println("Account deleted successfully.");
			} else {
				// System.out.println("Failed to delete account.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public static void addQueryToDatabase(Query query) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Query (accountNumber, accountName, text, date) VALUES (?, ?, ?, ?)")) {
			statement.setString(1, query.getAccountNumber());
			statement.setString(2, query.getAccountName());
			statement.setString(3, query.getText());
			statement.setObject(4, LocalDateTime.now());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				// System.out.println("Query added successfully.");
			} else {
				// System.out.println("Failed to add query.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public static ArrayList<Transaction> getTransactionsByAccountNumber(String accountNumber) {
		ArrayList<Transaction> transactions = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Transaction WHERE accountNumber = ?")) {
			statement.setString(1, accountNumber);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				double amount = resultSet.getDouble("amount");
				String transactionType = resultSet.getString("transaction_type");
				java.sql.Date transactionDate = resultSet.getDate("transaction_date");

				Transaction transaction = new Transaction(accountNumber, amount, transactionDate.toLocalDate(),
						transactionType);
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return transactions;
	}

	public static void addTransactionToDatabase(Transaction transaction) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Transaction (accountNumber, amount, transaction_date, transaction_type) VALUES (?, ?, ?, ?)")) {
			statement.setString(1, transaction.getAccountNumber());
			statement.setDouble(2, transaction.getAmount());
			statement.setObject(3, LocalDateTime.now());
			statement.setString(4, transaction.getType());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				// System.out.println("Transaction added successfully.");
			} else {
				// System.out.println("Failed to add transaction.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public static BankAccount searchAccountByNumber(String accountNumber) {
		BankAccount bankAccount = null;
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM BankAccount WHERE accountNumber = ?")) {
			statement.setString(1, accountNumber);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				bankAccount = new BankAccount(resultSet.getString("name"), resultSet.getString("email"),
						resultSet.getString("phone"), resultSet.getString("address"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("city"), resultSet.getString("zipcode"),
						resultSet.getString("accountType"), resultSet.getBoolean("encryption"),
						resultSet.getDouble("balance"));
				bankAccount.setNo(resultSet.getString("accountNumber"));
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return bankAccount;
	}

	public static void addIssueToDatabase(BankAccount account, String issueText) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Issue (accountNumber, accountName,text, date) VALUES (?, ?, ?,?)")) {
			statement.setString(1, account.getNo());
			statement.setString(2, account.getName());
			statement.setString(3, issueText);
			statement.setObject(4, LocalDate.now());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				// System.out.println("Issue added successfully.");
			} else {
				// System.out.println("Failed to add issue.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	public static void addTransferToDatabase(Transfer.TransferClass transferClass) {
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Transfer (senderAccountNo,receiverAccountNo, amount, date) VALUES (?, ?, ?, ?)")) {
			statement.setString(1, transferClass.getAccountNumber());
			statement.setString(2, transferClass.getToAccount());
			statement.setDouble(3, transferClass.getAmount());
			statement.setObject(4, LocalDateTime.now());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				// System.out.println("Transaction added successfully.");
			} else {
				// System.out.println("Failed to add transaction.");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

}
