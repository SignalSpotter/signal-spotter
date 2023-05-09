package signal.spotter;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField loginField;
    private JPasswordField passwordField;
    public JButton loginButton;

    public LoginPanel() {
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
        loginField = new JTextField(20);
        // Create password field
        passwordField = new JPasswordField(20);
        // Create login button
        loginButton = new JButton("Login");
        // Add action listener to login button

        // Add components to panel with GridBagConstraints
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2; // Span 2 columns
        add(imageLabel, c);
        c.gridwidth = 1; // Reset to 1 column
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("Login:"), c);
        c.gridx = 1;
        c.gridy = 1;
        add(loginField, c);
        c.gridx = 0;
        c.gridy = 2;
        add(new JLabel("Password:"), c);
        c.gridx = 1;
        c.gridy = 2;
        add(passwordField, c);
        c.gridx = 1;
        c.gridy = 3;
        add(loginButton, c);
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}