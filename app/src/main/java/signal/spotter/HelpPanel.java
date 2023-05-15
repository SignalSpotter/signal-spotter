package signal.spotter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.swing.*;

public class HelpPanel extends JPanel {

    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("HelpPanelDrawing.png");

    public HelpPanel() {
        // Use GridBagLayout with GridBagConstraints
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5); // Add some padding

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
            Image image = imageIcon.getImage().getScaledInstance(380, -1, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(image);

            // Create image label with scaled image
            JLabel imageLabel = new JLabel(scaledImageIcon);
            // Set alignment to center
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Add components to panel with GridBagConstraints
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2; // Span 2 columns
            add(imageLabel, c);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
