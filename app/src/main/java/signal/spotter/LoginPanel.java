package signal.spotter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
    private JTextField loginField;
    private JPasswordField passwordField;
    public JButton loginButton;

    public LoginPanel() {
        // Create login field
        loginField = new JTextField(20);
        // Create password field
        passwordField = new JPasswordField(20);
        // Create login button
        loginButton = new JButton("Login");
        // Add action listener to login button

        // Add components to panel
        add(new JLabel("Login:"));
        add(loginField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}