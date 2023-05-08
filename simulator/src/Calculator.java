import static javax.swing.JOptionPane.showMessageDialog;

public class Calculator {
    double y0;
    double b;
    double m;
    double g = 9.81;

    public Calculator(double y1, double b1, double m1){
        y0 = y1;
        b = b1;
        m = m1;
    }

    public double GetYwithEQ(double t){
        double y = y0 - ((Math.log(Math.cosh(Math.sqrt(b)*Math.sqrt(g)*Math.sqrt(m)*t)))/(b));

        return y;
    }

    public double GetTwithEQ(double y){
        double t = acosh(Math.exp(b*y0-b*y))/(Math.sqrt(b)*Math.sqrt(g)*Math.sqrt(m));
        showMessageDialog(null, "t="+Double.toString(t));
        return t;
    }

    public double acosh(double x){
        try {
            double y = Math.log(x+Math.sqrt(x*x-1));
            return y;
        } catch (Exception e) {
            showMessageDialog(null, "Cosh^-1 is not right, wrong given value");
            return 0;
        }
    }


}
