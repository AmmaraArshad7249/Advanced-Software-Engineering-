import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AccountSetup extends JFrame {

	private JTextField nameField, emailField, phoneField, addressField, cityField, zipcodeField;
	private JComboBox<String> accountTypeComboBox;
	private JTextField passField;
	private JTextField userField;
	private JTextField balanceField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSetup window = new AccountSetup();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AccountSetup() {
		setTitle("Account Setup");
		setSize(670, 615); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 

		JLabel nameLabel = new JLabel("Name:");
		JLabel emailLabel = new JLabel("Email:");
		JLabel phoneLabel = new JLabel("Phone:");
		JLabel addressLabel = new JLabel("Address:");
		JLabel cityLabel = new JLabel("City:");
		JLabel zipcodeLabel = new JLabel("Zipcode:");
		JLabel accountTypeLabel = new JLabel("Account Type:");

		nameField = new JTextField(20);
		emailField = new JTextField(20);
		phoneField = new JTextField(20);
		addressField = new JTextField(20);
		cityField = new JTextField(20);
		zipcodeField = new JTextField(20);
        String[] accountTypes = {"Personal", "Business"};
        accountTypeComboBox = new JComboBox<>(accountTypes);

		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.setForeground(new Color(255, 255, 255));
		createAccountButton.setBackground(Color.GREEN); 

		JPanel panel = new JPanel(null); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.WEST;

		nameLabel.setBounds(131, 140, 80, 25);
		panel.add(nameLabel);

		nameField.setBounds(374, 140, 200, 25);
		panel.add(nameField);

		emailLabel.setBounds(131, 170, 80, 25);
		panel.add(emailLabel);

		emailField.setBounds(374, 170, 200, 25);
		panel.add(emailField);

		phoneLabel.setBounds(131, 200, 80, 25);
		panel.add(phoneLabel);

		phoneField.setBounds(374, 200, 200, 25);
		panel.add(phoneField);

		addressLabel.setBounds(131, 230, 80, 25);
		panel.add(addressLabel);

		addressField.setBounds(374, 230, 200, 25);
		panel.add(addressField);

		cityLabel.setBounds(131, 260, 80, 25);
		panel.add(cityLabel);

		cityField.setBounds(374, 260, 200, 25);
		panel.add(cityField);

		zipcodeLabel.setBounds(131, 290, 80, 25);
		panel.add(zipcodeLabel);

		zipcodeField.setBounds(374, 290, 200, 25);
		panel.add(zipcodeField);

		accountTypeLabel.setBounds(131, 431, 100, 25);
		panel.add(accountTypeLabel);

		accountTypeComboBox.setBounds(374, 431, 200, 25);
		panel.add(accountTypeComboBox);

		createAccountButton.setBounds(245, 510, 150, 30);
		panel.add(createAccountButton);

		createAccountButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String email = emailField.getText();
				String phone = phoneField.getText();
				String address = addressField.getText();
				String username = userField.getText();
				String password = passField.getText();
				String city = cityField.getText();
				String zipcode = zipcodeField.getText();
				double amount = Double.parseDouble(balanceField.getText());
				String accountType = (String) accountTypeComboBox.getSelectedItem();
				Database.saveAccountToDatabase(new BankAccount(name,email,phone,address,username,password,city,zipcode,accountType,false,amount));

			}
		});

		getContentPane().add(panel);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(131, 325, 80, 25);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(131, 360, 80, 25);
		panel.add(lblPassword);

		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(131, 395, 80, 25);
		panel.add(lblBalance);

		passField = new JTextField(20);
		passField.setBounds(374, 360, 200, 25);
		panel.add(passField);

		userField = new JTextField(20);
		userField.setBounds(374, 325, 200, 25);
		panel.add(userField);

		balanceField = new JTextField(20);
		balanceField.setBounds(374, 398, 200, 25);
		panel.add(balanceField);

		JLabel titleLabel = new JLabel("Create new account");
		panel.add(titleLabel);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(220, 60, 200, 30);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Authentication a = new Authentication();
				a.frame.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setBounds(10, 10, 80, 30);
		panel.add(btnBack);
	}

	public static class AccountDetail extends JPanel {
		private JTextField nameField, emailField, phoneField, addressField, cityField, zipcodeField;
		private JComboBox<String> accountTypeComboBox;
		private JButton saveChangesButton, closeAccountButton;
		private BankAccount bankAccount;


		public AccountDetail(BankAccount bankAccount) {
			this.bankAccount = bankAccount;

			setLayout(null);

			JLabel titleLabel = new JLabel("Edit Information");
			titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
			titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			titleLabel.setBounds(150, 70, 200, 30);
			add(titleLabel);

			JLabel nameLabel = new JLabel("Name:");
			nameLabel.setBounds(80, 120, 80, 25);
			add(nameLabel);

			nameField = new JTextField(bankAccount.getName());
			nameField.setBounds(230, 120, 200, 25);
			add(nameField);

			JLabel emailLabel = new JLabel("Email:");
			emailLabel.setBounds(80, 150, 80, 25);
			add(emailLabel);

			emailField = new JTextField(bankAccount.getEmail());
			emailField.setBounds(230, 150, 200, 25);
			add(emailField);

			JLabel phoneLabel = new JLabel("Phone:");
			phoneLabel.setBounds(80, 180, 80, 25);
			add(phoneLabel);

			phoneField = new JTextField(bankAccount.getPhone());
			phoneField.setBounds(230, 180, 200, 25);
			add(phoneField);

			JLabel addressLabel = new JLabel("Address:");
			addressLabel.setBounds(80, 210, 80, 25);
			add(addressLabel);

			addressField = new JTextField(bankAccount.getAddress());
			addressField.setBounds(230, 210, 200, 25);
			add(addressField);

			JLabel cityLabel = new JLabel("City:");
			cityLabel.setBounds(80, 240, 80, 25);
			add(cityLabel);

			cityField = new JTextField(bankAccount.getCity());
			cityField.setBounds(230, 240, 200, 25);
			add(cityField);

			JLabel zipcodeLabel = new JLabel("Zipcode:");
			zipcodeLabel.setBounds(80, 270, 80, 25);
			add(zipcodeLabel);

			zipcodeField = new JTextField(bankAccount.getZipcode());
			zipcodeField.setBounds(230, 270, 200, 25);
			add(zipcodeField);

			JLabel accountTypeLabel = new JLabel("Account Type:");
			accountTypeLabel.setBounds(80, 300, 80, 25);
			add(accountTypeLabel);

			String[] accountTypes = { "Personal", "Business" };
			accountTypeComboBox = new JComboBox<>(accountTypes);
			accountTypeComboBox.setSelectedItem(bankAccount.getAccountType());
			accountTypeComboBox.setBounds(230, 300, 200, 25);
			add(accountTypeComboBox);

			saveChangesButton = new JButton("Save Changes");
			saveChangesButton.setForeground(new Color(255, 255, 255));
			saveChangesButton.setBackground(new Color(50, 205, 50));
			saveChangesButton.setBounds(80, 365, 140, 35);
			add(saveChangesButton);

			closeAccountButton = new JButton("Close Account");
			closeAccountButton.setForeground(new Color(255, 255, 255));
			closeAccountButton.setBackground(new Color(255, 0, 0));
			closeAccountButton.setBounds(230, 365, 140, 35);
			add(closeAccountButton);

			saveChangesButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					bankAccount.setName(nameField.getText());
					bankAccount.setEmail(emailField.getText());
					bankAccount.setPhone(phoneField.getText());
					bankAccount.setAddress(addressField.getText());
					bankAccount.setCity(cityField.getText());
					bankAccount.setZipcode(zipcodeField.getText());
					bankAccount.setAccountType((String) accountTypeComboBox.getSelectedItem());
					JOptionPane.showMessageDialog(null, "Changes saved successfully!");
					Database.updateAccountDetailsInDatabase(bankAccount);
				}
			});

			closeAccountButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the account?",
							"Confirm Close Account", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						SwingUtilities.getWindowAncestor(AccountDetail.this).dispose();
						Database.deleteAccountFromDatabase(bankAccount);
					}
				}
			});
		}


		}
}
