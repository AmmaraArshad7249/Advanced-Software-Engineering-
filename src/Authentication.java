import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authentication {

    JFrame frame;
    private JLabel createAccountLabel; 
    private JTextField userField;
    private JTextField passField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Authentication window = new Authentication();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the application.
     */
    public Authentication() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Authentication");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(135, 25, 150, 30); 
        frame.getContentPane().add(titleLabel);

        createAccountLabel = new JLabel("Create a new account");
        createAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        createAccountLabel.setForeground(Color.BLUE);
        createAccountLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createAccountLabel.setBounds(150, 220, 150, 20); 
        createAccountLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createNewAccountWindow();
            }
        });
        frame.getContentPane().add(createAccountLabel);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(73, 85, 80, 25);
        frame.getContentPane().add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(73, 120, 80, 25);
        frame.getContentPane().add(lblPassword);
        userField = new JTextField(20);
        userField.setBounds(163, 85, 200, 25);
        frame.getContentPane().add(userField);
        
        passField = new JTextField(20);
        passField.setBounds(163, 120, 200, 25);
        frame.getContentPane().add(passField);
        
        JButton createAccountButton = new JButton("Login");
        createAccountButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String username, password;
        		username = userField.getText();
        		password = passField.getText();
        		if (!username.equals("")||!password.equals("")) {
        			BankAccount account = Database.authenticate(username, password);
        			if (account!=null) {
        				frame.setVisible(false);
        				SoftwareSystem ss = new SoftwareSystem(account);
        				ss.frame.setVisible(true);
        			}
        			else {
        				JOptionPane.showMessageDialog(frame, "Please enter correct username and password.");
        			}
        		}
        		else {
    				JOptionPane.showMessageDialog(frame, "Username and password cant be empty.");
        		}
        	}
        });
        createAccountButton.setForeground(new Color(255, 255, 255));
        createAccountButton.setBackground(Color.GREEN);
        createAccountButton.setBounds(150, 180, 150, 30);
        frame.getContentPane().add(createAccountButton);
    }

    private void createNewAccountWindow() {
        frame.setVisible(false);
        AccountSetup as = new AccountSetup();
        as.setVisible(true);
    }
}
