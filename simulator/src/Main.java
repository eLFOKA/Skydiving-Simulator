public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        AnimatedDr animation = new AnimatedDr(gui);
        gui.runButton.addActionListener(animation);
    }
}