package GUI;
import javax.swing.*;

class HelloWorldGUI extends JFrame {
    
    public HelloWorldGUI() {
        JPanel root = new JPanel();
        JLabel message = new JLabel("");

        JTextField nameTF = new JTextField("<Enter your name>");
        JButton goButton = new JButton("Say Hi!");
//      goButton.addActionListener(new ButtonListener())
/*
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("I was clicked!");
            }
        });
*/
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


    public static void main(String[] args) {
        new HelloWorldGUI();
    }
}
