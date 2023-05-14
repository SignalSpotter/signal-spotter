package signal.spotter;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.*;

public class GUI extends JFrame {
    public final int screen_width = 400;
    public final int screen_height = 750;

    public static JPanel cardPanel;
    public static CardLayout cardLayout;
    private javax.swing.JButton homeButton;
    public javax.swing.JPanel topHeader;

    public GUI() {

        // Creating the Frame
        JFrame frame = new JFrame("Signal Spotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screen_width, screen_height);
        frame.setResizable(false);

        // First, authenticate the user

        LoginPanel loginPanel = new LoginPanel();
        DashboardPanel dashboardPanel = new DashboardPanel();
        HomePanel homePanel = new HomePanel();

        loginPanel.loginButton.addActionListener(e -> {
            try {
                GlobalState.getInstance()
                        .setJWT(Authentication.Authenticate(loginPanel.getLogin(), loginPanel.getPassword()));
                DashboardPanel.reports = GraphQL.queryReports();
                cardLayout.show(cardPanel, "homePanel");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error, incorrect username or password!");
                System.out.println(e1.getMessage());
            }
        });

        // Create the card layout panel and add two panels to it
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(loginPanel, "loginPanel");
        cardPanel.add(dashboardPanel, "dashboardPanel");
        cardPanel.add(homePanel, "homePanel");

        topHeader = new javax.swing.JPanel();
        topHeader.setBackground(new java.awt.Color(255, 255, 255));
        topHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        topHeader.setForeground(new java.awt.Color(255, 255, 255));
        topHeader.setAlignmentX(0.0F);
        topHeader.setAlignmentY(0.0F);
        topHeader.setMaximumSize(new java.awt.Dimension(400, 50));
        topHeader.setMinimumSize(new java.awt.Dimension(400, 50));
        topHeader.setPreferredSize(new java.awt.Dimension(400, 50));
        topHeader.setLayout(new java.awt.GridBagLayout());

        homeButton = new javax.swing.JButton();
        homeButton.setBackground(new java.awt.Color(255, 255, 255));
        homeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeButton.setForeground(new java.awt.Color(0, 0, 255));
        homeButton.setText("Signal Spotter");
        homeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        homeButton.setBorderPainted(false);
        homeButton.setMaximumSize(new java.awt.Dimension(396, 44));
        homeButton.setMinimumSize(new java.awt.Dimension(396, 44));
        homeButton.setPreferredSize(new java.awt.Dimension(396, 44));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (Authentication.isAuthenticated) {
                    cardLayout.show(cardPanel, "homePanel");
                }
            }
        });
        topHeader.add(homeButton, new java.awt.GridBagConstraints());

        // Add the card panel and button to the main frame
        frame.getContentPane().add(topHeader, BorderLayout.NORTH);
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }
}
