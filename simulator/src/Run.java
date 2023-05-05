import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run extends JPanel implements ActionListener {            //Animated drawing
    private int height = 400;
    private int width = 100;
    private int sPer = 500;         //Sampling period
    private int Xpos = 0;
    private int Ypos = 0;
    private double gr = 9.81;
    private Timer timer;
    Graphics gcur;

    private double m;
    private double b;
    private double y0;

    private GUI gui;

    public Run(GUI ex_gui){
        gui = ex_gui;
        this.setSize(200, 450);
        this.setMinimumSize(new Dimension(200, 460));
        gui.drawingPanel.add(this);
    }

    public void Start(double y0, double m, double b){
        int x = 100;
        int y = 30;         //Coordinates of pixel
        double e = 0;
        double e_1 = 0;
        double e_2 = 0;     //Samples
        Calculator cal = new Calculator(y0, b, m);
        double border_prec = Math.round((cal.GetTwithEQ(y0))*1000/400);
        int T = (int) Math.round(border_prec);

        for (int i = 0; i < 400; i++) {
            double ans = y0 - ((2*e_1*T-Math.sqrt(m*(-4*e_2*T+4*gr*T*T+m))+m)/(2*T));
            e_2=e_1;
            e_1=e;
            e=ans;
            gcur.drawLine(x, y+(int)e_1, x, y+(int)e_2);
            timer = new Timer(T, this);
            timer.start();
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawString("Falling of the object in real time", 20, 10);
        g.drawLine(80,20,80,430);           //Main axis/vetrical line
        g.drawLine(80,20,78,30);            //Arrow left
        g.drawLine(80,20,82,30);            //Arrow right

        for (int i = 0; i < 100; i+= 10){                   //Horizontal line
            g.drawLine(i+70,430,i+75,430);
        }

        g.drawString("y = 0", 35, 435);
        gcur = g;

    }

    private void GetVariables(GUI gui) {
        m = gui.get_m();
        b = gui.get_b();
        y0 = gui.get_y0();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GetVariables(gui);
        Start(y0, m, b);
    }
}
