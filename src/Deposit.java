import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Deposit extends JPanel {
    private JTextField amountField;
    private JButton depositButton;

    public Deposit(BankAccount account) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Deposit Money");
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

        depositButton = new JButton("Deposit");
        depositButton.setForeground(new Color(255, 255, 255));
        depositButton.setBackground(new Color(50, 205, 50));
        depositButton.setBounds(370, 159, 150, 35);
        add(depositButton);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(80, 270, 240, 221);
        add(textArea);
        
        JLabel lblReciept = new JLabel("Reciept:");
        lblReciept.setBounds(80, 230, 80, 30);
        add(lblReciept);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = amountField.getText();
                double amount = Double.parseDouble(amountStr);
                textArea.setFont(new Font("Arial", Font.BOLD, 16));
                textArea.setText("******Deposit Reciept******\nAccount Name: " +account.getName());
                textArea.append("\nAccount No: "+account.getNo());
                textArea.append("\nAccount Type: "+account.getAccountType());
                textArea.append("\nDate: ");
                textArea.append("\nAmount deposited: " + amount);
                account.setAmount(account.getAmount()+amount);
                textArea.append("\nBalance: "+account.getAmount());
				Database.updateAccountDetailsInDatabase(account);

				Database.addTransactionToDatabase(new Transaction(account.getNo(),amount,LocalDate.now(),"Deposit"));
                JOptionPane.showMessageDialog(null, "Deposit of $" + amount + " successful!");
            }
        });
    }
}
