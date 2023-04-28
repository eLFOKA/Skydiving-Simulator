import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Run implements ActionListener {

    GUI gui;
    private double m;
    private double b;
    private double y0;

    public Run(GUI gui_ex) {
        gui = gui_ex;
        gui.runButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GetVariables(gui);
    }

    private void GetVariables(GUI gui) {
        m = gui.get_m();
        b = gui.get_b();
        y0 = gui.get_y0();
    }
}