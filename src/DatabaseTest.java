import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class DatabaseTest {


	    @Test
	    public void testUpdateAccountDetailsInDatabase() {
	        BankAccount bankAccount = new BankAccount("Abdullah", "hehe@example.com", "1234567890", "123 Main St","fgh","789", "Anytown", "12345", "Personal", false,1000.0);
	        bankAccount.setNo("123");
	        Database.updateAccountDetailsInDatabase(bankAccount);
	    }
	    
	    @Test
	    public void testAuthenticate() {
	        BankAccount authenticatedAccount = Database.authenticate("abc", "123");
	        assertNotNull(authenticatedAccount);
	        
	        authenticatedAccount = Database.authenticate("invalidUsername", "invalidPassword");
	        assertEquals(null, authenticatedAccount);
	    }
	    
	    @Test
	    public void testAddRecurringPayment() {
	        Payment payment = new Payment("Abdullah","Maryam", 500.0, 30);
	        
	        Database.addRecurringPayment(payment);
	    }
	    
	    @Test
	    public void testGetAllRecurringPayments() {
	        ArrayList<Payment> recurringPayments = Database.getAllRecurringPayments("Abdullah");
	        assertTrue(recurringPayments.size() != 0);
	        
	    }

	    @Test
	    public void testGetTransactionsByAccountNumber() {
	        ArrayList<Transaction> transactions = Database.getTransactionsByAccountNumber("1");
	        assertTrue(transactions.size() != 0);	        
	    }

	    @Test
	    public void testAddTransactionToDatabase() {
	        Transaction transaction = new Transaction("123456", 500.0, LocalDate.now(), "Deposit");
	        
	        Database.addTransactionToDatabase(transaction);
	    }

	    @Test
	    public void testSearchAccountByNumber() {
	        BankAccount bankAccount = Database.searchAccountByNumber("1");
	        
	        assertNotNull(bankAccount);
	        
	    }

	    @Test
	    public void testAddIssueToDatabase() {
	        BankAccount account = new BankAccount("Abdullah", "example@example.com", "1234567890","abc" ,"321s","123 Main St", "Anytown", "12345", "Personal", false, 1000.0);
	        account.setNo("123456");
	        
	        Database.addIssueToDatabase(account, "Issue description");
	        
	    }

}
