package P2_GUIBasedGame;

import javax.swing.*;
import java.awt.*;

public class Driver extends JFrame {

    public Driver() {
        JPanel root = new JPanel();
        Instructions iPanel = new Instructions();
        Game gPanel = new Game();
        
        root.setLayout(new BorderLayout());
        root.add(gPanel , BorderLayout.CENTER);
        root.add(iPanel, BorderLayout.NORTH);

        this.getContentPane().add(root);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        gPanel.setFocusable(true);
        gPanel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new Driver();
    }
}
