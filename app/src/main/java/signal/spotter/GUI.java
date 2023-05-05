package signal.spotter;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.*;

public class GUI {
    public final int screen_width = 400;
    public final int screen_height = 750;

    private JPanel cardPanel;
    private CardLayout cardLayout;

    public GUI() {

        // Creating the Frame
        JFrame frame = new JFrame("Signal Spotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screen_width, screen_height);
        frame.setResizable(false);

        // First, authenticate the user

        LoginPanel loginPanel = new LoginPanel();
        DashboardPanel dashboardPanel = new DashboardPanel();

        loginPanel.loginButton.addActionListener(e -> {
            try {
                Authentication.Authenticate(loginPanel.getLogin(), loginPanel.getPassword());
                cardLayout.show(cardPanel, "dashboardPanel");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error, incorrect username or password!");
                e1.getMessage();
            }
        });

        // Create the card layout panel and add two panels to it
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(loginPanel, "loginPanel");
        cardPanel.add(dashboardPanel, "dashboardPanel");

        // Add the card panel and button to the main frame
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }
}
