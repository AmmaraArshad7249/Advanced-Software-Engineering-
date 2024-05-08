import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AccountInformation extends JPanel {
    public AccountInformation(BankAccount account) {
        setLayout(null);

        System.out.println(account);
        JLabel titleLabel = new JLabel("Account Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(150, 70, 200, 30);
        add(titleLabel);

        JLabel nameLabel = new JLabel("Name: "+account.getName());
        nameLabel.setBounds(80, 120, 200, 20);
        add(nameLabel);

        JLabel accountTypeLabel = new JLabel("Account Type: "+ account.getAccountType());
        accountTypeLabel.setBounds(80, 150, 200, 20);
        add(accountTypeLabel);

        JLabel balanceLabel = new JLabel("Balance: "+account.getAmount());
        balanceLabel.setBounds(80, 180, 200, 20);
        add(balanceLabel);

        JLabel recentTransactionsLabel = new JLabel("Recent Transactions:");
        recentTransactionsLabel.setBounds(80, 220, 200, 20);
        add(recentTransactionsLabel);

        ArrayList<Transaction> transactions = Database.getTransactionsByAccountNumber(account.getNo());
        String[] columnNames = {"Type", "Amount"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable transactionTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(80, 250, 300, 150);
        add(scrollPane);

        for (Transaction transaction : transactions) {
            Object[] rowData = {transaction.getType(), transaction.getAmount()};
            model.addRow(rowData);
        }
    }
}
