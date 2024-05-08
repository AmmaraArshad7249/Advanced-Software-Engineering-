import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ReportIssue extends JPanel {
    private JTextArea textArea;
    private JButton reportButton;

    public ReportIssue(BankAccount account) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Report Issue or Fraudulent Activity");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(120, 70, 300, 30);
        add(titleLabel);

        JLabel textLabel = new JLabel("Enter Issue:");
        textLabel.setBounds(80, 130, 100, 30);
        add(textLabel);

        textArea = new JTextArea();
        textArea.setBounds(80, 170, 400, 300);
        add(textArea);

        reportButton = new JButton("Report Issue");
        reportButton.setBackground(new Color(50, 205, 50));
        reportButton.setForeground(new Color(255, 255, 255));
        reportButton.setBounds(360, 500, 120, 35);
        add(reportButton);

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                if (!text.isEmpty()) {
                    Issue issue = new Issue(account.getNo(), account.getName(), LocalDateTime.now(), text);
                    Database.addIssueToDatabase(account,issue.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the issue text.");
                }
            }
        });
    }
}
