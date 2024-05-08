import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Withdraw extends JPanel {
    private JTextField amountField;
    private JButton withdrawButton;

    public Withdraw(BankAccount account) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Withdraw Money");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(150, 71, 200, 30);
        add(titleLabel);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(80, 161, 80, 30);
        add(amountLabel);

        amountField = new JTextField(10);
        amountField.setBounds(170, 161, 150, 30);
        add(amountField);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setForeground(new Color(255, 255, 255));
        withdrawButton.setBackground(new Color(50, 205, 50));
        withdrawButton.setBounds(170, 211, 150, 35);
        add(withdrawButton);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                double amount = Double.parseDouble(amountStr);
                account.setAmount(account.getAmount()- amount);
                Database.updateAccountDetailsInDatabase(account);
				Database.addTransactionToDatabase(new Transaction(account.getNo(),amount,LocalDate.now(),"Withdraw"));
                JOptionPane.showMessageDialog(null, "Withdraw of $" + amount + " successful!");
            }
        });
    }
}
