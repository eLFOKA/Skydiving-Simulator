import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class GUI extends JFrame{                           //Creating class GUI (Guide User Interface)
                                                             //Creating a window inside GUI
    JPanel settings_panel;                   //Creating panel inside GUI for adjusting variables
    JPanel animation_panel;                  //Creating panel inside GUI for showing animations
    JTextField txt_field_m;
    JTextField txt_field_b;
    JTextField txt_field_y0;
    public JButton run_button;

    public GUI() {

        this.setLayout(new BorderLayout());

        settings_panel = new JPanel();
        animation_panel = new JPanel();

        Color main_color = new Color(0x333333);
        Color settings_color = new Color(0x666666);

        ImageIcon icon = new ImageIcon("simulator/Resources/parachute.png");

        this.setVisible(true);                                         //Settings for frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setTitle("Skydiving - Simulator");
        this.setIconImage(icon.getImage());
        this.setBackground(main_color);

        this.add(settings_panel, BorderLayout.WEST);
        this.add(animation_panel, BorderLayout.CENTER);

        InitializePanels();

        settings_panel.setBackground(settings_color);
        settings_panel.setBounds(0, 0, 200, this.getHeight());

        animation_panel.setBackground(main_color);
        animation_panel.setBounds(200, 0, this.getWidth() - 200, this.getHeight());


        SwingUtilities.updateComponentTreeUI(this);
    }

    private void InitializePanels() {

        settings_panel.setLayout(new BoxLayout(settings_panel, BoxLayout.Y_AXIS));
        settings_panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        Dimension dimension_text_field = new Dimension(200, 30);

        ImageIcon run_icon = new ImageIcon("simulator/Resources/run.png");

        Image img = run_icon.getImage();
        Image newimg;
        newimg = img.getScaledInstance(60, 40, Image.SCALE_SMOOTH);
        run_icon = new ImageIcon(newimg);


        JLabel label_m = new JLabel("Object mass: ");
        settings_panel.add(label_m);

        txt_field_m = new JTextField();

        txt_field_m.setPreferredSize(dimension_text_field);
        txt_field_m.setSize(dimension_text_field);
        txt_field_m.setMaximumSize(dimension_text_field);
        settings_panel.add(txt_field_m);


        JLabel label_b = new JLabel("Air resistance: ");
        settings_panel.add(label_b);

        txt_field_b = new JTextField();
        txt_field_b.setPreferredSize(dimension_text_field);
        txt_field_b.setSize(dimension_text_field);
        txt_field_b.setMaximumSize(dimension_text_field);
        settings_panel.add(txt_field_b);

        JLabel label_y0 = new JLabel("Initial height: ");
        settings_panel.add(label_y0);

        txt_field_y0 = new JTextField();
        txt_field_y0.setPreferredSize(dimension_text_field);
        txt_field_y0.setSize(dimension_text_field);
        txt_field_y0.setMaximumSize(dimension_text_field);
        settings_panel.add(txt_field_y0);

        run_button = new JButton();
        run_button.setIcon(run_icon);
        run_button.setBorderPainted(false);
        run_button.setMargin(new Insets(0, 0, 0, 0));
        run_button.setContentAreaFilled(false);
        run_button.setPreferredSize(new Dimension(60, 40));
        run_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settings_panel.add(run_button);


    }

    public double get_m() {

        String m = txt_field_m.getText();

        try {
            double m_double = Double.parseDouble(m);
            return m_double;
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Value of mass is not given in correct way. Please, use only numbers - no whitespaces or letters");
            return 0;
        }
    }

    public double get_b() {

        String b = txt_field_b.getText();

        try {
            double b_double = Double.parseDouble(b);
            return b_double;
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Value of air resistance is not given in correct way. Please, use only numbers - no whitespaces or letters");
            return 0;
        }
    }

    public double get_y0() {

        String y0 = txt_field_y0.getText();

        try {
            double y0_double = Double.parseDouble(y0);
            return y0_double;
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Value of initial height is not given in correct way. Please, use only numbers - no whitespaces or letters");
            return 0;
        }
    }
}
