import javax.swing.*;

import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class GUI extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    public JButton runButton;
    public JPanel drawingPanel;

    public GUI(){

        ImageIcon imageIcon = new ImageIcon("Resources/parachute.png");
        Image img = imageIcon.getImage();


        this.setTitle("Skydiving Simulator");
        this.setIconImage(img);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.add(mainPanel);
        this.show();
    }

    public double get_m() {

        String m = textField1.getText();

        try {
            double m_double = Double.parseDouble(m);
            return m_double;
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Value of mass is not given in correct way. Please, use only numbers - no whitespaces or letters");
            return 0;
        }
    }

    public double get_b() {

        String b = textField2.getText();

        try {
            double b_double = Double.parseDouble(b);
            return b_double;
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Value of air resistance is not given in correct way. Please, use only numbers - no whitespaces or letters");
            return 0;
        }
    }

    public double get_y0() {

        String y0 = textField3.getText();

        try {
            double y0_double = Double.parseDouble(y0);
            return y0_double;
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Value of initial height is not given in correct way. Please, use only numbers - no whitespaces or letters");
            return 0;
        }
    }
}
