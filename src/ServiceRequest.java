import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServiceRequest extends JPanel {
    private JButton checkbookButton;
    private JButton cardButton;

    public ServiceRequest() {
        setLayout(null);

        JLabel titleLabel = new JLabel("Service Requests");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(150, 70, 138, 30);
        add(titleLabel);

        checkbookButton = new JButton("Request Checkbook");
        checkbookButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(getParent(), "Checkbook requested.");
        	}
        });
        checkbookButton.setForeground(new Color(255, 255, 255));
        checkbookButton.setBackground(new Color(0, 128, 128));
        checkbookButton.setBounds(116, 180, 200, 35);
        add(checkbookButton);

        cardButton = new JButton("Request Card");
        cardButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(getParent(), "Card requested.");
        	}
        });
        cardButton.setForeground(new Color(255, 255, 255));
        cardButton.setBackground(new Color(0, 128, 0));
        cardButton.setBounds(116, 230, 200, 35);
        add(cardButton);
    }
}
