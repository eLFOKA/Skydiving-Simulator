import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {                           //Creating class GUI (Guide User Interface)
    JFrame frame;                            //Creating a window inside GUI
    JPanel settings_panel;                   //Creating panel inside GUI for adjusting variables
    JPanel animation_panel;                  //Creating panel inside GUI for showing animations
    JTextField txt_field_m;
    JTextField txt_field_b;
    JTextField txt_field_y0;
    JButton m_button;
    JButton b_button;
    JButton y0_button;
    JButton run_button;

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

        InitializePanels();

        settings_panel.setBackground(settings_color);
        settings_panel.setBounds(0, 0, 200, frame.getHeight());

        animation_panel.setBackground(main_color);
        animation_panel.setBounds(200, 0, frame.getWidth()-200, frame.getHeight());

        SwingUtilities.updateComponentTreeUI(frame);
    }

    private void InitializePanels(){
        Dimension dimension_text_field = new Dimension(150, 30);
        Dimension dimension_buttons = new Dimension(30,30);

        ImageIcon ok_icon = new ImageIcon("simulator/Resources/check.png");
        ImageIcon run_icon = new ImageIcon("simulator/Resources/run.png");

        Image img = ok_icon.getImage();
        Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;
        ok_icon = new ImageIcon(newimg);

        img = run_icon.getImage();
        newimg = img.getScaledInstance(60, 40, Image.SCALE_SMOOTH);
        run_icon = new ImageIcon(newimg);


        JLabel label_m = new JLabel("Object mass: ");
        settings_panel.add(label_m);

        txt_field_m = new JTextField();

        txt_field_m.setPreferredSize(dimension_text_field);
        settings_panel.add(txt_field_m);

        m_button = new JButton();
        m_button.setIcon(ok_icon);
        m_button.setBorderPainted(false);
        m_button.setMargin(new Insets(0, 0, 0, 0));
        m_button.setContentAreaFilled(false);
        m_button.setPreferredSize(dimension_buttons);
        m_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settings_panel.add(m_button);

        JLabel label_b = new JLabel("Air resistance: ");
        settings_panel.add(label_b);

        txt_field_b = new JTextField();
        txt_field_b.setPreferredSize(dimension_text_field);
        settings_panel.add(txt_field_b);

        b_button = new JButton();
        b_button.setIcon(ok_icon);
        b_button.setBorderPainted(false);
        b_button.setMargin(new Insets(0, 0, 0, 0));
        b_button.setContentAreaFilled(false);
        b_button.setPreferredSize(dimension_buttons);
        b_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settings_panel.add(b_button);

        JLabel label_y0 = new JLabel("Start height: ");
        settings_panel.add(label_y0);

        txt_field_y0 = new JTextField();
        txt_field_y0.setPreferredSize(dimension_text_field);
        settings_panel.add(txt_field_y0);

        y0_button = new JButton();
        y0_button.setIcon(ok_icon);
        y0_button.setBorderPainted(false);
        y0_button.setMargin(new Insets(0, 0, 0, 0));
        y0_button.setContentAreaFilled(false);
        y0_button.setPreferredSize(dimension_buttons);
        y0_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settings_panel.add(y0_button);

        run_button = new JButton();
        run_button.setIcon(run_icon);
        run_button.setBorderPainted(false);
        run_button.setMargin(new Insets(0, 0, 0, 0));
        run_button.setContentAreaFilled(false);
        run_button.setPreferredSize(new Dimension(60, 40));
        run_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settings_panel.add(run_button);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
