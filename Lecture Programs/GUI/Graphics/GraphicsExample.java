package GUI.Graphics;

import javax.swing.*;
import java.awt.*;

public class GraphicsExample extends JFrame {

    public GraphicsExample() {
        GraphicsPanel gPanel = new GraphicsPanel();
        gPanel.setFocusable(true);
        gPanel.requestFocusInWindow();
        this.getContentPane().add(gPanel);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GraphicsExample();
    }
}
