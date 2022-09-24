package GUI.CookieClicker;

import java.awt.*;
import javax.swing.*;

class CookieClicker extends JFrame {
    // Must be a class variable in order to work inside lamba expression
    private int score = 0;

    public static void main(String[] args) {
        new CookieClicker();
    }
    
    public CookieClicker() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        JLabel message = new JLabel("Score: " + score);
        Font currentFont = message.getFont();
        message.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 30));

        JButton goButton = new JButton();
        goButton.setIcon(new ImageIcon("Lecture Programs/GUI/CookieClicker/cookie.png"));
        goButton.addActionListener(e -> {
            score++;
            message.setText("Score: " + score);
            
            if (score > 25) {
                message.setForeground(Color.BLUE);
            }
        });

        root.add(goButton);
        root.add(message);

        this.getContentPane().add(root);

        this.setTitle("Cookie Clicker");
        this.setSize(400, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
