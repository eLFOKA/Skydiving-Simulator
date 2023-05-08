import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Animation implements ActionListener {
    private double gr = 9.81;
    private Timer timer;
    double e_0 = 0;
    double e_1 = 0;
    double e_2 = 0;     //Samples
    private double m;
    private double b;
    private double y0;
    private Graphics g;
    private int T;
    private GUI gui;
    private Run run;


    public Animation(GUI gui_ex, Run run_ex){
        gui = gui_ex;
        run = run_ex;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        run.GetVariables();
        run.Start();

    }
}
