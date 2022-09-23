// Mahmoud Elbasiouny

package HW4_GettingWarmer;

import javax.swing.*;

public class GettingWarmer extends JFrame {
    
    public GettingWarmer() {
        JPanel root = new JPanel();
        JPanel fahrenheitF = new JPanel();
        JLabel fahrenheitL = new JLabel("Fahrenheit");
        JTextField fahrenheitTF = new JTextField("");
        JPanel celsiusF = new JPanel();
        JLabel celsiusL = new JLabel("Celsius");
        JTextField celsiusTF = new JTextField("");

        JButton convertFB = new JButton("Convert F° to C°");
        convertFB.addActionListener(e -> {
            try {
                double fahrenheit = Double.parseDouble(fahrenheitTF.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                celsiusTF.setText(String.format("%.1f", celsius));
            } catch (NumberFormatException ex) {
                celsiusTF.setText("Invalid input");
            }
        });

        JButton convertCB = new JButton("Convert C° to F°");
        convertCB.addActionListener(e -> {
            try {
                double celsius = Double.parseDouble(celsiusTF.getText());
                double fahrenheit = celsius * 9 / 5 + 32;
                fahrenheitTF.setText(String.format("%.1f", fahrenheit));
            } catch (NumberFormatException ex) {
                fahrenheitTF.setText("Invalid input");
            }
        });

        root.add(fahrenheitF);
        root.add(celsiusF);

        fahrenheitF.setLayout(new BoxLayout(fahrenheitF, BoxLayout.Y_AXIS));
        fahrenheitF.add(fahrenheitL);
        fahrenheitF.add(fahrenheitTF);
        fahrenheitF.add(convertFB);

        celsiusF.setLayout(new BoxLayout(celsiusF, BoxLayout.Y_AXIS));
        celsiusF.add(celsiusL);
        celsiusF.add(celsiusTF);
        celsiusF.add(convertCB);

        this.setTitle("Temp. Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(root);
        this.setSize(300, 125);
        this.setVisible(true);
        this.setResizable(false);
    }

    
    public static void main(String[] args) {
        new GettingWarmer();
    }
}
