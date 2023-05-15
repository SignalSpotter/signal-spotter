package signal.spotter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
    private String reportingMode = "none";
    private List<Report> filteredReports;

    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("csusm3.png");

    public DashboardPanel() {

        // Creating the Goodreport button
        JButton goodReportButton = new JButton("Report Good");
        goodReportButton.setBackground(Color.GREEN);
        goodReportButton.setForeground(Color.BLACK);
        goodReportButton.addActionListener(e -> {
            isReporting = !(isReporting);
            reportingMode = (reportingMode.equals("good") ? "none" : "good");
            goodReportButton.setBackground(isReporting ? Color.YELLOW : Color.GREEN);
            goodReportButton.setText(isReporting ? "Stop Reporting" : "Report Good");
        });

        // Creating the Badreport button
        JButton badReportButton = new JButton("Report Bad");
        badReportButton.setBackground(Color.RED);
        badReportButton.setForeground(Color.BLACK);
        badReportButton.addActionListener(e -> {
            isReporting = !(isReporting);
            reportingMode = (reportingMode.equals("bad") ? "none" : "bad");
            badReportButton.setBackground(isReporting ? Color.YELLOW : Color.RED);
            badReportButton.setText(isReporting ? "Stop Reporting" : "Report Bad");
        });

        // Creating the slider
        TimeSlider slider = new TimeSlider();

        // Load the image
        try (
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] bytes = baos.toByteArray();
            ImageIcon originalIcon = new ImageIcon(bytes);
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

                    filteredReports = GlobalState.getInstance().getReports().stream()
                            .filter(report -> {
                                LocalTime time = LocalTime.parse(report.getDatetime().substring(11, 19));
                                return time.isAfter(LocalTime.of(slider.sliderMin.getValue(), 59))
                                        && time.isBefore(LocalTime.of(slider.sliderMax.getValue(), 0));
                            })
                            .collect(Collectors.toList());

                    for (Report report : filteredReports) {
                        if (report.getRating().equals("good"))
                            g.setColor(Color.GREEN);
                        if (report.getRating().equals("bad"))
                            g.setColor(Color.RED);
                        g.fillOval((int) (report.getX() * scaledWidth), (int) (report.getY() * scaledHeight), 10, 10);
                    }

                    // Paint the cursor
                    if (cursor != null) {
                        if (isReporting) {
                            int radius = 10;
                            int x = cursor.x - radius;
                            int y = cursor.y - radius;
                            g.setColor(Color.YELLOW);
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
                    if (!isReporting) {
                        float x = e.getX() / (float) scaledWidth; // Get the current x coordinate of the mouse
                        float y = e.getY() / (float) scaledHeight; // Get the current y coordinate of the mouse
                        for (Report report : filteredReports) {
                            double xDiff = Math.abs(report.getX() - x);
                            double yDiff = Math.abs(report.getY() - y);
                            if (xDiff <= 0.03 && yDiff <= 0.03) {
                                String message = String.format("Reported: %s\nX: %f\nY: %f\nRating: %s",
                                        report.getDatetime(), report.getX(),
                                        report.getY(), report.getRating());
                                JOptionPane.showMessageDialog(null, message);
                            }

                        }
                        return;
                    }
                    if (isReporting) {
                        switch (reportingMode) {
                            case "bad":
                                badReportButton.setBackground(Color.RED);
                                badReportButton.setText("Report Bad");
                                break;
                            case "good":
                                goodReportButton.setBackground(Color.GREEN);
                                goodReportButton.setText("Report Good");
                                break;
                        }

                        try {
                            // Get the current date and time in ISO 8601 format
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter awsFormatter = DateTimeFormatter
                                    .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                            String awsDateTime = now.format(awsFormatter);

                            float x = e.getX() / (float) scaledWidth; // Get the current x coordinate of the mouse
                            float y = e.getY() / (float) scaledHeight; // Get the current y coordinate of the mouse

                            String rating = reportingMode; // Get the current rating coordinate of the mouse

                            GraphQL.createReport(new Report(awsDateTime, x, y, rating));

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        isReporting = false;
                        reportingMode = "none";

                        try {
                            Thread.sleep(2000);
                            GlobalState.getInstance().setReports(GraphQL.queryReports());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });

            add(goodReportButton);
            add(badReportButton);
            add(image_label);
            add(slider);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}