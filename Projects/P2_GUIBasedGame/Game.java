package P2_GUIBasedGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {
    private int xCoord;
    private int yCoord;
    private int change;

    public Game() {
        xCoord = 0;
        yCoord = 0;
        change = 10;

        this.addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillArc(xCoord, yCoord, 60, 60, 0, -180);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            System.out.println("Moved left");
            xCoord = xCoord - change;
            checkBounds();
            this.repaint();
        } else if (key == KeyEvent.VK_RIGHT) {
            System.out.println("Moved right");
            xCoord = xCoord + change;
            checkBounds();
            this.repaint();
        } else {
            System.out.println("Invalid input");
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void checkBounds() {
        if (xCoord < -30) { // Left half off window
            xCoord = 450;   // Teleport to right side
        }
        if (xCoord > 450) { // Right half off window
            xCoord = -30;   // Teleport to left side
        }
    }
}

