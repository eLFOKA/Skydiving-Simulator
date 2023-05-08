public class Main {
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        Run run = new Run(gui);
        Animation animation = new Animation(gui, run);
        gui.runButton.addActionListener(animation);
        gui.drawingPanel.add(run);
    }
}