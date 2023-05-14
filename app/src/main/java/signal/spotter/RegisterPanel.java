package signal.spotter;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {
    public JTextField emailField;
    public JPasswordField passwordField1;
    public JPasswordField passwordField2;
    public JButton registerButton;
    public JButton loginButton;

    public RegisterPanel() {
        // Use GridBagLayout with GridBagConstraints
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5); // Add some padding

        // Load image and scale it to 300 pixels width
        ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/resources/csusm-logo.jpg",
                "CSUSM Logo");
        Image image = imageIcon.getImage().getScaledInstance(300, -1, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create image label with scaled image
        JLabel imageLabel = new JLabel(scaledImageIcon);
        // Set alignment to center
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create login field
        emailField = new JTextField(20);
        // Create password fields
        passwordField1 = new JPasswordField(20);
        passwordField2 = new JPasswordField(20);
        // Create register button
        registerButton = new JButton("Register");
        loginButton = new JButton("Back to Login");

        // Add components to panel with GridBagConstraints
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2; // Span 2 columns
        add(imageLabel, c);
        c.gridwidth = 1; // Reset to 1 column
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("Email:"), c);
        c.gridx = 1;
        c.gridy = 1;
        add(emailField, c);
        c.gridx = 0;
        c.gridy = 2;
        add(new JLabel("Password:"), c);
        c.gridx = 1;
        c.gridy = 2;
        add(passwordField1, c);
        c.gridx = 0;
        c.gridy = 3;
        add(new JLabel("Confirm Password:"), c);
        c.gridx = 1;
        c.gridy = 3;
        add(passwordField2, c);
        c.gridx = 1;
        c.gridy = 4;
        add(registerButton, c);
        c.gridx = 1;
        c.gridy = 5;
        add(new JLabel("or"), c);
        c.gridx = 1;
        c.gridy = 6;
        add(loginButton, c);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() throws Exception {
        String pass1Text = new String(passwordField1.getPassword());
        String pass2Text = new String(passwordField2.getPassword());
        if (!pass1Text.equals(pass2Text))
            throw (new Exception("Error, password fields are not the same"));
        return pass1Text;
    }

}