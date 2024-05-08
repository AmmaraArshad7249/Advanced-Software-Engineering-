import javax.swing.*;
import java.awt.*;

public class SoftwareSystem {

    JFrame frame;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private CardLayout cardLayout;
    private BankAccount selectedAccount;

    /**
     * Initialize the contents of the frame.
     */
    public SoftwareSystem(BankAccount selectedAccount) {
    	this.selectedAccount = selectedAccount;
    	initialize();
    }
    
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 645);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Banking Software System");
        frame.getContentPane().setLayout(null);

        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 200, frame.getHeight());
        leftPanel.setLayout(null);

        JButton accountInfoButton = new JButton("Account Information");
        accountInfoButton.setForeground(new Color(255, 255, 255));
        accountInfoButton.setBackground(new Color(30, 144, 255));
        accountInfoButton.setPreferredSize(new Dimension(135, 35));
        accountInfoButton.setBounds(new Rectangle(30, 45, 135, 35));
        JButton serviceRequestButton = new JButton("Service Request");
        serviceRequestButton.setForeground(new Color(255, 255, 255));
        serviceRequestButton.setBackground(new Color(30, 144, 255));
        serviceRequestButton.setPreferredSize(new Dimension(135, 35));
        serviceRequestButton.setBounds(new Rectangle(30, 315, 135, 35));
        JButton recurringPaymentButton = new JButton("Recurring Payment");
        recurringPaymentButton.setForeground(new Color(255, 255, 255));
        recurringPaymentButton.setBackground(new Color(30, 144, 255));
        recurringPaymentButton.setPreferredSize(new Dimension(135, 35));
        recurringPaymentButton.setBounds(new Rectangle(30, 360, 135, 35));
        JButton authenticationButton = new JButton("Authentication");
        authenticationButton.setPreferredSize(new Dimension(135, 35));
        authenticationButton.setBounds(new Rectangle(0, 0, 135, 35));
        JButton encryptionButton = new JButton("Encryption");
        encryptionButton.setForeground(new Color(255, 255, 255));
        encryptionButton.setBackground(new Color(30, 144, 255));
        encryptionButton.setPreferredSize(new Dimension(135, 35));
        encryptionButton.setBounds(new Rectangle(30, 405, 135, 35));
        JButton complianceButton = new JButton("Compliance");
        complianceButton.setForeground(new Color(255, 255, 255));
        complianceButton.setBackground(new Color(30, 144, 255));
        complianceButton.setPreferredSize(new Dimension(135, 35));
        complianceButton.setBounds(new Rectangle(30, 450, 135, 35));
        JButton helpdeskButton = new JButton("Helpdesk");
        helpdeskButton.setForeground(new Color(255, 255, 255));
        helpdeskButton.setBackground(new Color(30, 144, 255));
        helpdeskButton.setPreferredSize(new Dimension(135, 35));
        helpdeskButton.setBounds(new Rectangle(30, 495, 135, 35));
        JButton reportIssueButton = new JButton("Report Issue");
        reportIssueButton.setForeground(new Color(255, 255, 255));
        reportIssueButton.setBackground(new Color(30, 144, 255));
        reportIssueButton.setPreferredSize(new Dimension(135, 35));
        reportIssueButton.setBounds(new Rectangle(30, 540, 135, 35));
        JButton editInfoButton = new JButton("Edit Information");
        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");

        JButton btnTransfer = new JButton("Transfer");
        JButton btnHistory = new JButton("Transactions");

        leftPanel.add(accountInfoButton);
        leftPanel.add(serviceRequestButton);
        leftPanel.add(recurringPaymentButton);
        leftPanel.add(encryptionButton);
        leftPanel.add(complianceButton);
        leftPanel.add(helpdeskButton);
        leftPanel.add(reportIssueButton);

        rightPanel = new JPanel();
        rightPanel.setBounds(200, 0, frame.getWidth() - 200, frame.getHeight());
        cardLayout = new CardLayout();
        rightPanel.setLayout(cardLayout);

        rightPanel.add("AccountInformation", new AccountInformation(selectedAccount));
        rightPanel.add("ServiceRequest", new ServiceRequest());
        rightPanel.add("RecurringPayment", new RecurringPayment(selectedAccount));
        rightPanel.add("EditInformation", new AccountSetup.AccountDetail(selectedAccount));
        rightPanel.add("Encryption", new Encryption(selectedAccount));
        rightPanel.add("Deposit", new Deposit(selectedAccount));
        rightPanel.add("Withdraw", new Withdraw(selectedAccount));
        rightPanel.add("Compliance", new Compliance());
        rightPanel.add("Helpdesk", new Helpdesk(selectedAccount));
        rightPanel.add("ReportIssue", new ReportIssue(selectedAccount));
        rightPanel.add("Transfer", new Transfer(selectedAccount));
        rightPanel.add("Transactions", new TransactionHistory(selectedAccount));

        accountInfoButton.addActionListener(e -> cardLayout.show(rightPanel, "AccountInformation"));
        editInfoButton.addActionListener(e -> cardLayout.show(rightPanel, "EditInformation"));
        btnDeposit.addActionListener(e -> cardLayout.show(rightPanel, "Deposit"));
        btnWithdraw.addActionListener(e -> cardLayout.show(rightPanel, "Withdraw"));
        btnTransfer.addActionListener(e -> cardLayout.show(rightPanel, "Transfer"));
        btnHistory.addActionListener(e -> cardLayout.show(rightPanel, "Transactions"));
        serviceRequestButton.addActionListener(e -> cardLayout.show(rightPanel, "ServiceRequest"));
        recurringPaymentButton.addActionListener(e -> cardLayout.show(rightPanel, "RecurringPayment"));
        authenticationButton.addActionListener(e -> cardLayout.show(rightPanel, "Authentication"));
        encryptionButton.addActionListener(e -> cardLayout.show(rightPanel, "Encryption"));
        complianceButton.addActionListener(e -> cardLayout.show(rightPanel, "Compliance"));
        helpdeskButton.addActionListener(e -> cardLayout.show(rightPanel, "Helpdesk"));
        reportIssueButton.addActionListener(e -> cardLayout.show(rightPanel, "ReportIssue"));

        frame.getContentPane().add(leftPanel);
      
        editInfoButton.setForeground(new Color(255, 255, 255));
        editInfoButton.setBackground(new Color(30, 144, 255));
        editInfoButton.setPreferredSize(new Dimension(135, 35));
        editInfoButton.setBounds(new Rectangle(30, 45, 135, 35));
        editInfoButton.setBounds(30, 90, 135, 35);
        leftPanel.add(editInfoButton);
        
        btnDeposit.setForeground(new Color(255, 255, 255));
        btnDeposit.setBackground(new Color(30, 144, 255));
        btnDeposit.setPreferredSize(new Dimension(135, 35));
        btnDeposit.setBounds(new Rectangle(30, 45, 135, 35));
        btnDeposit.setBounds(30, 135, 135, 35);
        leftPanel.add(btnDeposit);
        
        btnWithdraw.setForeground(new Color(255, 255, 255));
        btnWithdraw.setBackground(new Color(30, 144, 255));
        btnWithdraw.setPreferredSize(new Dimension(135, 35));
        btnWithdraw.setBounds(new Rectangle(30, 45, 135, 35));
        btnWithdraw.setBounds(30, 180, 135, 35);
        leftPanel.add(btnWithdraw);
        
        btnTransfer.setForeground(new Color(255, 255, 255));
        btnTransfer.setBackground(new Color(30, 144, 255));
        btnTransfer.setPreferredSize(new Dimension(135, 35));
        btnTransfer.setBounds(new Rectangle(30, 45, 135, 35));
        btnTransfer.setBounds(30, 225, 135, 35);
        leftPanel.add(btnTransfer);
        
        btnHistory.setForeground(new Color(255, 255, 255));
        btnHistory.setBackground(new Color(30, 144, 255));
        btnHistory.setPreferredSize(new Dimension(135, 35));
        btnHistory.setBounds(new Rectangle(30, 45, 135, 35));
        btnHistory.setBounds(30, 270, 135, 35);
        leftPanel.add(btnHistory);
        frame.getContentPane().add(rightPanel);
    }
}
