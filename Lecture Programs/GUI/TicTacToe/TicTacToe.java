package GUI.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    public TicTacToe() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        for (int i=1; i<=9; i++) {
            JButton b = new JButton("" + i);
            buttonPanel.add(b);
        }
        root.add(buttonPanel);

        JLabel msgLabel = new JLabel("Welcome to TicTacToe!");
        root.add(msgLabel);

        this.getContentPane().add(root);
        this.setTitle("TicTacToe");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new TicTacToe();
    }
}
