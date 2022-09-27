package P2_GUIBasedGame;

import javax.swing.*;

public class Instructions extends JPanel {
    
    public Instructions() {
        JPanel root = new JPanel();
        JButton instructionsB = new JButton("Instructions");
        instructionsB.addActionListener(e1 -> {
            JFrame popUp = new JFrame();
            JLabel message = new JLabel("asdfasfa");
            JButton close = new JButton("Close");
            instructionsB.addActionListener(e2 -> {
                
            });

            popUp.getContentPane().add(message);

            popUp.setVisible(true);
            popUp.setSize(500,400);
            popUp.setLocationRelativeTo(null);
        });

        root.add(instructionsB);
        this.add(root);
    }
}
