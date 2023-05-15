package signal.spotter;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class LoginPanel extends JPanel {
    public JTextField loginField;
    public JPasswordField passwordField;
    public JButton loginButton;
    public JButton registerButton;
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("csusm-logo.jpg");

    public LoginPanel() {
        // Use GridBagLayout with GridBagConstraints
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5); // Add some padding

        // Load image and scale it to 300 pixels width
        try (
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] bytes = baos.toByteArray();
            ImageIcon imageIcon = new ImageIcon(bytes);
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
            // Create register button
            registerButton = new JButton("Register");

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
            c.gridx = 1;
            c.gridy = 4;
            add(new JLabel("or"), c);
            c.gridx = 1;
            c.gridy = 5;
            add(registerButton, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}