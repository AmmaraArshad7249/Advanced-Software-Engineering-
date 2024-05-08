import javax.swing.*;
import java.awt.*;

public class Compliance extends JPanel {
    public Compliance() {
        setLayout(null);

        JLabel titleLabel = new JLabel("Financial Regulations Compliance");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(120, 70, 300, 30);
        add(titleLabel);

        JTextArea complianceTextArea = new JTextArea();
        complianceTextArea.setEditable(false);
        complianceTextArea.setLineWrap(true);
        complianceTextArea.setWrapStyleWord(true);
        complianceTextArea.setText("We prioritize the security and privacy of your "
        		+ "financial information. We adhere to industry-standard compliance regulations,"
        		+ " including Anti-Money Laundering (AML) and General Data Protection Regulation "
        		+ "(GDPR). Our robust security measures ensure the protection of your sensitive data "
        		+ "through encryption and secure authentication methods.\n\nYour Security Matters\n\n- "
        		+ "Encryption: Your data is encrypted to safeguard it from unauthorized access.\n- "
        	        		+ "Privacy Policy: Our privacy policy outlines how we collect, use, and protect your personal"
        		+ " information.\n- Terms of Service: Our terms of service define the rights and responsibilities"
        		+ " of both users and [Bank Name].\n\nReporting Fraud\n\nIf you suspect any fraudulent activity or "
        		+ "unauthorized access to your account, please report it immediately through our secure channels. "
        		+ "Your prompt action helps us maintain the integrity of our services and protect your finances.\n\nStay"
        		+ " Informed\n\nCheck our compliance page regularly for updates on security measures, privacy policies,"
        		+ " and regulatory changes. We are committed to keeping you informed about any developments that may "
        		+ "affect your banking experience.\n\nThank you for entrusting us with your financial needs. Your"
        		+ " security and privacy are our top priorities.");
        JScrollPane scrollPane = new JScrollPane(complianceTextArea);
        scrollPane.setBounds(80, 120, 450, 400);
        add(scrollPane);
    }
}
