import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class Helpdesk extends JPanel {
    private JTextArea textArea;
    private JButton reportButton;

    public Helpdesk(BankAccount account) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Helpdesk for customer support");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(120, 70, 300, 30);
        add(titleLabel);

        JLabel textLabel = new JLabel("Enter Query:");
        textLabel.setBounds(80, 130, 100, 30);
        add(textLabel);

        textArea = new JTextArea();
        textArea.setBounds(80, 170, 400, 300);
        add(textArea);

        reportButton = new JButton("Submit Query");
        reportButton.setBackground(new Color(50, 205, 50));
        reportButton.setForeground(new Color(255, 255, 255));
        reportButton.setBounds(360, 500, 120, 35);
        add(reportButton);

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                if (!text.isEmpty()) {
                    Query query = new Query(account.getNo(), account.getName(), LocalDateTime.now(), text);
                    Database.addQueryToDatabase(query);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter the issue text.");
                }
            }
        });
    }

}
