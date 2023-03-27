import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {                           //Creating class GUI (Guide User Interface)
    JFrame frame;                            //Creating a window inside GUI
    JPanel settings_panel;                   //Creating panel inside GUI for adjusting variables
    JPanel animation_panel;                  //Creating panel inside GUI for showing animations
    JTextField m;
    JTextField b;
    JTextField y0;

    public GUI(){
        frame = new JFrame();
        settings_panel = new JPanel();
        animation_panel = new JPanel();

        Color main_color = new Color(0x333333);
        Color settings_color = new Color(0x666666);

        ImageIcon icon = new ImageIcon("simulator/Resources/parachute.png");

        frame.setVisible(true);                                         //Settings for frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setTitle("Skydiving - Simulator");
        frame.setIconImage(icon.getImage());
        frame.setBackground(main_color);
        frame.add(settings_panel);
        frame.add(animation_panel);

        settings_panel.setBackground(settings_color);
        settings_panel.setBounds(0, 0, 200, frame.getHeight());

        animation_panel.setBackground(main_color);
        animation_panel.setBounds(200, 0, frame.getWidth()-200, frame.getHeight());

        InitializePanels();

    }

    private void InitializePanels(){
        Dimension dimension_text_field = new Dimension(180, 30);

        JLabel label_m = new JLabel("Object mass: ");
        settings_panel.add(label_m);

        JTextField txt_field_m = new JTextField();

        txt_field_m.setPreferredSize(dimension_text_field);
        settings_panel.add(txt_field_m);

        JLabel label_b = new JLabel("Air resistance: ");
        settings_panel.add(label_b);

        JTextField txt_field_b = new JTextField();
        txt_field_b.setPreferredSize(dimension_text_field);
        settings_panel.add(txt_field_b);

        JLabel label_y0 = new JLabel("Start height: ");
        settings_panel.add(label_y0);

        JTextField txt_field_y0 = new JTextField();
        txt_field_y0.setPreferredSize(dimension_text_field);
        settings_panel.add(txt_field_y0);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
