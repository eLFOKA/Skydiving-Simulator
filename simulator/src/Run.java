import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class Run extends JPanel implements ActionListener {            //Animated drawing
    private int height = 400;
    private int width = 100;
    private int sPer = 500;         //Sampling period
    int x = 120;
    int y = 30;         //Coordinates of pixel
    private double gr = 9.81;
    double e_0 = 0;
    double e_1 = 0;
    double e_2 = 0;     //Samples
    Graphics gcur;

    private double m;
    private double b;
    private double y0;
    private int T;
    private Timer timer;

    private GUI gui;
    private Animation animation;

    public Run(GUI ex_gui){
        gui = ex_gui;
        this.setSize(200, 450);
        this.setMinimumSize(new Dimension(200, 460));
    }

    public void paint (Graphics g) {
        super.paintComponent(g);
        gcur = g;
        g.drawString("Falling of the object in real time", 20, 10);
        g.drawLine(80,20,80,430);           //Main axis/vetrical line
        g.drawLine(80,20,78,30);            //Arrow left
        g.drawLine(80,20,82,30);            //Arrow right

        for (int i = 0; i < 100; i+= 10){                   //Horizontal line
            g.drawLine(i+70,430,i+75,430);
        }

        g.drawString("y = 0", 35, 435);

        g.drawLine(x, y, x, y+(int)e_0);

    }

    public void GetVariables() {
        m = gui.get_m();
        b = gui.get_b();
        y0 = gui.get_y0();
    }

    public void Start(){

        Calculator cal = new Calculator(y0, b, m);
        double border_prec = Math.round((cal.GetTwithEQ(0))*(1000/400));
        T = (int) Math.round(border_prec);
        showMessageDialog(null, "T="+Integer.toString(T));
        showMessageDialog(null, "Bprec="+Double.toString(border_prec));

        timer = new Timer(T, this);
        timer.start();
/*
        for (int i = 0; i < 400; i++) {
            double ans = y0 - ((2*e_1*T-Math.sqrt(m*(-4*e_2*T+4*gr*T*T+m))+m)/(2*T));
            e_2=e_1;
            e_1=e_0;
            e_0=ans;
            g.drawLine(x, y+(int)e_1, x, y+(int)e_2);
        }

 */
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        double ans = y0 - ((2*e_1*T-Math.sqrt(m*(-4*e_2*T+4*gr*T*T+m))+m)/(2*T));
        e_2=e_1;
        e_1=e_0;
        e_0=ans;
        repaint();
        /*
        if(y0-e_0<=0){
            timer.stop();
        }

         */
    }
}
