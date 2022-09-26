package GUI.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsPanel extends JPanel implements KeyListener {
    private int xCoord;
    private int yCoord;
    private int change;

    public GraphicsPanel() {
        xCoord = 50;
        yCoord = 100;
        change = 10;

        this.addKeyListener(this);

        // Ball bounces back and forth
        /*Timer t = new Timer(17, e -> {
            xCoord += change;
            if (xCoord >= 450 || xCoord <= 0) {
                change = -change;
            }
            this.repaint();
        });
        t.setRepeats(true);
        t.start(); */
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(xCoord, yCoord, 50, 50);
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed");
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Key released");
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed");
    }
}
