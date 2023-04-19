package signal.spotter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Color;

// import static signal.spotter.GUI.screen_width;

public class DashboardPanel extends JPanel {

    // Wherever the user's cursor is
    volatile Point cursor = null;
    private boolean isReporting = false;

    public DashboardPanel() {
        // Load the image
        ImageIcon originalIcon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\resources\\csusm3.png");
        Image originalImage = originalIcon.getImage();

        // Get the image dimensions
        int originalWidth = originalImage.getWidth(null);
        int originalHeight = originalImage.getHeight(null);

        // Calculate the scaling factor to fit within the frame
        double scaleFactor = Math.min(1d,
                (double) 300 / (double) originalWidth);

        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);
        Image scaledImage = originalImage.getScaledInstance(scaledWidth,
                scaledHeight, Image.SCALE_SMOOTH);

        // Create a JLabel with the scaled ImageIcon
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image_label = new JLabel(scaledIcon) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (cursor != null) {
                    int radius = 10;
                    int x = cursor.x - radius;
                    int y = cursor.y - radius;
                    g.setColor(Color.RED);
                    if (isReporting)
                        g.fillOval(x, y, radius * 2, radius * 2);
                }
            }
        };

        // Creating the panel at bottom and adding components
        JPanel bottomBar = new JPanel();
        JButton reportButton = new JButton("Report");

        reportButton.setBackground(Color.GREEN);
        reportButton.setForeground(Color.BLACK);

        reportButton.addActionListener(e -> {
            isReporting = !(isReporting);
            reportButton.setBackground(isReporting ? Color.RED : Color.GREEN);
            reportButton.setText(isReporting ? "Stop Reporting" : "Report");
        });

        image_label.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Get the location of the mouse cursor
                cursor = e.getPoint();

                // Repaint the panel to draw the circle
                image_label.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Do nothing
            }
        });

        bottomBar.add(reportButton);
        add(image_label, BorderLayout.CENTER);
        add(bottomBar, BorderLayout.SOUTH);

    }

}