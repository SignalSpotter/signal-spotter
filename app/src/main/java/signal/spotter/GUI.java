package signal.spotter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class GUI {
    public GUI() {
        final int screen_width = 360;
        final int screen_height = 640;

        // Creating the Frame
        JFrame frame = new JFrame("Signal Spotter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screen_width, screen_height);
        frame.setResizable(false);

        // Load the image
        ImageIcon originalIcon = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\resources\\csusm.png");
        Image originalImage = originalIcon.getImage();

        // Get the image dimensions
        int originalWidth = originalImage.getWidth(null);
        int originalHeight = originalImage.getHeight(null);

        // Calculate the scaling factor to fit within the frame
        double scaleFactor = Math.min(1d,
                (double) screen_width / (double) originalWidth);

        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);
        Image scaledImage = originalImage.getScaledInstance(scaledWidth,
                scaledHeight, Image.SCALE_SMOOTH);

        // Create a JLabel with the scaled ImageIcon
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image_label = new JLabel(scaledIcon);

        // Creating the panel at bottom and adding components
        JPanel panel = new JPanel();
        JLabel x_label = new JLabel("x:");
        JLabel y_label = new JLabel("y:");
        JTextField x_input = new JTextField(3);
        JTextField y_input = new JTextField(3);
        JButton reportButton = new JButton("Report");
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String datetime = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
                double x = Double.parseDouble(x_input.getText());
                double y = Double.parseDouble(y_input.getText());

                try {
                    Database.createReport(new Report(datetime, x, y));
                } catch (Exception error) {
                    System.out.println(error.getMessage());
                }
            }
        });

        panel.add(x_label);
        panel.add(x_input);
        panel.add(y_label);
        panel.add(y_input);
        panel.add(reportButton);

        // Adding Components to the frame.
        frame.getContentPane().add(image_label, BorderLayout.CENTER);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);

    }
}
