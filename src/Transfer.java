import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Transfer extends JPanel {
	private JTextField amountField;
	private JTextField accountNameField;
	private JButton searchButton, transferButton, paymentButton;
	private JTextField accountNumberField;
	private JTextField intervalField;
	private JPanel inputPanel;

	public Transfer(BankAccount account) {
		setLayout(null);

		inputPanel = new JPanel();
		inputPanel.setPreferredSize(new Dimension(500, 10));
		inputPanel.setLayout(null);
		inputPanel.setBounds(0, 0, 679, 499);

		JLabel accountNumberLabel = new JLabel("Account No:");
		accountNumberLabel.setBounds(80, 160, 89, 20);
		inputPanel.add(accountNumberLabel);
		accountNumberField = new JTextField();
		accountNumberField.setBounds(190, 161, 150, 30);
		inputPanel.add(accountNumberField);

		JLabel accountNameLabel = new JLabel("Name:");
		accountNameLabel.setBounds(80, 209, 70, 20);
		inputPanel.add(accountNameLabel);
		accountNameField = new JTextField();
		accountNameField.setBounds(190, 210, 150, 30);
		inputPanel.add(accountNameField);

		JLabel titleLabel_1 = new JLabel("Transfer Money");
		titleLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		titleLabel_1.setBounds(150, 70, 200, 30);
		inputPanel.add(titleLabel_1);

		add(inputPanel);

		searchButton = new JButton("Search");
		searchButton.setForeground(new Color(255, 255, 255));
		searchButton.setBackground(new Color(0, 128, 128));
		searchButton.setBounds(370, 159, 110, 35);
		inputPanel.add(searchButton);

		JLabel amountLabel = new JLabel("Amount:");
		amountLabel.setBounds(80, 261, 60, 20);
		inputPanel.add(amountLabel);

		amountField = new JTextField();
		amountField.setBounds(190, 262, 150, 30);
		inputPanel.add(amountField);
		
		JLabel intervalLabel = new JLabel("Interval(Day):");
		intervalLabel.setBounds(80, 315, 160, 20);
		inputPanel.add(intervalLabel);

		intervalField = new JTextField();
		intervalField.setBounds(190, 315, 150, 30);
		inputPanel.add(intervalField);

		transferButton = new JButton("Transfer");
		transferButton.setForeground(Color.WHITE);
		transferButton.setBackground(new Color(50, 205, 50));
		transferButton.setBounds(370, 260, 110, 35);
		inputPanel.add(transferButton);
		
		paymentButton = new JButton("Recurring");
		paymentButton.setForeground(Color.WHITE);
		paymentButton.setBackground(new Color(50, 205, 50));
		paymentButton.setBounds(370, 315, 110, 35);
		inputPanel.add(paymentButton);

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String accountNumber = accountNumberField.getText();
				BankAccount toAccount = Database.searchAccountByNumber(accountNumber);
				if (toAccount != null && !accountNumber.equalsIgnoreCase(account.getNo())) {
					accountNameField.setText(toAccount.getName());
				} else {
					JOptionPane.showMessageDialog(null, "Account not found!");
				}
			}
		});

		transferButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String accountNumber = accountNumberField.getText();
				BankAccount toAccount = Database.searchAccountByNumber(accountNumber);
				String amountStr = amountField.getText();
				double amount = Double.parseDouble(amountStr);
				String toAccountName = accountNameField.getText();
				account.setAmount(account.getAmount() - amount);
				Database.updateAccountDetailsInDatabase(account);
				toAccount.setAmount(toAccount.getAmount() + amount);
				Database.updateAccountDetailsInDatabase(toAccount);
				Database.addTransactionToDatabase(
						new Transaction(account.getNo(), amount, LocalDate.now(), "Transfer"));
				Database.addTransferToDatabase(new TransferClass(account.getNo(), amount, LocalDate.now(), "Transfer", toAccount.getNo()));
				JOptionPane.showMessageDialog(null, "Transferred $" + amount + " to " + toAccount + " successfully!");
			}
		});
		
		paymentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int interval = Integer.parseInt(intervalField.getText());
        		String accountNumber = accountNumberField.getText();
				BankAccount toAccount = Database.searchAccountByNumber(accountNumber);
				String amountStr = amountField.getText();
				double amount = Double.parseDouble(amountStr);
				if (toAccount != null && !accountNumber.equalsIgnoreCase(account.getNo())) {
					Database.addRecurringPayment(new Payment(account.getName(),toAccount.getName(),amount,interval));
					JOptionPane.showMessageDialog(null, "Transaction added to recurring payments successfully!");
				}
        	}
		});
	}

	protected class TransferClass extends Transaction {

		private String toAccount;

		public TransferClass(String accountNumber, double amount, LocalDate date, String type, String toAccount) {
			super(accountNumber, amount, date, type);
			this.toAccount = toAccount;
		}


		public String getToAccount() {
			return toAccount;
		}

		public void setToAccount(String toAccount) {
			this.toAccount = toAccount;
		}

	}
}
