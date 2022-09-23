package GUI;

import javax.swing.*;
import java.awt.*;

class LayoutExample extends JFrame {

    public LayoutExample() {
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        JButton b4 = new JButton();
        JButton b5 = new JButton();

        b1.setBackground(Color.RED);
        b2.setBackground(Color.BLUE);
        b3.setBackground(Color.GREEN);
        b4.setBackground(Color.YELLOW);
        b5.setBackground(Color.ORANGE);

        b1.setOpaque(true);
        b2.setOpaque(true);
        b3.setOpaque(true);
        b4.setOpaque(true);
        b5.setOpaque(true);

        JPanel root = new JPanel();

        // FlowLayout is the default
        //root.setLayout(new BoxLayout(root, BoxLayout.X_AXIS));
        //root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        //root.setLayout(new GridLayout(3, 2));
        root.setLayout(new BorderLayout());

        root.add(b1, BorderLayout.NORTH);
        root.add(b2, BorderLayout.EAST);
        root.add(b3, BorderLayout.SOUTH);
        root.add(b4, BorderLayout.WEST);
        root.add(b5, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(root);
        this.setSize(500, 400);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new LayoutExample();
    }
}
