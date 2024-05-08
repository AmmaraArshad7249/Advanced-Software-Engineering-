import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TransactionHistory extends JPanel {
    private JTable transactionTable;
    private JButton filterButton;
    private JTextField dateFilterField;
    private JTextField typeFilterField;
    private JTextField amountFilterField;

    public TransactionHistory(BankAccount account) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(210, 70, 200, 30);
        add(titleLabel);

        JLabel dateFilterLabel = new JLabel("Date:");
        dateFilterLabel.setBounds(80, 150, 50, 25);
        add(dateFilterLabel);
        dateFilterField = new JTextField();
        dateFilterField.setBounds(120, 150, 100, 25);
        add(dateFilterField);

        JLabel typeFilterLabel = new JLabel("Type:");
        typeFilterLabel.setBounds(230, 150, 50, 25);
        add(typeFilterLabel);
        typeFilterField = new JTextField();
        typeFilterField.setBounds(270, 150, 100, 25);
        add(typeFilterField);

        JLabel amountFilterLabel = new JLabel("Amount:");
        amountFilterLabel.setBounds(385, 150, 50, 25);
        add(amountFilterLabel);
        amountFilterField = new JTextField();
        amountFilterField.setBounds(435, 150, 100, 25);
        add(amountFilterField);

        String[] columnNames = {"Date", "Type", "Amount"};
        ArrayList<Transaction> transactions = Database.getTransactionsByAccountNumber(account.getNo());
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        transactionTable = new JTable(model);

        for (Transaction transaction : transactions) {
            Object[] rowData = {transaction.getDate(), transaction.getType(), transaction.getAmount()};
            model.addRow(rowData);
        }

        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(80, 210, 455, 200);
        add(scrollPane);

        filterButton = new JButton("Filter");
        filterButton.setBackground(new Color(135, 206, 250));
        filterButton.setForeground(new Color(255, 255, 255));
        filterButton.setBounds(270, 460, 100, 30);
        add(filterButton);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterTransactions();
            }
        });
    }

    private void filterTransactions() {
        String dateFilter = dateFilterField.getText();
        String typeFilter = typeFilterField.getText();
        String amountFilter = amountFilterField.getText();

        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        transactionTable.setRowSorter(sorter);

        ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();
        if (!dateFilter.isEmpty()) {
            filters.add(RowFilter.regexFilter(dateFilter, 0));
        }
        if (!typeFilter.isEmpty()) {
            filters.add(RowFilter.regexFilter(typeFilter, 1));
        }
        if (!amountFilter.isEmpty()) {
            filters.add(RowFilter.regexFilter(amountFilter, 2));
        }

        RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(combinedFilter);
    }
}
