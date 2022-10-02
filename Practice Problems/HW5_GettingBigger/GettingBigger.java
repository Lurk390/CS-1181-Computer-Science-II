// Mahmoud Elbasiouny
package HW5_GettingBigger;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

// Used this source for help:
// https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
public class GettingBigger extends JFrame implements ChangeListener {
    int FONT_MIN = 0;
    int FONT_MAX = 100;
    int FONT_INIT = 15;

    JPanel root = new JPanel();
    JTextArea text = new JTextArea("Type here...");
    JPanel bottomPanel = new JPanel();
    JLabel fontSizeLabel = new JLabel("Font Size:");
    JSlider fontSlider = new JSlider(JSlider.HORIZONTAL,
                                     FONT_MIN, FONT_MAX, FONT_INIT);

    public GettingBigger() {
        fontSlider.addChangeListener(this);
        fontSlider.setMajorTickSpacing(25);
        fontSlider.setMinorTickSpacing(5);
        fontSlider.setPaintTicks(true);
        fontSlider.setPaintLabels(true);

        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPanel.add(fontSizeLabel);
        bottomPanel.add(fontSlider);
        
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.add(text);
        root.add(bottomPanel);

        this.getContentPane().add(root);
        this.setTitle("Text Decorator");
        this.setSize(325, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int fontSize = (int)source.getValue();
            Font font = new Font("Serif", Font.PLAIN, fontSize);
            text.setFont(font);
        }
    }

    public static void main(String[] args) {
        new GettingBigger();
    }
}
