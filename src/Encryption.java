import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Encryption extends JPanel {
    public Encryption(BankAccount account) {
        setLayout(null);

        JLabel titleLabel = new JLabel("Data Encryption");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(150, 70, 200, 30);
        add(titleLabel);

        JLabel infoLabel = new JLabel("Ensure data encryption for sensitive information here.");
        infoLabel.setBounds(50, 150, 400, 20);
        add(infoLabel);

        JCheckBox enableEncryptionCheckBox = new JCheckBox("Enable Encryption");
        
        enableEncryptionCheckBox.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		account.setEncryption(true);
        		Database.updateAccountDetailsInDatabase(account);
        	}
        });
        enableEncryptionCheckBox.setBounds(50, 180, 150, 30);
        add(enableEncryptionCheckBox);
    }
}
