package signal.spotter;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.Hashtable;

public class TimeSlider extends JPanel {

    public JSlider sliderMin;
    public JSlider sliderMax;

    Dimension SIZE = new Dimension(350, 50);

    public TimeSlider() {

        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(0, new JLabel("12"));
        labels.put(1, new JLabel("1"));
        labels.put(2, new JLabel("2"));
        labels.put(3, new JLabel("3"));
        labels.put(4, new JLabel("4"));
        labels.put(5, new JLabel("5"));
        labels.put(6, new JLabel("6"));
        labels.put(7, new JLabel("7"));
        labels.put(8, new JLabel("8"));
        labels.put(9, new JLabel("9"));
        labels.put(10, new JLabel("10"));
        labels.put(11, new JLabel("11"));
        labels.put(12, new JLabel("12"));
        labels.put(13, new JLabel("1"));
        labels.put(14, new JLabel("2"));
        labels.put(15, new JLabel("3"));
        labels.put(16, new JLabel("4"));
        labels.put(17, new JLabel("5"));
        labels.put(18, new JLabel("6"));
        labels.put(19, new JLabel("7"));
        labels.put(20, new JLabel("8"));
        labels.put(21, new JLabel("9"));
        labels.put(22, new JLabel("10"));
        labels.put(23, new JLabel("11"));

        JPanel panel = new JPanel(new GridLayout(2, 1));

        // Create slider for minimum value
        sliderMin = new JSlider(JSlider.HORIZONTAL, 0, 23, 8);
        sliderMin.setSnapToTicks(true);
        sliderMin.setMajorTickSpacing(1);
        sliderMin.setMinorTickSpacing(1);
        sliderMin.setPaintTicks(true);
        sliderMin.setLabelTable(labels);
        sliderMin.setPaintLabels(true);
        sliderMin.setPreferredSize(SIZE);
        sliderMin.setMaximumSize(SIZE);
        sliderMin.setMinimumSize(SIZE);
        panel.add(sliderMin);

        // Create slider for maximum value
        sliderMax = new JSlider(JSlider.HORIZONTAL, 0, 23, 20);
        sliderMax.setSnapToTicks(true);
        sliderMax.setMajorTickSpacing(1);
        sliderMax.setMinorTickSpacing(1);
        sliderMax.setPaintTicks(true);
        sliderMax.setLabelTable(labels);
        sliderMax.setPaintLabels(true);
        sliderMax.setPreferredSize(SIZE);
        sliderMax.setMaximumSize(SIZE);
        sliderMax.setMinimumSize(SIZE);
        panel.add(sliderMax);

        // Add listener to sync the sliders
        sliderMin.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (sliderMin.getValue() > sliderMax.getValue()) {
                    sliderMin.setValue(sliderMax.getValue());
                }
            }
        });
        sliderMax.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (sliderMax.getValue() < sliderMin.getValue()) {
                    sliderMax.setValue(sliderMin.getValue());
                }
            }
        });

        // Add the panel
        add(panel);
    }

}
