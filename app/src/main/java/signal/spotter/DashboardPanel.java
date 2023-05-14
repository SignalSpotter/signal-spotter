package signal.spotter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardPanel extends JPanel {

    // Wherever the user's cursor is
    volatile Point cursor = null;
    private boolean isReporting = false;
    public static List<Report> reports;

    public DashboardPanel() {

        // Creating the report button
        JButton reportButton = new JButton("Report");
        reportButton.setBackground(Color.GREEN);
        reportButton.setForeground(Color.BLACK);
        reportButton.addActionListener(e -> {
            isReporting = !(isReporting);
            reportButton.setBackground(isReporting ? Color.RED : Color.GREEN);
            reportButton.setText(isReporting ? "Stop Reporting" : "Report");
        });

        // Creating the slider
        TimeSlider slider = new TimeSlider();

        // Load the image
        ImageIcon originalIcon = new ImageIcon(System.getProperty("user.dir") + "/src/main/resources/csusm3.png");
        Image originalImage = originalIcon.getImage();

        // Calculate the scaling factor to fit within the frame
        int originalWidth = originalImage.getWidth(null);
        int originalHeight = originalImage.getHeight(null);

        double scaleFactor = Math.min(1d,
                (double) 315 / (double) originalWidth);

        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        // Creating the main image
        Image scaledImage = originalImage.getScaledInstance(scaledWidth,
                scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel image_label = new JLabel(scaledIcon) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Draw a small circle at each reported value

                List<Report> filteredReports = reports.stream()
                        .filter(report -> {
                            LocalTime time = LocalTime.parse(report.getDatetime().substring(11, 19));
                            return time.isAfter(LocalTime.of(slider.sliderMin.getValue(), 59))
                                    && time.isBefore(LocalTime.of(slider.sliderMax.getValue(), 0));
                        })
                        .collect(Collectors.toList());

                for (Report report : filteredReports) {
                    g.setColor(Color.RED);
                    g.fillOval((int) (report.getX() * scaledWidth), (int) (report.getY() * scaledHeight), 10, 10);
                }

                // Paint the cursor
                if (cursor != null) {
                    if (isReporting) {
                        int radius = 10;
                        int x = cursor.x - radius;
                        int y = cursor.y - radius;
                        g.setColor(Color.RED);
                        g.fillOval(x, y, radius * 2, radius * 2);
                    }

                }
            }
        };
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

        image_label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (isReporting) {
                    isReporting = false;
                    reportButton.setBackground(Color.GREEN);
                    reportButton.setText("Report");
                }

                try {
                    // Get the current date and time in ISO 8601 format
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter awsFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    String awsDateTime = now.format(awsFormatter);

                    float x = e.getX() / (float) scaledWidth; // Get the current x coordinate of the mouse
                    float y = e.getY() / (float) scaledHeight; // Get the current y coordinate of the mouse

                    GraphQL.createReport(new Report(awsDateTime, x, y));
                    System.out.println("Report creation successful");

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                try {
                    Thread.sleep(2000);
                    reports = GraphQL.queryReports();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        add(reportButton);

        add(image_label);

        add(slider);

    }

}