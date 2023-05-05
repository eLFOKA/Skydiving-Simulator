public class Main {
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        Run run = new Run(gui);
        gui.runButton.addActionListener(run);
    }
}