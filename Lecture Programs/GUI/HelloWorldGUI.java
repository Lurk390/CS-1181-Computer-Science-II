package GUI;
import javax.swing.*;

class HelloWorldGUI extends JFrame {
    public static void main(String[] args) {
        new HelloWorldGUI();
    }

    
    public HelloWorldGUI() {
        JPanel root = new JPanel();
        JLabel message = new JLabel("");

        JTextField nameTF = new JTextField("<Enter your name>");
        JButton goButton = new JButton("Say Hi!");
        goButton.addActionListener(e -> {
            message.setText("Hello, " + nameTF.getText() + "!");
        });

        root.add(nameTF);
        root.add(goButton);
        root.add(message);

        this.getContentPane().add(root);

        this.setTitle("Hello, World!");
        this.setSize(400, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
