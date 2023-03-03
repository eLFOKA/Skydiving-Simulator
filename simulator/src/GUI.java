import javax.swing.*;

public class GUI {                           //Creating class GUI (Guide User Interface)
    JFrame frame;                            //Creating a window inside GUI
    JPanel panel;                            //Creating panel inside GUI (to use later)

    public GUI(){
        frame = new JFrame();
        panel = new JPanel();

        ImageIcon icon = new ImageIcon("simulator/Resources/parachute.png");

        frame.setVisible(true);                                         //Settings for frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setTitle("Skydiving - Simulator");
        frame.setIconImage(icon.getImage());


    }

}
