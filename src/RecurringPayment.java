import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;

public class RecurringPayment extends JPanel {
    public RecurringPayment(BankAccount account) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Recurring Payments and Direct Debits");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(100, 70, 300, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        ArrayList<Payment> payments = Database.getAllRecurringPayments(account.getName());
        String[] columnNames = {"From","To Account", "Amount", "Interval in days"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable transactionTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(80, 150, 350, 250);
        add(scrollPane);

        for (Payment payment : payments) {
            Object[] rowData = {payment.getAccountName(),payment.getToAccount(), payment.getAmount(), payment.getIntervalInDays()};
            model.addRow(rowData);
        }
    }
}
